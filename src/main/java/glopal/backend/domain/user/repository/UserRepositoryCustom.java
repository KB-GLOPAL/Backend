package glopal.backend.domain.user.repository;

import glopal.backend.domain.user.entity.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findByEmail(String email);
    Long findUserIdByEmail(String email);
}
