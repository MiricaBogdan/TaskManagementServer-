package taskManagement.dao;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import taskManagement.Entity.User;
@Stateless
@Transactional(SUPPORTS)
public class UserDao {
	
    @PersistenceContext(unitName="PersistenceUnit")
    private EntityManager em;
	
	//Create a new user in the database
    @Transactional(REQUIRED)
	public void createUser(@NotNull User user)
	{
		em.persist(user);
	}
	
	//Select a user from database
	public User selectUser(@NotNull int id) {
		
		User user = null;
		user = em.find(User.class, id);
		System.out.println(user==null);
		return user;
	}
		
	//Update the detail about user
	@Transactional(REQUIRED)
	public void updateUser(@NotNull User user)
	{
		User u = em.find(User.class, user.getId());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
	}
	
	//Delete a user from database
	@Transactional(REQUIRED)
	public void deleteUser(@NotNull int id) {
		em.remove(em.getReference(User.class, id));
	}
}
