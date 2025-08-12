package glopal.backend.domain.card.service;

import glopal.backend.domain.card.dto.request.CardRequest;
import glopal.backend.domain.card.dto.response.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService{

    @Override
    public CardResponse.CardInfo createCard(CardRequest.CreateCard createCard) {
        return null;
    }
}
