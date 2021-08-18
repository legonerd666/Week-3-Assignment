package week3;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main{

    private static String role;
    private static JPanel studentOptionsP;
    private static JPanel viewStudentDataP;
    // private static JPanel teacherP;
    // private static JPanel adminP;

    public static void main(String[] args) {

        GridBagConstraints fGBC = new GridBagConstraints();
        GridBagConstraints pGBC = new GridBagConstraints();
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());

        student(frame, pGBC, fGBC);
        roleSelector(frame, pGBC, fGBC);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Database");
        frame.pack();
        frame.setVisible(true);

    }

    public static void roleSelector(JFrame frame, GridBagConstraints pGBC, GridBagConstraints fGBC) {

        JPanel roleSelectorP = new JPanel(new GridBagLayout());

        roleSelectorP.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        JLabel introL = new JLabel("Please Choose Your Role:");
        pGBC.gridx = 0;
        pGBC.gridy = 0;
        roleSelectorP.add(introL, pGBC);

        //Creates a radio button that lets us select the role: student
        JRadioButton studentRB = new JRadioButton("Student");
        pGBC.gridx = 0;
        pGBC.gridy = 1;
        studentRB.setFocusable(false);
        studentRB.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                role = "student";
            }

        });
        roleSelectorP.add(studentRB, pGBC);

        //Creates a radio button that lets us select the role: teacher
        JRadioButton teacherRB = new JRadioButton("Teacher");
        pGBC.gridx = 0;
        pGBC.gridy = 2;
        teacherRB.setFocusable(false);
        teacherRB.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                role = "teacher";
            }

        });
        roleSelectorP.add(teacherRB, pGBC);

        //Creates a radio button that lets us select the role: admin
        JRadioButton adminRB = new JRadioButton("Administrator");
        pGBC.gridx = 0;
        pGBC.gridy = 3;
        adminRB.setFocusable(false);
        adminRB.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                role = "admin";
            }

        });
        roleSelectorP.add(adminRB, pGBC);

        //Puts all the role radio buttons into a group so that only one can be chosen at a time
        ButtonGroup roles = new ButtonGroup();
        roles.add(studentRB);
        roles.add(teacherRB);
        roles.add(adminRB);

        //Creates a button that selects our role
        JButton chooseRoleB = new JButton("Choose this role?");
        pGBC.gridx = 0;
        pGBC.gridy = 4;
        chooseRoleB.setFocusable(false);
        chooseRoleB.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                if (role == "student"){
                    System.out.println("Student");
                    //teacherP.setVisible(false);
                    //adminP.setVisible(false);
                    studentOptionsP.setVisible(true);
                } else if (role == "teacher") {
                    System.out.println("Teacher");
                    studentOptionsP.setVisible(false);
                } else if (role == "admin"){
                    System.out.println("Admin");
                    studentOptionsP.setVisible(false);
                } else {
                    System.out.println("No Role Selected");
                }
            }

        }); 
        roleSelectorP.add(chooseRoleB, pGBC);
        
        fGBC.gridx = 0;
        fGBC.gridy = 0;
        frame.add(roleSelectorP, fGBC);
    }

    public static void student(JFrame frame, GridBagConstraints pGBC, GridBagConstraints fGBC){

        pGBC.insets = new Insets(1, 2, 1, 2);

        int prefSizeX = 150;
        int prefSizeY = 25;

        studentOptionsP = new JPanel(new GridBagLayout());
        studentOptionsP.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        JLabel prompt = new JLabel("What would you like to do:");
        pGBC.gridx = 0;
        pGBC.gridy = 0;
        pGBC.gridwidth = 2;
        studentOptionsP.add(prompt, pGBC);

        JButton viewDataB = new JButton("View your Data");
        pGBC.gridx = 0;
        pGBC.gridy = 1;
        pGBC.gridwidth = 1;
        pGBC.fill = GridBagConstraints.HORIZONTAL;

        viewDataB.setPreferredSize(new Dimension(prefSizeX, prefSizeY));
        viewDataB.setVerticalAlignment(SwingConstants.CENTER);
        viewDataB.setFocusable(false);
        viewDataB.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

                studentOptionsP.setVisible(false);
                viewStudentDataP = new JPanel(new GridBagLayout());
                viewStudentDataP.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));


                JTextField idTF = new JTextField("Student ID");
                pGBC.gridx = 0;
                pGBC.gridy = 0;
                pGBC.gridwidth = 1;
                viewStudentDataP.add(idTF, pGBC);


                JButton getDataB = new JButton("Get Data");
                pGBC.gridx = 1;
                pGBC.gridy = 0;
                pGBC.gridwidth = 1;

                getDataB.setPreferredSize(new Dimension(prefSizeX, prefSizeY));
                getDataB.setVerticalAlignment(SwingConstants.CENTER);
                getDataB.setFocusable(false);
                getDataB.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e){
                        JLabel studentDataL = new JLabel("Student Data");
                        pGBC.gridx = 0;
                        pGBC.gridy = 1;
                        pGBC.gridwidth = 2;
                        pGBC.fill = GridBagConstraints.HORIZONTAL;
                        viewStudentDataP.add(studentDataL, pGBC);
                    }   

                });
                viewStudentDataP.add(getDataB, pGBC);

                fGBC.gridx = 0;
                fGBC.gridy = 1;
                frame.add(viewStudentDataP, fGBC);
            }

        });
        studentOptionsP.add(viewDataB, pGBC);


        JButton selectNewClass = new JButton("Select a New Class");
        pGBC.gridx = 1;
        pGBC.gridy = 1;
        pGBC.gridwidth = 1;
        pGBC.fill = GridBagConstraints.HORIZONTAL;

        selectNewClass.setPreferredSize(new Dimension(prefSizeX, prefSizeY));
        selectNewClass.setVerticalAlignment(SwingConstants.CENTER);
        selectNewClass.setFocusable(false);
        selectNewClass.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
            }

        });
        studentOptionsP.add(selectNewClass, pGBC);

        studentOptionsP.setVisible(false);
        fGBC.gridx = 0;
        fGBC.gridy = 1;
        frame.add(studentOptionsP, fGBC);
    }

    public static void studentDataPanel(JFrame frame, GridBagConstraints pGBC, GridBagConstraints fGBC){

        JPanel studentDataP = new JPanel(new GridBagLayout());

        JLabel nameL;
        JLabel idL;
        JLabel DOBL;
        JLabel gradeLevelL;
        JLabel takenClassesL;
        JLabel overallGrade;

        studentDataP.setVisible(false);
        fGBC.gridx = 0;
        fGBC.gridy = 2;
        frame.add(studentDataP, fGBC);

    }

}