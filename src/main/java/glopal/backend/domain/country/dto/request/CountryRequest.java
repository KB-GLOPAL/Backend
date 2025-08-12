package glopal.backend.domain.country.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CountryRequest {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCountry {
        @NotBlank(message = "국가 이름은 필수 입력 값입니다.")
        private String countryName;
    }
}
