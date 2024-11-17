class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double var1, double var3, double var5) {
        this.a = var1;
        this.b = var3;
        this.c = var5;
    }

    public Triangle(double var1, double var3, double var5, Color var7) {
        this.a = var1;
        this.b = var3;
        this.c = var5;
        this.color = var7;
    }

    public double getPerimeter() {
        return this.a + this.b + this.c;
    }

    public double getArea() {
        double var1 = this.getPerimeter() / 2.0;
        return Math.sqrt(var1 * (var1 - this.a) * (var1 - this.b) * (var1 - this.c));
    }
}
