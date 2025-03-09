package pt.com;

public class ShapeFactory {
    private ShapeFactory() {
    }

    public static Shape getShape(ShapeTypes shapeType) {
        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case TRIANGLE -> new Triangle();
            case SQUARE -> new Square();
        };
    }
}
