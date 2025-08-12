package glopal.backend.domain.transaction.dto.request;

import glopal.backend.domain.transaction.entity.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TransactionRequest {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateTransaction {
        @NotBlank(message = "결제처는 필수 입력 값입니다.")
        private String transactionPlace;

        @NotNull(message = "결제 금액은 필수 입력 값입니다.")
        private Double amountLocal;

        @NotNull(message = "카테고리는 필수 입력 값입니다.")
        private Category category;
    }
}
