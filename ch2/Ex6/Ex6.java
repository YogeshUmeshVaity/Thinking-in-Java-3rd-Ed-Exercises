class StaticFun	{
	static int i = 6;
	static void incr(){
		i++;
	}
}

public class Ex6	{
	public static void main(String[] args){
		System.out.println("Value of i before method call is " + StaticFun.i);
		StaticFun.incr();
		System.out.println("Value of i after method call is " + StaticFun.i);
		StaticFun sf = new StaticFun();
		System.out.println("Value of i before method call is " + sf.i);
		sf.incr();
		System.out.println("Value of i after method call is " + sf.i);
		System.out.println("Value of i before method call is " + StaticFun.i);
		StaticFun.incr();
		System.out.println("Value of i after method call is " + StaticFun.i);
	}
}