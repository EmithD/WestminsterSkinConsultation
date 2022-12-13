import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static WestminsterSkinConsultationManager test = new WestminsterSkinConsultationManager();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {

        int resp;
        int count = 0;

        System.out.println("========== WELCOME TO WESTMINSTER SKIN CLINIC =============");

        while (true) {
            if (count == 0) {
                test.readData();
            }
            test.aLToAString();
            Scanner scan = new Scanner(System.in);
            try {
                System.out.print("""
                        \nOPTIONS:
                                        
                        1 Add a doctor
                        2 Delete a doctor
                        3 Display all doctors
                        4 Open GUI
                        5 Exit
                                        
                        ENTER OPTION NUMBER
                        """);
                resp = scan.nextInt();
                count++;
                if ((resp >= 0) && (resp <= 4)) {
                    switch (resp) {
                        case (1) -> test.addPerson();
                        case (2) -> test.deletePerson();
                        case (3) -> test.printList();
                        case (4) -> new HomePageController();
                    }
                } else if (resp == 5) {
                    test.saveData();
                    System.out.println("======================== Thank you =========================");
                    break;
                } else {
                    System.out.println("Invalid option entered. Enter again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value entered. Enter again.");
                scan.reset();
            }
        }
    }

}