package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory managerFactory = Persistence
            .createEntityManagerFactory("loja");

    public static EntityManager createEntityManager(){
        return managerFactory.createEntityManager();
    }
}
