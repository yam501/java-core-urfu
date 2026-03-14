package lr2;

public class Example8 {
    // ------------------------- Животные -------------------------
    static abstract class Animal {
        private String name;
        private int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }

        public abstract String makeSound();

        @Override
        public String toString() {
            return getClass().getSimpleName() + "{name='" + name + "', age=" + age + "}";
        }
    }

    static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        public String getBreed() { return breed; }

        @Override
        public String makeSound() { return "Гав!"; }
    }

    static class Cat extends Animal {
        private String foodType;

        public Cat(String name, int age, String foodType) {
            super(name, age);
            this.foodType = foodType;
        }

        public String getFoodType() { return foodType; }

        @Override
        public String makeSound() { return "Мяу!"; }
    }

    static class Bird extends Animal {
        private boolean canFly;

        public Bird(String name, int age, boolean canFly) {
            super(name, age);
            this.canFly = canFly;
        }

        public boolean canFly() { return canFly; }

        @Override
        public String makeSound() { return "Чирик!"; }
    }

    // ------------------------- Геометрические фигуры -------------------------

    static abstract class Shape {
        public abstract double area();
        public abstract double perimeter();

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() { return radius; }

        @Override
        public double area() { return Math.PI * radius * radius; }

        @Override
        public double perimeter() { return 2 * Math.PI * radius; }
    }

    static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getSide() { return side; }

        @Override
        public double area() { return side * side; }

        @Override
        public double perimeter() { return 4 * side; }
    }

    static class Triangle extends Shape {
        private double a, b, c;
        private double height;

        public Triangle(double a, double b, double c, double height) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.height = height;
        }

        public double getHeight() { return height; }

        @Override
        public double area() { return 0.5 * a * height; }

        @Override
        public double perimeter() { return a + b + c; }
    }

    public static void main(String[] args) {
        System.out.println("------------------------- Животные -------------------------");
        Animal[] animals = {
            new Dog("Рекс", 3, "Овчарка"),
            new Cat("Мурка", 5, "Рыба"),
            new Bird("Кеша", 2, true)
        };

        for (Animal animal : animals) {
            System.out.println(animal + " -> " + animal.makeSound());
        }

        Dog dog = (Dog) animals[0];
        System.out.println("Порода собаки: " + dog.getBreed());

        Cat cat = (Cat) animals[1];
        System.out.println("Корм кошки: " + cat.getFoodType());

        Bird bird = (Bird) animals[2];
        System.out.println("Птица умеет летать: " + bird.canFly());

        System.out.println("\n------------------------- Геометрические фигуры -------------------------");
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Triangle(6, 5, 5, 4)
        };

        for (Shape shape : shapes) {
            System.out.printf("%s -> площадь: %.2f, периметр: %.2f%n",
                    shape, shape.area(), shape.perimeter());
        }

        Circle circle = (Circle) shapes[0];
        System.out.println("Радиус круга: " + circle.getRadius());

        Square square = (Square) shapes[1];
        System.out.println("Сторона квадрата: " + square.getSide());

        Triangle triangle = (Triangle) shapes[2];
        System.out.println("Высота треугольника: " + triangle.getHeight());
    }
}