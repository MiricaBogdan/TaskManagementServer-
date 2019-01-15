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
import javax.ws.rs.QueryParam;
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
	public Response createTask(TaskDTO taskDto, @Context UriInfo uriInfo) {
		Task task=taskDao.createTask(taskDto);
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
	
	@GET
    @Path("/getTasksForProject")
    @Produces(APPLICATION_JSON)
	public Response getTasksForProject(@QueryParam("projectId") Integer id) {
		List<TaskDTO> userProjects=taskDao.getTasksForProject(id);
		return Response.ok(userProjects).build();
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
