import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeRendererTest {
    @Test
    void testRenderRectangle() {
        Rectangle rectangle = new Rectangle(2, 3);
        ShapeRenderer.render(rectangle);
        // Manual verification needed for console output
    }

    @Test
    void testRenderTriangle() {
        Triangle triangle = new Triangle(3, 4, 5);
        ShapeRenderer.render(triangle);
        // Manual verification needed for console output
    }

    @Test
    void testRenderWithColor() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(255, 0, 0));
        ShapeRenderer.render(triangle);
        // Manual verification needed for console output
    }
}