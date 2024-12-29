
import models.School;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class myapp {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        Scanner studentScanner = new Scanner(new File("src\\students.txt"));
        while (studentScanner.hasNextLine()) {
            String line = studentScanner.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = parts[3].equalsIgnoreCase("Male");
            Student student = new Student(name, surname, age, gender);

            for (int i = 4; i < parts.length; i++) {
                student.addGrade(Integer.parseInt(parts[i]));
            }

            school.addMember(student);
        }
        studentScanner.close();

        Scanner teacherScanner = new Scanner(new File("src\\teachers.txt"));
        while (teacherScanner.hasNextLine()) {
            String line = teacherScanner.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = parts[3].equalsIgnoreCase("Male");
            String subject = parts[4];
            int yearsOfExperience = Integer.parseInt(parts[5]);
            int salary = Integer.parseInt(parts[6]);
            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            if (yearsOfExperience > 10) {
                teacher.giveRaise(6);
            }

            school.addMember(teacher);
        }
        teacherScanner.close();

        System.out.println(school);
    }
}