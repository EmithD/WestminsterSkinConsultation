import java.io.File;
import java.io.Serializable;

public class Consultation implements Serializable {

    private Patient patient;
    private String notes;
    private Doctor doctor;
    private String startTime;
    private String noOfHours;
    private String path;


    public Consultation(Doctor doctor, Patient patient, String notes, String startTime, String noOfHours, String path) {

        this.doctor = doctor;
        this.patient = patient;
        this.notes = notes;
        this.startTime = startTime;
        this.noOfHours = noOfHours;
        this.path = path;

    }

    @Override
    public String toString() {
        return "Consultation{" +
                "patient=" + patient +
                ", notes='" + notes + '\'' +
                ", doctor=" + doctor +
                ", startTime='" + startTime + '\'' +
                ", noOfHours='" + noOfHours + '\'' +
                '}';
    }
}

