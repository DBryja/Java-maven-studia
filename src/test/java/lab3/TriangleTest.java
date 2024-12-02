package lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleTest {
    @Test
    void testArea() {
        Triangle triangle = new Triangle(3, 4, 5);
        Assertions.assertEquals(6, triangle.getArea(), 0.001);
    }

    @Test
    void testPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        Assertions.assertEquals(12, triangle.getPerimeter());
    }

    @Test
    void testColor() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(255, 0, 0));
        Assertions.assertEquals(new Color(255, 0, 0), triangle.color);
    }
}