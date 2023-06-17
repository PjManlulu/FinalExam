package ceu.HardwareStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ceu.HardwareStore.entities.Category;
import ceu.HardwareStore.forms.CategoryForm;
import ceu.HardwareStore.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        List<Category> categories = categoryService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("categories", categories);
        return "/views/category/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("categoryForm", new CategoryForm());
        return "/views/category/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        CategoryForm categoryForm = categoryService.getForm(id);
        model.addAttribute("categoryForm", categoryForm);
        return "/views/category/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categoryService.delete(id);
        return String.format("redirect:/%s", "category");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CategoryForm categoryForm) {
        categoryService.save(categoryForm);
        return String.format("redirect:/%s", "category");
    }

}