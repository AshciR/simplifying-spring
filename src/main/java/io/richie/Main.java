package io.richie;

import io.richie.runners.DependencyInjectedRunner;
import io.richie.runners.SpringExplicitConfigRunner;
import io.richie.runners.SpringImplicitConfigRunner;
import io.richie.runners.TightlyCoupledRunner;

public class Main {

    public static void main(String[] args) {

        // Making an assumption that the first argument
        // will be the one that determines which runner to use
        String runnerArg = args[0];

        determineWhichRunnerToUse(runnerArg);
    }

    /**
     * Because we're showing 3 ways to create and run an application
     * we want a method to use them interchangeably
     *
     * @param runnerArg the type of runner you want
     */
    private static void determineWhichRunnerToUse(String runnerArg) {
        switch (runnerArg) {
            case "-t":
                new TightlyCoupledRunner().run();
                break;
            case "-d":
                new DependencyInjectedRunner().run();
                break;
            case "-e":
                new SpringExplicitConfigRunner().run();
                break;
            case "-i":
                new SpringImplicitConfigRunner().run();
                break;
            default:
                throw new RuntimeException("The argument you provided is not associated with a Runner");
        }
    }
}
