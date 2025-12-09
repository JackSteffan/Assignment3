package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setup() {
        service = new StudentService();
        service.addStudent(new Student("Alice", 90));
        service.addStudent(new Student("Bob", 80));
        service.addStudent(new Student("Charlie", 70));
    }

    @Test
    void testAddStudent() {
        Student s = new Student("David", 88);
        service.addStudent(s);

        assertTrue(service.getAllStudents().contains(s));
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = service.getAllStudents();
        assertEquals(3, students.size());
    }

    @Test
    void testGetStudentByNameFound() {
        Student s = service.getStudentByName("Bob");
        assertNotNull(s);
        assertEquals("Bob", s.getName());
        assertEquals(80, s.getScore());
    }

    @Test
    void testGetStudentByNameNotFound() {
        Student s = service.getStudentByName("Nonexistent");
        assertNull(s);
    }

    @Test
    void testRemoveStudentByNameSuccess() {
        boolean removed = service.removeStudentByName("Charlie");

        assertTrue(removed);
        assertNull(service.getStudentByName("Charlie"));
    }

    @Test
    void testRemoveStudentByNameFail() {
        boolean removed = service.removeStudentByName("Ghost");
        assertFalse(removed);
    }

    @Test
    void testGetAverageScore() {
        double avg = service.getAverageScore();
        assertEquals((90 + 80 + 70) / 3.0, avg);
    }
}

