package week3;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
    private static JPanel mainTeacherScreen;
    private static JPanel sortedStudentsScreen;

    private static int role;
    private static int studentID;
    private static boolean IDHasError;

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
        mainTeacherScreen(appFrame);

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
                    SwingUtilities.updateComponentTreeUI(frame);
                } else if (role == 1) {
                    System.out.println("Teacher");
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(mainTeacherScreen);
                    SwingUtilities.updateComponentTreeUI(frame);
                } else if (role == 2){
                    System.out.println("Admin");
                    frame.getContentPane().removeAll();
                    SwingUtilities.updateComponentTreeUI(frame);
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
        JTextField inputTF = new JTextField("");

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

                IDHasError = false;

                try {
                    studentID = Integer.parseInt(inputTF.getText());
                } catch (Exception e) {
                    errorL.setVisible(true);
                    IDHasError = true;
                    System.out.println("Got an error");
                    inputTF.setText("");
                }
                if (!IDHasError) {
                    errorL.setVisible(false);
                     System.out.println("Student Data Based on ID");
                     frame.getContentPane().removeAll();
                     frame.getContentPane().add(studentDataScreen);
                     SwingUtilities.updateComponentTreeUI(frame);
                }
            }

        });

        mainStudentScreen.add(enterIDB, pConstraints);



        //Sets the panel to visible by default
        mainStudentScreen.setVisible(true);


    
    }

    public static void studentDataScreen(JFrame frame){

        //Creates an empty panel
        studentDataScreen = new JPanel(new GridBagLayout());
        GridBagConstraints pConstraints = new GridBagConstraints();



        //Creates a label to house all the student information
        JLabel studentDataL = new JLabel();

        pConstraints.gridx = 0;
        pConstraints.gridy = 0;

        studentDataScreen.add(studentDataL, pConstraints);



        //Creates a button to allow students to choose to take a new class
        JButton takeClassB = new JButton("Select Class");

        pConstraints.gridx = 0;
        pConstraints.gridy = 1;

        takeClassB.setFocusable(false);

        takeClassB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                System.out.println("Taking new class");
            }

        });

        studentDataScreen.add(takeClassB, pConstraints);



        //Creates a button which returns you to the main student screen
        JButton mainStudentScreenB = new JButton("Return to ID Screen");

        pConstraints.gridx = 0;
        pConstraints.gridy = 2;

        mainStudentScreenB.setFocusable(false);

        mainStudentScreenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(mainStudentScreen);
                SwingUtilities.updateComponentTreeUI(frame);
            }

        });

        studentDataScreen.add(mainStudentScreenB, pConstraints);


        
        //Creates a button that returns you to the main screen
        JButton mainScreenB = new JButton("Return to Main Screen");

        pConstraints.gridx = 1;
        pConstraints.gridy = 2;

        mainScreenB.setFocusable(false);

        mainScreenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(mainScreen);
                SwingUtilities.updateComponentTreeUI(frame);
            }

        });

        studentDataScreen.add(mainScreenB, pConstraints);



        //Sets the panel as visible by default
        studentDataScreen.setVisible(true);



    }

    public static void mainTeacherScreen(JFrame frame){

        //Creates an empty panel
        mainTeacherScreen = new JPanel(new GridBagLayout());
        GridBagConstraints pConstraints = new GridBagConstraints();



        //Creates the intro label
        JLabel introL = new JLabel("Please choose what you would like to do");

        pConstraints.gridx = 0;
        pConstraints.gridy = 0;

        mainTeacherScreen.add(introL, pConstraints);



        //Creates a button that takes you to the sorted students page
        JButton sortedStudentsScreenB = new JButton("List Students");

        pConstraints.gridx = 0;
        pConstraints.gridy = 1;

        sortedStudentsScreenB.setFocusable(false);

        sortedStudentsScreenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.getContentPane().removeAll();
                //frame.getContentPane().add(sortedStudentsScreen);
                SwingUtilities.updateComponentTreeUI(frame);
            }

        });

        mainTeacherScreen.add(sortedStudentsScreenB, pConstraints);



        //Creates a button that takes you to a page where you can set a students grade
        JButton gradeStudentsScreenB = new JButton("Grade Students");

        pConstraints.gridx = 0;
        pConstraints.gridy = 2;

        gradeStudentsScreenB.setFocusable(false);

        gradeStudentsScreenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.getContentPane().removeAll();
                //frame.getContentPane().add(gradeStudentsScreen);
                SwingUtilities.updateComponentTreeUI(frame);
            }

        });

        mainTeacherScreen.add(gradeStudentsScreenB, pConstraints);



        //Creates a button that takes you to a page where you can set a students last day of attendance
        JButton setAttendanceStudentsScreenB = new JButton("Set Attendance of Students");

        pConstraints.gridx = 0;
        pConstraints.gridy = 3;

        setAttendanceStudentsScreenB.setFocusable(false);

        setAttendanceStudentsScreenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.getContentPane().removeAll();
                //frame.getContentPane().add(setAttendanceStudentsScreen);
                SwingUtilities.updateComponentTreeUI(frame);
            }

        });

        mainTeacherScreen.add(setAttendanceStudentsScreenB, pConstraints);



        //Creates a button that takes you to a page where you can list the students who take classes from a specific teacher
        JButton listStudentsByTeacherScreenB = new JButton("List Students by Teacher");

        pConstraints.gridx = 0;
        pConstraints.gridy = 4;

        listStudentsByTeacherScreenB.setFocusable(false);

        listStudentsByTeacherScreenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.getContentPane().removeAll();
                //frame.getContentPane().add(listStudentsByTeacherScreenB);
                SwingUtilities.updateComponentTreeUI(frame);
            }

        });

        mainTeacherScreen.add(listStudentsByTeacherScreenB, pConstraints);



        //Sets the panel as visible by default
        mainTeacherScreen.setVisible(true);




    }
    
}