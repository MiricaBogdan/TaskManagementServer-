package taskManagement.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;

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

import taskManagement.Entity.Task;
import taskManagement.dao.TaskDao;
import taskManagement.dto.TaskDTO;

@Path("/task")
public class TaskEndPoint {
	
	@Inject
	TaskDao taskDao;

	@POST
    @Consumes(APPLICATION_JSON)
	public Response createTask(Task task, @Context UriInfo uriInfo) {
		task=taskDao.createTask(task);
		URI createdURI = uriInfo.getBaseUriBuilder().path(task.getId().toString()).build();
		return Response.created(createdURI).build();
	}

	@GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
	public Response selectTask(@PathParam("id") Integer id) {
		TaskDTO taskDto=taskDao.selectTask(id);
		if(taskDto==null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(taskDto).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public Response updateTask(@PathParam("id") Integer id,TaskDTO taskDto) {
		taskDto.setId(id);
		taskDto=taskDao.updateTask(taskDto);
		return Response.ok(taskDto).build();
	}

	@DELETE
	@Path("{id}")
	public void deletetask(@PathParam("id") Integer id) {
		taskDao.deletetask(id);
	}

}
