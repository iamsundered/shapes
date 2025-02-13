package polaris;

import java.util.ArrayList;
import java.util.Scanner;

public class Arv {
    public ArrayList<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        Arv arv = new Arv();
        arv.newSquare();
        arv.printAll(); // FOR SOME REASON IT'S NOT PRINTING!
    }
    private Square newSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What size do you want to use?");
        double side = sc.nextDouble();
        System.out.println("What color do you want to use?");
        String color = sc.nextLine().toLowerCase();
        sc.nextLine();

        return new Square(color, side);

    }
    private void newCircle(String color, Scanner sc) {
        System.out.println("What radius do you want to use?");
        if (!sc.hasNextDouble()) {
            System.out.println("Please enter a double");
            return;
        }
        double radius = sc.nextDouble();
        sc.nextLine();
    }
    public void printAll() {
        for (Shape s : shapes) {
            System.out.println(s.toString());
            System.out.println("Area: " + s.getArea());
            System.out.println("Perimeter: " + s.getPerimeter());
        }
    }
}