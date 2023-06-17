package ceu.HardwareStore.specs;

import org.springframework.data.jpa.domain.Specification;

import ceu.HardwareStore.entities.Category;

public class CategorySpecification extends GenericSpecification<Category> {

    public static Specification<Category> id(int id) {
        return equal("id", id);
    }

    public static Specification<Category> name(String name) {
        return equal("name", name);
    }

    public static Specification<Category> nameLike(String name) {
        return like("name", name);
    }

}
