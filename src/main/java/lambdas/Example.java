package lambdas;

import interfaces.Photographer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

record Student(String name, int grade, String ... courses) {}

// in the core APIs java.util.function.Predicate
// @FunctionalInterface
//interface Predicate<T> {
//  boolean test(T t);
//}

class SmartStudent implements Predicate<Student> {
  @Override
  public boolean test(Student student) {
    return student.grade() > 60;
  }
}

public class Example {
  // "command" pattern--pass object as argument because of the BEHAVIOR it contains
  public static <E> List<E> getSmartStudent(List<E> in, Predicate<E> crit) {
    List<E> rv = new ArrayList<>();

    for (E s : in) {
      if (crit.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }

//  public static List<Student> getSmartStudent(List<Student> in, Predicate<Student> crit) {
//    List<Student> rv = new ArrayList<>();
//
//    for (Student s : in) {
//      if (crit.test(s)) {
//        rv.add(s);
//      }
//    }
//    return rv;
//  }
//
//  public static List<Student> getSmartStudent(List<Student> in, int threshold) {
//    List<Student> rv = new ArrayList<>();
//
//    for (Student s : in) {
//      if (s.grade() > threshold) {
//        rv.add(s);
//      }
//    }
//    return rv;
//  }
//
  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Ayo", 98, "Math", "Physics"),
        new Student("Siobahn", 45, "Journalism"),
        new Student("Inaya", 87, "Math", "Physics", "Electronics", "Astrophysics")
    );

//    System.out.println("Smart students:");
//    System.out.println(getSmartStudent(roster, 60));
//    System.out.println("Ridiculously smart students:");
//    System.out.println(getSmartStudent(roster, 90));
    System.out.println("Smart students:");
    System.out.println(getSmartStudent(roster, new SmartStudent()));

    System.out.println("Ridiculously smart students:");
//    System.out.println(getSmartStudent(roster, (Student s) -> {return s.grade() > 90;}));
//    System.out.println(getSmartStudent(roster, (s) -> {return s.grade() > 90;}));
    System.out.println(getSmartStudent(roster, s -> s.grade() > 90));

    System.out.println("Long names:");
    System.out.println(getSmartStudent(
        List.of("This", "is", "Some", "Words", "ambiguous"),
        s -> s.length() > 4));
    System.out.println("Short words:");
    System.out.println(getSmartStudent(
        List.of("This", "is", "Some", "Words", "ambiguous"),
        s -> s.length() < 5));
  }
}
