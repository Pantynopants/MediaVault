package myapp.service;
// not in use

import java.sql.*;
import java.sql.SQLNonTransientConnectionException;

import javax.persistence.*;

import org.apache.derby.impl.tools.sysinfo.Main;
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
import myapp.test.*;
public class LoadAlbum {
	

    private static EntityManager em = JPAUtil.getEntityManager();
    
    public LoadAlbum() {
		// TODO Auto-generated constructor stub
	}
    
    public String getAlbums(Long aID) {
		String albumsStr = "";
		//put it into GET sothat every time request can get different AllResource
		em.getTransaction().begin();

		//INIT
		InitResource initResource = new InitResource();
        initResource.createResources(em);
        
		AllResource allResource = em.find(AllResource.class, new Long(1));
		
			
		Album albums = new Album();
		
		for(int i=0; i < allResource.getAlbum().size(); i++){
			albums = em.find(Album.class, new Long(i));
        	if (albums != null && albums.getaID() != null) {
        		System.out.println("Id: " + i + ", name: " + albums.getaName());
        		albumsStr += "<hr class='featurette-divider'>"
    					+ " <div class='row featurette'> "
    					+ "<div class='col-md-7'>";
    			
        		albumsStr += "<h2 class='featurette-heading'>"
    					+ albums.getAritist()
    					+ "<span class='text-muted'>. : &nbsp;"
    					+ albums.getaGenre()
    					+ "</span></h2>";
        		albumsStr += "<p class='lead'>"
    					+ albums.getReview()
    					+ "</p>";
        		albumsStr += "<table class='table'>    "
    					+ " <thead>             "
    					+ " <tr>               "
    					+ " <th></th>                "
    					+ "<th></th>                "
    					+ "<th></th>               "
    					+ " <th></th>            "
    					+ "  </tr>           "
    					+ " </thead>";
        		albumsStr += "<tbody>"
        				+ "              <% session.setAttribute('album', "+ albums.getaName() + "); "
        				+ "            request.setAttribute('album',"+ albums.getaName() + ");           "
        						+ "            %>            <%! String tempalbumName = ' "+ albums.getaName() + " ';%>"
        								+ "   "//<jsp:include>
        										+ "            </tbody>"
        										+ "          </table>";
        		albumsStr += "</div>"
        				+ "        <div class='col-md-5'>"
        						+ "          <a href='track.jsp?name="+ albums.getaName() + "'>"
        						+ "<img class='featurette-image img-responsive center-block' data-src='holder.js/400x400/auto' "
        						+ "src=' " + albums.getaCover() + " ' alt='Generic placeholder image'>"
        								+ "</a>"
        								+ "        </div>"
        								+ "      </div>";
        	}

		}
		em.getTransaction().commit();
		System.out.println(albumsStr);
		return albumsStr;
    }
//    public static void main(String[] args) {
//    	getAlbums(new Long(1));
//	}
}