package inventory.dao;

import inventory.model.InventoryObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAOImpl implements InventoryDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<InventoryObject> allObjects() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from InventoryObject").list();
    }

    @Override
    public void add(InventoryObject object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
    }

    @Override
    public void delete(InventoryObject object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

    @Override
    public void edit(InventoryObject object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public InventoryObject getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(InventoryObject.class, id);
    }
}