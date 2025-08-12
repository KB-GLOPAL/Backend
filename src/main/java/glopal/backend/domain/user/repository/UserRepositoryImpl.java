package glopal.backend.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import glopal.backend.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static glopal.backend.domain.user.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<User> findByEmail(String email) {
        User resultUser = jpaQueryFactory
                .selectFrom(user)
                .where(user.email.eq(email))
                .fetchOne();
        return Optional.ofNullable(resultUser);
    }

    @Override
    public Long findUserIdByEmail(String email){
        return jpaQueryFactory
                .select(user.id)
                .from(user)
                .where(user.email.eq(email))
                .fetchOne();
    }
}
