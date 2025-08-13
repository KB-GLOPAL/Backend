package glopal.backend.domain.card.service;

import glopal.backend.domain.card.dto.response.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    @Override
    public CardResponse.CardList getCardList(Long userId) {
        return null;
    }
}
