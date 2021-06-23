package inventory.model;

import javax.persistence.*;


@Entity
@Table(name = "inventory_objects")
public class InventoryObject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "inventory_number")
    private int inventory_number;

    @Column(name = "serial")
    private String serial;

    @Column(name = "description")
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventory_number() {
        return inventory_number;
    }

    public void setInventory_number(int inventoryNumber) {
        this.inventory_number = inventoryNumber;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
