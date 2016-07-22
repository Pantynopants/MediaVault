package myapp.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
public class TVshow {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tvId;
//	@Column(name = "aId")
	
	// below is wrong !!! 
	//strategy=GenerationType.AUTO
	
	@ManyToOne
    private AllResource allResource;
	
    private String tName;
    private String tGenre;
    private String studio;//produces the show
    private String tCover;// cover pic of TV show
    private int eNumber;
    private String typicalLength;//length of an episode

    @OneToMany
    @JoinColumn()
    @Basic(fetch = FetchType.EAGER)
    private List<Episode> episode = new LinkedList<Episode>();
    
    public Long gettvID() {
    	return tvId;
    }
    public void settvID(Long tvId) {
    	this.tvId = tvId;
    }
	/**
	 * @return the tName
	 */
	public String gettName() {
		return tName;
	}
	/**
	 * @param tName the tName to set
	 */
	public void settName(String tName) {
		this.tName = tName;
	}
	/**
	 * @return the tGenre
	 */
	public String gettGenre() {
		return tGenre;
	}
	/**
	 * @param tGenre the tGenre to set
	 */
	public void settGenre(String tGenre) {
		this.tGenre = tGenre;
	}
	/**
	 * @return the studio
	 */
	public String getStudio() {
		return studio;
	}
	/**
	 * @param studio the studio to set
	 */
	public void setStudio(String studio) {
		this.studio = studio;
	}
	/**
	 * @return the tCover
	 */
	public String gettCover() {
		return tCover;
	}
	/**
	 * @param tCover the tCover to set
	 */
	public void settCover(String tCover) {
		this.tCover = tCover;
	}
	/**
	 * @return the eNumber
	 */
	public int geteNumber() {
		if (episode != null) {
			eNumber = episode.size();
		}else {
			eNumber = 0;
		}
		return eNumber;
	}
	/**
	 * @param eNumber the eNumber to set
	 */
	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}
	/**
	 * @return the typicalLength
	 */
	public String getTypicalLength() {
		return typicalLength;
	}
	/**
	 * @param typicalLength the typicalLength to set
	 */
	public void setTypicalLength(String typicalLength) {
		this.typicalLength = typicalLength;
	}
	
    public List<Episode> getEpisode() {
		return this.episode;
	}
    public void setEpisode(List<Episode> episode) {
		this.episode = episode;
	}
    
    public AllResource getAllResource() {
		return allResource;
	}
	
	public void setAllResource(AllResource allResource) {
		this.allResource = allResource;
	}
	
}
