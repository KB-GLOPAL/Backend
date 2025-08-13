package glopal.backend.domain.spending.dto.response;

import lombok.*;

public class SpendingResponse {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SpendingRatio {
        private Double transportation;
        private Double accommodation;
        private Double food;
        private Double attractions;
        private Double shopping;
        private Double others;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SavedPrice {
        private Double savedPrice;
    }
}
