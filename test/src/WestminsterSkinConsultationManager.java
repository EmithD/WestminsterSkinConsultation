import java.io.*;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    private final List<Doctor> doctors = new ArrayList<>();
    private String[][] docStringArray = new String[10][7];
    private Doctor[] docArray;


    public WestminsterSkinConsultationManager() {
    }

    @Override
    public void addPerson() {

        if(doctors.size() < 10) {

            String name, surname, dOB, email, medicalLicenceNo, specialisation;
            String mobileNo = null;

            boolean end = false;

            while (!end) {
                System.out.println();
                System.out.println("============ ENTER THE INFORMATION OF THE DOCTOR ============");

                Scanner scan = new Scanner(System.in);
                System.out.println("Enter name");
                name = scan.nextLine();
                System.out.println("Enter surname");
                surname = scan.nextLine();
                System.out.println("Enter the date of birth");
                dOB = scan.nextLine();

                boolean tpValidType = false;

                while (!tpValidType) {
                    Scanner scanTP = new Scanner(System.in);
                    scanTP.reset();
                    try {
                        boolean tpValidLength = false;
                        while (!tpValidLength) {
                            System.out.println("Enter mobile number");
                            mobileNo = scanTP.next();
                            int lengthTP = mobileNo.length();
                            if (lengthTP != 10) {
                                System.out.println("Invalid mobile number. Enter again.");
                                scanTP.reset();
                            } else {
                                tpValidLength = true;
                                tpValidType = true;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid mobile number. Enter again.");
                        scanTP.reset();
                    }
                }

                System.out.println("Enter the email");
                email = scan.nextLine();
                System.out.println("Enter medical licence number");
                medicalLicenceNo = scan.nextLine();
                System.out.println("Enter specialisation");
                specialisation = scan.nextLine();



                doctors.add(new Doctor(capitalizeFirstLetter(name), capitalizeFirstLetter(surname), dOB, mobileNo, email, medicalLicenceNo, specialisation));
                scan.reset();

                if (endLoop())
                    end = true;

                System.out.println("============================================================");
            }
        } else {
            System.out.println("Maximum capacity of doctors reached.");
            System.out.println("============================================================");
        }
    }

    @Override
    public void deletePerson() {

        Scanner scan = new Scanner(System.in);

        String toBeRemovedID;

        if(doctors.size() == 0) {
            System.out.println("List of doctors are empty.");
        }else{
            System.out.println();
            System.out.println("===================== REMOVE A DOCTOR =====================");

            boolean end = false;
            while (!end) {
                if(doctors.size() == 0){
                    System.out.println("List of doctors are empty.");
                    System.out.println("============================================================");
                    end = true;
                } else {
                    System.out.println("Enter the Medical licence number of the doctor to be removed");
                    toBeRemovedID = scan.next();

                    Iterator<Doctor> i = doctors.iterator();

                    boolean removed = false;

                    while (i.hasNext()) {
                        Doctor test;
                        test = i.next();
                        if (test.getMedLicenceNo().equals(toBeRemovedID)) {
                            String line = ("Dr. " + test.getName() + " " + test.getSurname() + " with medical licence number: " + test.getMedLicenceNo() + " removed.");
                            i.remove();
                            removed = true;
                            System.out.println(line);
                        }
                    }
                    if(!removed){
                        System.out.println(toBeRemovedID + " not found.");
                    }
                    if (endLoop())
                        end = true;
                    System.out.println("============================================================");
                }
            }
        }
    }

    public void sortList(){
        Collections.sort(doctors);
    }

    public void printList(){

        sortList();

        System.out.println("========================= DOCTORS ============================");
        if(doctors.size() == 0){
            System.out.println("List of doctors are empty.");
        } else{
            for(Doctor doc: doctors){
                System.out.println(doc);
                System.out.println("=============================================================");
            }
        }
    }

    public void saveData()  {
        try {
            FileOutputStream fos = new FileOutputStream("saveData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(doctors.size());

            for(Doctor docs: doctors){
                oos.writeObject(docs);
            }
            oos.close();
            System.out.println("All data saved");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readData(){
        try {
            FileInputStream fis = new FileInputStream("saveData.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            int size = ois.readInt();
            for(int i=0; i < size; i++){
                Doctor d = (Doctor) ois.readObject();
                doctors.add(d);
            }
            ois.close();
            System.out.println("Data read");

        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void aLToAString() {
        int i = 0;
        for (Doctor d : doctors) {
            docStringArray[i][0] = d.getName();
            docStringArray[i][1] = d.getSurname();
            docStringArray[i][2] = d.getdOB();
            docStringArray[i][3] = d.getMobileNo();
            docStringArray[i][4] = d.getEmail();
            docStringArray[i][5] = d.getMedLicenceNo();
            docStringArray[i][6] = d.getSpecialisation();
            i++;
        }
    }

    public void aLToAObjects(){
        docArray = doctors.toArray(new Doctor[0]);
    }

    public Doctor[] getDocArray() {
        return docArray;
    }

    public boolean endLoop(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any character to exit to main menu. Press Y to enter again.");
        String resp = scan.next();

        if(resp.equals("y") || resp.equals("Y")){
            scan.reset();
            return false;
        } else {
            return true;
        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public String[][] getDocStringArray() {
        return docStringArray;
    }

}