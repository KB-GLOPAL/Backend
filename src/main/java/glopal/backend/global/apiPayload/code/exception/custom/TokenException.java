package glopal.backend.global.apiPayload.code.exception.custom;

import glopal.backend.global.apiPayload.code.exception.GeneralException;
import glopal.backend.global.apiPayload.code.status.ErrorStatus;

public class TokenException extends GeneralException {

    public TokenException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
