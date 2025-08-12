package glopal.backend.domain.auth.converter;

import glopal.backend.domain.auth.dto.request.AuthRequest;
import glopal.backend.domain.user.entity.User;
import glopal.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthConverter {

    private final PasswordEncoder passwordEncoder;

    public User toUser(AuthRequest.LocalRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
}
