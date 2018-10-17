package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISClienteDAO implements ClienteDAO{

  @Inject
  private ClienteMapper clienteMapper;    

  @Override
  public void save(Cliente cl) throws PersistenceException{
  try{
      clienteMapper.insertarCliente(cl);
      for(int i =0; i < cl.getRentados().size();i++) {
    	  ItemRentado ir = cl.getRentados().get(i);
    	  clienteMapper.agregarItemRentadoACliente(ir.getId(), ir.getItem().getId(), ir.getFechainiciorenta(), ir.getFechafinrenta());
      }
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el clienete "+cl.toString(),e);
  }        

  }
	@Override
	public List<ItemRentado> consultarItemsCliente(long id) throws PersistenceException {
		try{
			return clienteMapper.consultarItemsRentados(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el ItemRentado "+id,e);
		  }
		
	}

  @Override
  public Cliente load(long documento) throws PersistenceException {
  try{
      return clienteMapper.consultarCliente(documento);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el cliente "+documento,e);
  }


  }

@Override
public List<Cliente> consultarClientes() throws PersistenceException {
	try{
	      return clienteMapper.consultarClientes();
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar los clientes",e);
	  }
}
@Override
public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException {
	try{
	      return clienteMapper.consultarMultaAlquiler(iditem, fechaDevolucion);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar los clientes",e);
	  }
}
@Override
public void registrarAlquilerCliente(ItemRentado it) throws PersistenceException {
	try{
	      clienteMapper.registrarAlquilerCliente(it);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar los clientes",e);
	  }
	
}
@Override
public void vetarCliente(long docu, boolean estado) throws PersistenceException {
	try{
	      clienteMapper.vetarCliente(docu,estado);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar los clientes",e);
	  }
	
}



  }
