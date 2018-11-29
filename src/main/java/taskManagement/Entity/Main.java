package taskManagement.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main 
{
    public static void main( String[] args )
    {
  //   User user=new User();
   //  user.setName("Maria");
   //  user.setPassword("password");
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersistenceUnit");
    	EntityManager em=emf.createEntityManager();
    	
    //	user=em.find(User.class,3);
    	Story story=em.find(Story.class, 1);
    	
    //	em.getTransaction().begin();
    //	user.setName("Mihai");
    //	em.getTransaction().commit();
    	
     	System.out.println(story.getUser());
    	em.close();
    	emf.close();
    }
}
