package myapp.modelDAO;

import java.util.List;

import javax.persistence.EntityManager;

import myapp.model.*;

import myapp.util.*;

public class EpisodeDAO {
	
	public void saveOrUpdateEpisode(String TVIDstr, Long eID, Episode episode) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		TVshow tvshow = manager.find(TVshow.class, Long.valueOf(TVIDstr));
				
		Episode newEpisode = manager.find(Episode.class, eID);
		newEpisode.seteAddress(episode.geteAddress());
		newEpisode.seteName(episode.geteName());
		newEpisode.setLength(episode.getLength());
		newEpisode.setSeanson(episode.getSeanson());
		newEpisode.setThumbnailAddress(episode.getThumbnailAddress());
		
		tvshow.getEpisode().add(newEpisode);
		newEpisode.setTVshow(tvshow);
		
		manager.persist(newEpisode);
		manager.persist(tvshow);//update tvshow
		manager.getTransaction().commit();
	}
	
	public Episode getEpisode(long eID) {
		EntityManager manager = JPAUtil.getEntityManager();
		Episode episode = (Episode) manager.find(Episode.class, eID);
		return episode;
	}
	
	/**
	 * Retrieve an account from the data store
	 * @name getTracskInAlbum
	 * 
	 * @param accountId :aID
	 *            identifier of the account to be retrieved
	 * @return tracks in this album
	 * 
	 */
	public List<Episode> getEpisodeInTV(long tvID) {
		EntityManager manager = JPAUtil.getEntityManager();
		TVshow tv = (TVshow) manager.find(TVshow.class, tvID);
//		Track track = (Track) manager.find(Track.class, tId);
		return tv.getEpisode();
	}
	
	public boolean deleteEpisode(Episode episode) {
		try {
			EntityManager manager = JPAUtil.getEntityManager();
			episode = manager.getReference(Episode.class, episode.geteID());
			manager.remove(episode);
		} catch (Exception e) {
			
			System.err.println(e);
			return false;
		}		
		return true;
	}

	public void addEpisode(String TVIDstr, Episode newEpisode) {
		if (newEpisode.geteAddress() == null) {
			System.err.println("add Episode unsuccessful");
			return;
		}
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Episode episode = newEpisode;
		
		TVshow tvshow = manager.find(TVshow.class, Long.valueOf(TVIDstr));
		
		tvshow.getEpisode().add(episode);
		episode.setTVshow(tvshow);
		
		manager.persist(episode);
		manager.persist(tvshow);//update tvshow
		
		manager.getTransaction().commit();
		System.out.println("add successful");
		
	}
}
