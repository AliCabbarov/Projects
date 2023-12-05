package com.library.libmanagesys.model.exceptions;

import com.library.libmanagesys.model.enums.Exceptions;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
public class ApplicationException extends RuntimeException {
    private final Exceptions exceptions;
    public ApplicationException(Exceptions e) {
        super(e.getMessage());
        this.exceptions = e;
    }
}
