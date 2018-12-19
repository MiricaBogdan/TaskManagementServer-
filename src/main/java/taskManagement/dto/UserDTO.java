package taskManagement.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	private Integer id;
	private String name;
	private String password;
	private List<StoryDTO> story=new ArrayList<StoryDTO>();
	private List<TaskDTO> task=new ArrayList<TaskDTO>();
	
	public UserDTO() {
		
	}
	
	public UserDTO(String name,String password) {
		this.name=name;
		this.password=password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<StoryDTO> getStory() {
		return story;
	}

	public void setStory(List<StoryDTO> story) {
		this.story = story;
	}

	public List<TaskDTO> getTask() {
		return task;
	}

	public void setTask(List<TaskDTO> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	
}
