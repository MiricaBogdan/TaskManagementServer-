package taskManagement.dao;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import taskManagement.Entity.Story;
import taskManagement.Entity.User;
import taskManagement.dto.StoryDTO;

@Stateless
@Transactional(SUPPORTS)
public class StoryDao {

	 @PersistenceContext(unitName = "PersistenceUnit")
	 private EntityManager em;
	
	//Create a new Story in the database
	@Transactional(REQUIRED) 
	public Story createStory(@NotNull StoryDTO storyDto){
		Story story=new Story();
		story.setName(storyDto.getName());
		story.setDescription(storyDto.getDescription());
		story.setState(storyDto.getState());
		story.setStart_time(storyDto.getStart_time());
		story.setFinish_time(storyDto.getFinish_time());
		story.setUser(em.find(User.class, storyDto.getCreated_by()));
		em.persist(story);
		return story;
	}
	
	//Select a story from database
	public StoryDTO selectStory(@NotNull int id) {
		Story story = em.find(Story.class, id);
		StoryDTO storyDto=new StoryDTO();
		storyDto.setId(story.getId());
		storyDto.setName(story.getName());
		storyDto.setDescription(story.getDescription());
		storyDto.setStart_time(story.getStart_time());
		storyDto.setFinish_time(story.getFinish_time());
		storyDto.setState(story.getState());
		storyDto.setCreated_by(story.getUser().getId());
		return storyDto;
	}
		
	//Update the detail about task
	@Transactional(REQUIRED)
	public StoryDTO updateStory(@NotNull StoryDTO storyDto)
	{
		Story updatedstory=em.find(Story.class, storyDto.getId());
		updatedstory.setName(storyDto.getName());
		updatedstory.setDescription(storyDto.getDescription());
		updatedstory.setState(storyDto.getState());
		updatedstory.setStart_time(storyDto.getStart_time());
		updatedstory.setFinish_time(storyDto.getFinish_time());
		updatedstory.setUser(em.find(User.class, storyDto.getCreated_by()));
		return storyDto;
	}
	
	//Delete a story from database
	@Transactional(REQUIRED)
	public void deletestory(@NotNull int id) {
		Story story = em.find(Story.class, id);
		em.remove(story);
	}
}
