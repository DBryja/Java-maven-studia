import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void testArea() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(6, rectangle.getArea());
    }

    @Test
    void testPerimeter() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(10, rectangle.getPerimeter());
    }

    @Test
    void testColor() {
        Rectangle rectangle = new Rectangle(2, 3, new Color(255, 0, 0));
        assertEquals(new Color(255, 0, 0), rectangle.color);
    }
}