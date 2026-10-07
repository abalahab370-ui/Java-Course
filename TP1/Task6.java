import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N: ");
        int N = sc.nextInt();

        int sum = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x < 0) {
                continue;
            }

            if (x == 999) {
                break;
            }

            sum += x;
            count++;
        }

        System.out.println("Accepted count: " + count);
        System.out.println("Accepted sum: " + sum);

        sc.close();
    }
}
