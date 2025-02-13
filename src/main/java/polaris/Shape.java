package polaris;

public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    abstract double getArea();
    abstract double getPerimeter();

    // Returns the shapes class name e.g Square, Circle etc + it's color.
    @Override
    public String toString() {
        return "Shape: " + this.getClass().getSimpleName() + " \nColor: " + color;
    }
}
