
package org.example;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        service.addStudent(new Student("Alice", 90));
        service.addStudent(new Student("Bob", 85));
        service.addStudent(new Student("Charlie", 75));

        System.out.println("Before removal:");
        service.getAllStudents().forEach(System.out::println);

        // Use the previously unused method
        boolean removed = service.removeStudentByName("Bob");
        System.out.println("\nAttempting to remove Bob: " + removed);

        System.out.println("\nAfter removal:");
        service.getAllStudents().forEach(System.out::println);
    }
}

