package basil;
public class TestAnimal {
	public static void main(String[] args) {
		Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();
        
        System.out.println("FISH");
        d.setName("Mimi");
        d.eat();
        d.walk();
        d.setName("Momo");
        
        System.out.println("\n");
        
        System.out.println("CAT");
        c.setName("Fluffy");
        c.walk();
        c.eat();
        c.setName("Moose");
        
        System.out.println("\n");
        
        System.out.println("SPIDER");
        e.eat();
        e.walk();

	}

}

abstract class Animal{
	protected int legs;
	protected Animal(int legs) {
		this.legs=legs;
	}
	public void walk(){
		System.out.println("the animal walks on "+ legs +" legs");
	}
	abstract void eat();
}

interface Pet {
	String getName();
	void setName(String name);
	void play();
}

class Spider extends Animal{
	public Spider() {
		super(8);
	}
	public void eat() {
		System.out.println("Spider eats insects");;
	}
}

class Cat extends Animal implements Pet{
	String name;
	public Cat(String name) {
		super(4);
		this.name=name;
	}
	public Cat() {
		this("");
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		System.out.println("the cat's name is "+ name);
	}
	public void play() {
		System.out.println("playing");
	}
	public void eat() {
		System.out.println("Cat eats fishes");
	}
}

class Fish extends Animal implements Pet{
	public Fish() {
		super(0);
	}
	String name;
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		System.out.println("the fish's name is "+ name);
	}
	public void play() {
		System.out.println("playing ");
	}
	public void walk() {
		System.out.println("the fish has no legs");
	}
	public void eat() {
		System.out.println("Fishes eat plants");
	}
}