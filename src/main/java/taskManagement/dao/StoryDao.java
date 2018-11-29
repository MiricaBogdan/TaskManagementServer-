package taskManagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import taskManagement.Entity.Story;
import taskManagement.util.EntityManagerFactorySingleton;

public class StoryDao {

EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
	
	//Create a new Story in the database
	public void createStory(Story story)
	{
		EntityManager em=emf.createEntityManager();
		try {
			EntityTransaction t=em.getTransaction();
			try {
				t.begin();
				em.persist(story);
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
	
	//Select a story from database
	public Story selectStory(int id) {
		EntityManager em = emf.createEntityManager();
		Story story = null;
		try {
			story = em.find(Story.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return story;
	}
	
	//Update the detail about task
	public void updateStory(Story story)
	{
		EntityManager em=emf.createEntityManager();
		try {
			EntityTransaction t=em.getTransaction();
			try {
				Story updatedstory=em.find(Story.class, story.getId());
				t.begin();
				updatedstory.setName(story.getName());
				updatedstory.setDescription(story.getDescription());
				updatedstory.setState(story.getState());
			}
			finally {
				
			}
		}
		finally
		{
			
		}
	}
	
	//Delete a story from database
	public void deletestory(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				Story story = em.find(Story.class, id);
				t.begin();
				em.remove(story);
				em.merge(story);
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
