package ceu.HardwareStore.forms;

import ceu.HardwareStore.entities.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerForm {

    private Integer id;

    private String name;

    public ManufacturerForm(Manufacturer manufacturer) {
        this.id = manufacturer.getId();
        this.name = manufacturer.getName();
    }

    public Manufacturer toEntity(Manufacturer manufacturer) {
        if (manufacturer == null) {
            manufacturer = new Manufacturer();
        }

        manufacturer.setName(name);

        return manufacturer;
    }

}
