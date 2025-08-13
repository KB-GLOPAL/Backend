package glopal.backend.domain.transaction.controller;

import glopal.backend.domain.transaction.dto.request.TransactionRequest;
import glopal.backend.domain.transaction.dto.response.TransactionResponse;
import glopal.backend.domain.transaction.service.TransactionCommandService;
import glopal.backend.domain.transaction.service.TransactionQueryService;
import glopal.backend.global.apiPayload.ApiResponse;
import glopal.backend.global.handler.annotation.Auth;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/cards/{cardId}/transactions")
public class TransactionController {

    private final TransactionCommandService transactionCommandService;
    private final TransactionQueryService transactionQueryService;

    @Operation(
            summary = "결제 내역 등록 API",
            description = "여행 중 결제할 내역을 등록합니다."
    )
    @PostMapping
    public ApiResponse<TransactionResponse.TransactionInfo> createTransaction(@RequestBody @Valid TransactionRequest.CreateTransaction createTransaction){
        TransactionResponse.TransactionInfo transactionInfo = transactionCommandService.createTransaction(createTransaction);
        return ApiResponse.onSuccess(transactionInfo);
    }

    @Operation(
            summary = "전체 결제 내역 조회 API",
            description = "전체 결제 내역을 조회합니다."
    )
    @GetMapping
    public ApiResponse<TransactionResponse.TransactionList> getTransactionList(@Auth Long userId){
        TransactionResponse.TransactionList transactionList = transactionQueryService.getTransactionList(userId);
        return ApiResponse.onSuccess(transactionList);
    }

    @Operation(
            summary = "분석 결과 조회 API",
            description = "AI로 분석한 최적의 결제 수단를 조회합니다."
    )
    @GetMapping("/best")
    public ApiResponse<TransactionResponse.BestCardInfo> getBestCard(@PathVariable("cardId") Long cardId){
        TransactionResponse.BestCardInfo bestCardInfo = transactionQueryService.getBestCardInfo(cardId);
        return ApiResponse.onSuccess(bestCardInfo);
    }
}