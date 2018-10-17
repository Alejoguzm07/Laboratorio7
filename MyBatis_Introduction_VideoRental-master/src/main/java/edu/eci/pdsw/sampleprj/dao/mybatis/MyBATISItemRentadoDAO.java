package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;


public class MyBATISItemRentadoDAO implements ItemRentadoDAO {
	  @Inject
	  private ClienteMapper clienteMapper;
	  @Inject
	  private ItemMapper itemMapper;
	  @Override
	  public void save(ItemRentado it) throws PersistenceException{
	  try{
		  clienteMapper.agregarItemRentadoACliente(it.getId(), it.getItem().getId(), it.getFechainiciorenta(), it.getFechafinrenta());
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al registrar el ItemRentado "+it.toString(),e);
	  }        

	  }

	  @Override
	  public ItemRentado load(int id) throws PersistenceException {
	  try{
	      return clienteMapper.consultarItemRentado(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el ItemRentado "+id,e);
	  }


	  }



	@Override
	public List<ItemRentado> ietmsDisponibles() throws PersistenceException {
		//toca verificar este with my primix
		try{
			return clienteMapper.consultarItemsRentados();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el ItemRentado ",e);
		  }
	}

	@Override
	public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException {
		try {
			return itemMapper.multa(iditem, fechaDevolucion);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el la multa de alquieler del item "+iditem,e);
		  }
		
	}
}
