package hibernateProject.dao;

import hibernateProject.model.IModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AbstractDAO {

    public Integer createAbstract(IModel model, SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (Integer) session.save(model);
        transaction.commit();
        session.close();
        System.out.println("Entity was created");
        return id;
    }
}
