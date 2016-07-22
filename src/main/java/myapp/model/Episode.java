package myapp.model;
import javax.persistence.*;

@Entity
public class Episode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "tId")
    private long eId;
	
	private String eName;
	private String seanson;
	private String length;
	private String thumbnailAddress;//address of thumnail
	private String eAddress;//address of episode

	
	@ManyToOne
	private TVshow tvshow;

	public long geteID() {
		return eId;
	}
	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}


	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}


	/**
	 * @return the seanson
	 */
	public String getSeanson() {
		return seanson;
	}


	/**
	 * @param seanson the seanson to set
	 */
	public void setSeanson(String seanson) {
		this.seanson = seanson;
	}


	/**
	 * @return the length
	 */
	public String getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}


	/**
	 * @return the thumbnailAddress
	 */
	public String getThumbnailAddress() {
		return thumbnailAddress;
	}


	/**
	 * @param thumbnailAddress the thumbnailAddress to set
	 */
	public void setThumbnailAddress(String thumbnailAddress) {
		this.thumbnailAddress = thumbnailAddress;
	}


	/**
	 * @return the eAddress
	 */
	public String geteAddress() {
		return eAddress;
	}


	/**
	 * @param eAddress the eAddress to set
	 */
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	
	public void setTVshow(TVshow tvshow) {
		this.tvshow = tvshow;
	}
	public TVshow getTVshow() {
		return this.tvshow;
	}
}
