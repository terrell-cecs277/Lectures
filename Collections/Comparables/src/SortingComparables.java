import java.util.Arrays;
import java.util.Comparator;

public class SortingComparables {
	
	// Demonstrating how to use the Comparable interface to sort arbitrary arrays.
	public static void sort(Comparable[] a) {
		// Sort a[] into increasing order.
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
				// Swap a[j] and a[j-1]
				Comparable temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// Declare and sort an array of Strings; the String class implements Comparable.
		String[] names = {"Terrell", "Gold", "Nachawati", "Trajkovic", "Hernandez", "Murgolo"};
		System.out.println("Before sorting: " + Arrays.toString(names));
		sort(names);
		System.out.println("After sorting: " + Arrays.toString(names));
	}
}
