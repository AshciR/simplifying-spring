package io.richie;

import io.richie.runners.*;

public class Main {

    public static void main(String[] args) {

        // Making an assumption that the first argument
        // will be the one that determines which runner to use
        String runnerArg = args[0];

        Runner runner = determineWhichRunnerToUse(runnerArg);
        runner.run();
    }

    /**
     * Because we're showing multiple ways to create and run an application
     * we want a method to use them interchangeably
     *
     * @param runnerArg the type of runner you want
     */
    static Runner determineWhichRunnerToUse(String runnerArg) {
        switch (runnerArg) {
            case "-t":
                return new TightlyCoupledRunner();
            case "-d":
                return new DependencyInjectedRunner();
            case "-e":
                return new SpringExplicitConfigRunner();
            case "-i":
                return new SpringImplicitConfigRunner();
            default:
                throw new RuntimeException("The argument you provided is not associated with a Runner");
        }
    }
}
