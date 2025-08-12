package glopal.backend.global.security.jwt;

import glopal.backend.global.apiPayload.code.exception.custom.BadRequestException;
import glopal.backend.global.apiPayload.code.exception.custom.TokenException;
import glopal.backend.global.apiPayload.code.status.ErrorStatus;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isExcluded(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            processTokenAuthentication(request);
        } catch (TokenException e) {
            log.error("Invalid Token", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Invalid Token");
            return;
        }

        filterChain.doFilter(request, response);
    }

    /**
     * 인증 필터 제외 경로
     */
    private boolean isExcluded(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return uri.startsWith("/swagger-ui") || // Swagger 관련 경로 제외
                uri.startsWith("/v3/api-docs") ||
                uri.startsWith("/api/v0/auth/sign-up") || // 회원가입 제외
                uri.startsWith("/api/v0/auth/login/local") || // 로그인 제외
                uri.startsWith("/css") ||
                uri.startsWith("/js") ||
                uri.startsWith("/images") ||
                uri.equals("/default-ui.css") ||
                uri.equals("/favicon.ico") ||
                uri.equals("/health");
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return true; // ✅ 에러 디스패치에서는 필터 미동작
    }

    /**
     * JWT 토큰 인증 처리
     */
    private void processTokenAuthentication(HttpServletRequest request) {
        String token = getToken(request);

        if (!StringUtils.hasText(token)) {
            return;
        }

        if (jwtTokenProvider.validateToken(token)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return;
        }

        throw new TokenException(ErrorStatus.INVALID_TOKEN);
    }

    /**
     * Authorization 헤더에서 토큰 추출
     */
    private String getToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}