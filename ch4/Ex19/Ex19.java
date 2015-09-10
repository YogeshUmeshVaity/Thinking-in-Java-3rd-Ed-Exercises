class ArrayDemo {
	double[][] arrayTwoD;
	void create2DArray(int size1, int size2, int beginning, int end) {
		arrayTwoD = new double[size1][size2];
		for(int i = 0; i < arrayTwoD.length; i++ ) {
			for (int j = 0; j < arrayTwoD[i].length && beginning <= end; j++)
			arrayTwoD[i][j] = (double)beginning++;
		}
	}
	void print2DArray() {
		for(int i = 0; i < arrayTwoD.length; i++)
			for(int j = 0; j < arrayTwoD[i].length; j++)
				System.out.println(arrayTwoD[i][j]);
	}
}

public class Ex19 {
	public static void main(String[] args) {
		ArrayDemo ad = new ArrayDemo();
		ad.create2DArray(5, 7, 65, 150);
		ad.print2DArray();
	}
}