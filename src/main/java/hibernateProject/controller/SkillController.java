package hibernateProject.controller;

import hibernateProject.dao.SkillDAO;
import hibernateProject.model.Skill;
import hibernateProject.view.ViewTotal;

public class SkillController extends ModelController{
    private final SkillDAO dao;

    public SkillController(SkillDAO dao) {
        this.dao = dao;
    }

    @Override
    public void choiceOfMenu(int choice) {
        Skill skill;
        int id;

        switch (choice) {
            case 1: // create skill
                skill = viewTotal.setSkill();
                dao.create(skill);
                break;
            case 2: //read skill by id
                id = viewTotal.getId();
                dao.readById(id);
                break;
            case 3: // update skill
                skill = viewTotal.setSkill();
                dao.update(skill);
                break;
            case 4: //delete skill
                id = viewTotal.getId();
                dao.delete(id);
                break;
            case 5: // read all skills
                dao.readAll();
                break;
            case 0:
                return;
        }
    }
}
