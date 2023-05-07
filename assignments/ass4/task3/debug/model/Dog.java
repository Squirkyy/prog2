package debug.model;

import debug.Animal;

public class Dog extends Animal { // Import für animal fehlt

  public Dog(String name) {
    super(name);
  }

  @Override
  public String getName() {
    return super.name_;
  }

  // getArms can be removed

  @Override
  public int getLegs() {
    return 4;
  }

  @Override
  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}