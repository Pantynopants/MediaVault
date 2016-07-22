package myapp.modelDAO;

import java.util.List;

import javax.persistence.EntityManager;

import myapp.model.*;

import myapp.util.*;

public class TrackDAO {
	public void saveOrUpdateTrack(Track track) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.persist(track);
	}
	
	public Track getTrack(long eID) {
		EntityManager manager = JPAUtil.getEntityManager();
		Track track = (Track) manager.find(Track.class, eID);
		return track;
	}
	
	/**
	 * get tracks as a list
	 * @name getTracskInAlbum
	 * 
	 * @param accountId :aID
	 *            identifier of the account to be retrieved
	 * @return tracks in this album
	 * 
	 */
	public List<Track> getTracskInAlbum(long tvID) {
		EntityManager manager = JPAUtil.getEntityManager();
		Album album = (Album) manager.find(Album.class, tvID);
//		Track track = (Track) manager.find(Track.class, tId);
		return album.getTracks();
	}
	/**
	 * add a track 
	 * 
	 * @param String albumIDstr ,Track newtrack
	 * 
	 * @return void
	 * 
	 * @author leo
	 * 
	 * it can not create without a Address
	 */
	public void addTrack(String albumIDstr, Track newtrack) {
		if (newtrack.gettAddress() == null) {
			System.out.println("add track unsuccessful");
			return;
		}
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Track track = newtrack;
		
		Album album = manager.find(Album.class, Long.valueOf(albumIDstr));
		
		album.getTracks().add(track);
		track.setAlbum(album);
		
		manager.persist(track);
		manager.persist(album);//update album
		
		manager.getTransaction().commit();
		System.out.println("add successful");
	}
	
	public boolean deleteTrack(Track track) {
		try {
			EntityManager manager = JPAUtil.getEntityManager();
			track = manager.getReference(Track.class, track.gettID());
			manager.remove(track);
		} catch (Exception e) {
			
			System.err.println(e);
			return false;
		}		
		return true;
	}
}
