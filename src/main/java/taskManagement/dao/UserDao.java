package taskManagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import taskManagement.util.EntityManagerFactorySingleton;
import taskManagement.Entity.User;

public class UserDao {
	
	EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
	
	//Create a new user in the database
	public void createUser(User user)
	{
		EntityManager em=emf.createEntityManager();
		try {
			EntityTransaction t=em.getTransaction();
			try {
				t.begin();
				em.persist(user);
				t.commit();
			}
			finally {
				if(t.isActive())
				t.rollback();
			}
		}
		finally {
			em.close();
		}
	}
	
	//Select a user from database
		public User selectUser(int id) {
			EntityManager em = emf.createEntityManager();
			User user = null;
			try {
				user = em.find(User.class, id);
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return user;
		}
		
		
	//Update the detail about user
	public void updateUser(User user)
	{
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				User u = em.find(User.class, user.getId());
				t.begin();
				u.setName(user.getName());
				u.setPassword(user.getPassword());
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	//Delete a user from database
	public void deleteUser(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				User user = em.find(User.class, id);
				t.begin();
				em.remove(user);
				em.merge(user);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
}
