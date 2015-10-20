/* Lauren Howard
 * CS1B - Assignment 2 - 2015.10.19
 * Auto.java
 * The Auto class models an automobile.
 */

package assignment2;

public class Auto {
  // string specifying the owner of the auto
  protected String m_ownerName;
  // string specifying the type of the auto
  protected String m_type;
  // float specifying the maximum speed of the automobile (in km/h)
  protected float m_maxSpeed;
  // float specifying the max tank capacity (in liters)
  protected float m_tankCapacity;
  // float specifying the auto's odometer (in km)
  protected float m_odometer;
  // float specifying the current amount of gas in the tank (in liters)
  protected float m_gasInTank;
  // float specifying the average kilometer per liter;
  protected float m_averageKPL;

  // default values
  public static final String DEFAULT_OWNER = "John Doe";
  public static final String DEFAULT_TYPE = "Auto";
  public static final float DEFAULT_MAX_SPEED = 80.0f;
  public static final float DEFAULT_TANK_CAPACITY = 40.0f;
  public static final float DEFAULT_ODOMETER = 0.0f;
  public static final float DEFAULT_GAS_IN_TANK = 0.0f;
  public static final float DEFAULT_AVERAGE_KPL = 10.63f;

  private static final float EPSILON = 0.00000001f;

  // default Auto constructor
  public Auto() {
    m_ownerName = DEFAULT_OWNER;
    m_type = DEFAULT_TYPE;
    m_maxSpeed = DEFAULT_MAX_SPEED;
    m_tankCapacity = DEFAULT_TANK_CAPACITY;
    m_odometer = DEFAULT_ODOMETER;
    m_gasInTank = DEFAULT_GAS_IN_TANK;
    m_averageKPL = DEFAULT_AVERAGE_KPL;
  }
  
  // Auto constructor with ownerName and type
  public Auto( String ownerName, String type ) {
    m_ownerName = ownerName;
    m_type = type;
    m_maxSpeed = DEFAULT_MAX_SPEED;
    m_tankCapacity = DEFAULT_TANK_CAPACITY;
    m_odometer = DEFAULT_ODOMETER;
    m_gasInTank = DEFAULT_GAS_IN_TANK;
    m_averageKPL = DEFAULT_AVERAGE_KPL;
  }

  // Auto constructor with ownerName, type, and averageKPL
  public Auto( String ownerName, String type, float averageKPL ) {
    m_ownerName = ownerName;
    m_type = type;
    m_maxSpeed = DEFAULT_MAX_SPEED;
    m_tankCapacity = DEFAULT_TANK_CAPACITY;
    m_odometer = DEFAULT_ODOMETER;
    m_gasInTank = DEFAULT_GAS_IN_TANK;
    m_averageKPL = averageKPL;
  }

  // Auto constructor with ownerName, type, tankCapacity and averageKPL
  public Auto( String ownerName, String type, float tankCapacity,
               float averageKPL ) {
    m_ownerName = ownerName;
    m_type = type;
    m_maxSpeed = DEFAULT_MAX_SPEED;
    m_tankCapacity = tankCapacity;
    m_odometer = DEFAULT_ODOMETER;
    m_gasInTank = DEFAULT_GAS_IN_TANK;
    m_averageKPL = averageKPL;
  }
  // simple method to check whether two floats are within some epsilon value
  // if they are, they are considered to be equal / equivalent.
  public static boolean floatEquals( float a, float b ) {
    return Math.abs( a - b ) < EPSILON;
  }

  public void travel( float distance ) {
    float gasUsedForDistance = distance / m_averageKPL;
    
    // check to see if the gas tank is empty
    if ( floatEquals( m_gasInTank, 0.0f ) ) {

      // if the gas tank is empty, do not travel
      System.out.println( "Auto is out of gas, can not travel!" );

    // check to see if the gas tank doesn't have enough gas for the trip
    } else if ( gasUsedForDistance > m_gasInTank ) {
      // the auto doesn't have enough gas for the full trip

      // the auto can only use the gas left in the tank to travel
      float distanceTravelled = m_gasInTank * m_averageKPL;

      // set the tank to empty because we have used up the gas
      m_gasInTank = 0.0f;

      // increment the odometer
      m_odometer += distanceTravelled;

      // 
      System.out.printf(
          "Ran out of gas! Travelled %.1f KM before running out.%n",
          distanceTravelled
      );
    } else {
      // the gas tank is not empty and there is enough gas
      
      // remove the gas that was used to travel
      m_gasInTank -= gasUsedForDistance;

      // increment the odometer
      m_odometer += distance;

      System.out.printf( "Travelled %.1f KM.%n", distance );
    }
  }

  public void fillGasTank() {
    m_gasInTank = m_tankCapacity;
  }

  // getter methods
  public String getOwnerName() {
    return m_ownerName;
  }

  public String getType() {
    return m_type;
  }

  public float getMaxSpeed() {
    return m_maxSpeed;
  }

  public float getTankCapacity() {
    return m_tankCapacity;
  }

  public float getOdometer() {
    return m_odometer;
  }

  public float getGasInTank() {
    return m_gasInTank;
  }

  public float getAverageKPL() {
    return m_averageKPL;
  }

  // setter methods
  public void setOwnerName( String ownerName ) {
    m_ownerName = ownerName;
  }

  public void setType( String type ) {
    m_type = type;
  }

  public void setMaxSpeed( float maxSpeed ) {
    m_maxSpeed = maxSpeed;
  }

  public void setTankCapacity( float tankCapacity ) {
    m_tankCapacity = tankCapacity;
  }

  public void setOdometer( float odometer ) {
    m_odometer = odometer;
  }

  public void setGasInTank( float gasInTank ) {
    m_gasInTank = gasInTank;
  }

  public void setAverageKPL( float averageKPL ) {
    m_averageKPL = averageKPL;
  }

  // display the auto information
  public void display() {
    System.out.println( "<Auto>" );
    System.out.printf( "  owner: %s%n", m_ownerName );
    System.out.printf( "  type: %s%n", m_type );
    System.out.printf( "  maxSpeed: %.1f%n", m_maxSpeed );
    System.out.printf( "  tankCapacity: %.1f%n", m_tankCapacity );
    System.out.printf( "  odometer: %.1f%n", m_odometer );
    System.out.printf( "  gasInTank: %.1f%n", m_gasInTank );
    System.out.printf( "  averageKPL: %.1f%n", m_averageKPL );
    System.out.println( "</Auto>\n" );
  }
}
