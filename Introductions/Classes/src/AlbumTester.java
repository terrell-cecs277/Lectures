public class AlbumTester {
	public static void main(String[] args) {
		Album theBoss = new Album("Born to Run", "Bruce Springsteen", 1975, 6_000_000);
		System.out.println(theBoss);
		
		mutateAlbum(theBoss);
		System.out.println(theBoss);

		/*
		The following line will not change the Sales of the album.
		*/
		theBoss.setSales(-1);
		System.out.println(theBoss);
	}
	
	public static void mutateAlbum(Album a) {
		a.setSales(10000000);
	}
}
