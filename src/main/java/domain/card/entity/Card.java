package domain.card.entity;

import domain.card.entity.enums.CardBrand;
import domain.card.entity.enums.CardType;
import domain.user.entity.User;
import glopal.backend.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "card_name", nullable = false, length = 50)
    private String cardName;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_brand", nullable = false)
    private CardBrand cardBrand;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false)
    private CardType cardType;

    @Column(name = "overseas_fee", nullable = false)
    private Double overseasFee;

    @Column(name = "cashback_rate", nullable = false)
    private Double cashbackRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
}
