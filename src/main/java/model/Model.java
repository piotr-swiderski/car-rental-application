package model;

import javax.persistence.*;

@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "generation")
    private String generation;

    @Column(name = "photo_directory")
    private String photoDirectory;

    @Column(name = "type")
    private String type;

    @Column(name = "seats_number")
    private int seatsNumber;

    @Column(name = "doors_number")
    private int doorsNumber;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "equipment_version")
    private EquipmentVersion equipmentVersion;

    public Model(String name, String generation, String photoDirectory, String type, EquipmentVersion equipmentVersion) {
        this.name = name;
        this.generation = generation;
        this.photoDirectory = photoDirectory;
        this.type = type;
        this.equipmentVersion = equipmentVersion;
    }

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getPhotoDirectory() {
        return photoDirectory;
    }

    public void setPhotoDirectory(String photoDirectory) {
        this.photoDirectory = photoDirectory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EquipmentVersion getEquipmentVersion() {
        return equipmentVersion;
    }

    public void setEquipmentVersion(EquipmentVersion equipmentVersion) {
        this.equipmentVersion = equipmentVersion;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }
}
