package myapp.model;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;



@Entity
//@Table(name = "ALBUM")
public class Album {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long aId;
//	@Column(name = "aId")
	// wrong !!! strategy=GenerationType.IDENTITY
	
    @ManyToOne
    private AllResource allResource;
	
    private String aName;
    private String aGenre;
    private int tNumber;
    private String aritist;
    private String aCover;//address of images
    private String tracksAddress;//jsp address for tracks
    private String review;
    
    @OneToMany
    @JoinColumn()
    @Basic(fetch = FetchType.EAGER)
    private List<Track> tracks = new LinkedList<Track>();
    
    public Album() {
		
	}
    
    public Long getaID() {
    	return aId;
    }
    public void setaID(Long aId) {
    	this.aId = aId;
    }
	/**
	 * @return the aName
	 */
	public String getaName() {
		return aName;
	}
	/**
	 * @param aName the aName to set
	 */
	public void setaName(String aName) {
		this.aName = aName;
	}
	/**
	 * @return the aGenre
	 */
	public String getaGenre() {
		return aGenre;
	}
	/**
	 * @param aGenre the aGenre to set
	 */
	public void setaGenre(String aGenre) {
		this.aGenre = aGenre;
	}
	/**
	 * @return the tNumber
	 */
	public int gettNumber() {
		if (tracks != null) {
			tNumber = tracks.size();
		}		
		return tNumber;
	}
	/**
	 * @param tNumber the tNumber to set
	 */
	public void settNumber(int tNumber) {
		this.tNumber = tNumber;
	}
	/**
	 * @return the aritist
	 */
	public String getAritist() {
		return aritist;
	}
	/**
	 * @param aritist the aritist to set
	 */
	public void setAritist(String aritist) {
		this.aritist = aritist;
	}
	/**
	 * @return the aCover
	 */
	public String getaCover() {
		return aCover;
	}
	/**
	 * @param aCover the aCover to set
	 */
	public void setaCover(String aCover) {
		this.aCover = aCover;
	}
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	/**
	 * @return the tracksAddress
	 */
	public String getTracksAddress() {
		return tracksAddress;
	}

	/**
	 * @param tracksAddress the tracksAddress to set
	 */
	public void setTracksAddress(String tracksAddress) {
		this.tracksAddress = tracksAddress;
	}

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}
	
	public AllResource getAllResource() {
		return allResource;
	}
	
	public void setAllResource(AllResource allResource) {
		this.allResource = allResource;
	}

}
