class Animal {
	class GroundAnimal {
		public String toString() {
			return "Ground Animal";
		}
	}
}

public class Ex24 {
	public static void main(String[] args) {
		Animal a = new Animal();
		Animal.GroundAnimal g = a.new GroundAnimal();
		System.out.println(g);
		// This is not possible
		//!GroundAnimal g = new GroundAnimal();
	}
}