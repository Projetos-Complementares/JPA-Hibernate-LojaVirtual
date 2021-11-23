package dao;

import lombok.AllArgsConstructor;
import models.Produto;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class ProdutoDao {
    private EntityManager manager;

    public void inserir(Produto produto){
        this.manager.persist(produto);
    }

    public void update(Produto produto){ this.manager.merge(produto);}

    public void remove(Produto produto){
        produto = manager.merge(produto);
        this.manager.remove(produto);
    }

    public Produto findById(long id){
        return manager.find(Produto.class, id);
    }

    public List<Produto> findAll(){
        String jpql = "SELECT p FROM Produto p";
        return manager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> findByCategory(String name){
        String jpql = "SELECT p FROM Produto p WHERE p.category.nome = :nome";
        return manager.createQuery(jpql, Produto.class)
                .setParameter("nome", name)
                .getResultList();
    }
}
