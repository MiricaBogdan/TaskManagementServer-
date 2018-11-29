package taskManagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import taskManagement.Entity.Task;
import taskManagement.util.EntityManagerFactorySingleton;

public class TaskDao {
	
	EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
	
	//Create a new task in the database
	public void createTask(Task task)
	{
		EntityManager em=emf.createEntityManager();
		try {
			EntityTransaction t=em.getTransaction();
			try {
				t.begin();
				em.persist(task);
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
	
	//Select a task from database
	public Task selectTask(int id) {
		EntityManager em = emf.createEntityManager();
		Task task = null;
		try {
			task = em.find(Task.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return task;
	}
	
	//Update the detail about task
	public void updateTask(Task task)
	{
		EntityManager em=emf.createEntityManager();
		try {
			EntityTransaction t=em.getTransaction();
			try {
				Task updatedTask=em.find(Task.class, task.getId());
				t.begin();
				updatedTask.setName(task.getName());
				updatedTask.setDescription(task.getDescription());
				updatedTask.setState(task.getState());
			}
			finally {
				
			}
		}
		finally
		{
			
		}
	}
	
	//Delete a task from database
	public void deletetask(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				Task task = em.find(Task.class, id);
				t.begin();
				em.remove(task);
				em.merge(task);
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
