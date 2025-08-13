package glopal.backend.domain.card.service;

import glopal.backend.domain.card.dto.response.CardResponse;

public interface CardQueryService {
    CardResponse.CardList getCardList(Long userId);
}
