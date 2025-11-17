package com.jsp.productInventory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pavan");
	EntityManager em = emf.createEntityManager();

	// Save product
	public void save(Product p) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	}

	// Get by ID
	public Product get(int id) {
		return em.find(Product.class, id);
	}

	// Delete by ID
	public void delete(int id) {
		EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class, id);

		if (p != null) {
			tx.begin();
			em.remove(p);
			tx.commit();
		}
	}

	// Fetch all
	public List<Product> getAll() {
		return em.createQuery("FROM Product", Product.class).getResultList();
	}
}
