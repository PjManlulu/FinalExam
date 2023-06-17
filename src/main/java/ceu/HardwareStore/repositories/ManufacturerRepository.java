package ceu.HardwareStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ceu.HardwareStore.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>, JpaSpecificationExecutor<Manufacturer> {

    public Manufacturer findByNameOrderByIdAsc(String name);

}

