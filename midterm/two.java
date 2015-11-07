class A {
  public A() { }
  public A( int x, char b ) { }
}

class B extends A {
  public B( int x, char t ) { }
}
public class C {
  public static void main( String[] args ) {
    B b = new B( 5, 'L' );
  }
}
