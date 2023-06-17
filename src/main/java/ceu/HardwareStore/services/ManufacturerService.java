package ceu.HardwareStore.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.HardwareStore.entities.Manufacturer;
import ceu.HardwareStore.forms.ManufacturerForm;
import ceu.HardwareStore.repositories.ManufacturerRepository;
import ceu.HardwareStore.specs.ManufacturerSpecification;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getById(Integer id) {
        return manufacturerRepository.findById(id).get();
    }

    public Manufacturer getByName(String name) {
        return manufacturerRepository.findOne(ManufacturerSpecification.name(name)).get();
    }

    public ManufacturerForm getForm(int id) {
        return new ManufacturerForm(getById(id));
    }

    public Manufacturer save(ManufacturerForm manufacturerForm) {
        Manufacturer manufacturer = manufacturerForm.getId() == null ? null : getById(manufacturerForm.getId());
        return save(manufacturerForm.toEntity(manufacturer));
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public void delete(Integer id) {
        manufacturerRepository.delete(getById(id));
    }

}