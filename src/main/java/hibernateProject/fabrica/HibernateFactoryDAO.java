package hibernateProject.fabrica;

import hibernateProject.dao.*;
import hibernateProject.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryDAO {
    private static SessionFactory sessionFactory;

    private static CompanyDAO companiesDAO;

    private static CustomerDAO customersDAO;

    private static DeveloperDAO developersDAO;

    private static ProjectDAO projectsDAO;

    private static SkillDAO skillsDAO;

    private HibernateFactoryDAO() {
    }

    public static SessionFactory getSessionFactory() {
        if ((sessionFactory == null) || (sessionFactory.isClosed())) {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Developer.class)
                    .addAnnotatedClass(Project.class)
                    .addAnnotatedClass(Skill.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
    public static CompanyDAO getCompanyDAO() {
        if (companiesDAO == null) {
            companiesDAO = new CompanyDAO(getSessionFactory());
        }
        return companiesDAO;
    }

    public static CustomerDAO getCustomerDAO() {
        if (customersDAO == null) {
            customersDAO = new CustomerDAO(getSessionFactory());
        }
        return customersDAO;
    }

    public static DeveloperDAO getDeveloperDAO() {
        if (developersDAO == null) {
            developersDAO = new DeveloperDAO(getSessionFactory());
        }
        return developersDAO;
    }

    public static ProjectDAO getProjectDAO() {
        if (projectsDAO == null) {
            projectsDAO = new ProjectDAO(getSessionFactory());
        }
        return projectsDAO;
    }

    public static SkillDAO getSkillDAO() {
        if (skillsDAO == null) {
            skillsDAO = new SkillDAO(getSessionFactory());
        }
        return skillsDAO;
    }
}
