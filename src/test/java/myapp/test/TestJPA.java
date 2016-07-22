package myapp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myapp.model.*;

public class TestJPA {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("test-jpa");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        em.close();
        emf.close();
    }

    @Test
    public void testInsertAndList() {
        insertSomeData();
        listInsertedData();
    }

    private void insertSomeData() {
        Person p = new Person();
        p.setName("person 01");
        Person p1 = new Person();
        p1.setName("person 02");

        em.getTransaction().begin();
        em.persist(p);
        em.persist(p1);
        em.getTransaction().commit();
    }

    private void listInsertedData() {
        em.getTransaction().begin();
        for (long i = 1; i <= 2; i++) {
            Person pFinded = em.find(Person.class, new Long(i));
            System.out.println("Id: " + i + ", name: " + pFinded.getName());
        }
        em.getTransaction().commit();
    }
}
