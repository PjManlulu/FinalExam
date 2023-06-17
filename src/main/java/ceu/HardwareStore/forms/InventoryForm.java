package ceu.HardwareStore.forms;

import ceu.HardwareStore.entities.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryForm {

    private Integer id;

    private String name;

    private int stock;

    private int price;

    private Integer categoryId;

    private Integer manufacturerId;

    public InventoryForm(Inventory inventory) {
        this.id = inventory.getId();
        this.name = inventory.getName();
        this.stock = inventory.getStock();
        this.price = inventory.getPrice();
    }

    public Inventory toEntity(Inventory inventory) {
        if (inventory == null) {
            inventory = new Inventory();
        }

        inventory.setName(name);
        inventory.setStock(stock);
        inventory.setPrice(price);

        return inventory;
    }

}
