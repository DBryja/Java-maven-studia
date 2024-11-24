import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    @Test
    void testDefaultColor() {
        Shape shape = new Shape() {
            public double getArea() {
                return 0;
            }

            public double getPerimeter() {
                return 0;
            }
        };
        assertEquals(new Color(255, 255, 255, 0), shape.color);
    }

    @Test
    void testCustomColor() {
        Shape shape = new Shape(new Color(0, 0, 0)) {
            public double getArea() {
                return 0;
            }

            public double getPerimeter() {
                return 0;
            }
        };
        assertEquals(new Color(0, 0, 0), shape.color);
    }

    @Test
    void testPrint() {
        Shape shape = new Shape() {
            public double getArea() {
                return 0;
            }

            public double getPerimeter() {
                return 0;
            }
        };
        assertDoesNotThrow(shape::print);
    }

    @Test
    void testGetColorDescription() {
        Shape shape = new Shape() {
            public double getArea() {
                return 0;
            }

            public double getPerimeter() {
                return 0;
            }
        };
        assertDoesNotThrow(shape::getColorDescription);
    }
}