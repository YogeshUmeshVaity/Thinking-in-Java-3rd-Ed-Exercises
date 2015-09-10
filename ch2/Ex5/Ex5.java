class StorageTest{
	int storage(String s){
		return s.length() * 2;
	}
}

public class Ex5{
	public static void main(String[] args){
	StorageTest st = new StorageTest();
	System.out.println(st.storage("Yogesh"));
	}
}