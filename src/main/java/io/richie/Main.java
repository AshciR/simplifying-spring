package io.richie;

import io.richie.runners.DependencyInjectedRunner;
import io.richie.runners.TightlyCoupledRunner;

public class Main {

    public static void main(String[] args) {

        // Making an assumption that the first argument
        // will be the one that determines which runner to use
        String runnerArg = args[0];

        determineWhichRunnerToUse(runnerArg);
    }

    private static void determineWhichRunnerToUse(String runnerArg) {
        switch (runnerArg) {
            case "-t":
                new TightlyCoupledRunner().run();
                break;
            case "-d":
                new DependencyInjectedRunner().run();
                break;
            default:
                System.out.println("Not Ready yet");
                break;
        }
    }
}
