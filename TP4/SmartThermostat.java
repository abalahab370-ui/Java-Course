package TP4;


public class SmartThermostat {

      private String location ;
      private double currentTemp ;
      private double targetTemp ;
      private boolean ecoMode ;
      private boolean isOn ;

      public SmartThermostat ( String location ,double currentTemp ,double targetTemp ,boolean ecoMode ,boolean isOn ) {
            this.location = location ;
            this.currentTemp = currentTemp ;
            this.targetTemp = targetTemp ;
            this.ecoMode = ecoMode ; 
            this.isOn = isOn ;
      }

      public void turnOn () {
            this.isOn = true ;
      }


      public void turnOff () {
            this.isOn = false ;
      }

      public void setTargetTemp (double p) {
            this.targetTemp = p ;
      }

     public double getTargetTemp() {
            return this.targetTemp;
      }


      public void toggleEcoMode () {
            if (this.currentTemp == this.targetTemp) {
                  this.ecoMode = true ;
            } 
            if (this.targetTemp - this.currentTemp > 10) {
                  this.ecoMode = true ;
            }
      }

      public static void main(String[] args) {
            SmartThermostat s1 = new SmartThermostat("idzad", 19, 24, false, false);

            System.out.println(s1.getTargetTemp());
      }

}

