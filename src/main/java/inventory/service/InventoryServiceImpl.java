package inventory.service;

import inventory.dao.InventoryDAO;
import inventory.model.InventoryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryDAO inventoryDAO;

    @Autowired
    public void setFilmServiceImpl(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Transactional
    @Override
    public List<InventoryObject> allObjects() {
        return inventoryDAO.allObjects();
    }

    @Transactional
    @Override
    public void add(InventoryObject object) {
        inventoryDAO.add(object);
    }

    @Transactional
    @Override
    public void delete(InventoryObject object) {
        inventoryDAO.delete(object);
    }

    @Transactional
    @Override
    public void edit(InventoryObject object) {
        inventoryDAO.edit(object);
    }

    @Transactional
    @Override
    public InventoryObject getById(int id) {
        return inventoryDAO.getById(id);
    }
}
