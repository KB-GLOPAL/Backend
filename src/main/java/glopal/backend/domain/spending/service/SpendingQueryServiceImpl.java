package glopal.backend.domain.spending.service;

import glopal.backend.domain.spending.dto.response.SpendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SpendingQueryServiceImpl implements SpendingQueryService {

    @Override
    public SpendingResponse.SpendingRatio getSpendingRatio(Long userId) {
        return null;
    }

    @Override
    public SpendingResponse.SavedPrice getSavedPrice(Long userId) {
        return null;
    }
}
