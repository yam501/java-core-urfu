package lr2;

public class Example6 {
    interface Shape {
        double area();
        double perimeter();
    }

    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "Circle{radius=" + radius + "}";
        }
    }

    static class Square implements Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }

        @Override
        public double perimeter() {
            return 4 * side;
        }

        @Override
        public String toString() {
            return "Square{side=" + side + "}";
        }
    }

    static class Triangle implements Shape {
        private double a, b, c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area() {
            double s = perimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }

        @Override
        public String toString() {
            return "Triangle{a=" + a + ", b=" + b + ", c=" + c + "}";
        }
    }

    static void printInfo(Shape shape) {
        System.out.println(shape);
        System.out.printf("  Площадь: %.2f%n", shape.area());
        System.out.printf("  Периметр: %.2f%n", shape.perimeter());
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Triangle(3, 4, 5)
        };

        for (Shape shape : shapes) {
            printInfo(shape);
        }
    }
}