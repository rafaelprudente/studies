package pt.com;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape(ShapeTypes.CIRCLE);
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape(ShapeTypes.RECTANGLE);
        shape2.draw();

        Shape shape3 = ShapeFactory.getShape(ShapeTypes.TRIANGLE);
        shape3.draw();
    }
}