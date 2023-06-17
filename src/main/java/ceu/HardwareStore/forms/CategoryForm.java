package ceu.HardwareStore.forms;

import ceu.HardwareStore.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {

    private Integer id;

    private String name;

    public CategoryForm(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Category toEntity(Category category) {
        if (category == null) {
            category = new Category();
        }

        category.setName(name);

        return category;
    }

}

