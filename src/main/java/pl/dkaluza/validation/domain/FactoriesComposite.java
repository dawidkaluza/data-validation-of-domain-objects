package pl.dkaluza.validation.domain;

import java.util.ArrayList;
import java.util.List;

class FactoriesComposite<T> extends Factory<T> {
    private final Assembler<T> assembler;
    private final List<Factory<?>> factories;

    FactoriesComposite(Assembler<T> assembler, Factory<?>... factories) {
        this(assembler, List.of(factories));
    }

    FactoriesComposite(Assembler<T> assembler, List<? extends Factory<?>> factories) {
        this.assembler = assembler;
        this.factories = new ArrayList<>(factories);
    }

    @Override
    protected List<FieldError> validate() {
        List<FieldError> errors = new ArrayList<>();
        for (Factory<?> factory : factories) {
            errors.addAll(factory.validate());
        }
        return errors;
    }

    @Override
    protected T assemble() {
        return assembler.assemble();
    }
}