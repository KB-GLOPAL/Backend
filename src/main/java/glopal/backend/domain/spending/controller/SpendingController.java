package glopal.backend.domain.spending.controller;

import glopal.backend.domain.spending.dto.response.SpendingResponse;
import glopal.backend.domain.spending.service.SpendingQueryService;
import glopal.backend.global.apiPayload.ApiResponse;
import glopal.backend.global.handler.annotation.Auth;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/spending")
public class SpendingController {

    private final SpendingQueryService spendingQueryService;

    @Operation(
            summary = "소비 비율 조회 API",
            description = "여행하는 동안 사용한 소비의 카테고리별 비율을 조회합니다."
    )
    @GetMapping("/ratio")
    public ApiResponse<SpendingResponse.SpendingRatio> getSpendingRatio(@Auth Long userId) {
        SpendingResponse.SpendingRatio spendingRatio = spendingQueryService.getSpendingRatio(userId);
        return ApiResponse.onSuccess(spendingRatio);
    }

    @Operation(
            summary = "절약한 금액 조회 API",
            description = "여행 기간동안 절약한 금액을 조회합니다."
    )
    @GetMapping("/saved")
    public ApiResponse<SpendingResponse.SavedPrice> getSavedPrice(@Auth Long userId) {
        SpendingResponse.SavedPrice savedPrice = spendingQueryService.getSavedPrice(userId);
        return ApiResponse.onSuccess(savedPrice);
    }
}
