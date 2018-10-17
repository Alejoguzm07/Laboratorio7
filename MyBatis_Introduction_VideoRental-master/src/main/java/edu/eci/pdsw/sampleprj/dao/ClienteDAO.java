package edu.eci.pdsw.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ClienteDAO {

   public void save(Cliente cl) throws PersistenceException;

   public Cliente load(long documento) throws PersistenceException;
   public List<Cliente> consultarClientes() throws PersistenceException;
   public List<ItemRentado> consultarItemsCliente(long id) throws PersistenceException;
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException;
   public void registrarAlquilerCliente(ItemRentado it) throws PersistenceException;

   public void vetarCliente(long docu, boolean estado)throws PersistenceException;

}
