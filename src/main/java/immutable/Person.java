package immutable;

// final class cannot be subtyped (no "extends Person")
public final class Person {
  // final fields must be initialized exactly once during initialization
  public final String name;
  public final int credit;

  public Person(String name, int credit) {
    this.name = name;
    this.credit = credit;
  }

  public Person withCredit(int cred) {
    return new Person(this.name, cred);
  }
}
