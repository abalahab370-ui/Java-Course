package TP1;

public class Task2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task2 n");
            return;
        }

        int n = Integer.parseInt(args[0]);

        if (n < 1000 || n > 9999) {
            System.out.println("INVALID");
            return;
        }

        int a = n / 1000;
        int b = (n / 100) % 10;
        int c = (n / 10) % 10;
        int d = n % 10;

        boolean valid = ((a + d) == (b + c)) && (n % 2 == 0);

        System.out.println(valid ? "VALID" : "INVALID");
    }
}