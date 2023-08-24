package InternShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    private static class Student {
        private String name;
        private int rollNumber;
        private int grade;

        public Student(String name, int rollNumber, int grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        // Getters and setters (omitted for brevity)
    }

    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void start() {
        System.out.println("Welcome to the Student Management System!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();

                    Student student = new Student(name, rollNumber, grade);
                    addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student searchedStudent = searchStudent(searchRollNumber);
                    if (searchedStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("Name: " + searchedStudent.name);
                        System.out.println("Roll Number: " + searchedStudent.rollNumber);
                        System.out.println("Grade: " + searchedStudent.grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    List<Student> allStudents = getAllStudents();
                    if (!allStudents.isEmpty()) {
                        System.out.println("All Students:");
                        for (Student s : allStudents) {
                            System.out.println("Name: " + s.name + ", Roll Number: " + s.rollNumber + ", Grade: " + s.grade);
                        }
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem managementSystem = new StudentManagementSystem();
        managementSystem.start();
    }
}

