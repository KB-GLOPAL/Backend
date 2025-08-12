package glopal.backend.domain.auth.controller;

import glopal.backend.domain.auth.converter.AuthConverter;
import glopal.backend.domain.auth.dto.request.AuthRequest;
import glopal.backend.domain.auth.service.AuthCommandService;
import glopal.backend.global.apiPayload.ApiResponse;
import glopal.backend.global.security.jwt.TokenInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/auth")
public class AuthController {

    private final AuthCommandService authCommandService;

    @Operation(
            summary = "일반 회원가입 API",
            description = "사용자가 일반 회원가입을 합니다."
    )
    @PostMapping("/sign-up")
    public ApiResponse<String> singUpLocal(@RequestBody @Valid AuthRequest.LocalRequest authRequest) {
        authCommandService.userSignUp(authRequest);
        return ApiResponse.onSuccess("회원가입에 성공하였습니다.");
    }

    @Operation(
            summary = "일반 로그인 API",
            description = "사용자가 일반 로그인을 합니다."
    )
    @PostMapping("/login/local")
    public ApiResponse<TokenInfo> loginLocal(@RequestBody @Valid AuthRequest.LocalRequest authRequest) {
        TokenInfo loginResponse = authCommandService.localLogin(authRequest);
        return ApiResponse.onSuccess(loginResponse);
    }
}
