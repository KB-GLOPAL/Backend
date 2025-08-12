package glopal.backend.global.apiPayload.code.exception.custom;

import glopal.backend.global.apiPayload.code.exception.GeneralException;
import glopal.backend.global.apiPayload.code.status.ErrorStatus;
import lombok.Getter;

@Getter
public class BadRequestException extends GeneralException {

    public BadRequestException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
