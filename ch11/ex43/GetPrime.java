public class GetPrime {
	public int getNextPrime(int currentNumber) {
	int nextPrime = 0;
	boolean primeFound = false;
	for(int i = currentNumber; !primeFound; i++) {
		boolean isPrime = true;
		for(int j = 2; j < i; j++) {
			if(i % j == 0) {
				isPrime = false;
			}
		}
		if(isPrime == true) {
			primeFound = true;
			nextPrime = i;
		}
	}
	return nextPrime;
	}
	public static void main(String[] args) {
		GetPrime p = new GetPrime();
		System.out.println("Next Prime : " + p.getNextPrime(450));
	}
}