package glopal.backend.domain.spending.entity;

import glopal.backend.domain.transaction.entity.Transaction;
import glopal.backend.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SpendingReport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spending_report_id")
    private Long id;

    @Column(name = "total_spent", nullable = false)
    private Double totalSpent;

    @Column(name = "total_saved", nullable = false)
    private Double totalSaved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "transaction_id")
    private Transaction transaction;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "spending_category_id")
    private SpendingCategory spendingCategory;
}
