package glopal.backend.global.security;

import glopal.backend.global.security.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 설정
                .csrf(csrf -> csrf.disable())

                // 인증/인가 설정
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/css/**",
                                "/images/**",
                                "/js/**",
                                "/lib/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/api/v0/auth/**",
                                "/error",
                                "/favicon.ico",
                                "/default-ui.css"
                        ).permitAll() // 허용 경로 설정
                        .anyRequest().authenticated() // 나머지 경로는 인증 필요
                )

                // 세션 관리 : JWT 사용 시 세션 비활성화
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 기본 로그인 폼 비활성화
                .formLogin(form -> form.disable())

                // HTTP 기본 인증 비활성화
                .httpBasic(httpBasic -> httpBasic.disable())

                // JWT 필터 추가 : UsernamePassworkAuthenticationFilter 앞에 실행
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}