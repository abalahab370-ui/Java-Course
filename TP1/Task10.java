public class Task10 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Task10 id role time");
            return;
        }

        int id = Integer.parseInt(args[0]);
        String role = args[1];
        int time = Integer.parseInt(args[2]);

        boolean granted = false;
        String reason = "";

        if (role.equalsIgnoreCase("staff")) {
            granted = true;
            reason = "Staff";
        } else if (role.equalsIgnoreCase("ta")) {
            if (time >= 8 && time <= 20) {
                granted = true;
                reason = "TA within allowed hours";
            } else {
                reason = "TA outside allowed hours";
            }
        } else if (role.equalsIgnoreCase("student")) {
            if (time >= 9 && time <= 17 && id % 2 == 0) {
                granted = true;
                reason = "Student even id within allowed hours";
            } else if (time < 9 || time > 17) {
                reason = "Student outside allowed hours";
            } else {
                reason = "Student id is odd";
            }
        } else {
            reason = "Invalid role";
        }

        if (granted) {
            System.out.println("ACCESS GRANTED - " + reason);
        } else {
            System.out.println("ACCESS DENIED - " + reason);
        }
    }
}
