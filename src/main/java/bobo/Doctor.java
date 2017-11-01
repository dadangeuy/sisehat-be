package bobo;

import jongko.User;

public class Doctor extends User {
    String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
