package principle.liskov;

/**
 * liskov Principle
 * Subtypes must be substitutable for their base types & this should not
 * alter behavior/ characteristics of program.
 *
 * How to fix it: Break the relationship between Rectangle & Square.
 * Create an interface 'Shape' and Rectangle & Square implements Shape interface
 */
class Rectangle {
    private int width;
    private int height;

    public int computeArea() {
        return width * height;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}


public class LiskovViolation {
    public static void main(String[] args) {
        useRectangle(new Rectangle(10, 20));
        useRectangle(new Square(10));
    }

    public static void useRectangle(Rectangle rectangle) {
        rectangle.setHeight(20);
        rectangle.setWidth(30);
        System.out.println("rectangle = " + rectangle);
        System.out.println("rectangle.computeArea() = " + rectangle.computeArea());

        // Will throw exception when Square running this -> violation of Liskov Principle
        if (rectangle.getHeight() != 20) throw new AssertionError("Height Not equal to 20");
        if (rectangle.getWidth() != 30) throw new AssertionError("Width Not equal to 30");
    }

}
