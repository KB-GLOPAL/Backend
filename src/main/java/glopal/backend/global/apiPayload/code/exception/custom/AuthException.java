package glopal.backend.global.apiPayload.code.exception.custom;

import glopal.backend.global.apiPayload.code.exception.GeneralException;
import glopal.backend.global.apiPayload.code.status.ErrorStatus;

public class AuthException extends GeneralException {

    public AuthException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
