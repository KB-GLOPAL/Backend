package glopal.backend.domain.auth.service;

import glopal.backend.domain.auth.converter.AuthConverter;
import glopal.backend.domain.auth.dto.request.AuthRequest;
import glopal.backend.domain.user.entity.User;
import glopal.backend.domain.user.repository.UserRepository;
import glopal.backend.global.apiPayload.code.exception.custom.AuthException;
import glopal.backend.global.apiPayload.code.status.ErrorStatus;
import glopal.backend.global.security.jwt.JwtTokenProvider;
import glopal.backend.global.security.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthCommandServiceImpl implements AuthCommandService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthConverter authConverter;
    private final AuthenticationManager authenticationManager;

    @Override
    public void userSignUp(AuthRequest.LocalRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new AuthException(ErrorStatus.ALREADY_EXIST_EMAIL);
        }

        User user = authConverter.toUser(request);
        userRepository.save(user);
    }


    @Override
    public TokenInfo localLogin(AuthRequest.LocalRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            Long userId = userRepository.findUserIdByEmail(loginRequest.getEmail());

            return jwtTokenProvider.generateToken(
                    userId,
                    authentication
            );
        } catch (BadCredentialsException ex) {
            throw new AuthException(ErrorStatus.INVALID_PASSWORD);
        }
    }



}
