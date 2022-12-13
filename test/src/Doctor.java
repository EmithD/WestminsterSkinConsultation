import java.io.Serializable;

public class Doctor extends Person implements Comparable<Doctor>, Serializable {

    private String medLicenceNo;
    private String specialisation;



//CONSTRUCTOR

    public Doctor(String name, String surname, String dOB, String mobileNo, String email, String medLicenceNo, String specialisation) {
        super(name, surname, dOB, mobileNo, email);
        this.medLicenceNo = medLicenceNo;
        this.specialisation = specialisation;
    }

    public Doctor(Doctor d) {
        super(d.getName(), d.getSurname(), d.getdOB(), d.getMobileNo(), d.getEmail());
        this.medLicenceNo = d.getMedLicenceNo();
        this.specialisation = d.getSpecialisation();
    }

//GETTERS

    public String getMedLicenceNo() {
        return medLicenceNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }



    //SETTERS

    public void setMedLicenceNo(String medLicenceNo) {
        this.medLicenceNo = medLicenceNo;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


    @Override
    public String toString() {
        return "Name: " + super.getName() +
                "\nSurname: " + super.getSurname() +
                "\nDate of birth: " + super.getdOB() +
                "\nMobile Number: " + super.getMobileNo() +
                "\nemail: " + super.getEmail() +
                "\nMedical Licence number: " + medLicenceNo +
                "\nSpecialisation: " + specialisation;
    }

    @Override
    public int compareTo(Doctor o) {
        if(this.getSurname().compareTo(o.getSurname()) > (o.getSurname().compareTo(this.getSurname())))
            return 1;
        else if (this.getSurname().compareTo(o.getSurname()) < (o.getSurname().compareTo(this.getSurname()))) {
            return -1;
        } else
            return 0;
    }
}
