package de.semisimple.advent.day1;

public class Module {

  final int mass;

  public Module(int mass) {
    this.mass = mass;
  }

  public static Module of(int mass) {
    return new Module(mass);
  }


  public int calculateFuelRequirement() {
    if(mass>8){
      int requiredFuel = (mass / 3) - 2;
      return requiredFuel + requiredFuelForMassOfFuel(requiredFuel);
    }
    return 0;
  }

  private int requiredFuelForMassOfFuel(int requiredFuel) {
    return Module.of(requiredFuel).calculateFuelRequirement();
  }
}
