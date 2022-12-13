public class Patient extends Person{
    private String patientID;

    public Patient() {
    }
//CONSTRUCTORS

    public Patient(String patientID, String name, String surname, String dOB, String mobileNo, String email ) {
        super(name, surname, dOB, mobileNo, email);
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Patient{" +
                "patientID='" + patientID + '\'' +
                '}';
    }
    //GETTERS

    public String getPatientID() {
        return patientID;
    }

    //SETTERS

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

}
