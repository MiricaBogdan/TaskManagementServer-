package taskManagement.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import taskManagement.Entity.User;
import taskManagement.dto.UserDTO;
import taskManagement.dao.UserDao;

@Path("/user")
public class UserEndPoint {

	@Inject
	UserDao userDao;

	@POST
    @Consumes(APPLICATION_JSON)
	public Response createUser(User user, @Context UriInfo uriInfo) {
		user=userDao.createUser(user);
		URI createdURI = uriInfo.getBaseUriBuilder().path(user.getId().toString()).build();
		return Response.created(createdURI).build();
	}

	@GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
	public Response selectUser(@PathParam("id") Integer id) {	
		UserDTO userDto=userDao.selectUser(id);
		if(userDto==null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(userDto).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public Response updateUser(@PathParam("id") Integer id,UserDTO userDto) {
		userDto.setId(id);
		userDto=userDao.updateUser(userDto);
		return Response.ok(userDto).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") Integer id) {
		userDao.deleteUser(id);
		return Response.noContent().build();
	}
	
	@GET
	@Produces(APPLICATION_JSON)
	public Response findAll() {
		List<UserDTO> userDtoList=userDao.findAll();
		if(userDtoList.size()==0)
		{
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		return Response.ok(userDtoList).build();
	}

	@POST
    @Path("/login")
    @Consumes(APPLICATION_JSON)
	public Response login(UserDTO UserDto) {
		String name=UserDto.getName();
		String password=UserDto.getPassword();
		System.out.println(name);
		Integer id=userDao.login(name,password);
		if(id==null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(id).build();
	}
}
