package glopal.backend.domain.card.controller;

import glopal.backend.domain.card.dto.request.CardRequest;
import glopal.backend.domain.card.dto.response.CardResponse;
import glopal.backend.domain.card.service.CardCommandService;
import glopal.backend.domain.card.service.CardQueryService;
import glopal.backend.global.apiPayload.ApiResponse;
import glopal.backend.global.handler.annotation.Auth;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/cards")
public class CardController {

    private final CardCommandService cardCommandService;
    private final CardQueryService cardQueryService;

    @Operation(
            summary = "카드 등록 API",
            description = "사용자가 보유한 카드를 등록합니다."
    )
    @PostMapping
    public ApiResponse<CardResponse.CardInfo> createCard(@RequestBody @Valid CardRequest.CreateCard createCard){
        CardResponse.CardInfo cardInfo = cardCommandService.createCard(createCard);
        return ApiResponse.onSuccess(cardInfo);
    }

    @Operation(
            summary = "카드 리스트 조회 API",
            description = "보유한 카드 리스트를 조회합니다."
    )
    @GetMapping
    public ApiResponse<CardResponse.CardList> getCardList(@Auth Long userId){
        CardResponse.CardList cardList = cardQueryService.getCardList(userId);
        return ApiResponse.onSuccess(cardList);
    }
}
