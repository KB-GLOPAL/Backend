package glopal.backend.domain.transaction.dto.response;

import glopal.backend.domain.card.entity.enums.CardBrand;
import glopal.backend.domain.card.entity.enums.CardType;
import lombok.*;

public class TransactionResponse {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TransactionInfo {
        private Long transactionId;
        private String transactionPlace;
        private Double amountLocal;
        private Double amountConverted;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class BestCardInfo {
        private String cardName;
        private CardBrand cardBrand;
        private CardType cardType;
        private Double amountLocal;
        private Double amountConverted;
        private String recommendedCard;
        private String worstCard;
        private Double savedPrice;
    }
}
