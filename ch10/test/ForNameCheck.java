public class ForNameCheck {
	public static void main(String[] args) throws ClassNotFoundException {
		ForNameCheck fnc = new ForNameCheck();
		// It returns a Class reference (Means it returns object of type Class)
		System.out.println(Class.forName("ForNameCheck"));
		// Produces the reference to the Class object(Means it represents the object of type Class) 
		System.out.println(ForNameCheck.class);
		// This method returns the object of type Class that
		// represents the runtime class of the object.(Same as above 2)
		System.out.println(fnc.getClass());
	}
}