package hibernateProject.controller;

import hibernateProject.dao.DeveloperDAO;
import hibernateProject.model.Developer;
import hibernateProject.model.Skill;

import java.util.HashSet;
import java.util.Set;

public class DeveloperController extends ModelController{
    private final DeveloperDAO dao;

    public DeveloperController(DeveloperDAO dao) {
        this.dao = dao;
    }

    @Override
    public void choiceOfMenu(int choice){
        int id;
        switch (choice){
            case 1: // create developer
                Developer developer = viewTotal.setDeveloper();
                Set <Skill> skills = new HashSet<Skill>();
                while (viewTotal.choiceOfSetSkill()==1){
                    skills.add(viewTotal.setSkill());
                }
                developer.setSkills(skills);
                dao.create(developer);
                break;
            case 2: //read developer by id
                id = viewTotal.getId();
                dao.readById(id);
                break;
            case 3: // update developer
                developer = viewTotal.setDeveloper();
                dao.update(developer);
                break;
            case 4: //delete developer
                id = viewTotal.getId();
                dao.delete(id);
                break;
            case 5: // read all developers
                dao.readAll();
                break;
            case 0:
                return;
        }
    }
}
