package ceu.HardwareStore.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> {

    public static <T> Specification<T> equal(String field, int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(field), value);
    }

    public static <T> Specification<T> equal(String field, String value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(field), value);
    }

    public static <T> Specification<T> lessThanOrEqualTo(String field, int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(field), value);
    }

    public static <T> Specification<T> greaterThanOrEqualTo(String field, int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(field), value);
    }

    public static <T> Specification<T> lessThan(String field, int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(field), value);
    }

    public static <T> Specification<T> greaterThan(String field, int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(field), value);
    }

    public static <T> Specification<T> like(String field, String value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(field), "%" + value + "%");
    }

}
