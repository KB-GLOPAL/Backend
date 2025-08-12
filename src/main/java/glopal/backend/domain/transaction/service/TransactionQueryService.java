package glopal.backend.domain.transaction.service;

import glopal.backend.domain.transaction.dto.response.TransactionResponse;

public interface TransactionQueryService {
    TransactionResponse.BestCardInfo getBestCardInfo(Long cardId);
}
