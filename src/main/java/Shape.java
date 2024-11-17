abstract class Shape {
    public Color color;
    Shape(Color color) {
        this.color = color;
    }
    Shape(){
        this.color = new Color(255,255,255,0);
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }

    public void getColorDescription(){
        System.out.println(color.toString());
    };

    public abstract double getArea();

    public abstract double getPerimeter();
}
