package taskManagement.dto;

import java.util.ArrayList;
import java.util.List;

import taskManagement.Entity.Task;

public class StoryDTO {
	private Integer id;
	private String name;
	private String description;
	private String start_time;
	private String finish_time;
	private int state;
	private Integer created_by;
	
	public Integer getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}
	private List<Task> task = new ArrayList<Task>();
	
	public StoryDTO() {

	}
	public StoryDTO(String name, String description, String start_time, String finish_time, int state) {
		this.name=name;
		this.description=description;
		this.start_time=start_time;
		this.finish_time=finish_time;
		this.state=state;
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
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(String finish_time) {
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
	@Override
	public String toString() {
		return "StoryDTO [id=" + id + ", name=" + name + ", description=" + description + ", start_time=" + start_time
				+ ", finish_time=" + finish_time + ", state=" + state + "]";
	}
	
	
}
