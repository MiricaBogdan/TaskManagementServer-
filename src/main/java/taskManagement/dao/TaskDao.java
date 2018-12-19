package taskManagement.dao;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import taskManagement.Entity.Task;
import taskManagement.dto.TaskDTO;

@Stateless
@Transactional(SUPPORTS)
public class TaskDao {
	
	 @PersistenceContext(unitName = "PersistenceUnit")
	 private EntityManager em;
	
	//Create a new task in the database
	@Transactional(REQUIRED)
	public Task createTask(@NotNull Task task)
	{
		em.persist(task);
		return task;
	}
	
	//Select a task from database
	public TaskDTO selectTask(@NotNull int id) {
		Task task = em.find(Task.class, id);
		TaskDTO taskDto=new TaskDTO();
		taskDto.setId(task.getId());
		taskDto.setName(task.getName());
		taskDto.setDescription(task.getDescription());
		taskDto.setState(task.getState());
		return taskDto;
	}
	
	//Update the detail about task
	@Transactional(REQUIRED)
	public TaskDTO updateTask(@NotNull TaskDTO taskDto)
	{
		Task updatedTask=em.find(Task.class, taskDto.getId());
		updatedTask.setName(taskDto.getName());
		updatedTask.setDescription(taskDto.getDescription());
		updatedTask.setState(taskDto.getState());
		return taskDto;
	}
	
	//Delete a task from database
	@Transactional(REQUIRED)
	public void deletetask(@NotNull int id) {
		Task task = em.find(Task.class, id);
		em.remove(task);
	}
}
