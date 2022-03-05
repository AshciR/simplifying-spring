package io.richie.services

import io.richie.domains.Doctor
import spock.lang.Specification

class DependencyInjectedHospitalSpec extends Specification {


    def "Hospital should operate as expected"() {

        given: 'We have a doctor who can practice'
        Doctor mockDoctor = Mock(Doctor)
        // Because we mocked the Doctor interface, we can tell it
        // to return whatever value we want when the practice() method is called.
        mockDoctor.practice() >> "Mock Doctor is practicing medicine"

        and: 'We have a hospital with said doctor'
        // And thanks to dependency injection we can pass whatever
        // doctor we want to work in the hospital, vs the Hospital being forced
        // to only use a specific Surgeon.
        HospitalService hospitalService = new DependencyInjectedHospital(mockDoctor)

        when: 'We operate the hospital'
        String actualHospitalStatus = hospitalService.operateHospital()

        then: 'The hospital should function correctly'
        final String expectedStatus = 'DependencyInjectedHospital is open. The Mock Doctor is practicing medicine'
        expectedStatus == actualHospitalStatus

    }

}
