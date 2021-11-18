import models.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastraProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Motorola G7");
        celular.setDescricao("Otimas configurações");
        celular.setPreco(new BigDecimal("1249"));

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(celular);
        manager.getTransaction().commit();
        manager.close();
    }
}
