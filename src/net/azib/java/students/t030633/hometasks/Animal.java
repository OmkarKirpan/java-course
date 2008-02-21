package net.azib.java.students.t030633.hometasks;

/**
 * Abstract animal.
 * 
 * @author t030633
 */
abstract public class Animal {

	protected String name, species;
	protected int age;

	Animal() {
		name = "Noname";
		age = -1; // -1 indicates uninitialized age
	}

	Animal(String setname, int setage) {
		name = setname;
		age = setage;
	}

	public int getAge() {
		return age;
	}

	protected String getName() {
		return species + ": " + name;
	}

	protected abstract String makeSound();

	public String toString() {
		return "I am a " + species + ", my name is " + name + " and i go: " + makeSound();
	}

}
