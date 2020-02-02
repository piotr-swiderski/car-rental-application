package dao;

import model.Model;
import java.util.Set;

public interface ModelDao {

    void saveModel(Model model);

    Set<Model> getModelByType(String type);

    Set<Model> getModelByName(String name);

    Set<Model> getAllModels();


}
