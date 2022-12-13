import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageController extends JFrame implements ActionListener{

    private JButton sortButton = new JButton();
    private JButton addPatientButton = new JButton();
    private JLabel updateSort = new JLabel();
    private JButton reviewConsultationButton = new JButton();

    private Border border = BorderFactory.createLineBorder(Color.black, 2);
    private Border border2 = BorderFactory.createLineBorder(Color.black, 1);

    HomePageController(){

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1300, 600);

        this.setTitle("Westminster Skin Clinic");


        String[] columnNames = {"Name", "Surname", "Date of Birth", "Mobile Number", "Email", "Medical Licence No.", "Specialisation"};
        JTable table = new JTable(Main.test.getDocStringArray(), columnNames);
        table.setRowHeight(30);
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 80 , 900, 323);

        JPanel header = new JPanel();
        header.setBounds(0,0, 1300, 40);
        header.setBackground(new Color(0xa4a8b0));
        header.setLayout(new BorderLayout());
        header.setBorder(border);

        JLabel headerTopicText = new JLabel();
        headerTopicText.setText("Westminster Skin Consultation Manager");
        headerTopicText.setVerticalTextPosition(JLabel.CENTER);
        headerTopicText.setHorizontalAlignment(JLabel.CENTER);
        headerTopicText.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JPanel doctorTopicPanel = new JPanel();
        doctorTopicPanel.setBounds(0, 40, 900,40);
        doctorTopicPanel.setBackground(new Color(0xbac0cc));
        doctorTopicPanel.setBorder(border2);
        doctorTopicPanel.setLayout(new BorderLayout());

        JLabel doctorTopicText = new JLabel();
        doctorTopicText.setText("Doctors");
        doctorTopicText.setVerticalTextPosition(JLabel.CENTER);
        doctorTopicText.setHorizontalAlignment(JLabel.CENTER);
        doctorTopicText.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        sortButton.setBounds(450, 450, 60, 25);
        sortButton.addActionListener(this);
        sortButton.setText("Sort");
        sortButton.setFocusable(false);
        sortButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sortButton.setBorder(border2);

        updateSort.setBounds(475, 450, 300, 25);
        updateSort.setVerticalTextPosition(JLabel.CENTER);
        updateSort.setHorizontalAlignment(JLabel.CENTER);
        updateSort.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        addPatientButton.setBounds(1000, 130, 200,25);
        addPatientButton.addActionListener(this);
        addPatientButton.setText("Add Patient");
        addPatientButton.setFocusable(false);
        addPatientButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addPatientButton.setBorder(border2);

        reviewConsultationButton.setBounds(1000, 180, 200,25);
        reviewConsultationButton.setText("Review Consultation");
        reviewConsultationButton.addActionListener(this);
        reviewConsultationButton.setFocusable(false);
        reviewConsultationButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        reviewConsultationButton.setBorder(border2);


        this.add(header);
        header.add(headerTopicText);

        this.add(doctorTopicPanel);
        doctorTopicPanel.add(doctorTopicText);

        this.add(scrollPane);

        this.add(updateSort);

        this.add(sortButton);
        this.add(addPatientButton);
        this.add(reviewConsultationButton);

        this.setVisible(true);

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public void reviewConsultationPage(){

        JFrame reviewPage = new JFrame();
        reviewPage.setSize(1000, 400);
        reviewPage.setResizable(false);

        JPanel header = new JPanel();
        header.setBounds(0,0, 1300, 40);
        header.setBackground(new Color(0xa4a8b0));
        header.setLayout(new BorderLayout());
        header.setBorder(border);

        JLabel headerTopicText = new JLabel();
        headerTopicText.setText("Westminster Skin Consultation Manager");
        headerTopicText.setVerticalTextPosition(JLabel.CENTER);
        headerTopicText.setHorizontalAlignment(JLabel.CENTER);
        headerTopicText.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        header.add(headerTopicText);

        reviewPage.add(header);

        reviewPage.setVisible(true);
        reviewPage.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sortButton){

            if(Main.test.getDoctors().size() == 0){
                updateSort.setText("List of Doctors empty.");
            } else{
                Main.test.sortList();
                Main.test.aLToAString();
                this.repaint();
                updateSort.setText("Doctors sorted based on surname.");
            }
        }
        if(e.getSource() == addPatientButton){
            new AddPatientController();
            this.dispose();
        }
        if(e.getSource() == reviewConsultationButton){
            reviewConsultationPage();
            this.dispose();
        }
    }
}