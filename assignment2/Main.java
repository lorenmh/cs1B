/* Lauren Howard
 * CS1B - Assignment 1-1 - 2015.9.24
 * Main.java
 * The main method instantiates some Fan objects, modifies their values, then
 * prints their values via the printFan method.
 */

package assignment2;

public class Main {
  public static void main( String[] args ) {
    Auto typicalCar = new Auto( "Loren Howard", "Typical Car");
    travelFibonacci( typicalCar );
 
  }

  public static void travelFibonacci( Auto automobile ) {
    automobile.fillGasTank();
    automobile.display(); 

    automobile.travel( 10.0f );
    automobile.travel( 20.0f );
    automobile.travel( 30.0f );
    automobile.travel( 50.0f );
    automobile.travel( 80.0f );
    automobile.travel( 130.0f );
    automobile.travel( 210.0f );
    automobile.travel( 340.0f );

    System.out.println();
    automobile.display();
  }
}
