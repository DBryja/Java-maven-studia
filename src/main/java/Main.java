public class Main {
    public static void main(String[] args) {
        Rectangle whiteRect = new Rectangle(10, 15);
        Triangle yellowTriangle = new Triangle(15, 25, 36, new Color(255, 255, 0));

        ShapeDescriber.describe(whiteRect);
        ShapeDescriber.describe(yellowTriangle);

        ShapeRenderer.render(whiteRect);
        ShapeRenderer.render(yellowTriangle);
    }
}