package taskManagement.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="task")
public class Task {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	@NotNull
	@Size(min = 1, max = 200)
	private String name;
	
	@Column(length = 10000)
	@Size(min = 1, max = 10000)
	private String description;
	
	private Date start_time;
	private Date finish_time;
	
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

	@NotNull
	private int state;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	private User createdByUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to")
	private User assignedToUser;
	
	public Task(){
		
	}

	public Task(String name, String description, Date start_time, Date finish_time, int state, User createdByUser,
			Project project, User assignedToUser) {
		super();
		this.name = name;
		this.description = description;
		this.start_time = start_time;
		this.finish_time = finish_time;
		this.state = state;
		this.createdByUser = createdByUser;
		this.project = project;
		this.assignedToUser = assignedToUser;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public User getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUser(User assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state + "]";
	}
	

	
	
}
