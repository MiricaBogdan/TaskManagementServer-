package taskManagement.dao;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import taskManagement.Entity.Project;
import taskManagement.Entity.Task;
import taskManagement.Entity.User;
import taskManagement.dto.TaskDTO;
import taskManagement.dto.UserDTO;

@Stateless
@Transactional(SUPPORTS)
public class TaskDao {

	@PersistenceContext(unitName = "PersistenceUnit")
	private EntityManager em;

	// Create a new task in the database
	@Transactional(REQUIRED)
	public TaskDTO createTask(@NotNull TaskDTO taskDto) {
		System.out.println(taskDto);
		Task task = new Task();
		task.setName(taskDto.getName());
		task.setDescription(taskDto.getDescription());
		task.setState(taskDto.getState());
		task.setState(taskDto.getState());
		task.setStart_time(new Date());
		task.setFinish_time(taskDto.getFinish_time());
		task.setCreatedByUser(em.find(User.class, taskDto.getCreated_by()));
		task.setAssignedToUser(em.find(User.class, taskDto.getAssigned_to().getId()));
		task.setProject(em.find(Project.class, taskDto.getProject_id()));
		em.persist(task);
		
		UserDTO assisgned_to=new UserDTO();
		assisgned_to.setId(task.getAssignedToUser().getId());
		assisgned_to.setName(task.getAssignedToUser().getName());
		
		TaskDTO taskDTO=new TaskDTO(task.getId(),task.getName(),task.getDescription(),task.getState(),assisgned_to,task.getProject().getId(),task.getStart_time(),task.getFinish_time());
		return taskDTO;
	}

	// Select a task from database
	public TaskDTO selectTask(@NotNull int id) {
		Task task = em.find(Task.class, id);
		TaskDTO taskDto = new TaskDTO();
		taskDto.setId(task.getId());
		taskDto.setName(task.getName());
		taskDto.setDescription(task.getDescription());
		taskDto.setStart_time(task.getStart_time());
		taskDto.setFinish_time(task.getFinish_time());
		taskDto.setState(task.getState());
		taskDto.setCreated_by(task.getCreatedByUser().getId());
		taskDto.setProject_id(task.getProject().getId());
		
		UserDTO userDTO=new UserDTO();
		userDTO.setId(task.getAssignedToUser().getId());
		userDTO.setName(task.getAssignedToUser().getName());
		
		taskDto.setAssigned_to(userDTO);
		return taskDto;
	}

	// Update the detail about task
	@Transactional(REQUIRED)
	public TaskDTO updateTask(@NotNull TaskDTO taskDto) {
		Task updatedTask = em.find(Task.class, taskDto.getId());
		if ((taskDto.getState() !=null)&& ((taskDto.getState() == 0) || (taskDto.getState() == 1)))
			updatedTask.setState(taskDto.getState());
		if (taskDto.getName() != null)
			updatedTask.setName(taskDto.getName());
		if (taskDto.getDescription() != null)
			updatedTask.setDescription(taskDto.getDescription());
		if (taskDto.getStart_time() != null)
			updatedTask.setStart_time(taskDto.getStart_time());
		if (taskDto.getFinish_time() != null)
			updatedTask.setFinish_time(taskDto.getFinish_time());
		if (taskDto.getCreated_by()!= null)
			updatedTask.setCreatedByUser(em.find(User.class, taskDto.getCreated_by()));
		if (taskDto.getProject_id()!= null)
			updatedTask.setProject(em.find(Project.class, taskDto.getProject_id()));
		if (taskDto.getAssigned_to()!= null)
			updatedTask.setAssignedToUser(em.find(User.class, taskDto.getAssigned_to().getId()));
		return taskDto;
	}

	// Delete a task from database
	@Transactional(REQUIRED)
	public void deletetask(@NotNull int id) {
		Task task = em.find(Task.class, id);
		task.setAssignedToUser(null);
		task.setProject(null);
		task.setCreatedByUser(null);
		em.remove(task);
	}

	public List<TaskDTO> getTasksForProject(Integer id) {
		List<TaskDTO> tasks = new ArrayList<>();
		if (id == null) {
			return tasks;
		}

		Project project = em.find(Project.class, id);
		for (Task task : project.getTask()) {
			UserDTO assisgned_to=new UserDTO();
			assisgned_to.setId(task.getAssignedToUser().getId());
			assisgned_to.setName(task.getAssignedToUser().getName());
			
			TaskDTO taskDto = new TaskDTO(task.getId(),task.getName(), task.getDescription(), task.getState(), assisgned_to, task.getProject().getId(), task.getStart_time(),
					task.getFinish_time());
			tasks.add(taskDto);
		}
		return tasks;
	}
}
