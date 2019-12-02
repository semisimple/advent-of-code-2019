package de.semisimple.advent.day1;

public class Module {

  final int mass;

  public Module(int mass) {
    this.mass = mass;
  }

  public static Module of(int mass) {
     isValid(mass);
    return new Module(mass);
  }

  /**
   * Small masses were not explained and are therefore illegal for now ;)
   *
   * @param massToCheck
   */
  private static void isValid(int massToCheck) {
    if(massToCheck<6) throw new IllegalArgumentException();
  }

  public int calculateFuelRequirement() {
    return (mass / 3) - 2;
  }
}
