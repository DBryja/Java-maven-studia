class ShapeDescriber {
    ShapeDescriber() {
    }

    public static void describe(Shape var0) {
        System.out.println("Area: " + var0.getArea());
        System.out.println("Perimeter: " + var0.getPerimeter());
        var0.getColorDescription();
    }
}
