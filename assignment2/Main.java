/* Lauren Howard
 * CS1B - Assignment 2 - 2015.10.19
 * Main.java
 * The main method instantiates two Auto objects (an Auto and a Truck
 * instance). Using travelTestFibonacci the travel methods are called for these
 * two Auto objects. Results are printed as the tests execute.
 */

package assignment2;

public class Main {
  public static int testCounter = 0;

  public static void main( String[] args ) {
    Auto typicalCar = new Auto( "Lauren Howard", "Typical Car" );
    travelTestFibonacci( typicalCar );

    Auto semiTruck = new Truck( "Jim Truckdriver", "Semi-Truck" );
    travelTestFibonacci( semiTruck );
  }

  // travelTestFibonacci tests an Auto instance's travel method.
  // The Auto instance's gas tank is filled, then the Auto travels increasing
  // distances.
  public static void travelTestFibonacci( Auto automobile ) {
    System.out.printf( "Test %d ========================%n", ++testCounter );
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
    automobile.travel( 550.0f );
    System.out.println();

    automobile.display();
  }
}
