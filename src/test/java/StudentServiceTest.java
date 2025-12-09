import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setup() {
        service = new StudentService();
        // Student(String name, int age, double gpa)
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 21, 3.7));
        service.addStudent(new Student("Charlie", 22, 2.9));
    }

    // -------------------------
    // addStudent()
    // -------------------------
    @Test
    void testAddStudent_affectsAverageWhenSingleStudent() {
        StudentService single = new StudentService();
        Student d = new Student("Derek", 23, 3.9);
        single.addStudent(d);

        // With only one student, average should equal that student's GPA
        assertEquals(3.9, single.calculateAverageGpa(), 1e-6);
    }

    // -------------------------
    // getTopStudent()
    // -------------------------
    @Test
    void testGetTopStudent_returnsStudentWithHighestGpa() {
        Student top = service.getTopStudent();
        assertNotNull(top);
        assertEquals("Bob", top.getName());
        assertEquals(3.7, top.getGpa(), 1e-6);
    }

    @Test
    void testGetTopStudent_emptyListThrowsIndexOutOfBounds() {
        StudentService empty = new StudentService();
        assertThrows(IndexOutOfBoundsException.class, empty::getTopStudent);
    }

    // -------------------------
    // calculateAverageGpa()
    // -------------------------
    @Test
    void testCalculateAverageGpa_computesCorrectAverage() {
        double expected = (3.5 + 3.7 + 2.9) / 3.0;
        assertEquals(expected, service.calculateAverageGpa(), 1e-6);
    }

    @Test
    void testCalculateAverageGpa_emptyListIsZero() {
        StudentService empty = new StudentService();
        assertEquals(0.0, empty.calculateAverageGpa(), 1e-6);
    }

    // -------------------------
    // removeStudentByName()
    // -------------------------

    @Test
    void testRemoveStudentByName_whenNoMatch_doesNotThrow() {
        // If the name does not exist, the method currently iterates and makes no removal.
        assertDoesNotThrow(() -> service.removeStudentByName("Nonexistent"));
    }
}
