package inventory.dao;

import inventory.model.InventoryObject;

import java.util.List;


public interface InventoryDAO {
    List<InventoryObject> allObjects();
    void add(InventoryObject object);
    void delete(InventoryObject object);
    void edit(InventoryObject object);
    InventoryObject getById(int id);
}
