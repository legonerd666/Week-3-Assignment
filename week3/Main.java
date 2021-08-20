package week3;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static JFrame appFrame;
    private static JPanel mainScreen;
    private static JPanel mainStudentScreen;
    private static JPanel studentDataScreen;

    private static int role;
    private static int studentID;

    public static void main(String[] args) {
        
        createScreens();
        
        appFrame.getContentPane().add(mainScreen);

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setTitle("Student Database");
        appFrame.pack();
        appFrame.setVisible(true);

    }

    public static void createScreens(){

        appFrame = new JFrame();
        mainScreen(appFrame);
        mainStudentScreen(appFrame);
        studentDataScreen(appFrame);

    }

    public static void mainScreen(JFrame frame){

        //Creates an empty panel
        mainScreen = new JPanel(new GridBagLayout());
        GridBagConstraints pConstraints = new GridBagConstraints();



        //Creates the intro text label
        JLabel introL = new JLabel("Pick a Role:");

        pConstraints.gridx = 0;
        pConstraints.gridy = 0;

        mainScreen.add(introL, pConstraints);
    


        //Creates the radio buttons
        JRadioButton studentRB = new JRadioButton("Student");

        pConstraints.gridx = 0;
        pConstraints.gridy = 2;

        studentRB.setFocusable(false);

        studentRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                role = 0;
            }

        });

        mainScreen.add(studentRB, pConstraints);


        JRadioButton teacherRB = new JRadioButton("Teacher");

        pConstraints.gridx = 0;
        pConstraints.gridy = 3;

        teacherRB.setFocusable(false);

        teacherRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                role = 1;
            }

        });

        mainScreen.add(teacherRB, pConstraints);


        JRadioButton adminRB = new JRadioButton("Administrator");

        pConstraints.gridx = 0;
        pConstraints.gridy = 4;

        adminRB.setFocusable(false);

        adminRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                role = 2;
            }

        });

        mainScreen.add(adminRB, pConstraints);



        //Puts the radio buttons into a group so that only one can be selected at the same time
        ButtonGroup roleBG = new ButtonGroup();

        roleBG.add(studentRB);
        roleBG.add(teacherRB);
        roleBG.add(adminRB);



        //Creates the button to select your role
        JButton selectRoleB = new JButton("Select Role");

        pConstraints.gridx = 0;
        pConstraints.gridy = 5;

        selectRoleB.setFocusable(false);

        selectRoleB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (role == 0){
                    System.out.println("Student Selected");
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(mainStudentScreen);
                } else if (role == 1) {
                    System.out.println("Teacher");
                    frame.getContentPane().removeAll();
                } else if (role == 2){
                    System.out.println("Admin");
                    frame.getContentPane().removeAll();
                } else {
                    System.out.println("No Role Selected");
                }
            }

        });

        mainScreen.add(selectRoleB, pConstraints);



        //Sets the panel to visible by default
        mainScreen.setVisible(true);



    }

    public static void mainStudentScreen(JFrame frame){

        //Creates an empty panel
        mainStudentScreen = new JPanel(new GridBagLayout());
        GridBagConstraints pConstraints = new GridBagConstraints();



        //Creates the intro label
        JLabel introL = new JLabel("Enter your student ID number:");

        pConstraints.gridx = 0;
        pConstraints.gridy = 0;

        mainStudentScreen.add(introL, pConstraints);



        //Creates the input field
        JTextField inputTF = new JTextField();

        pConstraints.gridx = 0;
        pConstraints.gridy = 1;
        pConstraints.fill = GridBagConstraints.HORIZONTAL;

        mainStudentScreen.add(inputTF, pConstraints);



        //Creates the error message text for if a non-number is entered as an id
        JLabel errorL = new JLabel("Not a Number");

        pConstraints.gridx = 0;
        pConstraints.gridy = 2;

        errorL.setForeground(Color.RED);

        errorL.setVisible(false);

        mainStudentScreen.add(errorL, pConstraints);


        //Creates the button that sets the student id to the inputed ID and switches to the data screen
        JButton enterIDB = new JButton("Enter ID");

        pConstraints.gridx = 1;
        pConstraints.gridy = 1;

        enterIDB.setFocusable(false);

        enterIDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                try {
                    studentID = Integer.parseInt(inputTF.getText());
                } catch (Exception e) {
                    errorL.setVisible(true);
                    inputTF.setText("");
                }
                if (inputTF.getText() != "") {
                    System.out.println("Student Data Based on ID");
                    frame.getContentPane().removeAll();
                }
            }

        });

        mainStudentScreen.add(enterIDB, pConstraints);



        //Sets the panel to visible by default
        mainStudentScreen.setVisible(true);


    
    }

    public static void studentDataScreen(JFrame frame){

    }
    
}