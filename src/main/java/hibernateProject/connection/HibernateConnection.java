package hibernateProject.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConnection {

    private SessionFactory sessionFactory;

    public SessionFactory getInstance() {
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
