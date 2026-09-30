public class file3 {
    public static void main(String[] args) {
        String firstName = args[0];
        String lastName = args[1];
        byte groupe = Byte.parseByte(args[2]);

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(groupe);
        // System.out.println(firstName + "\n" + lastName + "\n" + groupe);
    }
}
