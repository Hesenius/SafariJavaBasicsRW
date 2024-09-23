package date;

//import static date.Date.*;

enum DayOfWeek {
  SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
}

public class Date {
  private int day;
  private int month;
  private int year;

  // initializer (called "constructor")
  public Date(int day, int month, int year) {
    if (month < 1 || month > 12) throw new IllegalArgumentException("Bad Month");
    // should also check day!!!
    this.day = day;
    this.month = month;
    this.year = year;
    System.out.println(this.asText());
  }

  public Date(int day, int month) {
    this(day, month, 2024); // today, "this()" must be first
    // do other things here???
  }

  // unnecessary duplication
//  public Date(int day, int month) {
//    if (month < 1 || month > 12) throw new IllegalArgumentException("Bad Month");
//    // should also check day!!!
//    this.day = day;
//    this.month = month;
//    this.year = 2024;
//  }
//
//  public static int dayOfWeek(Date d) {
  public DayOfWeek dayOfWeek(Date this) {
    int m = this.month, y = this.year; // allowed but ugly
    if (this.month < 3) {
      m = this.month + 12;
      y = this.year - 1;
    }
    int dayNum = (this.day + (13 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400)) % 7;
    System.out.println("dayNum is " + dayNum);
    DayOfWeek rv = DayOfWeek.values()[dayNum];
    return rv;
  }

  public String toString() {
    return this.asText();
  }

//  public String asText(@NotNull Date this) {
  public String asText() {
//    int day = 99;
//    return "Date, day=" + this.day + ", month=" + this.month + ", year=" + this.year;
    return "Date, day=" + day + ", month=" + this.month + ", year=" + this.year;
  }

  public static String dateAsText(Date d) {
    return "Date, day=" + d.day + ", month=" + d.month + ", year=" + d.year;
  }

  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  // method "overloading" -- same method name, different argument TYPE SEQUENCE
  public static int daysInMonth(int month) {
    return daysInMonth(month, 2024);
  }

  public static int daysInMonth(int month, int year) {
    return switch (month) {
      case 9, 4, 6, 11 -> 30;
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 2 -> isLeapYear(year) ? 29 : 28;
      default -> throw new IllegalArgumentException("Bad month value");
    };
  }

  public static boolean isValidDate(int day, int month, int year) {
    return true;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public void setMonth(int month) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("Bad Month");
    }
    this.month = month;
  }

  public void setYear(int year) {
    this.year = year;
  }
}

class Holiday extends Date {
  private String name;
  public Holiday(int day, int month, int year, String name) {
    // if no "super" compiler adds super()
    super(day, month, year); // must happen first :)
    this.name = name;
  }

  public String asText() {
    return "Holiday, called " + name + " on " + super.asText();
  }
}

class UseDate {
  public static void addToCalendar(Date d) {
    System.out.println("Adding a date," + d.asText() + " to the calendar");
  }

  public static void main(String[] args) {
    // new creates the object, and initializes it with zeros
    // then it's passed to the "matching" constructor
    Date today = new Date(23, 9, 2024);
//    today.day = 23;
//    today.month = 99;
//    today.year = 2024;

    System.out.println("today represents as " + today);
    System.out.println(Date.dateAsText(today));
//    System.out.println(dateAsText(today));
    System.out.println(today.asText());

    System.out.println("Day of week of today is, " + today.dayOfWeek());
    System.out.println("today's day is " + today.getDay());
    addToCalendar(today);

//    Object newYearsDay = new Holiday(1, 1, 2025, "New Year's Day");
//    newYearsDay = "First of January";

    Date newYearsDay = new Holiday(1, 1, 2025, "New Year's Day");
    addToCalendar(newYearsDay);
  }
}