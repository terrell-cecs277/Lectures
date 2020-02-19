import java.util.*;

public class Iterators {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(8);
		list.add(6);
		list.add(7);
		list.add(5);
		list.add(3);
		list.add(0);
		list.add(9);
		
		// Using an iterator directly.
		Iterator<Integer> itr = list.iterator();
		int sum = 0;
		while (itr.hasNext()) {
			int val = itr.next();
			sum += val;
		}
		
		// Or the EQUIVALENT "enhanced for loop":
		sum = 0;
		for (int val : list) {
			sum += val;
		}
	}
}
