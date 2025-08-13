package glopal.backend.domain.spending.service;

import glopal.backend.domain.spending.dto.response.SpendingResponse;

public interface SpendingQueryService {
    SpendingResponse.SavedPrice getSavedPrice(Long userId);
}
