package glopal.backend.global.apiPayload.code.exception.handler;

import glopal.backend.global.apiPayload.code.BaseErrorCode;
import glopal.backend.global.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}