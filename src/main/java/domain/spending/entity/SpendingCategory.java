package domain.spending.entity;

import glopal.backend.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SpendingCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spending_category_id")
    private Long id;

    private Double transportation;

    private Double accommodation;

    private Double food;

    private Double attractions;

    private Double shopping;

    private Double others;
}
