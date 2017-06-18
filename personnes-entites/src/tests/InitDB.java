package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Personne;

public class InitDB {
	// constantes
	private final static String TABLE_NAME = "jpa01_personne";

	public static void main(String[] args) throws ParseException {
		// recuperer un EntityManagerFactory à partir de l'unite de persistance
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		// recuperer un EntityManager e partir de l'EntityManagerFactory
		EntityManager em = emf.createEntityManager();
		// debut transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// supprimer les elements de la table PERSONNE
		em.createNativeQuery("delete from " + TABLE_NAME).executeUpdate();
		// mettre des elements dans la table PERSONNE
		Personne p1 = new Personne("Martin", "Paul", new SimpleDateFormat("dd/MM/yy").parse("31/01/2000"), true, 2);
		Personne p2 = new Personne("Durant", "Sylvie", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
		// persistance des personnes
		em.persist(p1);
		em.persist(p2);
		// affichage personnes
		System.out.println("[personnes]");
		for (Object p : em.createQuery("select p from Personne p order by p.nom asc").getResultList()) {
			System.out.println(p);
		}
		// fin transaction
		tx.commit();
		// fin EntityManager
		em.close();
		// fin EntityManagerFactory
		emf.close();
		// log
		System.out.println("termine ...");
	}
}
