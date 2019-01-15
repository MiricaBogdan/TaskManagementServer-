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
import taskManagement.Entity.Project;
import taskManagement.dao.ProjectDao;
import taskManagement.dto.ProjectDTO;

@Path("/project")
public class ProjectEndPoint {
	
	@Inject
	ProjectDao projectDao;

	@POST
    @Consumes(APPLICATION_JSON)
	public Response createProject(ProjectDTO projectDto, @Context UriInfo uriInfo) {
		Project project=projectDao.createProject(projectDto);
		URI createdURI = uriInfo.getBaseUriBuilder().path(project.getId().toString()).build();
		return Response.created(createdURI).build();
	}

	@GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
	public Response selectProject(@PathParam("id") Integer id) {
		ProjectDTO projectDto=projectDao.selectProject(id);
		if(projectDto==null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(projectDto).build();
	}
	
	@GET
    @Path("/getProjectsForUser")
    @Produces(APPLICATION_JSON)
	public Response getProjectsForUser(@QueryParam("userId") Integer id) {
		List<ProjectDTO> userProjects=projectDao.getProjectsForUser(id);
		return Response.ok(userProjects).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public Response updateProject(@PathParam("id") Integer id,ProjectDTO projectDto) {
		projectDto.setId(id);
		projectDto=projectDao.updateProject(projectDto);
		return Response.ok(projectDto).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteProject(@PathParam("id") Integer id) {
		projectDao.deleteProject(id);
		return Response.noContent().build();
	}

}
