package myapp.modelDAO;

import javax.persistence.EntityManager;

import myapp.util.*;
import myapp.model.*;
//for the suitation when it's not suit for new a EntityManager
public class AlbumDAO {

	
	public void saveOrUpdateAlbum(Album album) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.persist(album);
	}
	
	public Album getAlbum(long aID) {
		EntityManager manager = JPAUtil.getEntityManager();
		Album album = (Album) manager.find(Album.class, aID);
		return album;
	}
	/**
	 * add a album 
	 * @name getTracskInAlbum
	 * 
	 * @param album
	 * 
	 * @return void
	 * 
	 * @author leo
	 * 
	 * it is OK with no cover 
	 */
	public void addAlbum(Album newalbum) {
//		if (newalbum.getaCover() == null) {
//			System.out.println("add album unsuccessful");
//			return;
//		}
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Album album = newalbum;
		AllResource allResource = manager.find(AllResource.class, new Long(1));
		
		allResource.getAlbum().add(album);
		album.setAllResource(allResource);
		
		manager.persist(album);
		manager.persist(allResource);//update allResource
		
		manager.getTransaction().commit();
		System.out.println("add successful");
//		allResource = manager.find(AllResource.class, new Long(1));
//		System.out.println(allResource.getAlbum().size());
	}
	
	public boolean deleteAlbum(Album album) {
		try {
			EntityManager manager = JPAUtil.getEntityManager();
			album = manager.getReference(Album.class, album.getaID());
			manager.remove(album);
		} catch (Exception e) {
			
			System.err.println(e);
			return false;
		}		
		return true;
	}
}
