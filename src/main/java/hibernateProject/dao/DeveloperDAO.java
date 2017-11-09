package hibernateProject.dao;

import hibernateProject.dao.InterfacesDAO.IDeveloperDAO;
import hibernateProject.model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperDAO implements IDeveloperDAO {

    private SessionFactory sessionFactory;
    private AbstractDAO abstractDAO = new AbstractDAO();

    public DeveloperDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer create(Developer developer) {
        return  abstractDAO.createAbstract(developer, sessionFactory);
    }

    public Developer readById(Integer id) {
        Session session = sessionFactory.openSession();
        Developer model1 = session.get(Developer.class, id);
        if (model1!=null) {
            System.out.println("Developer " + model1);
            return model1;
        }else {
            System.out.println("There are not such developer");
        }
        session.close();
        return null;
    }

    public void update(Developer developer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developerDB = new Developer();
        developerDB = session.get(Developer.class, developer.getId());
        if (developerDB!=null){
            developerDB.setFirstName(developer.getFirstName());
            developerDB.setSecondName(developer.getSecondName());
            developerDB.setSalary(developer.getSalary());
            developerDB.setSkills(developer.getSkills());
            session.update(developerDB);
            transaction.commit();
            System.out.println("Developer " + developer + " was updated");
        }
        session.close();
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developerDB = new Developer();
        developerDB = session.get(Developer.class, id);
        if (developerDB!=null){
            session.delete(developerDB);
            transaction.commit();
            System.out.println("Developer " + developerDB + " was deleted");
        }else {
            System.out.println("There is not such developer");
        }
        session.close();
    }

    public List<Developer> readAll() {
        Session session = sessionFactory.openSession();
        List<Developer> developers = session.createQuery("from Developer ").list();
        session.close();
        System.out.println(developers);
        return developers;
    }
}
