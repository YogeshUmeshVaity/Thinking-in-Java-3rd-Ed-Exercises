package Ex12.thirdpackage;
import Ex12.classpackage.*;
import Ex12.interfacepackage.*;

public class InheritClass extends ClassB {
	InterfaceA InnerObject() {
		// InheritClass can access the protected members of ClassB
		// but cannot access protected members of protected class insede B.
		// so the constructor in class B needs to be public.
		// because the constructor is protected by default.
		return new InnerC();
	}
	public static void main(String[] args) {
		InheritClass ic = new InheritClass();
		InterfaceA ia = ic.InnerObject();
	}
}