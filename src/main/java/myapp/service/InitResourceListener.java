package myapp.service;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myapp.util.JPAUtil;

@WebServlet(name="InitResourceListener",urlPatterns="/InitResourceListener")
public class InitResourceListener extends HttpServlet {

	private static EntityManager em = JPAUtil.getEntityManager();

		
	public InitResourceListener() {

		System.out.println("in InitResourceListener");
		System.out.println("init data");
		
		em.getTransaction().begin();
		InitResource initResource = new InitResource();
        initResource.createResources(em);
        em.getTransaction().commit();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//INIT
				System.out.println("init data");
				InitResource initResource = new InitResource();
		        initResource.createResources(em);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
