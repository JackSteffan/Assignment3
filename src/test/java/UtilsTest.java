
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testIsNullOrEmptyNull() {
        assertTrue(Utils.isNullOrEmpty(null));
    }

    @Test
    void testIsNullOrEmptyEmpty() {
        assertTrue(Utils.isNullOrEmpty(""));
    }

    @Test
    void testIsNullOrEmptySpaces() {
        assertTrue(Utils.isNullOrEmpty("   "));
    }

    @Test
    void testIsNullOrEmptyValid() {
        assertFalse(Utils.isNullOrEmpty("Hello"));
    }

    @Test
    void testAdd() {
        assertEquals(8, Utils.add(3, 5));
        assertEquals(-2, Utils.add(3, -5));
    }
}
