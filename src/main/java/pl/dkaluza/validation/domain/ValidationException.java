package pl.dkaluza.validation.domain;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<FieldError> errors;

    public ValidationException(List<FieldError> errors) {
        super(buildMessage(errors));
        this.errors = errors;
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
