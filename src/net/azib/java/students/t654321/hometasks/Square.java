package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Karl
 */
public class Square extends Shape {

	private double side;
	private static final int HASH_PRIME = 103;
	
	public Square(double side){
		this.side = side;
	}
	
	@Override
	public double area() {
		return Math.pow(side, 2.0);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Square & this.side == ((Square)o).side) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return HASH_PRIME * Double.toString(side).hashCode();
	}

	@Override
	public String toString() {
		return "This is square with side " + this.side + ".";
	}

}
