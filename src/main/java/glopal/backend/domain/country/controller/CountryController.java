package glopal.backend.domain.country.controller;

import glopal.backend.domain.country.dto.request.CountryRequest;
import glopal.backend.domain.country.dto.response.CountryResponse;
import glopal.backend.domain.country.service.CountryCommandService;
import glopal.backend.domain.country.service.CountryQueryService;
import glopal.backend.global.apiPayload.ApiResponse;
import glopal.backend.global.handler.annotation.Auth;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/countries")
public class CountryController {

    private final CountryCommandService countryCommandService;
    private final CountryQueryService countryQueryService;

    @Operation(
            summary = "여행 국가 등록 API",
            description = "사용자가 여행할 국가를 등록합니다."
    )
    @PostMapping
    public ApiResponse<CountryResponse.CountryInfo> createCountry(@RequestBody @Valid CountryRequest.CreateCountry createCountry) {
        CountryResponse.CountryInfo countryInfo = countryCommandService.createCountry(createCountry);
        return ApiResponse.onSuccess(countryInfo);
    }

    @Operation(
            summary = "여행 국가 조회 API",
            description = "사용자가 여행하는 국가를 조회합니다."
    )
    @GetMapping
    public ApiResponse<CountryResponse.CountryInfo> getCountry(@Auth Long userId){
        CountryResponse.CountryInfo countryInfo = countryQueryService.getCountry(userId);
        return ApiResponse.onSuccess(countryInfo);
    }
}
