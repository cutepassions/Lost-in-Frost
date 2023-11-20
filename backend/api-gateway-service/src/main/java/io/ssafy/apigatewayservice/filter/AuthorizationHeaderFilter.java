package io.ssafy.apigatewayservice.filter;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    @Value("${token.secret}")
    private String jwtSecret;

    /**
     * 설정 관련 클래스 캐스팅
     */
    public AuthorizationHeaderFilter() {
        super(Config.class);
    }

    /**
     * 필터 적용 메소드
     * @param config 설정 관련 클래스
     * @return GatewayFilter
     */
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            // 헤더에 Authorization이 없을 경우
            if (!request.getHeaders().containsKey("Authorization")) {
                return onError(exchange, "No Authorization header", HttpStatus.UNAUTHORIZED);
            }

            // header 가져 오기
            String authorizationHeader = request.getHeaders().get("Authorization").get(0);
            // jwt 가져 오기
            String jwt = authorizationHeader.replace("Bearer", "");

            // jwt 유효성 검사
            if (!isJwtValid(jwt)) {
                return onError(exchange, "JWT token is not valid", HttpStatus.UNAUTHORIZED);
            }

            return chain.filter(exchange);
        });
    }

    /**
     * JWT 토큰이 유효한지 확인하는 메소드
     * @param jwt 토큰
     * @return boolean 토큰 유효 여부
     */
    private boolean isJwtValid(String jwt) {
        boolean result = true;

        String subject = null;
        // TODO: 추후 이 subject가 사용자가 넣었던 ID와 동일한 지 확인 하는 로직을 넣어도 좋을듯 함, redis에 refresh token을 저장하고 이를 통해 subject를 비교해봐도 좋을 듯 함
        try {
            subject = Jwts.parser().setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt).getBody().getSubject();
        } catch (Exception e) {
            result = false;
        }
        if (subject == null || subject.isEmpty()) {
            result = false;
        }

        return result;
    }

    /**
     * 에러 발생 시 처리하는 메소드
     * @param exchange http 요청/응답 관련 메소드
     * @param err 에러 메시지
     * @param httpStatus 에러 상태 코드
     * @return Mono<Void>
     */
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);

        log.error(err);
        return response.setComplete();
        
    }

    /**
     * Config 클래스
     */
    public static class Config {

    }
}
