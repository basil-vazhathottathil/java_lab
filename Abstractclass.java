package basil_vazhathottathil;

public class Abstractclass {
	public static void main(String[] args) {
		Rectangle r= new Rectangle();
		Triangle t= new Triangle();
		Hexagon h= new Hexagon();
		r.numberofSides();
		t.numberofSides();
		h.numberofSides();
	}
}

abstract class Shape{
	abstract public void numberofSides();
}

class Rectangle extends Shape{
	public void  numberofSides(){
		System.out.println("the number of sides a rectangle has is 4");
	}
}

class Triangle extends Shape{
	public void  numberofSides(){
		System.out.println("the number of sides a triangle has is 3");
	}
}

class Hexagon extends Shape{
	public void  numberofSides(){
		System.out.println("the number of sides a hexagon has is 6");
	}
}