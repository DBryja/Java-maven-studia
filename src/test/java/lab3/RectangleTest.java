package lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {
    @Test
    void testArea() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assertions.assertEquals(6, rectangle.getArea());
    }

    @Test
    void testPerimeter() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assertions.assertEquals(10, rectangle.getPerimeter());
    }

    @Test
    void testColor() {
        Rectangle rectangle = new Rectangle(2, 3, new Color(255, 0, 0));
        Assertions.assertEquals(new Color(255, 0, 0), rectangle.color);
    }
}