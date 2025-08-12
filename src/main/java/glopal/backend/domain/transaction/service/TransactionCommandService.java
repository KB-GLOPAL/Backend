package glopal.backend.domain.transaction.service;

import glopal.backend.domain.transaction.dto.request.TransactionRequest;
import glopal.backend.domain.transaction.dto.response.TransactionResponse;

public interface TransactionCommandService {
    TransactionResponse.TransactionInfo createTransaction(TransactionRequest.CreateTransaction createTransaction);
}
