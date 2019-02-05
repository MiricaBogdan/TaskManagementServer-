package taskManagement.dto;

import java.util.Date;

public class TaskDTO {
	private Integer id;
	private String name;
	private String description;
	private Integer state;
	private Integer created_by;
	private UserDTO assigned_to;
	private Integer project_id;
	private Date start_time;
	private Date finish_time;

	public TaskDTO() {

	}

	public TaskDTO(String name, String description, int state, Date start_time, Date finish_time) {
		super();
		this.name = name;
		this.description = description;
		this.state = state;
		this.start_time = start_time;
		this.finish_time = finish_time;
	}

	public TaskDTO(Integer id, String name, String description, int state, UserDTO assigned_to, Integer project_id,
			Date start_time, Date finish_time) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.state = state;
		this.assigned_to = assigned_to;
		this.project_id = project_id;
		this.start_time = start_time;
		this.finish_time = finish_time;
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

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public UserDTO getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(UserDTO assigned_to) {
		this.assigned_to = assigned_to;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state
				+ ", created_by=" + created_by + ", assigned_to=" + assigned_to + ", project_id=" + project_id
				+ ", start_time=" + start_time + ", finish_time=" + finish_time + "]";
	}

}
