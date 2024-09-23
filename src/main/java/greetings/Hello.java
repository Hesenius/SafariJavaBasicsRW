package greetings;

//import java.lang.System;
//import java.lang.*; // imported by default!!
//import static java.lang.System.out;
import static java.lang.System.*;

// "primitive types" in java
// boolean (true, false), byte, short, char, int, long, float, double

class TwoNumbers {
  public int first;
  public int second;
}

public class Hello { // can only have ONE public type in a single source file
  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  public static int daysInMonth(int month, int year) {
//    if (month == 9 || month == 4 ) ... return 30;

//    switch (month) {
//      case 9: // target for "goto"
//        // falls through without "break"
//      case 4:
//      case 6:
//      case 11:
//        return 30;
//      ...
//    }

    return switch (month) {
      case 9, 4, 6, 11 -> 30;
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 2 -> isLeapYear(year) ? 29 : 28;
      default -> throw new IllegalArgumentException("Bad month value");
    };

//    switch (month) {
//      case 9, 4, 6, 11 -> {return 30;}
//      case 1, 3, 5, 7, 8, 10, 12 -> {return 31;}
//      case 2 -> {return isLeapYear(year) ? 29 : 28;}
//      default -> throw new IllegalArgumentException("Bad month value");
//    }
  }

  public static boolean isValidDate(int day, int month, int year) {
    return true;
  }

  // no default values for arguments
  // no named argument passing only positional
  public static TwoNumbers addUp(int a, int b) {
    TwoNumbers retVal = new TwoNumbers();
    retVal.first = a + b;
    retVal.second = Integer.max(a, b);
    return retVal;
  }

  public static int funct(int a, int b) {
//    int sum = a + b;
//    return sum;
//    var sum; // NO, MUST declare AND INITIALIZE in one go
//    sum = a + b;
    var sum = a + b;
    long bigNum = 10_000_000_000L;
//    sum = bigNum; // NO sum is INT!!!
    return sum;
//    return a + b;
  }

  public static void main(String[] args) {
//    java.lang.System.out.println("Hello Java 22 World!");
//    System.out.println("Hello Java 22 World!");
    out.println("Hello Java 22 World!");
//    out.println(); // sout TAB shorthand in IntelliJ

//    int sum = funct(3, 5, 7); // NO must match argument count
    int sum = funct(3, 5); // NO must match argument count
//    out.println("sum is ", sum); // NO, single argument to println
    out.println("sum is " + sum);

    TwoNumbers tn1 = addUp(3, 7);
    out.printf("sum is %d, max is %d\n", tn1.first, tn1.second);
    tn1 = addUp(99, 7);
    out.printf("sum is %d, max is %d\n", tn1.first, tn1.second);

    out.println("is 31, 2, 2025 valid? " + isValidDate(31, 2, 2025));
    out.println("is 31, 2, 2025 valid? " + isValidDate(7, 2, 2025));
  }
}
