package glopal.backend.domain.card.controller;

import glopal.backend.domain.card.dto.request.CardRequest;
import glopal.backend.domain.card.dto.response.CardResponse;
import glopal.backend.domain.card.service.CardCommandService;
import glopal.backend.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/cards")
public class CardController {

    private final CardCommandService cardCommandService;

    @Operation(
            summary = "일반 회원가입 API",
            description = "사용자가 일반 회원가입을 합니다."
    )
    @PostMapping
    public ApiResponse<CardResponse.CardInfo> createCard(@RequestBody @Valid CardRequest.CreateCard createCard){
        CardResponse.CardInfo cardInfo = cardCommandService.createCard(createCard);
        return ApiResponse.onSuccess(cardInfo);
    }
}
