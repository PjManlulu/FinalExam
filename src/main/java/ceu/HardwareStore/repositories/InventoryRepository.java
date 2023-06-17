package ceu.HardwareStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ceu.HardwareStore.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>, JpaSpecificationExecutor<Inventory> {

    public Inventory findByNameOrderByIdAsc(String name);

}

