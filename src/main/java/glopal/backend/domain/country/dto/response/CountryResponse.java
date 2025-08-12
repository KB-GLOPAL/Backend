package glopal.backend.domain.country.dto.response;

import lombok.*;

public class CountryResponse {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CountryInfo {
        private Long countryId;
        private String countryName;
    }
}
