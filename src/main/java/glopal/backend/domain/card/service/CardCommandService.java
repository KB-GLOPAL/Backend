package glopal.backend.domain.card.service;

import glopal.backend.domain.card.dto.request.CardRequest;
import glopal.backend.domain.card.dto.response.CardResponse;

public interface CardCommandService {
    CardResponse.CardInfo createCard(CardRequest.CreateCard createCard);
}
