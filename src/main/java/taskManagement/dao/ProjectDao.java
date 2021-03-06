package taskManagement.dao;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import taskManagement.Entity.Project;
import taskManagement.Entity.ProjectUser;
import taskManagement.Entity.User;
import taskManagement.dto.ProjectDTO;
import taskManagement.dto.UserDTO;

@Stateless
@Transactional(SUPPORTS)
public class ProjectDao {

	@PersistenceContext(unitName = "PersistenceUnit")
	private EntityManager em;

	// Create a new Project in the database
	@Transactional(REQUIRED)
	public Project createProject(@NotNull ProjectDTO projectDto) {
		Project project = new Project();
		project.setName(projectDto.getName());
		project.setDescription(projectDto.getDescription());
		project.setState(projectDto.getState());
		project.setStart_time(projectDto.getStart_time());
		project.setFinish_time(projectDto.getFinish_time());
		project.setProjectOwner(em.find(User.class, projectDto.getProject_owner()));
		em.persist(project);
		return project;
	}

	// Select a project from database
	public ProjectDTO selectProject(@NotNull int id) {
		Project project = em.find(Project.class, id);
		ProjectDTO projectDto = new ProjectDTO();
		projectDto.setId(project.getId());
		projectDto.setName(project.getName());
		projectDto.setDescription(project.getDescription());
		projectDto.setStart_time(project.getStart_time());
		projectDto.setFinish_time(project.getFinish_time());
		projectDto.setState(project.getState());
		projectDto.setProject_owner(project.getProjectOwner().getId());
		return projectDto;
	}

	// Update the detail about task
	@Transactional(REQUIRED)
	public ProjectDTO updateProject(@NotNull ProjectDTO projectDto) {
		Project updatedproject = em.find(Project.class, projectDto.getId());
		if ((projectDto.getState() == 0) || (projectDto.getState() == 1))
			updatedproject.setState(projectDto.getState());
		if (projectDto.getName() != null)
			updatedproject.setName(projectDto.getName());
		if (projectDto.getDescription() != null)
			updatedproject.setDescription(projectDto.getDescription());
		if (projectDto.getStart_time() != null)
			updatedproject.setStart_time(projectDto.getStart_time());
		if (projectDto.getFinish_time() != null)
			updatedproject.setFinish_time(projectDto.getFinish_time());
		if (projectDto.getProject_owner() != null)
			updatedproject.setProjectOwner(em.find(User.class, projectDto.getProject_owner()));
		return projectDto;
	}

	// Delete a project from database
	@Transactional(REQUIRED)
	public void deleteProject(@NotNull int id) {
		Project project = em.find(Project.class, id);
		em.remove(project);
	}

	public List<ProjectDTO> getProjectsForUser(Integer id) {
		List<ProjectDTO> userProjects = new ArrayList<>();
		if (id == null) {
			return userProjects;
		}

		User u = em.find(User.class, id);
		for (ProjectUser pu : u.getUserProjects()) {
			Project proj = pu.getProject();
			ProjectDTO projDTO = new ProjectDTO(proj.getId(), proj.getName(), proj.getDescription(),
					proj.getStart_time(), proj.getFinish_time(), proj.getState(), proj.getProjectOwner().getId());

			List<UserDTO> projectUsers = new ArrayList<>();

			for (ProjectUser projUser : proj.getProjectUser()) {
				UserDTO userDTO = new UserDTO(projUser.getUser().getId(), projUser.getUser().getName(), "");
				projectUsers.add(userDTO);
			}
			projDTO.setProjectUser(projectUsers);
			userProjects.add(projDTO);
		}

		return userProjects;
	}

}
