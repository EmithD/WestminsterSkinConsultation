import java.io.Serializable;

abstract class Person implements Serializable{

    private String name;
    private String surname;
    private String dOB;
    private String mobileNo;
    private String email;

    //CONSTRUCTOR

    public Person(String name, String surname, String dOB, String mobileNo, String email) {
        this.name = name;
        this.surname = surname;
        this.dOB = dOB;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public Person() {
    }

//GETTERS

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getdOB() {
        return dOB;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dOB='" + dOB + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


    public void setEmail(String email) {
        this.email = email;
    }

}
