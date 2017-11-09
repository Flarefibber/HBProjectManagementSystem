package hibernateProject.dao;

import hibernateProject.dao.InterfacesDAO.IProjectDAO;
import hibernateProject.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProjectDAO implements IProjectDAO {

    private SessionFactory sessionFactory;
    private AbstractDAO abstractDAO = new AbstractDAO();

    public ProjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer create(Project project) {
        return abstractDAO.createAbstract(project, sessionFactory);
    }

    public Project readById(Integer id) {
        Session session = sessionFactory.openSession();
        Project model1 = session.get(Project.class, id);
        if (model1 != null) {
            System.out.println("Project " + model1);
            return model1;
        } else {
            System.out.println("There are not such project");
        }
        session.close();
        return null;
    }

    public void update(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Project projectDB = new Project();
        projectDB = session.get(Project.class, project.getId());

        if (projectDB != null) {
            projectDB.setProjectName(project.getProjectName());
            projectDB.setCost(project.getCost());
            projectDB.setDevelopers(project.getDevelopers());
            session.update(projectDB);
            transaction.commit();
            System.out.println("Project " + project + " was updated");
        }
        session.close();
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Project projectDB = new Project();
        projectDB = session.get(Project.class, id);
        if (projectDB != null) {
            session.delete(projectDB);
            transaction.commit();
            System.out.println("Project " + projectDB + " was deleted");
        } else {
            System.out.println("There is not such project");
        }
        session.close();
    }

    public List<Project> readAll() {
        Session session = sessionFactory.openSession();
        List projects = session.createQuery("from Project ").list();
        session.close();
        System.out.println(projects);
        return projects;
    }
}
