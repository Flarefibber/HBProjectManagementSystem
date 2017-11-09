package hibernateProject.fabrica;

import hibernateProject.controller.*;

public class HibernateFactoryController {
    private static CompanyController companiesController;

    private static CustomerController customersController;

    private static DeveloperController developersController;

    private static ProjectController projectsController;

    private static SkillController skillsController;

    public static CompanyController getCompanyController() {
        if (companiesController == null) {
            companiesController = new CompanyController(HibernateFactoryDAO.getCompanyDAO());
        }
        return companiesController;
    }

    public static CustomerController getCustomersController() {
        if (customersController == null) {
            customersController = new CustomerController(HibernateFactoryDAO.getCustomerDAO());
        }
        return customersController;
    }

    public static DeveloperController getDevelopersController() {
        if (developersController == null) {
            developersController = new DeveloperController(HibernateFactoryDAO.getDeveloperDAO());
        }
        return developersController;
    }

    public static ProjectController getProjectsController() {
        if (projectsController == null) {
            projectsController = new ProjectController(HibernateFactoryDAO.getProjectDAO());
        }
        return projectsController;
    }

    public static SkillController getSkillsController() {
        if (skillsController == null) {
            skillsController = new SkillController(HibernateFactoryDAO.getSkillDAO());
        }
        return skillsController;
    }
}

