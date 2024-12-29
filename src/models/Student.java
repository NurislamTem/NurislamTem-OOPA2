package models;

import java.util.ArrayList;

public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        setId(idCounter);
        setGrades(grades);
    }

    public int getId() {return studentID;}
    public void setId(int id){this.studentID = idCounter++;}

    public ArrayList<Integer> getGrades() {return grades;}
    public void setGrades(ArrayList<Integer> grades){this.grades = grades;}

    public void addGrade(int grade){
        grades.add(grade);
    }

    public double calculateGPA(){
        int s = 0;
        for (Integer grade : grades) {
            s += grade;
        }
        return (s / (double)grades.size()) * 0.04;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student whith ID " + studentID + " and my GPA is " + calculateGPA();
    }

}
