package lr2;

public class Example5 {
    static class Rectangle {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() { return length; }
        public void setLength(double length) { this.length = length; }

        public double getWidth() { return width; }
        public void setWidth(double width) { this.width = width; }

        public double area() {
            return length * width;
        }

        public double perimeter() {
            return 2 * (length + width);
        }

        @Override
        public String toString() {
            return "Rectangle{length=" + length + ", width=" + width + "}";
        }
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);
        System.out.println(rect);
        System.out.println("Площадь: " + rect.area());
        System.out.println("Периметр: " + rect.perimeter());
    }
}