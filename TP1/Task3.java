package TP1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Option (1-4): ");
        int option = sc.nextInt();

        System.out.print("Value: ");
        double value = sc.nextDouble();

        double result;
        String label;

        switch (option) {
            case 1:
                result = value * 9.0 / 5.0 + 32;
                label = "Fahrenheit";
                break;
            case 2:
                result = (value - 32) * 5.0 / 9.0;
                label = "Celsius";
                break;
            case 3:
                result = value * 0.621371;
                label = "Miles";
                break;
            case 4:
                result = value * 1.60934;
                label = "Kilometers";
                break;
            default:
                System.out.println("Invalid option");
                sc.close();
                return;
        }

        System.out.printf("%.2f %s%n", result, label);
        sc.close();
    }
}
