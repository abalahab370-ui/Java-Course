
public class Task1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Task1 quiz midterm final");
            return;
        }

        int quiz = Integer.parseInt(args[0]);
        int midterm = Integer.parseInt(args[1]);
        int finalGrade = Integer.parseInt(args[2]);

        double average = quiz * 0.20 + midterm * 0.30 + finalGrade * 0.50;

        System.out.printf("Weighted average: %.2f%n", average);
        System.out.println("Status: " + (average >= 50 ? "PASS" : "FAIL"));
        System.out.println("Merit: " + (average >= 85 ? "YES" : "NO"));
    }
}