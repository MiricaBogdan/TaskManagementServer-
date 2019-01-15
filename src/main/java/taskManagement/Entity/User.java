package taskManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 200)
	@NotNull
	@Size(min = 1, max = 200)
	private String name;
	
	@Column(length = 10000)
	@NotNull
	@Size(min = 1, max = 10000)
	private String password;
	
	@NotNull
	@OneToMany(mappedBy="projectOwner",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Project> projects=new ArrayList<Project>();
	
	@NotNull
	@OneToMany(mappedBy="createdByUser",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Task> createdTasks=new ArrayList<Task>();
	
	@NotNull
	@OneToMany(mappedBy="assignedToUser",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Task> assignedTasks=new ArrayList<Task>();
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectUser> userProjects=new ArrayList<>();
	
	public User() {
		
	}
	
	public User(String name,String password) {
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
