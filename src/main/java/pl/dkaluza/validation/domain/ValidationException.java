package pl.dkaluza.validation.domain;

import java.util.List;

public class ValidationException extends RuntimeException {
    public ValidationException(List<FieldError> fieldErrors) {
        super(buildMessage(fieldErrors));
    }

    private static String buildMessage(List<FieldError> fieldErrors) {
        StringBuilder builder = new StringBuilder();
        builder.append("The following fields are invalid: ");
        for (var error : fieldErrors) {
            builder
                .append(error.field())
                .append(": ")
                .append(error.error())
                .append("; ");
        }
        return builder.toString();
    }
}
