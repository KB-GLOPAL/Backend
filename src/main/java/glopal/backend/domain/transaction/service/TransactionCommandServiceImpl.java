package glopal.backend.domain.transaction.service;

import glopal.backend.domain.transaction.dto.request.TransactionRequest;
import glopal.backend.domain.transaction.dto.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {

    @Override
    public TransactionResponse.TransactionInfo createTransaction(TransactionRequest.CreateTransaction createTransaction) {
        return null;
    }
}
