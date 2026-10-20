
class Pilots {
      String name ;
      int age ;
      String grade ;
      String flyingHours ;

      //Constructor : 
      public Pilots ( String name ,int age ,String grade ,String flyingHours ) {
            this.name = name ;
            this.age = age ; 
            this.grade = grade ;
            this.flyingHours = flyingHours ;
      }

      public void printPilotInfo () {
            System.out.println("name " + name + " age " + age + " grade " + grade + "flyingHours" + flyingHours );
      }
};

class Airplane {
      String regNo ;
      String altitude ;
      String speed ;
      Pilots[] pilots  ;

      public Airplane (  String regNo ,String altitude ,String speed ,Pilots[] pilots ) {
            this.regNo = regNo;
            this.altitude = altitude;
            this.speed = speed;
            this.pilots = pilots ;
      }

      public void fly() {
            System.out.println("plan is flying!") ;
      }

       public void land() {
            System.out.println("plan is landing!");
      }
}



public class task {
      public static void main (String[] args) {
            
            Pilots pilot1 = new Pilots("mohammed" , 19 , "A" ,"200h") ;
            Pilots pilot2 = new Pilots("akram" , 18 , "A" , "100h") ;
            Pilots[] pilots = {pilot1 , pilot2} ;
            Airplane Boinge = new Airplane(null, null, null, pilots) ;
            Boinge.fly() ;
      }
}
