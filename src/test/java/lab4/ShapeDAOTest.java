package lab4;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeDAOTest {
    private SessionFactory sessionFactory;
    private ShapeDAO shapeDAO;

    @BeforeEach
    public void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        shapeDAO = new ShapeDAO(sessionFactory);
    }

    @AfterEach
    public void tearDown() {
        shapeDAO.close();
    }

    @Test
    public void testSaveAndRetrieveShape() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        shapeDAO.saveShape(rectangle);

        Shape retrievedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
        assertNotNull(retrievedShape);
        assertEquals(rectangle.getWidth(), ((Rectangle) retrievedShape).getWidth(), 0.01);
        assertEquals(rectangle.getHeight(), ((Rectangle) retrievedShape).getHeight(), 0.01);
    }

    @Test
    public void testGetAllShapes() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        shapeDAO.saveShape(rectangle);
        shapeDAO.saveShape(triangle);

        List<? extends Shape> rectangles = shapeDAO.getAllShapes(Rectangle.class);
        List<? extends Shape> triangles = shapeDAO.getAllShapes(Triangle.class);
        assertEquals(1, rectangles.size());
        assertEquals(1, triangles.size());
    }

    @Test
    public void testUpdateShape() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        shapeDAO.saveShape(rectangle);

        rectangle = new Rectangle(7.0, 10.0);
        shapeDAO.updateShape(rectangle);

        Shape updatedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
        assertEquals(7.0, ((Rectangle) updatedShape).getWidth(), 0.01);
    }

    @Test
    public void testDeleteShape() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        shapeDAO.saveShape(rectangle);

        shapeDAO.deleteShape(rectangle);

        Shape deletedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
        assertNull(deletedShape);
    }
}