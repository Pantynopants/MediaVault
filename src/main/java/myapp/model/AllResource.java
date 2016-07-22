package myapp.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
//@Table(name = "ALBUM")
public class AllResource {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@OneToMany
    @JoinColumn()
    @Basic(fetch = FetchType.EAGER)
	private List<Album> album = new LinkedList<Album>();
	
	@OneToMany
    @JoinColumn()
    @Basic(fetch = FetchType.EAGER)
    private List<TVshow> tvshow = new LinkedList<TVshow>();
	
	public AllResource() {
		// TODO Auto-generated constructor stub
	}
	public List<Album> getAlbum() {
		return album;
	}
	public List<TVshow> getTVshow() {
		return tvshow;
	}
}
