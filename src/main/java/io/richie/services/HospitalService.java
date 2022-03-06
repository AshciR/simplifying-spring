package io.richie.services;

/**
 * Interface that represents a hospital.
 * Implementing classes should report that
 * the hospital is open and tell us what
 * work the doctor is doing.
 */
public interface HospitalService {
    /**
     * Should provide updates about what's happening in
     * the hospital.
     */
    String operateHospital();
}
