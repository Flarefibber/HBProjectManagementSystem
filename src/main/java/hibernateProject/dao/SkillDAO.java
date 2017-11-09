package hibernateProject.dao;

import hibernateProject.dao.InterfacesDAO.ISkillDAO;
import hibernateProject.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SkillDAO implements ISkillDAO {

    private SessionFactory sessionFactory;
    private AbstractDAO abstractDAO = new AbstractDAO();

    public SkillDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer create(Skill skill) {
        return abstractDAO.createAbstract(skill, sessionFactory);
    }

    public Skill readById(Integer id) {
        Session session = sessionFactory.openSession();
        Skill skill = session.get(Skill.class, id);
        if (skill!=null) {
            System.out.println(skill);
            return skill;
        }else {
            System.out.println("There are not such skill");
        }
        session.close();
        return null;
    }

    public void update(Skill skill) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Skill skillDB = new Skill();
        skillDB = session.get(Skill.class, skill.getId());
        if (skillDB!=null){
            skillDB.setSkill(skill.getSkill());
            session.update(skillDB);
            transaction.commit();
            System.out.println("Skill " + skill + " was updated");
        }
        session.close();
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Skill skillDB = new Skill();
        skillDB = session.get(Skill.class, id);
        if (skillDB!=null){
            session.delete(skillDB);
            transaction.commit();
            System.out.println("Skill " + skillDB + " was deleted");
        }else {
            System.out.println("There is not such developer");
        }
        session.close();
    }

    public List<Skill> readAll() {
        Session session = sessionFactory.openSession();
        List<Skill> skills = session.createQuery("from Skill").list();
        session.close();
        System.out.println(skills);
        return skills;
    }
}
