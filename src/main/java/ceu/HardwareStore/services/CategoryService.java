package ceu.HardwareStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.HardwareStore.entities.Category;
import ceu.HardwareStore.forms.CategoryForm;
import ceu.HardwareStore.repositories.CategoryRepository;
import ceu.HardwareStore.specs.CategorySpecification;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public Category getByName(String name) {
        return categoryRepository.findOne(CategorySpecification.name(name)).get();
    }

    public CategoryForm getForm(int id) {
        return new CategoryForm(getById(id));
    }

    public Category save(CategoryForm categoryForm) {
        Category category = categoryForm.getId() == null ? null : getById(categoryForm.getId());
        return save(categoryForm.toEntity(category));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Integer id) {
        categoryRepository.delete(getById(id));
    }

}
