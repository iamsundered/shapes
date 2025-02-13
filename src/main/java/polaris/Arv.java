package polaris;

import java.util.ArrayList;
import java.util.Scanner;

public class Arv {
    public ArrayList<Shape> shapes;
    private Scanner sc;


    public static void main(String[] args) {
        Arv app = new Arv();
        app.run();
    }

    public Arv() {
        shapes = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    private double getDoubleInput(String prompt) {
        double input;
        while (true) {
            System.out.println(prompt);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid input, please enter a number.");
                sc.nextLine();
            }
        }
        return input;
    }
    private String getStringInput(String prompt) {
        String input;
        while (true) {
            System.out.println(prompt);

            input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("[a-öA-Ö ]+")) { // Only allows alphabetic letters and " ".
                break;
            } else {
                System.out.println("Invalid input, please enter a color.");
            }
        }
        return input;
    }

    private Square newSquare() {
        double side = getDoubleInput("What size do you want to use?");
        String color = getStringInput("What color do you want to use?");

        return new Square(color, side);
    }

    private Circle newCircle() {
        double radius = getDoubleInput("What radius do you want to use?");
        String color = getStringInput("What color do you want to use?");

        return new Circle(color, radius);
    }

    private Triangle newTriangle() {
        double height = getDoubleInput("What height do you want to use?");
        double base = getDoubleInput("What base do you want to use?");
        String color = getStringInput("What color do you want to use?");

        return new Triangle(color, height, base);
    }


    public void printAll() {
        for (Shape s : shapes) {
            System.out.println(s.toString());
            System.out.println("Area: " + s.getArea());

            if (s instanceof Circle) {
                System.out.println("Circumference: " + s.getPerimeter());
            } else {
                System.out.println("Perimeter: " + s.getPerimeter());
            }

            System.out.println();
        }
    }

    public void run() {
        while (true) {
            System.out.println();
            System.out.println("Pick a shape to create:");
            System.out.println("1. Square");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            System.out.println("4. Print all shapes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    shapes.add(newSquare());
                    break;
                case 2:
                    shapes.add(newCircle());
                    break;
                case 3:
                    shapes.add(newTriangle());
                    break;
                case 4:
                    printAll();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}