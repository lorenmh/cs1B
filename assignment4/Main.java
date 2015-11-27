package assignment4;

import java.io.*;

public class Main {
  public static final String DELIMITER = ":";

  // regex for number, will match for real nums (Ints and decimal nums)
  public static final String NUM_REGEX = "[0-9]+(\\.[0-9]+)?";

  public static final String NUMBER_T = "number";
  public static final String CHAR_T = "character";
  public static final String STRING_T = "string";

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please provide the file path as an argument");
      // exit with error code 1
      System.exit(1);
    }

    String path = args[0];
    File file = new File(path);
    
    // try-with-resources statement
    // this will instantiate a BufferedReader which will close after the 
    // try-block executes.  Using BufferedReader for performance.
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      // line is the line which will be read from the file
      String line;

      // the expression (line = reader.readLine()) will be null if there are
      // no more lines
      while((line = reader.readLine()) != null) {
        // subStrings is the array of strings between the delimiter character
        // for ex, "foo:bar" -> ["foo", "bar"] if the delimiter is ':'
        String[] subStrings = line.split(DELIMITER);

        // the for-block will loop through the subStrings and print their type
        for(int i = 0; i < subStrings.length; i++) {
          // the current string
          String currentString = subStrings[i];
          // the current type string
          String currentType = typeString(currentString);
          // printing out the string and the type
          System.out.printf("%s is a %s%n", currentString, currentType);
        }
      }

    } catch(FileNotFoundException exception) {
      System.out.println("File not found");
      // exit with error code 1
      System.exit(1);
    } catch(IOException exception) {
      // IOException is a checked exception, needs to be caught.  Apparently 
      // this will fire if there are errors opening the file ( for ex, over a 
      // network ).  I wasn't able to see the error so I just print the stack
      // trace if it does occur
      System.out.println("IOException");
      // print stack trace
      exception.printStackTrace();
      // exit with error code 1
      System.exit(1);
    }
  }

  // this will return a string corresponding to the 'pseudo type' from the
  // assignment example
  public static String typeString(String str) {
    // uses NUM_REGEX, which should match for decimal numbers and integers
    if (str.matches(NUM_REGEX)) {
      return NUMBER_T;
    } else if (str.length() == 1) {
      return CHAR_T;
    } else {
      // if its not a char or a number, we call it a string
      return STRING_T;
    }
  }
}
