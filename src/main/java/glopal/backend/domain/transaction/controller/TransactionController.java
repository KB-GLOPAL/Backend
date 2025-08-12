package glopal.backend.domain.transaction.controller;

import glopal.backend.domain.transaction.dto.request.TransactionRequest;
import glopal.backend.domain.transaction.dto.response.TransactionResponse;
import glopal.backend.domain.transaction.service.TransactionCommandService;
import glopal.backend.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/transactions")
public class TransactionController {

    private final TransactionCommandService transactionCommandService;

    @Operation(
            summary = "결제 내역 등록 API",
            description = "여행 중 결제할 내역을 등록합니다."
    )
    @PostMapping
    public ApiResponse<TransactionResponse.TransactionInfo> createTransaction(@RequestBody @Valid TransactionRequest.CreateTransaction createTransaction){
        TransactionResponse.TransactionInfo transactionInfo = transactionCommandService.createTransaction(createTransaction);
        return ApiResponse.onSuccess(transactionInfo);
    }
}