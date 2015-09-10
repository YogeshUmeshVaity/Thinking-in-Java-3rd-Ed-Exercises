public class intList {
	private int capacity = 30;
	private int[] ints = new int[capacity];
	private int index = 0; 
	public boolean add(int addMe) {
		if(index < ints.length) {
			ints[index] = addMe;
			index++;
			return true;
		}
		// otherwise increase capacity of ints and then add
		int[] tempInts = new int[ints.length + 1];
		for(int i : ints) {
			tempInts[i] = i;
		}
		ints = new int[tempInts.length];
		for(int i : tempInts) {
			ints[i] = i;
		}
		ints[index] = addMe;
		index++;
		return true;
	}
	
	@Override public String toString() {
		StringBuilder s = new StringBuilder("[");
		for(int i : ints) {
				s.append(i + ", ");
		}
		s.append("]");
		return s.toString();
	}
	public static void main(String[] args) {
		intList list = new intList();
		list.add(3);
		list.add(6);
		list.add(9);
		for(int i = 0; i < 99; i++) {
			list.add(i);
		}
		System.out.println(list);
	}
}