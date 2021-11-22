package tests;

import dao.CategoriaDao;
import models.CategoryItem;
import dao.ProdutoDao;
import util.JPAUtil;
import models.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastraProduto {
    public static void main(String[] args) {
        CategoryItem category = new CategoryItem();
        category.setCategory("CELULARES");

        Produto celular = new Produto();
        celular.setNome("Motorola G7");
        celular.setDescricao("Otimas configurações");
        celular.setPreco(new BigDecimal("1249"));
        celular.setCategory(category);

        EntityManager manager = JPAUtil.createEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(manager);
        CategoriaDao categoriaDao = new CategoriaDao(manager);

        manager.getTransaction().begin();
        categoriaDao.insert(category);
        produtoDao.inserir(celular);
        manager.getTransaction().commit();
        manager.close();
    }
}
