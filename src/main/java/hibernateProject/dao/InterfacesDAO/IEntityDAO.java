package hibernateProject.dao.InterfacesDAO;

import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public interface IEntityDAO<T, ID extends Serializable> {

    ID create (T entity);
    T readById(ID id);
    void update(T entity);
    void delete(ID id);
    List<T> readAll();
}
