package hibernateProject.dao;

import hibernateProject.dao.InterfacesDAO.ICompanyDAO;
import hibernateProject.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO implements ICompanyDAO {

    private SessionFactory sessionFactory;
    private AbstractDAO abstractDAO = new AbstractDAO();

    public CompanyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer create(Company company) {
        return  abstractDAO.createAbstract(company, sessionFactory);
    }

    public Company readById(Integer id) {
        Session session = sessionFactory.openSession();
        Company model1 = session.get(Company.class, id);
        if (model1!=null) {
            System.out.println(model1);
            return model1;
        }else {
            System.out.println("There are not such company");
        }
        session.close();
        return null;
    }

    public void update(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company companyDB = new Company();
        companyDB = session.get(Company.class, company.getId());
        if (companyDB!=null){
            companyDB.setCompanyName(company.getCompanyName());
            companyDB.setProjects(company.getProjects());
            session.update(companyDB);
            transaction.commit();
            System.out.println("Company " + company + " was updated");
        }
        session.close();
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company companyDB = new Company();
        companyDB = session.get(Company.class, id);
        if (companyDB!=null){
            session.delete(companyDB);
            transaction.commit();
            System.out.println("Company " + companyDB + " was deleted");
        }else {
            System.out.println("There is not such company");
        }
        session.close();
    }

    public List<Company> readAll() {
        Session session = sessionFactory.openSession();
        List<Company> companies = session.createQuery("from Company ").list();
        session.close();
        System.out.println(companies);
        return companies;
    }
}
