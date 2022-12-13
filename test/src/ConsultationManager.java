import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultationManager {

    private final List<Consultation> consultations = new ArrayList<>();

    private final List<Doctor> doctorsConsultation = Main.test.getDoctors();

    public void addConsultation(Doctor doctor, String ID, String name, String surname, String dOB, String mobileNo, String email, String notes, String startTime, String noOfHours, String path){
        consultations.add(new Consultation(doctor, new Patient(ID, name, surname, dOB, mobileNo, email), notes, startTime, noOfHours, path));
        saveConsultation();
        System.out.println(consultations);
    }

    public void saveConsultation(){
        try{
            FileOutputStream fos = new FileOutputStream("savedConsultations.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(consultations.size());

            for(Consultation consultation: consultations){
                oos.writeObject(consultation);
            }
            oos.close();
            System.out.println("Consultation saved successfully");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readConsultations(){
        try{

            FileInputStream fis = new FileInputStream("savedConsultations.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            int size = ois.readInt();
            for(int i=0; i<size; i++){
                Consultation c = (Consultation) ois.readObject();
                consultations.add(c);
            }
            ois.close();
            System.out.println("Consultations read");

        } catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

}
