package glopal.backend.domain.transaction.dto.response;

import lombok.*;

public class TransactionResponse {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TransactionInfo {
        private Long transactionId;
        private String transactionPlace;
        private Double AmountLocal;
        private Double AmountConverted;
    }
}
