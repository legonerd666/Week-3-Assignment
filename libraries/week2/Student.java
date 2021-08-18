package libraries.week2;

import java.util.List;

public class Student {

    private String name;
    private int ID;
    private int[] dateOfBirth;
    private int gradeLevel;
    private List<TakenClass> takenClasses;
    private float overallGrade;

    Student(String name, int ID, int[] dateOfBirth, int gradeLevel, List<TakenClass> takenClasses){

        this.name = name;
        this.ID = ID;
        this.dateOfBirth = dateOfBirth;
        this.gradeLevel = gradeLevel;
        this.takenClasses = takenClasses;
        this.overallGrade = getOverallGrade();

    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public int getID(){
        return this.ID;
    }
    public void setID(int newID){
        this.ID = newID;
    }

    public int[] getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(int[] dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfBirthDMY(){
        StringBuilder str = new StringBuilder();
        str.append(this.dateOfBirth[0] + "/");
        str.append(this.dateOfBirth[1] + "/");
        str.append(this.dateOfBirth[2]);
        return str.toString();
    }

    public int getGradeLevel(){
        return this.gradeLevel;
    }
    public void setGradeLevel(int newGradeLevel){
        this.gradeLevel = newGradeLevel;
    }

    public List<TakenClass> getTakenClasses(){
        return this.takenClasses;
    }
    public void setTakenClasses(List<TakenClass> newTakenClasses){
        this.takenClasses = newTakenClasses;     
    }
    public String getTakenClassesAsString(){
        StringBuilder str = new StringBuilder();
        for (int e = 0; e < this.takenClasses.size(); e++) {
            str.append((e+1) + ".\n");
            str.append(this.takenClasses.get(e).toString());
        }
        return str.toString();
    }
    
    public float getOverallGrade(){
        setOverallGrade();
        return this.overallGrade;
    }
    public void setOverallGrade(){
        float grades = 0;

        for (TakenClass class1 : getTakenClasses()) {
            grades += class1.getGrade();
        }

        this.overallGrade = 100 * (grades / (getTakenClasses().size() * 100));
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Name: " + this.name + "\n");
        str.append("ID: " + this.ID + "\n");
        str.append("Date of Birth (D/M/Y): " + getDateOfBirthDMY() + "\n");
        str.append("Grade Level: " + this.gradeLevel + "\n");
        str.append("Classes:\n");
        str.append(getTakenClassesAsString());
        str.append("Overall Grade: " + getOverallGrade() + "/100\n");
        return str.toString();
    }

}