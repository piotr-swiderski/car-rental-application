package model;

import javax.persistence.*;

@Entity
@Table(name = "equipment_version")
public class EquipmentVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "equipment_description")
    private String equipmentDescription;

    @Column(name = "equipment_name")
    private String EquipmentVersionEnum;

    public EquipmentVersion(String equipmentDescription, String equipmentName) {
        this.equipmentDescription = equipmentDescription;
        this.EquipmentVersionEnum = EquipmentVersionEnum;
    }

    public EquipmentVersion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public String getEquipmentName() {
        return EquipmentVersionEnum;
    }

    public void setEquipmentName(String equipmentName) {
        this.EquipmentVersionEnum = equipmentName;
    }
}
