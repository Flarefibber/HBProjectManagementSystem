package hibernateProject.controller;

import hibernateProject.dao.ProjectDAO;
import hibernateProject.model.Developer;
import hibernateProject.model.Project;

import java.util.HashSet;
import java.util.Set;

public class ProjectController extends ModelController{
    private final ProjectDAO dao;

    public ProjectController(ProjectDAO dao) {
        this.dao = dao;
    }

    public void choiceOfMenu(int choice){
        int id;
        switch (choice){
            case 1: // create project
                Project project = viewTotal.setProject();
                Set <Developer> developers = new HashSet<Developer>();
                while (viewTotal.choiceOfSetDeveloper()==1){
                    developers.add(viewTotal.setDeveloper());
                }
                project.setDevelopers(developers);
                dao.create(project);
                break;
            case 2: //read project by id
                id = viewTotal.getId();
                dao.readById(id);
                break;
            case 3: // update project
                project = viewTotal.setProject();
                dao.update(project);
                break;
            case 4: //delete project
                id = viewTotal.getId();
                dao.delete(id);
                break;
            case 5: // read all projects
                dao.readAll();
                break;
            case 0:
                return;
        }
    }
}
