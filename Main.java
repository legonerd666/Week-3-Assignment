import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main {

    public static void main(String[] args) {

        GridBagConstraints gbc = new GridBagConstraints();
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridBagLayout());

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Database");
        frame.pack();
        frame.setVisible(true);

        JLabel intro = new JLabel("Please Choose Your Role:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(intro, gbc);

        JRadioButton studentButton = new JRadioButton("Student");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(studentButton, gbc);

        JRadioButton teacherButton = new JRadioButton("Teacher");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(teacherButton, gbc);

        JRadioButton adminButton = new JRadioButton("Administrator");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(adminButton, gbc);

        ButtonGroup roles = new ButtonGroup();
        roles.add(studentButton);
        roles.add(teacherButton);
        roles.add(adminButton);
    }
}