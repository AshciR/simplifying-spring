package io.richie.services

import io.richie.configs.ExplicitHospitalConfig
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import spock.lang.Specification

/**
 * JUnit (which Spock uses underneath the hood) provides
 * a @RunWith annotation that allows you to specify a test runner.
 *
 * Spring provides a @ContextConfiguration annotation that
 * we can use to specify which Spring configuration should
 * be used to create the beans for the Specification.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExplicitHospitalConfig.class)
class SpringHospitalIntegrationSpec extends Specification {

    // We said earlier that we should avoid field injection
    // but we have to make an exception for Spock specifications
    // doesn't allow constructors.
    @Autowired
    HospitalService hospitalService

    def "The Hospital should be autowired"() {
        expect: 'The hospital service to be autowired'
        null != hospitalService
    }

    def "Hospital should operate as expected"() {

        given: 'We have a hospital with a doctor'
        // Because we're treating this Specification as an Integration test
        // We're gonna use the real objects instead of mocks.
        // hospitalService will be injected by this point in the code

        when: 'We operate the hospital'
        String actualHospitalStatus = hospitalService.operateHospital()

        then: 'The hospital should function correctly'
        final String expectedStatus = 'SpringHospital is open. The PrimaryCareProvider is doing a checkup'
        expectedStatus == actualHospitalStatus

    }
}
