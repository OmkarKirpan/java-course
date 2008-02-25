package net.azib.java.lessons.basic;

/**
 * Dog
 *
 * @author anton
 */
public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	public Dog(String name, byte age) {
		super(name, age);
	}

	@Override
	public void makeSound() {
		System.out.println("Woof-woof!");
	}
}