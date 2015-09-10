class Furniture {
	class WoodFurniture {
		WoodFurniture(String color) {}
	}
}

class HouseFittings {
	// You need instance of the enclosing class which contains
	// the inner class that is extended here
	// to call the non-default constructor.
	Furniture f = new Furniture();
	class BathFittings extends Furniture.WoodFurniture {
		BathFittings(String color) {
			f.super(color); // This is important
		}
		
	}
}

public class Ex25 {
	/* public static void main(String[] args) {
		HouseFittings hf = new HouseFittings();
		HouseFittings.BathFittings b = hf.new BathFittings("Red");
	} */
}