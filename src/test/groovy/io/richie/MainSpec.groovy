package io.richie

import io.richie.runners.*
import spock.lang.Specification
import spock.lang.Unroll

class MainSpec extends Specification {

    @Unroll
    def "Should return #expectedRunnerClass.getSimpleName() when #arg input argument is passed in"() {

        when: 'We determine which runner to use'
        Runner actualRunner = Main.determineWhichRunnerToUse(arg)

        then: 'The correct runner should be returned'
        expectedRunnerClass == actualRunner.class

        where:
        arg  | expectedRunnerClass
        '-t' | TightlyCoupledRunner.class
        '-d' | DependencyInjectedRunner.class
        '-e' | SpringExplicitConfigRunner.class
        '-i' | SpringImplicitConfigRunner.class

    }

}
