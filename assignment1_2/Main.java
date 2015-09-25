/* Lauren Howard
 * CS1B - Assignment 1-2 - 2015.9.24
 * Main.java
 * The main method instantiates a 2D integer array, then using the sumMatrix
 * method, the sum of the integer values in the 2D array are printed.
 */

package assignment1_2;

public class Main {
  public static void main( String[] args ) {
    // instantiate the 2D integer array
    int[][] matrix = {
      { 1, 2, 3, 4 },
      { 2, 3, 4, 5 },
      { 3, 4, 5, 6 },
      { 4, 5, 6, 7 }
    };

    // print out the sum of the integer values using sumMatrix
    System.out.printf( "Sum of matrix: %.1f%n%n", sumMatrix( matrix ) );
  }
  
  // returns the sum of the integers in matrix m
  public static double sumMatrix( int[][] m ) {
    double sum = 0.0;

    int numRows = m.length;
    int numCols = m[ 0 ].length;

    for ( int row = 0; row < numRows; row++ ) {
      for ( int col = 0; col < numCols; col++ ) {
       sum += m[ row ][ col ];
      }
    }

   return sum; 
  }
}
