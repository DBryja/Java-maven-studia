public class Main {
    public static void main(String[] args) {
        Color yellow = new Color(255, 255, 0);
        Rectangle whiteRect = new Rectangle(10, 15);
        Triangle yellowTriangle = new Triangle(10, 10, 10, yellow);

        ShapeDescriber.describe(whiteRect);
        ShapeDescriber.describe(yellowTriangle);
    }
}