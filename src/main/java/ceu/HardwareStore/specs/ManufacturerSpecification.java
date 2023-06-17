package ceu.HardwareStore.specs;

import org.springframework.data.jpa.domain.Specification;

import ceu.HardwareStore.entities.Manufacturer;

public class ManufacturerSpecification extends GenericSpecification<Manufacturer> {

    public static Specification<Manufacturer> id(int id) {
        return equal("id", id);
    }

    public static Specification<Manufacturer> name(String name) {
        return equal("name", name);
    }

    public static Specification<Manufacturer> nameLike(String name) {
        return like("name", name);
    }

}
