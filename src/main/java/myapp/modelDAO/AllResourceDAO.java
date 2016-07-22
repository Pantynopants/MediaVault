package myapp.modelDAO;

import java.util.List;

import javax.persistence.EntityManager;

import myapp.model.Album;
import myapp.model.AllResource;
import myapp.model.TVshow;
import myapp.model.Track;
import myapp.util.JPAUtil;

public class AllResourceDAO {
	public void saveOrUpdateResource(AllResource allResource) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.persist(allResource);
	}
	/**
	 * Retrieve an account from the data store
	 * @name getAlbums
	 * 
	 * @param AllResourceID :ID
	 *       
	 * @return all albums
	 * 
	 */
	public List<Album> getAlbums(long ID) {
		EntityManager manager = JPAUtil.getEntityManager();
		AllResource src = (AllResource) manager.find(AllResource.class, ID);
//		Track track = (Track) manager.find(Track.class, tId);
		return src.getAlbum();
	}
	
	public List<TVshow> getTVshow(long ID) {
		EntityManager manager = JPAUtil.getEntityManager();
		AllResource src = (AllResource) manager.find(AllResource.class, ID);
//		Track track = (Track) manager.find(Track.class, tId);
		return src.getTVshow();
	}
}
