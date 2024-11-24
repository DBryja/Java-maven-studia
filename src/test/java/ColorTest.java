import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    @Test
    void testInvalidRedValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(-1, 0, 0);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void testInvalidGreenValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(0, -1, 0);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void testInvalidBlueValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(0, 0, -1);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void testRedValueExceedsMax() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(256, 0, 0);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void testGreenValueExceedsMax() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(0, 256, 0);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void testBlueValueExceedsMax() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(0, 0, 256);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void testInvalidAlphaValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Color(0, 0, 0, -1);
        });
        assertEquals("Invalid alpha", exception.getMessage());
    }
}