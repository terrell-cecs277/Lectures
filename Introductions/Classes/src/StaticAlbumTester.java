import java.util.Arrays;

public class StaticAlbumTester {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		StaticAlbum theBoss = new StaticAlbum("Born to Run", "Bruce Springsteen", 1975, 6_000_000);
		StaticAlbum heart = new StaticAlbum("Dreamboat Annie", "Heart", 1975, 1_000_000);
		
		System.out.println(theBoss); // ????
	}
}
