package hibernateProject.controller;

import hibernateProject.dao.CustomerDAO;
import hibernateProject.model.Customer;
import hibernateProject.model.Project;
import java.util.HashSet;
import java.util.Set;

public class CustomerController extends ModelController{
    private final CustomerDAO dao;

    public CustomerController(CustomerDAO dao) {
        this.dao = dao;
    }

    @Override
    public void choiceOfMenu(int choice){
        int id;
        switch (choice){
            case 1: // create customer
                Customer customer = viewTotal.setCustomer();
                Set<Project> projects = new HashSet<Project>();
                while (viewTotal.choiceOfSetProject()==1){
                    projects.add(viewTotal.setProject());
                }
                customer.setProjects(projects);
                dao.create(customer);
                break;
            case 2: //read customer by id
                id = viewTotal.getId();
                dao.readById(id);
                break;
            case 3: // update customer
                customer = viewTotal.setCustomer();
                dao.update(customer);
                break;
            case 4: //delete customer
                id = viewTotal.getId();
                dao.delete(id);
                break;
            case 5: // read all customers
                dao.readAll();
                break;
            case 0:
                return;
        }
    }
}
