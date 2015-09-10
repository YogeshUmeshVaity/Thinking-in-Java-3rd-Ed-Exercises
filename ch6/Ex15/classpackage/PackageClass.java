package classpackage;
public class PackageClass {
	protected void protectedMethod() {
		System.out.println("protectedMethod accessible.");
	}
}

// If protected member of the class from another package cannot be accessed.
// The compiler will give error that protectedMethod() has protected accesse
// in PackageClass.
// Protected members are available only in the same package or
// with inheritance outside the package.