package myapp.service;

import javax.persistence.EntityManager;


import myapp.model.*;
import myapp.model.AllResource;
import myapp.modelDAO.*;
import myapp.util.*;

public class InitResource {
	public static AllResource resource = new AllResource();
	public static AllResourceDAO allResourceDAO;
	public static AlbumDAO albumDAO;
	public static TrackDAO trackDAO;
	public static TVDAO tvDAO;
	public static EpisodeDAO episodeDAO;
//	private static EntityManager em = JPAUtil.getEntityManager();
	//can design a max tracks number for each album
	//it will be implement later
	
	public  Album a1;
	public  Album a2;
	public  Album a3;
	public  Album a4;
	public  Album a5;
	
	public Track t1;
	public Track t2;
	public Track t3;
	public Track t4;
	public Track t5;
	
	public TVshow tv1;
	public TVshow tv2;
	public TVshow tv3;
	public TVshow tv4;
	public TVshow tv5;
	public TVshow tv6;
	public TVshow tv7;
	public TVshow tv8;
	public TVshow tv9;
	
	public Episode e1;
	public Episode e2;
	//first call this methods
	public boolean createResources(EntityManager em) {
		System.out.println("init resource");
		createAlbums(em);
		createTracks(em);
		createTV(em);
		createEpisode(em);
		//TODO
		//em can transmit between files?
		em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);
        em.persist(a5);
        
//        em.persist(e1);
        
        em.persist(tv1);
        em.persist(tv2);
        em.persist(tv3);
        em.persist(tv4);
        em.persist(tv5);
        em.persist(tv6);
        em.persist(tv7);
        em.persist(tv8);
        em.persist(tv9);
        
		em.persist(resource);
		return false;	
	}
	
	public boolean createAlbums(EntityManager em) {
		
		a1 = new Album();
        a1.setaName("Animal");
        a1.setAritist("Maroon 5");
        a1.setaGenre("POP");
//        a1.setReview("Maroon 5 is a Grammy Award-winning American pop rock band. group comprises five members: Adam Levine (lead vocals, rhythm guitar), James Valentine (lead guitar, backing vocals), Jesse Carmichael (keyboards, rhythm guitar, backing vocals), Mickey Madden (bass guitar), and Matt Flynn (drums, percussion)");
        a1.setReview("Maroon 5 is a Grammy Award-winning American pop rock band");
        a1.setaCover("images/music12.jpg");
        a1.setTracksAddress("https://www.baidu.com");
        resource.getAlbum().add(a1);
        a1.setAllResource(resource);
        
        a2 = new Album();
        a2.setaName("Maps");
        a2.setAritist("Jacky Xue");
        a2.setaGenre("Rap");
        a2.setReview("Jacky Xue is a singer and actor from shanghai,China.His life changed after he competed in My Show.'I was very excited and regarded it as a way to take me closer to my dream,' he said.And his favourite slogan is smile on the easy life");
        a2.setaCover("images/music11.jpeg");
        a2.setTracksAddress("https://www.baidu.com");
        resource.getAlbum().add(a2);
        a2.setAllResource(resource);
        
        a3 = new Album();
        a3.setaName("Payphone");
        a3.setAritist("Sakura");
        a3.setaGenre("Blues");
        a3.setReview("He is a Japanese singer,belong to SME Records company.");
        a3.setaCover("images/music14.jpg");
        a3.setTracksAddress("https://www.baidu.com");
        resource.getAlbum().add(a3);
        a3.setAllResource(resource);
        
        a4 = new Album();
        a4.setaName("This Summer");
        a4.setAritist("Wacci");
        a4.setaGenre("Rap");
        a4.setaCover("https://www.baidu.com/img/bd_logo1.png");
        a4.setTracksAddress("https://www.baidu.com");
        resource.getAlbum().add(a4);
        a4.setAllResource(resource);
        
        a5 = new Album();
        a5.setaName("Sugar");
        a5.setAritist("Taylor Swift");
        a5.setaGenre("Blues");
        a5.setReview("Taylor Swift is one of the most popular singers in America.She is very good at singing. Her songs are always countryside music, but there are also pop music, hip-hop, and rock.");
        a5.setaCover("images/music13.jpg");
        a5.setTracksAddress("https://www.baidu.com");
        resource.getAlbum().add(a5);
        a5.setAllResource(resource);
        
        //TODO only want to create now, have not think about persist
//        em.persist(a1);
//        em.persist(a2);
//        em.persist(a3);
//        em.persist(a4);
//        em.persist(a5);
        
//        albumDAO = new AlbumDAO();
//        albumDAO.saveOrUpdateAlbum(a1);
//        albumDAO.saveOrUpdateAlbum(a2);
//        albumDAO.saveOrUpdateAlbum(a3);
//        albumDAO.saveOrUpdateAlbum(a4);
//        albumDAO.saveOrUpdateAlbum(a5);
        return true;		
	}

	public boolean createTracks(EntityManager em) {
		//TODO
		//use all t1's name now
		
		t1 = new Track();
		t1.setTrackName("01 - 1989 Was Inspired");
		t1.settAddress( Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t1.settDuration("3:09");
		
		t2 = new Track();
		t2.setTrackName("02 - be on");
		t2.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t2.settDuration("3:09");
		
		t3 = new Track();
		t3.setTrackName("03 - Fly");
		t3.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t3.settDuration("3:09");
		
		t4 = new Track();
		t4.setTrackName("04 - Actor");
		t4.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t4.settDuration("3:09");
		
		t1.setAlbum(a1);
		t2.setAlbum(a1);
		t3.setAlbum(a1);
		t4.setAlbum(a1);
		a1.getTracks().add(t1);
		a1.getTracks().add(t2);
		a1.getTracks().add(t3);
		a1.getTracks().add(t4);
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		
		t1 = new Track();
		t1.setTrackName("01 - Animals");
		t1.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t1.settDuration("2:42");
		
		t2 = new Track();
		t2.setTrackName("02 - Freshman");
		t2.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t2.settDuration("2:42");
		
		t3 = new Track();
		t3.setTrackName("03 - Gentleman");
		t3.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t3.settDuration("2:42");
		
		t4 = new Track();
		t4.setTrackName("04 - Cry");
		t4.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t4.settDuration("2:42");
		
		t1.setAlbum(a2);
		t2.setAlbum(a2);
		t3.setAlbum(a2);
		t4.setAlbum(a2);
		a2.getTracks().add(t1);
		a2.getTracks().add(t2);
		a2.getTracks().add(t3);
		a2.getTracks().add(t4);
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		
		t1 = new Track();
		t1.setTrackName("01 - Ugly");
		t1.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t1.settDuration("2:52");
		
		t2 = new Track();
		t2.setTrackName("02 - I Knew You");
		t2.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t2.settDuration("2:53");
		
		t1.setAlbum(a3);
		t2.setAlbum(a3);
		a3.getTracks().add(t1);
		a3.getTracks().add(t2);
		em.persist(t1);
		em.persist(t2);

		t1 = new Track();
		t1.setTrackName("02 - Leave");
		t1.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t1.settDuration("3:44");
		
		t2 = new Track();
		t2.setTrackName("01 - Heart");
		t2.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t2.settDuration("3:44");
		
		t3 = new Track();
		t3.setTrackName("03 - One More Night");
		t3.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t3.settDuration("3:44");
		
		t4 = new Track();
		t4.setTrackName("04 - Sugar");
		t4.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t4.settDuration("3:44");
		
		t1.setAlbum(a4);
		t2.setAlbum(a4);
		t3.setAlbum(a4);
		t4.setAlbum(a4);
		a4.getTracks().add(t1);
		a4.getTracks().add(t2);
		a4.getTracks().add(t3);
		a4.getTracks().add(t4);
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		
		t1 = new Track();
		t1.setTrackName("04 - To be what you wanna be");
		t1.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t1.settDuration("3:35");
		
		t2 = new Track();
		t2.setTrackName("01 - Wacci");
		t2.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t2.settDuration("3:35");
		
		t2 = new Track();
		t2.setTrackName("'02 - Maps");
		t2.settAddress(Global.WEBPATH + "music/" + t1.getTrackName() + ".mp3");
		t2.settDuration("3:35");
		
		t1.setAlbum(a5);
		t2.setAlbum(a5);
		t3.setAlbum(a5);
		a5.getTracks().add(t1);
		a5.getTracks().add(t2);
		a5.getTracks().add(t3);
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		
		return true;
	}

	public boolean createTV(EntityManager em) {
		tv1 = new TVshow();
		tv1.settName("Downton Abbey");
		tv1.settGenre("Action");
		tv1.setStudio("Warner Bros");
		tv1.settCover("images/TV1.jpg");
		tv1.setTypicalLength("31:20");
		resource.getTVshow().add(tv1);
        tv1.setAllResource(resource);
        
        tv2 = new TVshow();
		tv2.settName("Friends");
		tv2.settGenre("Comedy");
		tv2.setStudio("Warner Bros");
		tv2.settCover("images/TV2.jpg");
		tv2.setTypicalLength("31:20");
		resource.getTVshow().add(tv2);
        tv2.setAllResource(resource);
        
        tv3 = new TVshow();
		tv3.settName("Agents of S.H.I.E.L.D");
		tv3.settGenre("Action");
		tv3.setStudio("Warner Bros");
		tv3.settCover("images/TV3.jpg");
		tv3.setTypicalLength("31:20");
		resource.getTVshow().add(tv3);
        tv3.setAllResource(resource);
        
        tv4 = new TVshow();
		tv4.settName("The Big Bang Theory");
		tv4.settGenre("Action");
		tv4.setStudio("Disney");
		tv4.settCover("images/video1.jpg");
		tv4.setTypicalLength("31:20");
		resource.getTVshow().add(tv4);
        tv4.setAllResource(resource);
        
        tv5 = new TVshow();
		tv5.settName("Green Arrow");
		tv5.settGenre("Action");
		tv5.setStudio("Warner Bros");
		tv5.settCover("images/video2.jpg");
		tv5.setTypicalLength("31:20");
		resource.getTVshow().add(tv5);
        tv5.setAllResource(resource);
        
        tv6 = new TVshow();
		tv6.settName("Modern Family");
		tv6.settGenre("Comedy");
		tv6.setStudio("Warner Bros");
		tv6.settCover("images/video3.jpg");
		tv6.setTypicalLength("31:20");
		resource.getTVshow().add(tv6);
        tv6.setAllResource(resource);
        
        tv7 = new TVshow();
		tv7.settName("Sherlock");
		tv7.settGenre("Love");
		tv7.setStudio("Warner Bros");
		tv7.settCover("images/video4.jpg");
		tv7.setTypicalLength("31:20");
		resource.getTVshow().add(tv7);
        tv7.setAllResource(resource);
        
        tv8 = new TVshow();
		tv8.settName("Game of Thrones");
		tv8.settGenre("Love");
		tv8.setStudio("Warner Bros");
		tv8.settCover("images/video5.jpg");
		tv8.setTypicalLength("31:20");
		resource.getTVshow().add(tv8);
        tv8.setAllResource(resource);
        
        tv9 = new TVshow();
		tv9.settName("2 Broke Girls");
		tv9.settGenre("Comedy");
		tv9.setStudio("Warner Bros");
		tv9.settCover("images/video6.jpg");
		tv9.setTypicalLength("31:20");
		resource.getTVshow().add(tv9);
        tv9.setAllResource(resource);
		
		return true;
	}
//	public boolean deleteTV() {
//		return false;
//	}
	public boolean createEpisode(EntityManager em) {
		e1 = new Episode();
		e1.seteName("welcome");
		e1.setLength("31:00");
		e1.setSeanson("2");
		e1.setThumbnailAddress("images/video11.png");
		e1.seteAddress("video/" + "RIPD.mp4");
		e1.setTVshow(tv1);
		tv1.getEpisode().add(e1);
		
		em.persist(e1);
		return true;
		
	}
//	public boolean deleteEpisode() {
//		return false;
//	}
}
