package hibernateProject.controller;

import hibernateProject.fabrica.HibernateFactoryController;
import hibernateProject.fabrica.HibernateFactoryDAO;

public class MainController extends AbstractController{
    private final CompanyController companyController;

    private final CustomerController customerController;

    private final DeveloperController developerController;

    private final ProjectController projectController;

    private final SkillController skillController;

    public MainController() {
        this.companyController = HibernateFactoryController.getCompanyController();
        this.customerController = HibernateFactoryController.getCustomersController();
        this.developerController = HibernateFactoryController.getDevelopersController();
        this.projectController = HibernateFactoryController.getProjectsController();
        this.skillController = HibernateFactoryController.getSkillsController();
    }
    @Override
    protected void choiceOfMenu(int menuNumber) {
        switch (menuNumber) {
            case 1:
                this.companyController.startMenu();
                break;
            case 2:
                this.customerController.startMenu();
                break;
            case 3:
                this.developerController.startMenu();
                break;
            case 4:
                this.projectController.startMenu();
                break;
            case 5:
                this.skillController.startMenu();
                break;
            default:
                System.exit(0);
        }
    }
}

