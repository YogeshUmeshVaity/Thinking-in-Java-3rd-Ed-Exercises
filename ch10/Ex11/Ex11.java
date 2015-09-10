class Instrument {
	void play() {}
	// This is confusing because it implies that Percussion and
	// Electronic also have spit valves
	//! void clearSpitValve() {}
}

// When you don't have control over base class(Instrument here) 
// which maybe handled by someone else or you might discover that
// your base class(Instrument) doesn't include the method you need
// which is clearSpitValve()
// So the solution is RTTI : You inherit a new type(Wind) and 
// add you extra method in it.
// Elsewhere in the code you can detect your particular type
// and call that special method.
class Wind extends Instrument {
	// It's appropriate here.
	// You can access this method with the help of RTTI
	// So you can access this method by upcasting the Trumpet
	// or Saxophone to Wind
	// that is, using the Wind reference(base class to Trumpet) to 
	// access this method. and the appropriate method for that
	// specific instrument, will be called.
	void clearSpitValve() {
		System.out.println("Spit valve of Wind has been cleared");
	} 
}

class Percussion extends Instrument {}

class Electronic extends Instrument {}

class Trumpet extends Wind {
	@Override
	void clearSpitValve() {
		System.out.println("Spit valve of Trumpet has been cleared");
	} 
}

class Saxophone extends Wind {
	@Override
	void clearSpitValve() {
		System.out.println("Spit valve of Saxophone has been cleared");
	} 
}

public class Ex11 {
	public static void main(String[] args) {
		// Create Object array of the above classes
		Object[] obj = {
			new Wind(),
			new Percussion(),
			new Electronic(),
			new Trumpet(),
			new Saxophone()
		};
		// Clear the spit valves of the instruments in the array
		// use RTTI to identify the Wind objects and
		// clear spit valves only for Wind objects
		for(int i = 0; i < obj.length; i++) {
			// check if it is instanceof Wind using RTTI
			if(obj[i] instanceof Wind) {
				// Downcast it to Wind reference to use the desired method
				// Polymorphism takes over at this point and calls the appropriate
				// methods for Wind, Trumpet and Saxophone
				((Wind)obj[i]).clearSpitValve();
			}
		}
	}
}

// The intent of Java is that you use polymorphic method calls
// throughout your code, and you use RTTI only when you must.
// So a more appropriate solution is to put a
// prepareInstrument() method in the base class
// but you might not see this when you’re first solving
// the problem and could mistakenly assume that you must use RTTI.