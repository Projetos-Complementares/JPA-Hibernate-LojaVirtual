package dao;

import lombok.AllArgsConstructor;
import models.CategoryItem;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class CategoriaDao {
    private EntityManager manager;

    public void insert(CategoryItem category){
        this.manager.persist(category);
    }

    public void update(CategoryItem categoryItem){this.manager.merge(categoryItem);}

    public void remove(CategoryItem categoryItem){
        categoryItem = manager.merge(categoryItem);
        this.manager.remove(categoryItem);
    }

    public CategoryItem findById(long id){ return manager.find(CategoryItem.class, id);}

    public List<CategoryItem> findAll(){
        String jpql = "SELECT item FROM CategoryItem item";
        return manager.createQuery(jpql, CategoryItem.class).getResultList();
    }

    public List<CategoryItem> findByName(String name){
        String jpql = "SELECT item FROM CategoryItem item WHERE item.category = :name";
        return manager.createQuery(jpql, CategoryItem.class)
                .setParameter("name", name)
                .getResultList();
    }
}
