/* Lauren Howard
 * CS1B - Assignment 1 - 2015.9.24
 * The Fan class models a fan.  It has a speed, on state, radius and color.
 */

package assignment1;

public class Fan {
  // speed constants
  public static final int SLOW = 1;
  public static final int MEDIUM = 2;
  public static final int FAST = 3;

  // onState constants
  public static final boolean ON = true;
  public static final boolean OFF = false;
  
  // color constants
  public static final String YELLOW = "YELLOW";
  public static final String BLUE = "BLUE";
  
  // default values
  private static final int DEFAULT_SPEED = SLOW;
  private static final boolean DEFAULT_ON_STATE = false;
  private static final double DEFAULT_RADIUS = 5.0;
  private static final String DEFAULT_COLOR = BLUE;
  
  // member variables
  private int m_speed;
  private boolean m_onState;
  private double m_radius;
  private String m_color;
  
  // default Fan constructor
  public Fan() {
    m_speed = DEFAULT_SPEED;
    m_onState = DEFAULT_ON_STATE;
    m_radius = DEFAULT_RADIUS;
    m_color = DEFAULT_COLOR;
  }
  
  // setters / getters for member variables
  public void setSpeed( int speed ) {
    m_speed = speed;
  }
  
  public int getSpeed() {
    return m_speed;
  }
  
  public void setOnState( boolean onState ) {
    m_onState = onState;
  }
  
  public boolean getOnState() {
    return m_onState;
  }
  
  public void setRadius( double radius ) {
    m_radius = radius;
  }
  
  public double getRadius() {
    return m_radius;
  }
  
  public void setColor( String color ) {
    m_color = color;
  }
  
  public String getColor() {
    return m_color;
  }
}
