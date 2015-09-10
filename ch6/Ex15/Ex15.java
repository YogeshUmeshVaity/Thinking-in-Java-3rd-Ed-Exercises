import classpackage.*;
class AccessClass extends PackageClass {
		void accessProtectedMethod() {
			protectedMethod();
		}
}

public class Ex15 {
	public static void main(String[] args) {
		AccessClass ac = new AccessClass();
		ac.accessProtectedMethod();
	}
}

// protected member of the class from another package cannot be accessed outside of the package(without inheritance.)
// The compiler will give error that protectedMethod() has protected accessed
// in PackageClass.
// Protected members are available only in the same package or
// with inheritance outside the package.