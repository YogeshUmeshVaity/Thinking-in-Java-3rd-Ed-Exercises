// The inner classes are named using $ as a separator
class Animal { // Animal.class
	class ForestAnimal { // Animal$ForestAnimal.class
		class GroudAnimal { // Animal$ForestAnimal$GroudAnimal.class
		}
		// Can't use static class here
		/*! static class Elephant {
			
		} */
	}
	// Can use static class here
	// Animal$WaterAnimal
	static class WaterAnimal {
		// Animal$WaterAnimal$DeepWaterAnimal.class
		static class DeepWaterAnimal {
			// Animal$WaterAnimal$DeepWaterAnimal$VeryDeepWaterAnimal.class
			static class VeryDeepWaterAnimal {
				
			}
		}
		
	}
}

// Can't use static class here
/*! static class Elephant {
	static class AsianElephant {
		static class IndianElephant {
						
		}
	}
} */

public class Ex23 {
	public static void main(String[] args) {
		Animal a = new Animal();
	}
}