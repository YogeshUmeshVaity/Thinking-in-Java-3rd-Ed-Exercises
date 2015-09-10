class DataOnly{
	int i;
	float f;
	boolean b;
}

public class Ex3{
	public static void main(String[] args){
		DataOnly d = new DataOnly();
		d.i = 3;
		d.f = 3.3f;
		d.b = true;
		System.out.println(d.i);
		System.out.println(d.f);
		System.out.println(d.b);
	}
}