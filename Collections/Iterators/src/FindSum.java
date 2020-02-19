import java.util.ArrayList;

public class FindSum {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(8);
		list.add(6);
		list.add(7);
		list.add(5);
		list.add(3);
		list.add(0);
		list.add(9);
		
		int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			int val = list.get(i);
			if (val > max)
				max = val;
		}
		
		// But how would we do this with a TreeSet? Trees don't have indicies, and sets don't have a .get() method...
	}
}
