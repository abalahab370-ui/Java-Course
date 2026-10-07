import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int count = 0;

        while (true) {
            int x = sc.nextInt();

            if (x == 0) {
                break;
            }

            sum += x;
            count++;
        }

        if (count == 0) {
            System.out.println("No data");
        } else {
            double average = (double) sum / count;
            System.out.println("Sum: " + sum);
            System.out.println("Count: " + count);
            System.out.printf("Average: %.2f%n", average);
        }

        sc.close();
    }
}