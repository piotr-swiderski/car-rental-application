package dao.impl;

import dao.AbstractDao;
import dao.EquipmentVersionDao;
import hibernate.util.HibernateUtil;
import model.EquipmentVersion;
import javax.persistence.TypedQuery;

public class EquipmentVersionDaoImpl extends AbstractDao implements EquipmentVersionDao {
    @Override
    public void saveEquipmentVersion(EquipmentVersion equipmentVersion) {
        hibernateUtil.save(equipmentVersion);
    }

    @Override
    public void deleteEquipmentVersion(long equipmentVersionId) {
        hibernateUtil.delete(EquipmentVersion.class, equipmentVersionId);
    }

    @Override
    public EquipmentVersion getEquipmentVersionByName(String name) {
        TypedQuery<EquipmentVersion> query = entityManager.createQuery("select e from EquipmentVersion e where e.EquipmentVersionEnum = :name", EquipmentVersion.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
