package myapp.test;

import static org.junit.Assert.assertTrue;

import java.sql.*;
import java.sql.SQLNonTransientConnectionException;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myapp.model.*;
import myapp.util.*;
import myapp.service.*;

public class TestAlbumTrack {

	    private static final Logger LOGGER = LogManager.getLogger(TestAlbumTrack.class);
	    private static EntityManagerFactory emFactory;
	    private static EntityManager em;

//	    @BeforeClass
//	    public static void setUp() throws Exception {
//	        LOGGER.info("Starting memory database for unit tests.");
//	        try {
//	            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//	            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;create=true").close();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            LOGGER.error("Exception during database startup");
//	        }
//
//	        LOGGER.info("Building EntityManager for unit tests");
////	        try {
//	            emFactory = Persistence.createEntityManagerFactory("test-jpa");
//	            em = emFactory.createEntityManager();
////	        } catch (Exception e) {
////	            LOGGER.error("Exception during JPA EntityManager instanciation.");
////	        }
//	    }

	    @Before
	    public void setUp() throws Exception {
//	    	emFactory = Persistence.createEntityManagerFactory("test-jpa");
//	        em = emFactory.createEntityManager();
	    	em = JPAUtil.getEntityManager();
	    }
	    
	    @After
	    public void tearDown() throws Exception {
	        em.close();
//	        emFactory.close();
	    }
//	    @AfterClass
//	    public static void tearDown() throws Exception {
//	        LOGGER.info("Shutting Hibernate JPA layer.");
//	        if (em != null)
//	            em.close();
//	        if (emFactory != null)
//	            emFactory.close();
//
//	        LOGGER.error("Stopping memory database.");
//
//	        try {
//	            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;shutdown=true").close();
//	        } catch (SQLNonTransientConnectionException e) {
//	            if (e.getErrorCode() != 45000)
//	                throw e;
//	        }
//	    }

	    @Test
	    public void testPersistence()  {
//	        try {
	            em.getTransaction().begin();
	            InitResource initResource = new InitResource();
	            initResource.createResources(em);
//	            Album p1 = new Album();
//	            p1.setaName("album1");
//	            Album p2 = new Album();
//	            p2.setaName("album2");
//	            
//	   
//	            Track c1 = new Track();
//	            c1.setTrackName("c1");
//	            Track c2 = new Track();
//	            c2.setTrackName("c2");
//	            Track c3 = new Track();
//	            c3.setTrackName("c3");
//	             
//	            c1.setAlbum(p2);                      
//	            p2.getTracks().add(c1);
//	            
//	            c2.setAlbum(p2);
//	            p2.getTracks().add(c2);
//	            
//	            c3.setAlbum(p2);
//	            p2.getTracks().add(c3);
//	            
//	            em.persist(c1);
//	            em.persist(c2);
//	            em.persist(c3);
//	            em.persist(p1);
//	            em.persist(p2);
//	            
//	            assertTrue(em.contains(p1));
//	            assertTrue(em.contains(p2));
//	            System.out.println(p1.getaID());
//	            System.out.println(c1.gettID());
//	            System.out.println(c2.gettID());
	            
	            em.getTransaction().commit();
//	            System.out.println(p1.getId());
	            listInsertedData();
//	        } catch (Exception e) {
//	            em.getTransaction().rollback();
//	            e.printStackTrace();
//	            LOGGER.error("Exception during testPersistence");
//	        }
	    }
	    
	    private void listInsertedData() {
//	    	em = JPAUtil.getEntityManager();
	        em.getTransaction().begin();
	        //Only ONE allresource here!!!
	        AllResource allResource = em.find(AllResource.class, new Long(1));
	        
//	        Track cTemp = em.find(Track.class, new Long(2));
//	        System.out.println(cTemp.getAlbum().getaName());
//	        System.out.println(cTemp.getTrackName());
	        
	        Album pFinded ;
//	        System.out.println(pFinded.getaName());
	        
	        for (long i = 1; i <= allResource.getAlbum().size(); i++) {
	        	pFinded = em.find(Album.class, new Long(i));
	        	if (pFinded != null) {
	        		System.out.println("Id: " + i + ", name: " + pFinded.getaName());
				}else{
					System.out.println("null album");
				}
	            
	            
	            if (pFinded != null && pFinded.getTracks() != null){
	            	for (int j = 0; j < pFinded.gettNumber(); j++) {
	            		Track temp = pFinded.getTracks().get(j);
	                	System.out.println("in " + pFinded.getaName() + " : " + "id " + temp.gettID() + " " + temp.getTrackName());
	    			}
	            }
	            
	        }
	        
	        TVshow tvshow = new TVshow();
	        
	        for (long i = 1; i <= allResource.getTVshow().size(); i++) {
	        	tvshow = em.find(TVshow.class, new Long(i));
	        	if (tvshow != null) {
	        		System.out.println("Id: " + i + ", name: " + tvshow.gettName());
				}else{
					System.out.println("null TVshow");
				}
	            
	            
	            if (tvshow != null && tvshow.getEpisode() != null){
	            	for (int j = 0; j < tvshow.geteNumber(); j++) {
	            		Episode temp = tvshow.getEpisode().get(j);
	                	System.out.println("in " + tvshow.gettName() + " : " + "id " + temp.geteID() + " " + temp.geteName());
	    			}
	            }
	            
	        }
	        
	        em.getTransaction().commit();
	    }

	

}
