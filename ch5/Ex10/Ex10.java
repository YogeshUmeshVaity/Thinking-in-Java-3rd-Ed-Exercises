//Ex10 = ConnectionManager
public class Ex10 {
	public static void main(String[] args) {
		Connection [] arr = new Connection[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Connection.getConnection();
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}
}

class Connection {
	private Connection() {
		
	}
	static int maxObjects = 6;
	public static Connection getConnection() {
		if(maxObjects == 0)
			return null;
		else {
			maxObjects--;
			return new Connection();
			
		}
			
	}
}