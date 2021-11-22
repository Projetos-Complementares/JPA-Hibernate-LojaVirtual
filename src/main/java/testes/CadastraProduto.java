package testes;

import Dao.ProdutoDao;
import Util.JPAUtil;
import models.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastraProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Motorola G7");
        celular.setDescricao("Otimas configurações");
        celular.setPreco(new BigDecimal("1249"));

        EntityManager manager = JPAUtil.createEntityManager();

        ProdutoDao dao = new ProdutoDao(manager);
        manager.getTransaction().begin();
        dao.inserir(celular);
        manager.getTransaction().commit();
        manager.close();
    }
}
