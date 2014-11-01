package br.com.dbs.java.mps.model.util;


import javassist.bytecode.stackmap.BasicBlock;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.annotations.FlushModeType;

public class JPAUtil {
    
    private static EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("playlistPU");
    
    private static EntityManager em;
    
    public static EntityManager createEntityManager(){
        
        if (em == null || !em.isOpen()){
            em = emf.createEntityManager();
        }
        return em;
    }
    public static boolean cloeEntityaManager(){
        try {
            em.close();
            return true;
        } catch (Exception e) {
          return false;
        }
    }
}
