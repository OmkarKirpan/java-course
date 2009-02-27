package net.azib.java.students.t074918;

import net.azib.java.students.t074918.Dog;

/**
 * Animal
 *
 * @author Mart Mangus
 */
public abstract class Animal implements Cloneable {
	
	String name;
	private int age = 2;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Animal) {
			Animal a = (Animal)obj;
			return (a.name.equals(this.name) && a.age == this.age);
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + name + " is " + age + " year(s) old.";
	}
	
	/**
	 * @Deprecated Please use {@link net.azib.java.students.t074918.Dog.toString}
	 * instead
	 */
	public String depFunction() {
		return "See ei ole hea funktsioon...";
	}
	
	public abstract void makeNoise();

	@Override
	public int hashCode() {
		return name.hashCode() + age * 37;
	}

	@Override
	public Animal clone() throws CloneNotSupportedException {
		Animal clone = (Animal) super.clone();
		clone.age = 0;
		return clone;
	}

	
}
