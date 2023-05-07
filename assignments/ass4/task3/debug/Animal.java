package debug;

public class Animal {
  protected String name_; // made name protected
  private int legs_;
  private int arms_;

  public Animal(String name, int legs, int arms) { // Public constructor
    this.name_ = name;
    this.legs_ = legs;
    this.arms_ = arms;
  }

  public Animal(String name) { // Public constructor
    this(name, 0, 0);
  }

  public String getName() {
    return this.name_;
  }

  public int getArms() {
    return this.arms_;
  }

  public int getLegs() {
    return this.legs_;
  }

  // @Override muss weg
  public String toString() {
    return String.format("%s is an animal with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}