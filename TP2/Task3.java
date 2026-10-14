import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        int k = sc.nextInt();

        k = normalize(k);

        String result = encrypt(message, k);
        System.out.println(result);
    }

    public static int normalize(int k) {
        k = k % 26;
        if (k < 0) {
            k += 26;
        }
        return k;
    }

    public static String encrypt(String message, int k) {
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int shifted = ch - 'A';
                shifted = (shifted + k) % 26;
                result += (char) ('A' + shifted);
            } else if (ch >= 'a' && ch <= 'z') {
                int shifted = ch - 'a';
                shifted = (shifted + k) % 26;
                result += (char) ('a' + shifted);
            } else {
                result += ch;
            }
        }

        return result;
    }
}
