public class Task9 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task9 width height");
            return;
        }

        double width = Double.parseDouble(args[0]);
        double height = Double.parseDouble(args[1]);

        if (width <= 0 || height <= 0) {
            System.out.println("Width and height must be positive.");
            return;
        }

        double area = width * height;
        double perimeter = 2 * (width + height);
        String classification = (width == height) ? "Square" : "Rectangle";

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Classification: " + classification);
    }
}