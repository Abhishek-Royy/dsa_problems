/**
 * OOPS PART 1
 *
 * This program demonstrates the basic concepts of
 * Object-Oriented Programming (OOP) in Java.
 *
 * Concepts covered:
 * 1. Class
 * 2. Object
 * 3. Constructor
 * 4. this keyword
 * 5. Inheritance
 * 6. super keyword
 * 7. Encapsulation
 * 8. Method Overriding
 * 9. Runtime Polymorphism
 * 10. Abstraction
 * 11. static keyword
 */
public class oops_part1 {

    // ============================================================
    // 1. ABSTRACTION
    // ============================================================
    // Animal is an abstract class.
    //
    // We cannot directly create an object of an abstract class.
    // Example:
    // Animal a = new Animal();  // NOT ALLOWED
    //
    // Instead, we create objects of child classes such as Dog/Cow.

    static abstract class Animal {

        // ========================================================
        // 2. ENCAPSULATION
        // ========================================================
        // Fields are kept private so they cannot be directly
        // accessed from outside the class.
        //
        // We use getter and setter methods to access them.

        private String sound;
        private String name;
        private int legCount;


        // ========================================================
        // 3. CONSTRUCTOR
        // ========================================================
        // Constructor is called automatically when an object
        // is created.

        Animal(String sound, String name, int legCount) {

            // 'this' refers to the current object.
            //
            // this.sound = sound;
            // Left side  -> instance variable
            // Right side -> constructor parameter

            this.sound = sound;
            this.name = name;
            this.legCount = legCount;
        }


        // ========================================================
        // 4. GETTER METHODS
        // ========================================================
        // Used to read private variables.

        public String getSound() {
            return sound;
        }

        public String getName() {
            return name;
        }

        public int getLegCount() {
            return legCount;
        }


        // ========================================================
        // 5. SETTER METHODS
        // ========================================================
        // Used to modify private variables.

        public void setSound(String sound) {
            this.sound = sound;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLegCount(int legCount) {
            this.legCount = legCount;
        }


        // ========================================================
        // 6. NORMAL METHOD
        // ========================================================

        public void eat() {
            System.out.println(name + " is eating.");
        }


        // ========================================================
        // 7. ABSTRACT METHOD
        // ========================================================
        // An abstract method does not have a body.
        //
        // Child classes MUST implement this method.

        public abstract void makeSound();
    }


    // ============================================================
    // 8. INHERITANCE
    // ============================================================
    // Dog inherits properties and methods from Animal.
    //
    // Dog IS-A Animal.

    static class Dog extends Animal {

        // Constructor of Dog
        Dog() {

            // super() calls the constructor of parent class.
            super("Bhau Bhau", "Dog", 4);
        }


        // ========================================================
        // 9. METHOD OVERRIDING
        // ========================================================
        // Dog provides its own implementation of makeSound().

        @Override
        public void makeSound() {

            System.out.println(getName() + " says: " + getSound());
        }


        // Dog's own method

        public void guardHouse() {
            System.out.println("Dog is guarding the house.");
        }
    }


    // ============================================================
    // 10. ANOTHER CHILD CLASS
    // ============================================================
    // Cow also inherits from Animal.
    //
    // Cow IS-A Animal.

    static class Cow extends Animal {

        // Cow constructor

        Cow() {

            // Calling parent constructor

            super("Moo Moo", "Cow", 4);
        }


        // ========================================================
        // 11. METHOD OVERRIDING
        // ========================================================

        @Override
        public void makeSound() {

            System.out.println(getName() + " says: " + getSound());
        }


        // Cow's own method

        public void giveMilk() {
            System.out.println("Cow gives milk.");
        }
    }


    // ============================================================
    // 12. ANOTHER CHILD CLASS
    // ============================================================

    static class Cat extends Animal {

        Cat() {

            super("Meow Meow", "Cat", 4);
        }


        @Override
        public void makeSound() {

            System.out.println(getName() + " says: " + getSound());
        }


        public void climbTree() {

            System.out.println("Cat is climbing the tree.");
        }
    }


    // ============================================================
    // 13. STATIC VARIABLE
    // ============================================================
    // static variable belongs to the class rather than an object.
    //
    // Only one copy of this variable exists.

    static int animalCount = 0;


    // ============================================================
    // 14. MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        System.out.println("========== JAVA OOP CONCEPTS ==========\n");


        // ========================================================
        // OBJECT CREATION
        // ========================================================
        // Dog is a class.
        // dog1 is an object of Dog.

        Dog dog1 = new Dog();

        animalCount++;


        // Display Dog information

        System.out.println("----- DOG -----");

        System.out.println("Name: " + dog1.getName());

        System.out.println("Sound: " + dog1.getSound());

        System.out.println("Legs: " + dog1.getLegCount());


        // Calling inherited method

        dog1.eat();

        // Calling overridden method

        dog1.makeSound();

        // Calling Dog-specific method

        dog1.guardHouse();


        System.out.println();


        // ========================================================
        // COW OBJECT
        // ========================================================

        Cow cow1 = new Cow();

        animalCount++;

        System.out.println("----- COW -----");

        System.out.println("Name: " + cow1.getName());

        System.out.println("Sound: " + cow1.getSound());

        System.out.println("Legs: " + cow1.getLegCount());

        cow1.eat();

        cow1.makeSound();

        cow1.giveMilk();


        System.out.println();


        // ========================================================
        // CAT OBJECT
        // ========================================================

        Cat cat1 = new Cat();

        animalCount++;

        System.out.println("----- CAT -----");

        System.out.println("Name: " + cat1.getName());

        System.out.println("Sound: " + cat1.getSound());

        System.out.println("Legs: " + cat1.getLegCount());

        cat1.eat();

        cat1.makeSound();

        cat1.climbTree();


        System.out.println();


        // ========================================================
        // ENCAPSULATION EXAMPLE
        // ========================================================
        // We cannot do:
        //
        // dog1.name = "Tommy";
        //
        // because name is private.
        //
        // Instead, we use setter.

        dog1.setName("Tommy");

        System.out.println("Dog's updated name: " + dog1.getName());


        System.out.println();


        // ========================================================
        // POLYMORPHISM
        // ========================================================
        // Parent class reference can store child class object.
        //
        // Animal reference -> Dog object
        //
        // This is called UPCASTING.

        Animal animal1 = new Dog();

        Animal animal2 = new Cow();

        Animal animal3 = new Cat();


        // Although the reference type is Animal,
        // Java calls the overridden method of the actual object.

        System.out.println("----- POLYMORPHISM -----");

        animal1.makeSound();

        animal2.makeSound();

        animal3.makeSound();


        System.out.println();


        // ========================================================
        // POLYMORPHISM USING ARRAY
        // ========================================================
        // We can store different child objects inside
        // an Animal array.

        Animal[] animals = {

            new Dog(),
            new Cow(),
            new Cat()
        };


        System.out.println("----- ANIMAL ARRAY -----");


        for (Animal animal : animals) {

            System.out.println(
                animal.getName() +
                " has " +
                animal.getLegCount() +
                " legs."
            );

            animal.makeSound();

            System.out.println();
        }


        // ========================================================
        // STATIC VARIABLE
        // ========================================================
        // animalCount is shared by all objects.

        System.out.println(
            "Total animals created: " + animalCount
        );


        System.out.println(
            "\n========== PROGRAM END =========="
        );
    }
}