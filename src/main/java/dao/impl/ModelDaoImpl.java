package dao.impl;

import dao.ModelDao;
import hibernate.util.HibernateUtil;
import model.Model;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

public class ModelDaoImpl extends HibernateUtil implements ModelDao {
    @Override
    public void saveModel(Model model) {
        save(model);
    }

    @Override
    public Set<Model> getModelByType(String type) {
        TypedQuery<Model> query = getEntityManager().createQuery("select m from Model m where m.type = :type", Model.class);
        query.setParameter("type", type);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Set<Model> getModelByName(String name) {
        TypedQuery<Model> query = getEntityManager().createQuery("select m from Model m where m.name = :name", Model.class);
        query.setParameter("name", name);
        return new HashSet<>(query.getResultList());
    }


    @Override
    public Set<Model> getAllModels() {
        TypedQuery<Model> query = getEntityManager().createQuery("select m from Model m", Model.class);
        return new HashSet<>(query.getResultList());
    }
}
