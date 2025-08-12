package glopal.backend.domain.transaction.entity;

import glopal.backend.domain.card.entity.Card;
import glopal.backend.domain.country.entity.Country;
import glopal.backend.domain.transaction.entity.enums.Category;
import glopal.backend.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "transaction_place", nullable = false)
    private String transactionPlace;

    @Column(name = "amount_local", nullable = false)
    private Double amountLocal;

    @Column(name = "amount_converted", nullable = false)
    private Double amountConverted;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Boolean recommended;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "card_id")
    private Card card;
}