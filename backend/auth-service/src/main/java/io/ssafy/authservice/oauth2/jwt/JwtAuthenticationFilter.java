package io.ssafy.authservice.oauth2.jwt;

import io.ssafy.authservice.oauth2.cookie.CookieUtils;
import io.ssafy.authservice.oauth2.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("## doFilter 동작!!");
        
        // 쿠키에서 토큰 추출
        Optional<Cookie> accessToken = CookieUtils.getCookie((HttpServletRequest) servletRequest,"accessToken" );
        if (accessToken.isPresent()) {
            String validToken = jwtTokenProvider.validateToken(String.valueOf(accessToken.get().getValue()), (HttpServletResponse) servletResponse);
            UsernamePasswordAuthenticationToken authentication;
            if (validToken != null) {
                authentication = jwtTokenProvider.createAuthenticationFromToken(accessToken.get().getValue(), validToken);
            }
            // 토큰이 만료되었을 경우 -> 새로운 토큰 발급
            else {
                authentication = jwtTokenProvider.replaceAccessToken((HttpServletResponse) servletResponse, accessToken.get().getValue());
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
            filterChain.doFilter(servletRequest, servletResponse);
    }

}
