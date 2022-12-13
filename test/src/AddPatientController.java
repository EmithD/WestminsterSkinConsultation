import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;

public class AddPatientController implements ActionListener {

    Font font = new Font("Times New Roman", Font.BOLD, 16);
    private ConsultationManager consultationManager = new ConsultationManager();
    private JFrame jFrame = new JFrame();
    private JButton backButton = new JButton("Back");
    private JButton submitPatientButton = new JButton("Add Consultation");
    private JButton checkAvailabilityButton = new JButton("Check Availability");
    private JButton browseButton = new JButton("Choose image of infected area");
    private JButton refreshButton = new JButton("Refresh");
    private JLabel previewLabel = new JLabel();
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField surnameField = new JTextField();
    private JTextField dOBField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField additionalInfo = new JTextField();
    private JLabel formNotFilledWarning = new JLabel();
    private JComboBox<String> doctorDrop = new JComboBox<>(getDoctorNameArray());
    private final JFormattedTextField mobileNoField;
    private final JFormattedTextField pickHours;
    private final JFormattedTextField timeField;

    AddPatientController(){

        consultationManager.readConsultations();

        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setSize(1200,700);

        Border border = BorderFactory.createLineBorder(Color.black, 2);
        Border border2 = BorderFactory.createLineBorder(Color.black, 1);

        JPanel header = new JPanel();
        header.setBounds(0,0, 1200, 40);
        header.setBackground(new Color(0xa4a8b0));
        header.setLayout(new BorderLayout());
        header.setBorder(border);

        JPanel header2 = new JPanel();
        header2.setBounds(0,40, 1200, 30);
        header2.setBackground(new Color(0xADADB4));
        header2.setLayout(new BorderLayout());
        header2.setBorder(border2);

        JLabel headerTopicText = new JLabel();
        headerTopicText.setText("Westminster Skin Consultation Manager");
        headerTopicText.setVerticalTextPosition(JLabel.CENTER);
        headerTopicText.setHorizontalAlignment(JLabel.CENTER);
        headerTopicText.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel addConsultationText = new JLabel();
        addConsultationText.setText("Add consultation");
        addConsultationText.setVerticalTextPosition(JLabel.CENTER);
        addConsultationText.setHorizontalAlignment(JLabel.CENTER);
        addConsultationText.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        JLabel patientDetailsText = new JLabel();
        patientDetailsText.setText("Enter patient details");
        patientDetailsText.setBounds(710, 110, 150, 25);
        patientDetailsText.setFont(font);

        JLabel pickDoctor = new JLabel();
        pickDoctor.setText("Check doctor availability");
        pickDoctor.setBounds(220, 110, 250, 25);
        pickDoctor.setFont(font);

        idField.setBounds(700, 150, 300, 25);

        nameField.setBounds(700,200, 300, 25);

        surnameField.setBounds(700, 250, 300, 25);

        dOBField.setBounds(700, 300, 300, 25);

        emailField.setBounds(700, 400, 300, 25);

        additionalInfo.setBounds(700, 450, 300, 25);

        JLabel iD = new JLabel();
        iD.setText("Patient ID");
        iD.setBounds(615, 150, 150, 25);
        iD.setFont(font);

        JLabel name = new JLabel();
        name.setText("Name");
        name.setBounds(615, 200, 150, 25);
        name.setFont(font);

        JLabel surname = new JLabel();
        surname.setText("Surname");
        surname.setBounds(615, 250, 150, 25);
        surname.setFont(font);

        JLabel dOB = new JLabel();
        dOB.setText("Date of birth");
        dOB.setBounds(615, 300, 150, 25);
        dOB.setFont(font);

        JLabel mobileNo = new JLabel();
        mobileNo.setText("Mobile No.");
        mobileNo.setBounds(615, 350, 150, 25);
        mobileNo.setFont(font);

        JLabel email = new JLabel();
        email.setText("Email");
        email.setBounds(615, 400, 150, 25);
        email.setFont(font);

        JLabel addiInfoText = new JLabel();
        addiInfoText.setText("Notes");
        addiInfoText.setBounds(615, 450, 150 , 25);
        addiInfoText.setFont(font);

        JLabel pickHoursText = new JLabel();
        pickHoursText.setText("Pick no. of Hours");
        pickHoursText.setBounds(150, 300, 150, 25);
        pickHoursText.setFont(font);

        MaskFormatter maskPhoneNo = null;
        try{
            maskPhoneNo = new MaskFormatter("##########");
            maskPhoneNo.setPlaceholderCharacter('#');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mobileNoField = new JFormattedTextField(maskPhoneNo);
        mobileNoField.setBounds(700, 350, 300, 25);

        MaskFormatter maskHours = null;
        try {
            maskHours = new MaskFormatter("# hours");
            maskHours.setPlaceholderCharacter('#');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pickHours = new JFormattedTextField(maskHours);
        pickHours.setBounds(300,300, 150, 25);

        checkAvailabilityButton.setBounds(150, 350, 300, 25);
        checkAvailabilityButton.setFont(font);
        checkAvailabilityButton.setFocusable(false);
        checkAvailabilityButton.setBorder(border2);

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBounds(250,200, 200, 50);
        datePicker.setFocusable(false);

        JLabel pickDateText = new JLabel();
        pickDateText.setText("Pick Date");
        pickDateText.setBounds(150, 200, 150,25);
        pickDateText.setFont(font);

        JLabel pickTimeText = new JLabel();
        pickTimeText.setText("Pick Time");
        pickTimeText.setBounds(150,250,150,25);
        pickTimeText.setFont(font);

        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##h##min");
            mask.setPlaceholderCharacter('#');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        timeField = new JFormattedTextField(mask);
        timeField.addActionListener(this);
        timeField.setBounds(250,250,200,25);

        browseButton.setBounds(700, 500, 300, 25);
        browseButton.setFocusable(false);
        browseButton.addActionListener(this);
        browseButton.setFont(font);
        browseButton.setBorder(border2);
        previewLabel.setBounds(600, 550, 500, 281);

        backButton.setBounds(10, 8, 80, 25);
        backButton.setFocusable(false);
        backButton.setFont(font);
        backButton.addActionListener(this);
        backButton.setBorder(border2);

        refreshButton.setBounds(1090, 8, 80, 25);
        refreshButton.setFocusable(false);
        refreshButton.setFont(font);
        refreshButton.addActionListener(this);
        refreshButton.setBorder(border2);

        submitPatientButton.setBounds(700, 550, 300, 25);
        submitPatientButton.setFocusable(false);
        submitPatientButton.addActionListener(this);
        submitPatientButton.setFont(font);
        submitPatientButton.setBorder(border2);

        formNotFilledWarning.setBounds(790, 580, 300, 25);
        formNotFilledWarning.setFont(font);

        doctorDrop.setBounds(150,150,300, 25);

        header.add(backButton);
        header.add(refreshButton);
        header.add(headerTopicText);
        header2.add(addConsultationText);

        jFrame.add(patientDetailsText);
        jFrame.add(browseButton);
        jFrame.add(previewLabel);
        jFrame.add(doctorDrop);
        jFrame.add(idField);
        jFrame.add(iD);
        jFrame.add(nameField);
        jFrame.add(name);
        jFrame.add(surnameField);
        jFrame.add(surname);
        jFrame.add(dOBField);
        jFrame.add(dOB);
        jFrame.add(mobileNoField);
        jFrame.add(mobileNo);
        jFrame.add(emailField);
        jFrame.add(email);
        jFrame.add(pickDoctor);
        jFrame.add(additionalInfo);
        jFrame.add(additionalInfo);
        jFrame.add(timeField);
        jFrame.add(pickDateText);
        jFrame.add(datePicker);
        jFrame.add(pickTimeText);
        jFrame.add(submitPatientButton);
        jFrame.add(header2);
        jFrame.add(header);
        jFrame.add(pickHours);
        jFrame.add(pickHoursText);
        jFrame.add(checkAvailabilityButton);
        jFrame.add(mobileNoField);
        jFrame.add(addiInfoText);
        jFrame.add(formNotFilledWarning);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
    }

    public ImageIcon resizeImage(String imagePath){
        ImageIcon MyImage = new ImageIcon(imagePath);
        Image image = MyImage.getImage();
        Image newImage = image.getScaledInstance(previewLabel.getWidth(),previewLabel.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        File selectedFile;
        String path = null;

        if(e.getSource() == backButton){
            new HomePageController();
            jFrame.dispose();
        }
        if(e.getSource() == refreshButton){
            jFrame.repaint();
            idField.setText("");
            nameField.setText("");
            surnameField.setText("");
            dOBField.setText("");
            mobileNoField.setText("");
            emailField.setText("");
            additionalInfo.setText("");
            pickHours.setText("");
            timeField.setText("");

        }
        if(e.getSource() == browseButton){
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("user.home"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","gif","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                jFrame.setSize(1200,930);
                submitPatientButton.setBounds(700, 850, 300, 25);
                formNotFilledWarning.setBounds(790, 880, 300, 25);
                previewLabel.setIcon(resizeImage(path));
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("None selected");
            }
        }
        if(e.getSource() == submitPatientButton){
            if(idField.getText().equals("") || nameField.getText().equals("")){
                formNotFilledWarning.setText("Form not complete.");
            } else {
                Main.test.aLToAObjects();
                int chosenDocIndex = doctorDrop.getSelectedIndex();

                String time = timeField.getText();
                String hour = time.substring(0,2);
                String minutes = time.substring(3,5);
                String startTime = hour+":"+minutes+":"+"00";

                consultationManager.addConsultation(Main.test.getDocArray()[chosenDocIndex], idField.getText(), nameField.getText(), surnameField.getText(), dOBField.getText(), mobileNoField.getText(), emailField.getText(), additionalInfo.getText(), startTime, pickHours.getText(), path);
            }
        }
    }



    public String[] getDoctorNameArray(){
        Main.test.sortList();
        Main.test.aLToAString();
        String[] docNames = new String[Main.test.getDoctors().size()];

        for(int i=0; i<Main.test.getDoctors().size(); i++){
            docNames[i] = Main.test.getDocStringArray()[i][0] + " specialising in " + Main.test.getDocStringArray()[i][6];
        }
        return docNames;
    }
}