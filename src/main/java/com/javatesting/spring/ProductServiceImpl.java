/**
 * 
 */
package com.javatesting.spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
   private static Map<Integer, ModelClass> ModelClassRepo = new HashMap<>();
   static {
      ModelClass honey = new ModelClass();
      honey.setId(1);
      honey.setName("Honey");
      ModelClassRepo.put(honey.getId(), honey);

      ModelClass almond = new ModelClass();
      almond.setId(2);
      almond.setName("Almond");
      ModelClassRepo.put(almond.getId(), almond);
   }
   
   @Override
   public void createProduct(ModelClass modelClass) {
      ModelClassRepo.put(modelClass.getId(), modelClass);
      System.out.println("New model class has created !" + modelClass.getName());
   }
   
   @Override
   public void updateProduct(Integer id, ModelClass modelClass) {
      ModelClassRepo.remove(id);
      modelClass.setId(id);
      ModelClassRepo.put(id, modelClass);
   }
   
   @Override
   public void deleteProduct(Integer id) {
      ModelClassRepo.remove(id);

   }
   @Override
   public Collection<ModelClass> getProducts() {
      return ModelClassRepo.values();
   }
}