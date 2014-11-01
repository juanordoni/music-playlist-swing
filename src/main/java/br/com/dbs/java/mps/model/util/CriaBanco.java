package br.com.dbs.java.mps.model.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Ordoni
 */
public class CriaBanco {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = 
              Persistence.createEntityManagerFactory("playlistPU");
        
        emf.close();
        
    }
}
