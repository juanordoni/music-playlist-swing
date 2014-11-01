package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.dao.GenericDao;
import br.com.dbs.java.mps.model.util.JPAUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Juan Ordoni
 */
public class GenericDaoHibernate <T> implements GenericDao<T>{
     
    private Class <T> ClassePersistente;
    
    public GenericDaoHibernate(){
        ClassePersistente = getTypeClass();
    }
    
    
    private Class <T> getTypeClass(){
        ParameterizedType type = 
                (ParameterizedType) getClass().getGenericSuperclass();
        
        Type[] types = type.getActualTypeArguments();
        Class <T> classe = (Class<T>) types[0];
        return classe;
    }
    
    @Override
    public void adiciona(T entidade) {
        EntityManager em = JPAUtil.createEntityManager();
        
        try {
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();        
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally{
            JPAUtil.cloeEntityaManager();
        }
    }

    @Override
    public void atualiza(T entidade) {
      EntityManager em = JPAUtil.createEntityManager();
      
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            JPAUtil.cloeEntityaManager();
        }
    }

    @Override
    public void remove(T entidade) {
      EntityManager em = JPAUtil.createEntityManager();
      
        try {
            em.getTransaction().begin();
            em.remove(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            JPAUtil.cloeEntityaManager();
        } 
    }

    @Override
    public List<T> lista() {
        
    }

    @Override
    public T pesquisaPorId(Long id) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
           T objeto = em.find(ClassePersistente, id);
           return objeto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            JPAUtil.cloeEntityaManager();
        }
    }
     
}
