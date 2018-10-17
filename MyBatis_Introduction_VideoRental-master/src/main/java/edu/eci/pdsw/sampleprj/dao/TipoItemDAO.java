package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.TipoItem;


public interface TipoItemDAO {
	
	   public void save(TipoItem ti) throws PersistenceException;

	   public TipoItem load(int id) throws PersistenceException;
	   public List<TipoItem> consultarTiposItem() throws PersistenceException;
}
