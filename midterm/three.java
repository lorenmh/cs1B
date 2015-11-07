public class three {
  public static void main( String[] args ) {
    java.util.Date[] dates = new java.util.Date[ 12 ];
    // to fix this, simply define all of the elements in the dates array

    for ( int i = 0; i < dates.length; i++ ) {
      dates[ i ] = new java.util.Date();
    }

    System.out.println( dates[7].toString() );
  }
}
