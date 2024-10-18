package pl.dkaluza.validation.domain;

import java.util.Collections;
import java.util.List;

public abstract class Factory<T> {
    private List<FieldError> errors;
    private boolean isReviewed;

    public Factory() {
        errors = Collections.emptyList();
        isReviewed = false;
    }

    /**
     * Performs validation on given object and returns list of errors.
     */
    protected abstract List<FieldError> validate();

    /**
     * Instantiates and returns given object.
     */
    protected abstract T assemble();

    /**
     * Checks if given object is valid.
     * First call runs validation, caches the results and returns them.
     * Next calls just return the cached results.
     */
    public List<FieldError> review() {
        if (isReviewed) {
            return errors;
        }

        this.errors = validate();
        isReviewed = true;
        return Collections.unmodifiableList(errors);
    }

    /**
     * Reviews object (via review method).
     * If errors were found during the review, validation exception is thrown.
     * Otherwise, object is assembled (via assemble method) and returned.
     */
    public T produce() throws ValidationException {
        var errors = review();
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        return assemble();
    }
}
