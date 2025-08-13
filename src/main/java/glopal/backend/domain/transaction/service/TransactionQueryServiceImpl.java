package glopal.backend.domain.transaction.service;

import glopal.backend.domain.transaction.dto.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    @Override
    public TransactionResponse.TransactionList getTransactionList(Long userId) {
        return null;
    }

    @Override
    public TransactionResponse.BestCardInfo getBestCardInfo(Long cardId) {
        return null;
    }
}
