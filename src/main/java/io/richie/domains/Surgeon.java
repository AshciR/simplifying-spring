package io.richie.domains;

public class Surgeon implements Doctor {
    @Override
    public String practice() {
        return this.getClass().getSimpleName() + " is performing surgery";
    }
}
