/* Lauren Howard
 * CS1B - Assignment 2 - 2015.10.19
 * Truck.java
 * The Truck class is a subclass of the Auto class.  Similar to an Auto
 * instance, a truck can travel by calling the travel method.  In addition to
 * the member variables of the Auto class, trucks have a cargoCapacity.
 * Trucks also have a maximum KM/L of 9.0KM/L, whereas Auto instances have no
 * limit to their KM/L
 */

package assignment2;

public class Truck extends Auto{
  // the cargo capacity of the truck in KG
  private float cargoCapacity;

  // default values
  public static final String DEFAULT_TYPE = "Semi-Truck";
  public static final float DEFAULT_MAX_SPEED = 40.0f;
  public static final float DEFAULT_TANK_CAPACITY = 550.0f;
  public static final float DEFAULT_AVERAGE_KPL = 2.9f;
  public static final float DEFAULT_CARGO_CAPACITY = 18000.0f;

  // max KM/L for trucks only
  public static final float MAX_TRUCK_KPL = 9.0f;

  private static final float EPSILON = 0.00000001f;

  // default Auto constructor
  public Truck() {
    super();

    this.type = DEFAULT_TYPE;
    this.maxSpeed = DEFAULT_MAX_SPEED;
    this.tankCapacity = DEFAULT_TANK_CAPACITY;
    
    setAverageKPL( DEFAULT_AVERAGE_KPL );

    cargoCapacity = DEFAULT_CARGO_CAPACITY;
  }
  
  // Auto constructor with ownerName and type
  public Truck( String ownerName, String type ) {
    super( ownerName, type );

    this.maxSpeed = DEFAULT_MAX_SPEED;
    this.tankCapacity = DEFAULT_TANK_CAPACITY;

    setAverageKPL( DEFAULT_AVERAGE_KPL );

    cargoCapacity = DEFAULT_CARGO_CAPACITY;
  }

  // for this assignment, make it so that trucks have a maximum KPL
  @Override
  public void setAverageKPL( float averageKPL ) {
    // makes sure that average KPL is not set to a value larger than max KPL
    this.averageKPL = Math.min( averageKPL, MAX_TRUCK_KPL );
  }

  // display the auto information
  @Override
  public void display() {
    System.out.printf( "Truck owner: %s%n", this.ownerName );
    System.out.printf( "Truck type: %s%n", this.type );
    System.out.printf( "Truck maxSpeed: %.1fKM/h%n", this.maxSpeed );
    System.out.printf( "Truck tankCapacity: %.1fL%n", this.tankCapacity );
    System.out.printf( "Truck odometer: %.1fKM%n", this.odometer );
    System.out.printf( "Truck gasInTank: %.1fL%n", this.gasInTank );
    System.out.printf( "Truck averageKPL: %.1fKM/L%n", this.averageKPL );
    System.out.printf( "Truck cargoCapacity: %.1fKG%n%n", this.cargoCapacity );
  }
}
