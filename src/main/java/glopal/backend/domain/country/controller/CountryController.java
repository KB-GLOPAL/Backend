package glopal.backend.domain.country.controller;

import glopal.backend.domain.country.dto.request.CountryRequest;
import glopal.backend.domain.country.dto.response.CountryResponse;
import glopal.backend.domain.country.service.CountryCommandService;
import glopal.backend.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/countries")
public class CountryController {

    private final CountryCommandService countryCommandService;

    @Operation(
            summary = "여행 국가 등록 API",
            description = "사용자가 여행할 국가를 등록합니다."
    )
    @PostMapping
    public ApiResponse<CountryResponse.CountryInfo> createCountry(@RequestBody @Valid CountryRequest.CreateCountry createCountry) {
        CountryResponse.CountryInfo countryInfo = countryCommandService.createCountry(createCountry);
        return ApiResponse.onSuccess(countryInfo);
    }
}
