package io.richie;

import io.richie.runners.TightlyCoupledRunner;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final boolean tightlyCoupledFlagIsPresent = Arrays
                .stream(args)
                .anyMatch(arg -> arg.equalsIgnoreCase("-t"));

        if (tightlyCoupledFlagIsPresent) {
            new TightlyCoupledRunner().run();
        } else {
            System.out.println("Hello World");
        }
    }
}
