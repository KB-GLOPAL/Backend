package domain.transaction.entity;

import glopal.backend.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BestTransaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "best_transaction_id")
    private Long id;

    @Column(name = "recommended_card", nullable = false)
    private String recommendedCard;

    @Column(name = "worst_card", nullable = false)
    private String worstCard;

    @Column(name = "saved_price", nullable = false)
    private Double savedPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "transaction_id")
    private Transaction transaction;
}
