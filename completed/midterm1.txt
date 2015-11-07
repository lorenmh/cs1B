// Lauren Howard, 2015.10.25
// FH CS1B Midterm





// PROBLEM ONE
public class Calculator {
  public static void main( String[] args ) {
    // the operator variable will be used in a switch statement
    String operator = args[ 0 ];

    // args[ 1 ] and args[ 2 ] will be strings and need to be converted to int
    int operand1 = Integer.parseInt( args[ 1 ] );
    int operand2 = Integer.parseInt( args[ 2 ] );

    switch( operator ) {
      case "+":
        System.out.println( operand1 + operand2 );
        break;
      case "-":
        System.out.println( operand1 - operand2 );
        break;
      case "/":
        System.out.println( ( (double) operand1 ) / operand2 );
        break;
      case "*":
        System.out.println( operand1 * operand2 );
        // break isnt necessary here
    }
  }
}

//PROBLEM ONE OUTPUT (NOTE: I had to escape the multiplier operator (*) because I am using bash)
loren@ucomp:~/learn/fh-cs1b/midterm1$ java Calculator + 4 2
6
loren@ucomp:~/learn/fh-cs1b/midterm1$ java Calculator \* 4 2
8
loren@ucomp:~/learn/fh-cs1b/midterm1$ java Calculator - 4 2
2
loren@ucomp:~/learn/fh-cs1b/midterm1$ java Calculator / 4 2
2.0





//PROBLEM TWO
The issue is that the default, no argument A constructor is implicitly called within the B constructor.  In other words, within B it is implicitly calling 'super()', but, A doesn't have a constructor without any arguments.
To fix this, you can add an A constructor which has no arguments ( signature would look like 'public A()' ), or, if you were to modify B's constructor then you would make a call to A's constructor passing it the values from B's constructor ( the invocation would look like 'super( z, t )' ), but in the instructions you say not to modify the constructors so I will not take this approach.

The fix is:
class A {
  // the no-arg constructor which is implicitly called in B's constructor
  public A() { }
  
  public A( int x, char b ) { }
}

class B extends A {
  public B( int z, char t ) { }
}
public class C {
  public static void main( String[] args ) {
    B b = new B( 5, 'L' );
  }
}





// PROBLEM THREE
The problem is that while the objects in the dates array have been declared, they not been defined.  By default java will set undefined objects to a value of null, so every element in the dates array is therefore set to null.
To fix the problem, simply instantiate / define the values for each element in the dates array:

public class Test {
  public static void main( String[] args ) {
    java.util.Date[] dates = new java.util.Date[ 12 ];
    
    // to fix the error, simply define all of the elements in the dates array
    for ( int i = 0; i < dates.length; i++ ) {
      dates[ i ] = new java.util.Date();
    }

    System.out.println( dates[7].toString() );
  }
}

// PROBLEM THREE OUTPUT
loren@ucomp:~/learn/fh-cs1b/midterm1$ java Test 
Sun Oct 25 16:15:27 PDT 2015





// PROBLEM FOUR
public abstract class Employee {
  // overtime starts after working 40 hours in the work week
  public static final int OVERTIME_START_HOUR = 40;

  // member variables
  protected String firstName, lastName, title;
  protected float hourlyWage;
  
  public Employee() {
    firstName = "John";
    lastName = "Doe";
    title = "New-Hire";
    hourlyWage = 0.0f;
  }

  // computPayWithOvertime takes a float of hours worked and returns a float
  // value corresponding with the number of dollars to pay the employee.
  //
  // In the US some employees are exempt from overtime pay ( for example,
  // I believe software engineers / IT professionals are exempt from overtime
  // pay ).  However, some employees can still receive overtime pay.  If
  // we wanted to create different Employee subtypes, then we would want to 
  // implement this method differently.  Contract vs salaried, overtime
  // exempt vs non-exempt, etc etc etc
  public abstract float computePayWithOvertime( float hours );

  // pay employee will pay the employee a float amount of dollars;
  //
  // Some employees are paid differently, depending on whether they are
  // contract or salaried, etc. etc.
  public abstract void payEmployee( float dollars );

  // returns the full name ( the first name and the last name in a single string )
  public String fullName() {
    return String.format( "%s %s", firstName, lastName );
  }

  // setter methods
  public void setFirstName( String newFirstName ) {
    firstName = newFirstName;
  }

  public void setLastName( String newLastName ) {
    lastName = newLastName;
  }

  public void setTitle( String newTitle ) {
    title = newTitle;
  }

  public void setHourlyWage( float newHourlyWage ) {
    hourlyWage = newHourlyWage;
  }

  // getter methods
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTitle() {
    return title;
  }

  public float getHourlyWage() {
    return hourlyWage;
  }

  public void setHourlyWage( float newHourlyWage ) {
    hourlyWage = newHourlyWage;
  }
}
