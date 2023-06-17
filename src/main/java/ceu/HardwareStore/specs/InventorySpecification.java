package ceu.HardwareStore.specs;

import org.springframework.data.jpa.domain.Specification;

import ceu.HardwareStore.entities.Inventory;

public class InventorySpecification extends GenericSpecification<Inventory> {

    public static Specification<Inventory> id(int id) {
        return equal("id", id);
    }

    public static Specification<Inventory> name(String name) {
        return equal("name", name);
    }

    public static Specification<Inventory> nameLike(String name) {
        return like("name", name);
    }

}