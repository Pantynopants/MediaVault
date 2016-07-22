package myapp.modelDAO;

import javax.persistence.EntityManager;

import myapp.model.*;
import myapp.util.*;

public class TVDAO {
	public void saveOrUpdateTVshow(TVshow tvshow) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.persist(tvshow);
	}
	
	public TVshow getTV(long tvID) {
		EntityManager manager = JPAUtil.getEntityManager();
		TVshow album = (TVshow) manager.find(TVshow.class, tvID);
		return album;
	}
	
	/**
	 * add a tvshow 
	 * @name void addTV(TVshow newtvshow) 
	 * 
	 * @param TVshow
	 * 
	 * @return void
	 * 
	 * @author leo
	 * 
	 * it can not with no cover 
	 */
	public void addTV(TVshow newtvshow) {
		if (newtvshow.gettCover() == null) {
			System.out.println("add tv unsuccessful");
			return;
		}
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		TVshow tvshow = newtvshow;
		AllResource allResource = manager.find(AllResource.class, new Long(1));
		
		allResource.getTVshow().add(tvshow);
		tvshow.setAllResource(allResource);
		
		manager.persist(tvshow);
		manager.persist(allResource);//update allResource
		
		manager.getTransaction().commit();
		System.out.println("add tv successful");
//		allResource = manager.find(AllResource.class, new Long(1));
//		System.out.println(allResource.getAlbum().size());
	}
	
	public boolean deleteTV(TVshow tvshow) {
		try {
			EntityManager manager = JPAUtil.getEntityManager();
			tvshow = manager.getReference(TVshow.class, tvshow.gettvID());
			manager.remove(tvshow);
		} catch (Exception e) {
			
			System.err.println(e);
			return false;
		}		
		return true;
	}


}
