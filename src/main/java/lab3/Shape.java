package lab3;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

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
