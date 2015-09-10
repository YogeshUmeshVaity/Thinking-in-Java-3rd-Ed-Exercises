class ArrayDemo {
	double[][][] arrayThreeD;
	void create3DArray(int size1, int size2, int size3, int beginning, int end) {
		arrayThreeD = new double[size1][size2][size3];
		for(int i = 0; i < arrayThreeD.length; i++ )
			for(int j = 0; j < arrayThreeD[i].length; j++) {	
				for (int k = 0; k < arrayThreeD[i][j].length && beginning <= end; k++)
				arrayThreeD[i][j][k] = (double)beginning++;
			}
	}
	void print3DArray() {
		for(int i = 0; i < arrayThreeD.length; i++)
			for(int j = 0; j < arrayThreeD[i].length; j++)
				for(int k = 0; k < arrayThreeD[i][j].length; k++)
					System.out.println(arrayThreeD[i][j][k]);
	}
}

public class Ex20 {
	public static void main(String[] args) {
		ArrayDemo ad = new ArrayDemo();
		ad.create3DArray(5, 7, 8, 65, 150);
		ad.print3DArray();
	}
}