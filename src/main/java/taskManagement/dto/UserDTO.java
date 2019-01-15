package taskManagement.dto;

import java.util.ArrayList;
import java.util.List;

import taskManagement.Entity.Project;
import taskManagement.Entity.ProjectUser;
import taskManagement.Entity.Task;

public class UserDTO {
	private Integer id;
	private String name;
	private String password;
	private List<Project> projects=new ArrayList<Project>();
	private List<Task> createdTasks=new ArrayList<Task>();
	private List<Task> assignedTasks=new ArrayList<Task>();
	private List<ProjectUser> userProjects=new ArrayList<>();
	
	public UserDTO() {
		
	}
	
	public UserDTO(String name,String password) {
		this.name=name;
		this.password=password;
	}
	

	public UserDTO(Integer id, String name, String password, List<Project> projects, List<Task> createdTasks,
			List<Task> assignedTasks, List<ProjectUser> userProjects) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.projects = projects;
		this.createdTasks = createdTasks;
		this.assignedTasks = assignedTasks;
		this.userProjects = userProjects;
	}

	public UserDTO(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getCreatedTasks() {
		return createdTasks;
	}

	public void setCreatedTasks(List<Task> createdTasks) {
		this.createdTasks = createdTasks;
	}

	public List<Task> getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(List<Task> assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	public List<ProjectUser> getUserProjects() {
		return userProjects;
	}

	public void setUserProjects(List<ProjectUser> userProjects) {
		this.userProjects = userProjects;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	
}
