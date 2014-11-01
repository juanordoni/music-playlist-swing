package br.com.dbs.java.mps.model.dao;

import java.util.List;

/**
 *
 * @author Juan Ordoni
 */
public interface GenericDao  <T> {
    
    void adiciona(T entidade);
    void atualiza(T entidade);
    void remove(T entidade);
    
    List<T> lista();
    
    T pesquisaPorId(Long id);
}
