package myapp.model;
import javax.persistence.*;

@Entity
public class Track {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "tId")
    private long tId;
	
	private String trackName;
	private String tAddress;//address of one music
	private int number;
	private String tDuration;
	
	@ManyToOne
	private Album album;
	
    public Long gettID() {
    	return tId;
    }

    public void settID(Long tId) {
    	this.tId = tId;
    }

	/**
	 * @return the trackName
	 */
	public String getTrackName() {
		return trackName;
	}

	/**
	 * @param trackName the trackName to set
	 */
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	/**
	 * @return the tAddress
	 */
	public String gettAddress() {
		return tAddress;
	}

	/**
	 * @param tAddress the tAddress to set
	 */
	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the tDuration
	 */
	public String gettDuration() {
		return tDuration;
	}

	/**
	 * @param tDuration the tDuration to set
	 */
	public void settDuration(String tDuration) {
		this.tDuration = tDuration;
	}
	/**
	 * @return the Album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param Album the Album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

}
