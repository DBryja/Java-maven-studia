import javax.persistence.*;

@Entity
@Table(name="rectangles")
class Rectangle extends Shape {
    @Id
    @GeneratedValue
    public Integer id;

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getPerimeter() {
        return 2.0 * (this.width + this.height);
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
}
