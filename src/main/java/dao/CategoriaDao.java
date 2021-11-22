package dao;

import lombok.AllArgsConstructor;
import models.CategoryItem;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class CategoriaDao {
    private EntityManager manager;

    public void insert(CategoryItem category){
        this.manager.persist(category);
    }

    public void update(CategoryItem categoryItem){this.manager.merge(categoryItem);}
}
