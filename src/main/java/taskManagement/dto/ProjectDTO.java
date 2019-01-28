package taskManagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import taskManagement.Entity.ProjectUser;
import taskManagement.Entity.Task;

public class ProjectDTO {
	private Integer id;
	private String name;
	private String description;
	private Date start_time;
	private Date finish_time;
	private int state;
	private Integer project_owner;
	private List<Task> task = new ArrayList<Task>();
	private List<UserDTO> projectUsers = new ArrayList<UserDTO>();
	

	
	public ProjectDTO() {

	}

	
	public ProjectDTO(Integer id, String name, String description, Date start_time, Date finish_time, int state,
			Integer project_owner, List<Task> task, List<UserDTO> projectUsers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_time = start_time;
		this.finish_time = finish_time;
		this.state = state;
		this.project_owner = project_owner;
		this.task = task;
		this.projectUsers = projectUsers;
	}



	public ProjectDTO(String name, String description, Date start_time, Date finish_time, int state,
			Integer project_owner, List<Task> task, List<UserDTO> projectUsers) {
		super();
		this.name = name;
		this.description = description;
		this.start_time = start_time;
		this.finish_time = finish_time;
		this.state = state;
		this.project_owner = project_owner;
		this.task = task;
		this.projectUsers = projectUsers;
	}


	public ProjectDTO(Integer id, String name, String description, Date start_time, Date finish_time, int state,
			Integer project_owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_time = start_time;
		this.finish_time = finish_time;
		this.state = state;
		this.project_owner = project_owner;
	}



	public Integer getProject_owner() {
		return project_owner;
	}



	public void setProject_owner(Integer project_owner) {
		this.project_owner = project_owner;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	
	public List<UserDTO> getProjectUser() {
		return projectUsers;
	}
	public void setProjectUser(List<UserDTO> projectUsers) {
		this.projectUsers = projectUsers;
	}
	
	@Override
	public String toString() {
		return "StoryDTO [id=" + id + ", name=" + name + ", description=" + description + ", start_time=" + start_time
				+ ", finish_time=" + finish_time + ", state=" + state + "]";
	}
	
	
}
