/* Lauren Howard
 * CS1B - Assignment 2 - 2015.10.19
 * Auto.java
 * The Auto class models an automobile.  It has an owner, type, maxSpeed,
 * tankCapacity, odometer, gasInTank, and averageKPL.  An Auto instance
 * can travel a distance (in km) by calling its travel method.  When an auto 
 * travels, it uses up gas and increments the odometer the distance travelled.
 * Note: KM/L is shortened to 'KPL' meaning 'Kilometer Per Liter of gas used'.
 */

package assignment2;

public class Auto {
  // string specifying the owner of the auto
  protected String ownerName;
  // string specifying the type of the auto
  protected String type;
  // float specifying the maximum speed of the automobile (in km/h)
  protected float maxSpeed;
  // float specifying the max tank capacity (in liters)
  protected float tankCapacity;
  // float specifying the auto's odometer (in km)
  protected float odometer;
  // float specifying the current amount of gas in the tank (in liters)
  protected float gasInTank;
  // float specifying the average kilometer per liter;
  protected float averageKPL;

  // default values
  public static final String DEFAULT_OWNER = "John Doe";
  public static final String DEFAULT_TYPE = "Sedan";
  public static final float DEFAULT_MAX_SPEED = 160.0f;
  public static final float DEFAULT_TANK_CAPACITY = 40.0f;
  public static final float DEFAULT_ODOMETER = 0.0f;
  public static final float DEFAULT_GAS_IN_TANK = 0.0f;
  public static final float DEFAULT_AVERAGE_KPL = 10.63f;

  // used to compare float values
  private static final float EPSILON = 0.00000001f;

  // default Auto constructor
  public Auto() {
    ownerName = DEFAULT_OWNER;
    type = DEFAULT_TYPE;
    maxSpeed = DEFAULT_MAX_SPEED;
    tankCapacity = DEFAULT_TANK_CAPACITY;
    odometer = DEFAULT_ODOMETER;
    gasInTank = DEFAULT_GAS_IN_TANK;
    averageKPL = DEFAULT_AVERAGE_KPL;
  }
  
  // Auto constructor with ownerName and type
  public Auto( String ownerName, String type ) {
    this.ownerName = ownerName;
    this.type = type;

    maxSpeed = DEFAULT_MAX_SPEED;
    tankCapacity = DEFAULT_TANK_CAPACITY;
    odometer = DEFAULT_ODOMETER;
    gasInTank = DEFAULT_GAS_IN_TANK;
    averageKPL = DEFAULT_AVERAGE_KPL;
  }

  // simple method to check whether two floats are within some epsilon value
  // if they are, they are considered to be equal / equivalent.
  public static boolean floatEquals( float a, float b ) {
    return Math.abs( a - b ) < EPSILON;
  }

  public void travel( float distance ) {
    float gasUsedForDistance = distance / averageKPL;
    
    // check to see if the gas tank is empty
    if ( floatEquals( gasInTank, 0.0f ) ) {

      // if the gas tank is empty, do not travel
      System.out.println( "Auto is out of gas, can not travel!" );

    // check to see if the gas tank doesn't have enough gas for the trip
    } else if ( gasUsedForDistance > gasInTank ) {
      // the auto doesn't have enough gas for the full trip

      // the auto can only use the gas left in the tank to travel
      float distanceTravelled = gasInTank * averageKPL;

      // set the tank to empty because we have used up the gas
      gasInTank = 0.0f;

      // increment the odometer
      odometer += distanceTravelled;

      // display travel info 
      System.out.printf(
          "Ran out of gas! Travelled %.1f KM before running out.%n",
          distanceTravelled
      );
    } else {
      // the gas tank is not empty and there is enough gas
      
      // remove the gas that was used to travel
      gasInTank -= gasUsedForDistance;

      // increment the odometer
      odometer += distance;

      // display travel info
      System.out.printf( "Travelled %.1f KM.%n", distance );
    }
  }

  // fill up the gas tank
  public void fillGasTank() {
    gasInTank = tankCapacity;
  }

  // setter methods
  public void setOwnerName( String ownerName ) {
    this.ownerName = ownerName;
  }

  public void setType( String type ) {
    this.type = type;
  }

  public void setMaxSpeed( float maxSpeed ) {
    this.maxSpeed = maxSpeed;
  }

  public void setTankCapacity( float tankCapacity ) {
    this.tankCapacity = tankCapacity;
  }

  public void setOdometer( float odometer ) {
    this.odometer = odometer;
  }

  public void setGasInTank( float gasInTank ) {
    this.gasInTank = gasInTank;
  }

  public void setAverageKPL( float averageKPL ) {
    this.averageKPL = averageKPL;
  }

  // display the auto information
  public void display() {
    System.out.printf( "Auto owner: %s%n", ownerName );
    System.out.printf( "Auto type: %s%n", type );
    System.out.printf( "Auto maxSpeed: %.1fKM/h%n", maxSpeed );
    System.out.printf( "Auto tankCapacity: %.1fL%n", tankCapacity );
    System.out.printf( "Auto odometer: %.1fKM%n", odometer );
    System.out.printf( "Auto gasInTank: %.1fL%n", gasInTank );
    System.out.printf( "Auto averageKPL: %.1fKM/L%n%n", averageKPL );
  }
}
