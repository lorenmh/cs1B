/* Lauren Howard
 * CS1B - Assignment 1-1 - 2015.9.24
 * Main.java
 * The main method instantiates some Fan objects, modifies their values, then
 * prints their values via the printFan method.
 */

package assignment1_1;

public class Main {
  public static void main( String[] args ) {
    // instantiate fans
    Fan fan1 = new Fan();
    Fan fan2 = new Fan();
    
    // set fan1 values
    fan1.setSpeed( Fan.FAST );
    fan1.setRadius( 10.0 );
    fan1.setColor( Fan.YELLOW );
    fan1.setOnState( Fan.ON );

    // set fan2 values
    fan2.setSpeed( Fan.MEDIUM );
    fan2.setRadius( 5.0 );
    fan2.setColor( Fan.BLUE );
    fan2.setOnState( Fan.OFF );

    // print fans
    printFan( fan1 );
    printFan( fan2 );
  }
 
  // prints the values of a Fan instance using Fan's accessor methods
  public static void printFan( Fan fan ) {
    System.out.println( "Fan" );
    System.out.printf( "  speed: %d%n", fan.getSpeed() );
    System.out.printf( "  onState: %b%n", fan.getOnState() );
    System.out.printf( "  radius: %.1f%n", fan.getRadius() );
    System.out.printf( "  color: %s%n%n", fan.getColor() );
  }
}
