package glopal.backend.domain.auth.service;

import glopal.backend.domain.auth.dto.request.AuthRequest;
import glopal.backend.global.security.jwt.TokenInfo;

public interface AuthCommandService {
    void userSignUp(AuthRequest.LocalRequest request);
    TokenInfo localLogin(AuthRequest.LocalRequest loginRequest);
}
