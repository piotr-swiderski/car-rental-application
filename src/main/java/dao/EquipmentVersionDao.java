package dao;

import model.EquipmentVersion;

public interface EquipmentVersionDao {

    void saveEquipmentVersion(EquipmentVersion equipmentVersion);

    void deleteEquipmentVersion(long equipmentVersionId);

    EquipmentVersion getEquipmentVersionByName(String name);

}
