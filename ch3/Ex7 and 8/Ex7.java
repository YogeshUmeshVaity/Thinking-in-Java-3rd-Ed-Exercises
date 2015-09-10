import java.util.Random;
public class Ex7	{
	public static void main(String[] args)	{
		Random randomGenerator = new Random();
		while(true)
		{
			int n1 = randomGenerator.nextInt(25);
			int n2 = randomGenerator.nextInt(25);
			if(n1 > n2)
				System.out.println("n1 " + n1 + " is greater than n2 " + n2);
			else if(n1 < n2)
				System.out.println("n1 " + n1 + " is less than n2 " + n2);
			else if(n1 == n2)
				System.out.println("Both are equal.");
		}
	}
}