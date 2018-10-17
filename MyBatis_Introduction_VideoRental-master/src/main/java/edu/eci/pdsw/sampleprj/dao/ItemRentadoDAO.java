package edu.eci.pdsw.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	
	   public void save(ItemRentado ir) throws PersistenceException;

	   public ItemRentado load(int id) throws PersistenceException;
	   public List<ItemRentado> ietmsDisponibles() throws PersistenceException; //duda nose si esta vuelta debe ir en itemRentado o en item
	   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion)throws PersistenceException;

}
