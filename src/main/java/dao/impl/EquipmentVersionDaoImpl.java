package dao.impl;

import dao.EquipmentVersionDao;
import hibernate.util.HibernateUtil;
import model.EquipmentVersion;
import javax.persistence.TypedQuery;

public class EquipmentVersionDaoImpl extends HibernateUtil implements EquipmentVersionDao {
    @Override
    public void saveEquipmentVersion(EquipmentVersion equipmentVersion) {
        save(equipmentVersion);
    }

    @Override
    public void deleteEquipmentVersion(long equipmentVersionId) {
        delete(EquipmentVersion.class, equipmentVersionId);
    }

    @Override
    public EquipmentVersion getEquipmentVersionByName(String name) {
        TypedQuery<EquipmentVersion> query = getEntityManager().createQuery("select e from EquipmentVersion e where e.EquipmentVersionEnum = :name", EquipmentVersion.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
