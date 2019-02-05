package taskManagement.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

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
import javax.ws.rs.core.Response;


import taskManagement.dao.TaskDao;
import taskManagement.dto.TaskDTO;

@Path("/task")
public class TaskEndPoint {
	
	@Inject
	TaskDao taskDao;

	@POST
    @Consumes(APPLICATION_JSON)
	public Response createTask(TaskDTO taskDto) {
		TaskDTO task=taskDao.createTask(taskDto);
		return Response.ok(task).build();
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
		System.out.println(taskDto);
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
