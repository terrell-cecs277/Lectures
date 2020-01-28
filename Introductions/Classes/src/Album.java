/**
 * Represents an album recorded and released by a musical artist.
 */
public class Album {
	private String mTitle;
	private String mArtist;
	private int mReleaseYear;
	private int mSales;
	
	// An "enum" stands for "enumeration": a type where the only valid values of the type
	// are explicitly listed and named.
	public enum RiaaCertifications {
		NONE,
		GOLD,
		PLATINUM,
		MULTI_PLATINUM,
		DIAMOND
	}
	// In Java, the enum "cases" are written in ALL_CAPS.
	
	
	/**
	 * Constructs an Album with the given title, artist, release year, and sales.
	 */
	public Album(String title, String artist, int releaseYear, int sales) {
		mTitle = title;
		mArtist = artist;
		mReleaseYear = releaseYear;
		mSales = sales;
	}

	
	// A class can have any number of constructors with different parameter lists.
	/**
	 * Constructs an Album with the given title, artist, and release year, and 0 sales.
	 */
	public Album(String title, String artist, int releaseYear) {
		// Here, "this" allows us to call the other constructor. It must be the first statement in
		// this constructor.
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
		/*
		Setting sales to be negative would be an invalid state for this type. We can't trust the person using
		this class to follow the rules; we have to be DEFENSIVE and guard our code against bad values.
		*/
		if (sales >= 0) {
			mSales = sales;			
		}
	}
	
	/**
	 * Gets the RIAA certification for this album based on its sales.
	 * @return NONE if the record did not reach at least GOLD sales.
	 */
	public RiaaCertifications getCertification() {
		if (mSales >= 10_000_000) {
			return RiaaCertifications.DIAMOND;
		}
		else if (mSales >= 2_000_000) {
			return RiaaCertifications.MULTI_PLATINUM;
		}
		else if (mSales >= 1_000_000) {
			return RiaaCertifications.PLATINUM;
		}
		else if (mSales >= 500_000) {
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
