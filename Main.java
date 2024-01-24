import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String name;
    private String rollNumber;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Code to add a student
                    addStudent(scanner, system);
                    break;
                case 2:
                    // Code to remove a student
                    removeStudent(scanner, system);
                    break;
                case 3:
                    // Code to search for a student
                    searchStudent(scanner, system);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the Student Management System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);

        scanner.close();
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Roll Number: ");
        String rollNumber = scanner.next();
        System.out.print("Grade: ");
        String grade = scanner.next();

        Student newStudent = new Student(name, rollNumber, grade);
        system.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter the roll number of the student to remove: ");
        String rollNumber = scanner.next();

        if (system.searchStudent(rollNumber) != null) {
            system.removeStudent(rollNumber);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found. Unable to remove.");
        }
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter the roll number of the student to search: ");
        String rollNumber = scanner.next();

        Student foundStudent = system.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found:");
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }
}
