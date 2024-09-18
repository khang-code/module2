import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Liner Equation Resolver");
        System.out.println("Given a question as 'a * x + b = 0' please enter constant:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a= scanner.nextDouble();
        System.out.print("b: ");
        double b= scanner.nextDouble();
        if (a != 0) {
            double solution = -b / a;
            System.out.printf("the solution is %f!", solution);
        } else { if (b == 0) {
            System.out.print("The solution is all x!");
        } else {
            System.out.println("No solution");
        }
    }
}}
