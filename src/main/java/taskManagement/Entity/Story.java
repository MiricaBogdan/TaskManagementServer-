package taskManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "story")
public class Story {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 200)
	@NotNull
	@Size(min = 1, max = 200)
	private String name;

	@Column(length = 10000)
	@Size(min = 1, max = 10000)
	private String description;

	private String start_time;
	private String finish_time;

	@NotNull
	private int state;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	private User user;

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Task> task = new ArrayList<Task>();

	public Story() {

	}
	public Story(String name, String description, String start_time, String finish_time, int state) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", name=" + name + ", description=" + description + ", start_time=" + start_time
				+ ", finish_time=" + finish_time + ", state=" + state + "]";
	}

}
