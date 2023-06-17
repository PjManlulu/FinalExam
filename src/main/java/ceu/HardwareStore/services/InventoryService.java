package ceu.HardwareStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.HardwareStore.entities.Inventory;
import ceu.HardwareStore.forms.InventoryForm;
import ceu.HardwareStore.repositories.InventoryRepository;
import ceu.HardwareStore.specs.InventorySpecification;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    public Inventory getById(Integer id) {
        return inventoryRepository.findById(id).get();
    }

    public Inventory getByName(String name) {
        return inventoryRepository.findOne(InventorySpecification.name(name)).get();
    }

    public InventoryForm getForm(int id) {
        return new InventoryForm(getById(id));
    }

    public Inventory save(InventoryForm inventoryForm) {
        Inventory inventory = inventoryForm.getId() == null ? null : getById(inventoryForm.getId());
        return save(inventoryForm.toEntity(inventory));
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void delete(Integer id) {
        inventoryRepository.delete(getById(id));
    }

}
