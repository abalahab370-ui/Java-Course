import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        do {
            System.out.print("Enter number in [10, 50]: ");
            n = sc.nextInt();
        } while (n < 10 || n > 50);

        System.out.println("Accepted: " + n);
        System.out.println("Square: " + (n * n));

        sc.close();
    }
}