package taskManagement.dao;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import taskManagement.Entity.User;
import taskManagement.dto.UserDTO;
@Stateless()
@Transactional(SUPPORTS)
public class UserDao {
	
    @PersistenceContext(unitName="PersistenceUnit")
    private EntityManager em;
	
	//Create a new user in the database
    @Transactional(REQUIRED)
	public User createUser(@NotNull User user)
	{
		em.persist(user);
		return user;
	}
	
	//Select a user from database
	public UserDTO selectUser(@NotNull int id) {
		User user = em.find(User.class, id);
		UserDTO userDto=new UserDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
		
	//Update the detail about user
	@Transactional(REQUIRED)
	public UserDTO updateUser(@NotNull UserDTO userDto)
	{
		User u = em.find(User.class, userDto.getId());
		u.setName(userDto.getName());
		u.setPassword(userDto.getPassword());
		return userDto;
	}
	
	//Delete a user from database
	@Transactional(REQUIRED)
	public void deleteUser(@NotNull int id) {
		em.remove(em.getReference(User.class, id));
	}
}
