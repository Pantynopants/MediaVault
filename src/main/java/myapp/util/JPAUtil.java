package myapp.util;

import javax.persistence.*;

import java.sql.*;
import java.sql.SQLNonTransientConnectionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myapp.test.TestAlbumTrack;
/**
 * JPA Utility used to configure EntityManagerFactory and retrieve it.
 */
public class JPAUtil {

//	private static final Logger LOGGER = LogManager.getLogger(TestAlbumTrack.class);
    private static EntityManagerFactory emFactory;
    private static EntityManager em;

    private static InheritableThreadLocal<EntityManager> entityManagerThreadLocal = new InheritableThreadLocal<EntityManager>();

	static {
		try {
			emFactory = Persistence.createEntityManagerFactory("test-jpa");
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			// ---- ---- --- --- --- ---------- -- -- ----- -- ---------
			System.err.println("Initial EntityManagerFactory creation failed."
					+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get the configured entityManagerFactory
	 * 
	 * @return entityManagerFactory
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return emFactory;
	}

	/**
	 * Get entity manager from thread
	 * 
	 * @return entity manager
	 */
	public static EntityManager getEntityManager() {
		System.out.println("create em");
		if (entityManagerThreadLocal == null) {
			System.out.println("entityManagerThreadLocal is null");
		}
		if (entityManagerThreadLocal.get() == null || entityManagerThreadLocal.get().isOpen() == false) {
			entityManagerThreadLocal.set(emFactory.createEntityManager());
		}
		return entityManagerThreadLocal.get();
	}
}




