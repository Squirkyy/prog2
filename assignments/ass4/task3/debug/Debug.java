package debug;

import debug.model.*;

public class Debug {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
    animals[1] = new Dog("Barks");
    animals[2] = new Monkey("King Kong");
    for (int i = 0; i < animals.length; ++i) {
      System.out.println(animals[i]);
    }
  }
}

/*
 * Error 1: The constructor Animal(String) is not visibleJava(134217859)
 * debug.Animal.Animal(String name)
 * -> public Animal
 * 
 * Error 2: Removed the getArms for the Dogs and fixed string
 * 
 * Error 3: @override in Zeile 30 muss weg, weil Animal die superclass ist und
 * nichts overrized
 * 
 * Error 4: Dog.java Zeile 5, der import fehlt
 * 
 * Error 5: Animal.java Zeile 4: Made String protected
 */