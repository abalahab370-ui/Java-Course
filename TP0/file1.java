public class file1 {
      /*public static void main (String [] args ) {
            System.out.println("bingo");
      }
      */
      public static void main(String[] args) {
      // Declare and initialize variables
      Boolean check  = true ;
      int number = 10;
      double decimal = 5.5;
      String text = "Java is fun!";
      // Print variables
      System.out.println("Number: " + number);
      System.out.println("Decimal: " + decimal);
      System.out.println("Text: " + text + " " + check);
      // Perform arithmetic operations
      int sum = number + (int) decimal; // Casting double to int
      System.out.println("Sum: " + sum);
      // Use a loop
      for (int i = 0; i < 5; i++) {
      System.out.println("Loop iteration: " + i);
      }
      // Use a conditional statement
      if (number > 5) {
      System.out.println("Number is greater than 5");
      } else {
      System.out.println("Number is 5 or less");
      }


      Boolean check2 = false ;
      Boolean check3 = null ;
      Boolean check4 = Boolean.valueOf("true") ;
      Boolean check5 ;
      System.err.println(check + " " + check2 + " " +  check3 + " " + check4 + " " );
      }

}