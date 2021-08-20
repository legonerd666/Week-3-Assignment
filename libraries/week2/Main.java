package libraries.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import week3.*;

public class Main {

    public static void main(String[] args) {

        //Creates a List to store all teachers, students, and classes
        List<Student> students = new ArrayList<>();
        List<TakeableClass> allClasses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();


        //Adds Teachers to the List of Teachers (Try making one yourself!)
        teachers.add(new Teacher("Alan Dickinson", teachers.size()+1));
        teachers.add(new Teacher("Rick Sanchez", teachers.size()+1));


        //Adds Classes to the List of Classes (Try making one yourself!)
        allClasses.add(new TakeableClass(teachers.get(0), "Math"));
        allClasses.add(new TakeableClass(teachers.get(1), "Burping"));


        //Adds Students to the List of Students (Try making one yourself!)
        
        int[] DOB1 = {2, 11, 1996};
        int[] LDA = {0, 0, 0};
        List<TakenClass> classes1 = new ArrayList<>();
        classes1.add(new TakenClass(allClasses.get(1), LDA));
        students.add(new Student("Bobbi Burris", students.size()+1, DOB1, 1, classes1));
        allClasses.get(1).getStudents().add(students.get(0));

        int[] DOB2 = {16, 2, 1996};
        List<TakenClass> classes2 = new ArrayList<>();
        classes2.add(new TakenClass(allClasses.get(0), LDA));
        students.add(new Student("Jason Smith", students.size()+1, DOB2, 1, classes2));
        allClasses.get(0).getStudents().add(students.get(1));

        int[] DOB3 = {27, 8, 1996};
        students.add(new Student("Lenny Bannister", students.size()+1, DOB3, 1, classes1));
        allClasses.get(1).getStudents().add(students.get(2));

        int[] DOB4 = {3, 5, 1995};
        students.add(new Student("Lily-May Campbell", students.size()+1, DOB4, 2, classes1));
        allClasses.get(1).getStudents().add(students.get(3));

        int[] DOB5 = {9, 2, 1996};
        students.add(new Student("Dollie O'Neill", students.size()+1, DOB5, 1, classes2));
        allClasses.get(0).getStudents().add(students.get(4));

        int[] DOB6 = {31, 4, 1996};
        students.add(new Student("Carl Brooks", students.size()+1, DOB6, 1, classes2));
        allClasses.get(0).getStudents().add(students.get(5));

        int[] DOB7 = {17, 7, 1995};
        classes1.add(new TakenClass(allClasses.get(0), LDA));
        students.add(new Student("Iqra O'Doherty", students.size()+1, DOB7, 2, classes1));
        allClasses.get(1).getStudents().add(students.get(6));

        int[] DOB8 = {16, 11, 1996};
        students.add(new Student("Codie Cain", students.size()+1, DOB8, 1, classes1));
        allClasses.get(1).getStudents().add(students.get(7));

        int[] DOB9 = {4, 3, 1996};
        students.add(new Student("Greg O'Gallagher", students.size()+1, DOB9, 1, classes1));
        allClasses.get(1).getStudents().add(students.get(8));

        int[] DOB10 = {3, 10, 1996};
        students.add(new Student("Tania Clarkson", students.size()+1, DOB10, 1, classes2));
        allClasses.get(0).getStudents().add(students.get(9));


        //Begins the main program now that the students, classes, and teachers have been made
        week3.Old_Main.main(args);
        mainScreen(students, allClasses, teachers);

    }

    public static void mainScreen(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){

        //Asks the user with what permission level they'd like to access the database
        int userType = getInput("Hello! \nPlease enter your User Type:\n1. Student\n2. Teacher\n3. Admin", 3);
        switch (userType) {
            case 1:
                student(students, allClasses, teachers);
                break;
            
            case 2:
                teacher(students, allClasses, teachers);
                break;
            case 3:
                admin(students, allClasses, teachers);
                break;
        }
    }

    public static int getInput(String text, int numInputs){

        //Allows us to get input from the user
        Scanner scan = new Scanner(System.in);

        System.out.println(text);
        String input = scan.nextLine();


        //Makes sure there are no errors converting input to an integer
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }

        //Makes sure the input is within the number of inputs allowed
        if (Integer.parseInt(input) > numInputs || Integer.parseInt(input) < 1){
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }

        //Returns the input as an integer
        return Integer.parseInt(input);

    }

    public static int getInputAllow0(String text, int numInputs){

        //Allows us to get input from the user
        Scanner scan = new Scanner(System.in);

        System.out.println(text);
        String input = scan.nextLine();


        //Makes sure there are no errors converting input to an integer
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }

        //Makes sure the input is within the number of inputs allowed
        if (Integer.parseInt(input) > numInputs || Integer.parseInt(input) < 0){
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }

        //Returns the input as an integer
        return Integer.parseInt(input);

    }
    
    public static void student(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){

    
        int input = getInput("What would you like to do:\n1. Look at your data\n2. Take a new class", 2);

        switch (input) {
            case 1:
                //Lets a student see their information if they have their ID Number
                int studentID = getInput("Please enter your student ID:", students.size());
                System.out.println(students.get(studentID-1).toString());
                break;
            
            case 2:
                //Allows student to choose to add a class provided they don't already take the class
                studentID = getInput("Please enter your student ID:", students.size());
                int pickedClassI = pickClassBySubject(allClasses);
                boolean hadClass = false;
                for (TakenClass takenClass : students.get(studentID-1).getTakenClasses()) {
                    if (takenClass.getTakeableClass().getSubject() == allClasses.get(pickedClassI-1).getSubject()){
                        System.out.println("You already take that class");
                        hadClass = true;
                    }
                }
                if (hadClass) {
                    break;
                } else {
                    int[] LDA = {0, 0, 0};
                    students.get(studentID-1).getTakenClasses().add(new TakenClass(allClasses.get(pickedClassI-1), LDA));
                    allClasses.get(pickedClassI-1).getStudents().add(students.get(studentID));
                    break;
                }
        }

        mainScreen(students, allClasses, teachers);;

    }

    public static void teacher(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){


        /*  Allows teachers to read all student information sorted 4 different ways
            Change a students grades and last day of attendance if they teach said student
            And list students by teacher teaching a class they take
        */
        int input = getInput("What would you like to do:\n1. Look at Student Data\n2. Change Students Grades\n3. Change Students Latest Date of Attendance\n4. List Students by Teacher", 4);

        switch (input) {
            
            //Sorts students by prefered method and prints them to console and then prints chosen students information
            case 1:
                List<Student> sortedStudents = new ArrayList<>();
                for (Student student : students) {
                    sortedStudents.add(student);
                }
                sortedStudents = getSortedListOfStudents(sortedStudents, allClasses);
                int pickedStudentID = pickStudentByName(sortedStudents);
                System.out.println(sortedStudents.get(pickedStudentID-1));
                break;
            //Lets teachers pick a student and change the grades of one of those students classes if the teacher teaches that class
            case 2:
                pickedStudentID = pickStudentByName(students);
                System.out.println("Please enter which teacher you are:");
                int signedInTeacher = pickTeacherByName(teachers);
                String classList = students.get(pickedStudentID-1).getTakenClassesAsString();
                int classNum = getInput("Please enter which class you'd like to set the grades of:\n" + classList, students.get(pickedStudentID-1).getTakenClasses().size());
                if (students.get(pickedStudentID-1).getTakenClasses().get(classNum-1).getTakeableClass().getTeacher().getID() != signedInTeacher) {
                    System.out.println("I'm sorry, you don't teach that student.");
                } else {
                    int newGrade = getInputAllow0("Please enter what their grade should be (0-100):", 100);
                    students.get(pickedStudentID-1).getTakenClasses().get(classNum-1).setGrade(newGrade);
                }
                break;
            //Lets teachers pick a student and change the last day of attendance of one of those students classes if the teacher teaches that class
            case 3:
                pickedStudentID = pickStudentByName(students);
                System.out.println("Please enter which teacher you are:");
                signedInTeacher = pickTeacherByName(teachers);
                classList = students.get(pickedStudentID-1).getTakenClassesAsString();
                classNum = getInput("Please enter which class you'd like to set attendance for:\n" + classList, students.get(pickedStudentID-1).getTakenClasses().size());
                if (students.get(pickedStudentID-1).getTakenClasses().get(classNum-1).getTakeableClass().getTeacher().getID() != signedInTeacher) {
                    System.out.println("I'm sorry, you don't teach that student.");
                } else {
                    int newLdaDay = getInput("Please enter the day they attended:", 31);
                    int newLdaMonth = getInput("Please enter the month they attended:", 12);
                    int newLdaYear = getInput("Please enter the year they attended:", 3000);
                    int[] newLatestAttendance = {newLdaDay, newLdaMonth, newLdaYear};
                    students.get(pickedStudentID-1).getTakenClasses().get(classNum-1).setLastDayOfAttendance(newLatestAttendance);
                }
                break;
            //Lets teachers pick a teacher and then print all students who take any of the classes taught by that teacher
            case 4:
                int pickedTeacherID = pickTeacherByName(teachers);
                for (Student student : students) {
                    for (TakenClass takenClass : student.getTakenClasses()) {
                        if (takenClass.getTakeableClass().getTeacher().getID() == pickedTeacherID){
                            System.out.println(student.toString());
                        }
                    }
                }
                break;
            
        }

        mainScreen(students, allClasses, teachers);

    }

    public static void admin(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){

        /*  Allows admins to read all student information sorted 4 different ways
            Change a students grades and last day of attendance
            List students by teacher teaching a class they take
            Assign a teacher to a class
            list all classes
            Add new classes
            add new teachers
            and add new students
        */
        int input = getInput("What would you like to do:\n1. Look at Student Data\n2. Change Students Grades\n3. Change Students Latest Date of Attendance\n4. List Students by Teacher\n5. Assign Teacher to Class\n6. List Classes\n7. Add a new class\n8. Hire new teacher\n9. Recruit new student", 9);

        switch (input) {
            case 1:
                //Prints all students to the console in prefered sorting method
                List<Student> sortedStudents = new ArrayList<>();
                for (Student student : students) {
                    sortedStudents.add(student);
                }
                sortedStudents = getSortedListOfStudents(sortedStudents, allClasses);
                int pickedStudentID = pickStudentByName(sortedStudents);
                System.out.println(sortedStudents.get(pickedStudentID-1));
                break;
            case 2:
                //allows admin to change a students grades
                pickedStudentID = pickStudentByName(students);
                String classList = students.get(pickedStudentID-1).getTakenClassesAsString();
                int classNum = getInput("Please enter which class you'd like to set the grades of:\n" + classList, students.get(pickedStudentID-1).getTakenClasses().size());
                int newGrade = getInputAllow0("Please enter what their grade should be (0-100):", 100);
                students.get(pickedStudentID-1).getTakenClasses().get(classNum-1).setGrade(newGrade);
                break;
            case 3:
                //allows an admin to change a students last day of attendance
                pickedStudentID = pickStudentByName(students);
                classList = students.get(pickedStudentID-1).getTakenClassesAsString();
                classNum = getInput("Please enter which class you'd like to set attendance for:\n" + classList, students.get(pickedStudentID-1).getTakenClasses().size());
                int newLdaDay = getInput("Please enter the day they attended:", 31);
                int newLdaMonth = getInput("Please enter the month they attended:", 12);
                int newLdaYear = getInput("Please enter the year they attended:", 3000);
                int[] newLatestAttendance = {newLdaDay, newLdaMonth, newLdaYear};
                students.get(pickedStudentID-1).getTakenClasses().get(classNum-1).setLastDayOfAttendance(newLatestAttendance);
                break;
            case 4:
                //prints all students who take classes from a teacher
                int pickedTeacherID = pickTeacherByName(teachers);
                for (Student student : students) {
                    for (TakenClass takenClass : student.getTakenClasses()) {
                        if (takenClass.getTakeableClass().getTeacher().getID() == pickedTeacherID){
                            System.out.println(student.toString());
                        }
                    }
                }
                break;
            case 5:
                //allows an admin to assign a teacher to a class
                int pickedClassI = pickClassBySubject(allClasses);
                pickedTeacherID = pickTeacherByName(teachers);
                allClasses.get(pickedClassI-1).setTeacher(teachers.get(pickedTeacherID-1));
                break;
            case 6:
                //prints all classes to the console
                System.out.println(allClasses.toString());
                break;
            case 7:
                //allows admins to create a new class
                Scanner scan = new Scanner(System.in);

                System.out.println("What would you like the class subject to be:");
                String subject = scan.nextLine();
                pickedTeacherID = pickTeacherByName(teachers);
                allClasses.add(new TakeableClass(teachers.get(pickedTeacherID-1), subject));
                break;
            case 8:
                //allows admins to hire a new teacher
                scan = new Scanner(System.in);

                System.out.println("What is the teachers name:");
                String name = scan.nextLine();
                teachers.add(new Teacher(name, teachers.size()+1));
                break;
            case 9:
                //allows admins to recruit a new student
                scan = new Scanner(System.in);

                System.out.println("What is the students name:");
                name = scan.nextLine();
                int DOB = getInput("Please enter the day of their birth:", 31);
                int MOB = getInput("Please enter the month of their birth:", 12);
                int YOB = getInput("Please enter the year of their birth:", 3000);
                int[] dateOfBirth = {DOB, MOB, YOB};
                int gradeLevel = getInput("Please enter their grade", 12);
                List<TakenClass> takenClasses = new ArrayList<>();
                students.add(new Student(name, students.size()+1, dateOfBirth, gradeLevel, takenClasses));
                break;
        }

        mainScreen(students, allClasses, teachers);

    }

    public static int pickStudentByName(List<Student> students){

        //Creates a String of all the students
        StringBuilder studentNames = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            if (i-1 < students.size()){
                studentNames.append((i+1) + ". " + students.get(i).getName() + "\n");
            } else{
                studentNames.append((i+1) + ". " + students.get(i).getName());
            }
            
        }

        //Gets user input and lists the students
        int input = getInput("Which student?\n" + studentNames, students.size());
        return input;

    }
    
    public static int pickTeacherByName(List<Teacher> teachers){


        //Creates a String of all the teachers
        StringBuilder teacherNames = new StringBuilder();
        for (int i = 0; i < teachers.size(); i++) {
            if (i-1 < teachers.size()){
                teacherNames.append((teachers.get(i).getID()) + ". " + teachers.get(i).getName() + "\n");
            } else{
                teacherNames.append((teachers.get(i).getID()) + ". " + teachers.get(i).getName());
            }
            
        }

        //Gets user input and prints the information of all the teachers
        int input = getInput("Which Teacher would you like it to be?\n" + teacherNames, teachers.size());
        return input;
    }

    public static List<Student> getSortedListOfStudents(List<Student> students, List<TakeableClass> allClasses){

        //returns a sorted list of students
        System.out.println("1. ID\n2. Name\n3. Class\n4. Grade");

        int input = getInput("Pick Sorting Method:", 4);

        switch (input) {
            case 2:
                //Sorts the students by name in alphabetical order
                Collections.sort(students, new Comparator<Student>(){
                    public int compare(Student s1, Student s2){
                        return s1.getName().compareTo(s2.getName());
                    }
                });
                break;
            case 3:
                //Sorts students by classes they take (classes with lower IDS take priority)
                List<Student> unsortedStudents = new ArrayList<>();
                for (TakeableClass takeableClass : allClasses){
                    for (Student student : takeableClass.getStudents()) {
                        unsortedStudents.add(student);
                    }
                }
                students = unsortedStudents;
                break;
            case 4:
                //Sorts the students by grade
                Collections.sort(students, new Comparator<Student>(){
                    public int compare(Student s1, Student s2){
                        return Integer.compare(s1.getGradeLevel(), s2.getGradeLevel());
                    }
                });
                break;
            
        }


        return students;

    }

    public static int pickClassBySubject(List<TakeableClass> allClasses){

        //Creates a String of all the classes
        StringBuilder classSubjects = new StringBuilder();
        for (int i = 0; i < allClasses.size(); i++) {
            if (i-1 < allClasses.size()){
                classSubjects.append((i+1) + ". " + allClasses.get(i).getSubject() + "\n");
            } else{
                classSubjects.append((i+1) + ". " + allClasses.get(i).getSubject());
            }
            
        }

        //Gets user input and lists the students
        int input = getInput("Which class?\n" + classSubjects, allClasses.size());
        return input;

    }
}