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
import taskManagement.Entity.Story;
import taskManagement.dao.StoryDao;
import taskManagement.dto.StoryDTO;

@Path("/story")
public class StoryEndPoint {
	
	@Inject
	StoryDao storyDao;

	@POST
    @Consumes(APPLICATION_JSON)
	public Response createStory(StoryDTO storyDto, @Context UriInfo uriInfo) {
		Story story=storyDao.createStory(storyDto);
		URI createdURI = uriInfo.getBaseUriBuilder().path(story.getId().toString()).build();
		return Response.created(createdURI).build();
	}

	@GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
	public Response selectStory(@PathParam("id") Integer id) {
		StoryDTO storyDto=storyDao.selectStory(id);
		if(storyDto==null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(storyDto).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public Response updateStory(@PathParam("id") Integer id,StoryDTO storyDto) {
		storyDto.setId(id);
		storyDto=storyDao.updateStory(storyDto);
		return Response.ok(storyDto).build();
	}

	@DELETE
	@Path("{id}")
	public Response deletestory(@PathParam("id") Integer id) {
		storyDao.deletestory(id);
		return Response.noContent().build();
	}

}
