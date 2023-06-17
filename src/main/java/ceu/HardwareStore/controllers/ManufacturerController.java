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

import ceu.HardwareStore.entities.Manufacturer;
import ceu.HardwareStore.forms.ManufacturerForm;
import ceu.HardwareStore.services.ManufacturerService;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public String index(Model model) {
        List<Manufacturer> manufacturers = manufacturerService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("manufacturers", manufacturers);
        return "/views/manufacturer/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("manufacturerForm", new ManufacturerForm());
        return "/views/manufacturer/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        ManufacturerForm manufacturerForm = manufacturerService.getForm(id);
        model.addAttribute("manufacturerForm", manufacturerForm);
        return "/views/manufacturer/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        manufacturerService.delete(id);
        return String.format("redirect:/%s", "manufacturer");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ManufacturerForm manufacturerForm) {
        manufacturerService.save(manufacturerForm);
        return String.format("redirect:/%s", "manufacturer");
    }

}
