package hibernateProject.controller;

import hibernateProject.dao.CompanyDAO;
import hibernateProject.model.Company;
import hibernateProject.model.Project;

import java.util.HashSet;
import java.util.Set;

public class CompanyController extends ModelController{
    private final CompanyDAO dao;

    public CompanyController(CompanyDAO dao) {
        this.dao = dao;
    }

    @Override
    public void choiceOfMenu(int choice) {
        int id;
        switch (choice) {
            case 1: // create company
                Company company = viewTotal.setCompany();
                Set<Project> projects = new HashSet<Project>();
                while (viewTotal.choiceOfSetProject() == 1) {
                    projects.add(viewTotal.setProject());
                }
                company.setProjects(projects);
                dao.create(company);
                break;
            case 2: //read company by id
                id = viewTotal.getId();
                dao.readById(id);
                break;
            case 3: // update company
                company = viewTotal.setCompany();
                dao.update(company);
                break;
            case 4: //delete company
                id = viewTotal.getId();
                dao.delete(id);
                break;
            case 5: // read all companies
                dao.readAll();
                break;
            case 0:
                return;
        }
    }
}
