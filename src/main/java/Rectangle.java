class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double var1, double var3) {
        this.width = var1;
        this.height = var3;
    }

    public Rectangle(double var1, double var3, Color var5) {
        this.width = var1;
        this.height = var3;
        this.color = var5;
    }

    public double getPerimeter() {
        return 2.0 * (this.width + this.height);
    }

    public double getArea() {
        return this.width * this.height;
    }
}
