public class StaticAlbum {
	private String mTitle;
	private static String mArtist; // WARNING: STATIC!!!
	private int mReleaseYear;
	private int mSales;
	
	public enum RiaaCertifications {
		NONE,
		GOLD,
		PLATINUM,
		MULTI_PLATINUM,
		DIAMOND
	}
	
	/**
	 * Constructs an Album with the given title, artist, release year, and sales.
	 */
	public StaticAlbum(String title, String artist, int releaseYear, int sales) {
		mTitle = title;
		mArtist = artist;
		mReleaseYear = releaseYear;
		mSales = sales;
	}
	
	
	// A class can have any number of constructors with different parameter lists.
	/**
	 * Constructs an Album with the given title, artist, and release year, and 0 sales.
	 */
	public StaticAlbum(String title, String artist, int releaseYear) {
		this(title, artist, releaseYear, 0);
	}
	
	// Accessors (getters).
	/**
	 * Gets the album's title.
	 */
	public String getTitle() {
		return mTitle;
	}
	
	/**
	 * Gets the album's artist.
	 */
	public String getArtist() {
		return mArtist;
	}
	
	/**
	 * Gets the album's release year.
	 */
	public int getReleaseYear() {
		return mReleaseYear;
	}
	
	/**
	 * Gets the album's total sales.
	 */
	public int getSales() {
		return mSales;
	}
	
	/**
	 * Sets the album's sales to the given value.
	 * @param sales a non-negative integer.
	 */
	public void setSales(int sales) {
		if (sales < 0) {
			throw new IllegalArgumentException("sales cannot be negative");
		}
		
		mSales = sales;
	}
	
	public void setArtist(String artist) {
		mArtist = artist;
	}
	
	/**
	 * Gets the RIAA certification for this album based on its sales.
	 * @return NONE if the record did not reach at least GOLD sales.
	 */
	public RiaaCertifications getCertification() {
		return getCertification(mSales);
	}
	
	/**
	 * Gets the RIAA certification for an album with the given number of sales.
	 * @param sales the number of sales of a hypothetical album.
	 * @return NONE if the record did not reach at least GOLD sales.
	 */
	public static RiaaCertifications getCertification(int sales) {
		if (sales >= 10_000_000) {
			return RiaaCertifications.DIAMOND;
		}
		else if (sales >= 2_000_000) {
			return RiaaCertifications.MULTI_PLATINUM;
		}
		else if (sales >= 1_000_000) {
			return RiaaCertifications.PLATINUM;
		}
		else if (sales >= 500_000) {
			return RiaaCertifications.GOLD;
		}
		return RiaaCertifications.NONE;
	}
	
	/**
	 * Gets a string representation of an Album, including its certification (if any).
	 */
	public String toString() {
		RiaaCertifications cert = getCertification();
		String certString;
		if (cert == RiaaCertifications.DIAMOND) {
			certString = "Diamond";
		}
		else if (cert == RiaaCertifications.MULTI_PLATINUM) {
			certString = "Multi-Platinum";
		}
		else if (cert == RiaaCertifications.PLATINUM) {
			certString = "Platinum";
		}
		else if (cert == RiaaCertifications.GOLD) {
			certString = "Gold";
		}
		else {
			certString = "";
		}
		return mArtist + " - " + mTitle + " (" + mReleaseYear + "): "
		 + mSales + " sales"
		 + (cert != RiaaCertifications.NONE ? " [CERTIFIED " + certString + "]" : "");
	}
}
