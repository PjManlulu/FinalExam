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

import ceu.HardwareStore.entities.Inventory;
import ceu.HardwareStore.forms.InventoryForm;
import ceu.HardwareStore.services.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String index(Model model) {
        List<Inventory> inventories = inventoryService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("inventories", inventories);
        return "/views/inventory/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("inventoryForm", new InventoryForm());
        return "/views/inventory/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        InventoryForm inventoryForm = inventoryService.getForm(id);
        model.addAttribute("inventoryForm", inventoryForm);
        return "/views/inventory/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        inventoryService.delete(id);
        return String.format("redirect:/%s", "inventory");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute InventoryForm inventoryForm) {
        inventoryService.save(inventoryForm);
        return String.format("redirect:/%s", "inventory");
    }

}
