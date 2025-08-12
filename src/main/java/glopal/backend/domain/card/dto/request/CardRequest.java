package glopal.backend.domain.card.dto.request;

import glopal.backend.domain.card.entity.enums.CardBrand;
import glopal.backend.domain.card.entity.enums.CardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

        @NotNull(message = "카드 브랜드는 필수 입력 값입니다.")
        private CardBrand cardBrand;

        @NotNull(message = "카드 종류는 필수 입력 값입니다.")
        private CardType cardType;
    }
}
