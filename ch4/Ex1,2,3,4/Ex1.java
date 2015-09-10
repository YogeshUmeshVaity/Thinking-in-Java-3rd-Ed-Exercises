import java.util.*;
class DefaultConstructor	{
	DefaultConstructor()	{
		System.out.println("This message is displayed from default constructor.");
	}
	DefaultConstructor(String overloadedMsg)	{
		System.out.println("Message displayed from overloaded constructor : " + overloadedMsg);
	}
}

public class Ex1	{
	public static void main(String[] args)	{
		//DefaultConstructor dc = new DefaultConstructor("Good programer"); 
		DefaultConstructor[] dca = new DefaultConstructor[3];
		for(int i = 0; i < dca.length; i++)
			dca[i] = new DefaultConstructor(Integer.toString(i));
	}
	
}