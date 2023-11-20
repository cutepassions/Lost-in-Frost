package io.ssafy.authservice.global.config.security;

import io.ssafy.authservice.oauth2.cookie.CookieAuthorizationRequestRepository;
import io.ssafy.authservice.oauth2.enums.Role;
import io.ssafy.authservice.oauth2.handler.OAuth2AuthenticationFailureHandler;
import io.ssafy.authservice.oauth2.handler.OAuth2AuthenticationSuccessHandler;
import io.ssafy.authservice.oauth2.jwt.JwtAuthenticationFilter;
import io.ssafy.authservice.oauth2.jwt.JwtTokenProvider;
import io.ssafy.authservice.oauth2.service.CustomOAuth2UserService;
import io.ssafy.authservice.oauth2.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@Slf4j
public class WebSecurityConfigure {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieAuthorizationRequestRepository cookieAuthorizationRequestRepository;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private final CustomUserDetailsService customUserDetailsService;

    @Value("${url.frontend}")
    private String FRONTEND_BASE_URL;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.debug("filterChain => ");
        log.debug("   {}", http.toString());

        // 기타 보안 설정
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .rememberMe(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        //요청에 대한 권한 설정
        http.authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
        );


        //oauth2Login
        http.oauth2Login(oauth2-> oauth2
                .authorizationEndpoint(auth->auth.baseUri("/api/oauth2/authorize")
                        .authorizationRequestRepository(cookieAuthorizationRequestRepository))
                .redirectionEndpoint(redirect -> redirect.baseUri("/api/oauth2/callback/*"))
                .userInfoEndpoint(user -> user.userService(customOAuth2UserService))
                .successHandler(oAuth2AuthenticationSuccessHandler)
                .failureHandler(oAuth2AuthenticationFailureHandler)
        );


        // 로그아웃 관련 설정
        http.
                logout(logout -> logout.logoutUrl("/api/auth/logout").permitAll()
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessHandler((request, response, authentication) ->
                                response.sendRedirect(FRONTEND_BASE_URL))
                );


        //jwt filter 설정
        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, customUserDetailsService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
