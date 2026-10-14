import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.trim().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("")) {
                System.out.println(words[i]);
            }
        }

        sc.close();
    }
}
