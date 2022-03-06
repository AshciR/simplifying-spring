package io.richie.domains;

/**
 * Interface used to represent doctors who can work at the hospital.
 * Implementing classes should make their doctor report what
 * they are doing as a String.
 */
public interface Doctor {

    /**
     * Returns a string that describes the work the doctor is doing
     *
     * @return the work the doctor is doing
     */
    String practice();

}
