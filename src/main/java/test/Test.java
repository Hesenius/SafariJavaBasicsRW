package test;

record X(String msg, int x) {}

public class Test {
  public static void main(String[] args) {
    Object obj = new X("Hello Java 22 World!", 99);
    System.out.println(switch (obj) {
      case X(String m, _) -> m;
      default -> throw new IllegalStateException("That shouldn't happen");
    });
  }
}
