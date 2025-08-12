package glopal.backend.domain.card.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CardRequest {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCard {
        @NotBlank(message = "카드 이름은 필수 입력 값입니다.")
        private String cardName;

        @NotBlank(message = "카드 브랜드는 필수 입력 값입니다.")
        private String cardBrand;

        @NotBlank(message = "카드 종류는 필수 입력 값입니다.")
        private String cardType;
    }
}
