package polaris;

public abstract class Shape {
    private String color;

    Shape(String color) {
        this.color = color;
    }

    public String getColor(String color) {
        return color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    // Returns the shapes class name e.g Square, Circle etc + it's color.
    @Override
    public String toString() {
        return "shape: " + this.getClass().getSimpleName() + ". Color: " + color;
    }
}
