package hibernateProject.dao;

import hibernateProject.dao.InterfacesDAO.ICustomerDAO;
import hibernateProject.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private SessionFactory sessionFactory;
    private AbstractDAO abstractDAO = new AbstractDAO();

    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer create(Customer customer) {
        return  abstractDAO.createAbstract(customer, sessionFactory);
    }

    public Customer readById(Integer id) {
        Session session = sessionFactory.openSession();
        Customer model1 = session.get(Customer.class, id);
        if (model1!=null) {
            System.out.println(model1);
            return model1;
        }else {
            System.out.println("There are not such customer");
        }
        session.close();
        return null;
    }

    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customerDB = new Customer();
        customerDB = session.get(Customer.class, customer.getId());
        if (customerDB!=null){
            customerDB.setCustomerName(customer.getCustomerName());
            customerDB.setProjects(customer.getProjects());
            session.update(customerDB);
            transaction.commit();
            System.out.println("Customer " + customer + " was updated");
        }
        session.close();
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customerDB = new Customer();
        customerDB = session.get(Customer.class, id);
        if (customerDB!=null){
            session.delete(customerDB);
            transaction.commit();
            System.out.println("Customer " + customerDB + " was deleted");
        }else {
            System.out.println("There is not such customer");
        }
        session.close();
    }

    public List<Customer> readAll() {
        Session session = sessionFactory.openSession();
        List customers = session.createQuery("from Customer ").list();
        session.close();
        System.out.println(customers);
        return customers;
    }
}
