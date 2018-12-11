package taskManagement.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import taskManagement.Entity.User;
import taskManagement.dao.UserDao;

@Path("/user")
public class UserEndPoint {

	@Inject
	UserDao userDao;

	public void createUser(User user) {
		userDao.createUser(user);
	}

	@GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
	public Response selectUser(@PathParam("id") Integer id) {
		System.out.println("asdasdad");

		User user=userDao.selectUser(id);
		
		if(user==null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		
		return Response.ok(user).build();
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	@GET
    @Path("/create")
    @Produces(APPLICATION_JSON)
	public Response cUser() {
		System.out.println("asdasdad");

		User u =new User();
		u.setName("asdsa");
		u.setPassword("asda");
		
		userDao.createUser(u);
		
		return Response.ok(u).build();
	}
	
}
