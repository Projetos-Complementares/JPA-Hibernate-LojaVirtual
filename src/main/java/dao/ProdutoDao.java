package dao;

import lombok.AllArgsConstructor;
import models.Produto;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class ProdutoDao {
    private EntityManager manager;

    public void inserir(Produto produto){
        this.manager.persist(produto);
    }

    public void update(Produto produto){ this.manager.merge(produto);}
}
