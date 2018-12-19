package taskManagement.dto;

public class TaskDTO {
	private Integer id;
	private String name;
	private String description;
	private int state;
	
	public TaskDTO(){
		
	}
	
	public TaskDTO(String name,String description,int state){
		this.name=name;
		this.description=description;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state + "]";
	}
	
}
