//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import static org.mockito.Mockito.*;
//
//class ShapeDescriberTest {
//    @Test
//    void testDescribe() {
//        Shape shape = mock(Shape.class);
////        when(shape.getClass().getSimpleName()).thenReturn("MockShape");
//        when(shape.color).thenReturn(new Color(255, 255, 255));
//        when(shape.getArea()).thenReturn(100.0);
//        when(shape.getPerimeter()).thenReturn(40.0);
//
//        Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);
//        ShapeDescriber.describe(shape);
//
//        verify(logger).info("Shape: {}", "MockShape");
//        verify(logger).info("Color: {}", "java.awt.Color[r=255,g=255,b=255]");
//        verify(logger).info("Area: {}", 100.0);
//        verify(logger).info("Perimeter: {}", 40.0);
//    }
//}