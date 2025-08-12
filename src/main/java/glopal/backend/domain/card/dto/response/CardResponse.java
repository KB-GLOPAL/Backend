package glopal.backend.domain.card.dto.response;

import lombok.*;

public class CardResponse {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CardInfo {
        private Long cardId;
        private String cardName;
    }
}
