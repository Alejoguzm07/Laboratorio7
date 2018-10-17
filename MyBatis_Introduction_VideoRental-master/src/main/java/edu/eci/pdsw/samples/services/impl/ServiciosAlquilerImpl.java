package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private TipoItemDAO tipoItemDAO;
   @Inject
   private ItemDAO itemDAO;
   @Inject
   private ItemRentadoDAO itemRentadoDAO;
   @Inject
   private ClienteDAO clienteDAO;
   
   @Override
   public long valorMultaRetrasoxDia(int itemId) throws ExcepcionServiciosAlquiler {
	   try{
		return itemDAO.load(itemId).getTarifaxDia();
	   }catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el documento del cliente "+itemId,ex);
       }
   }

   @Override
   public Cliente consultarCliente(long documento) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.load(documento);
		   
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el documento del cliente "+documento,ex);
       }
       
       
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
       try {
    	   return clienteDAO.consultarItemsCliente(idcliente);
       }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el documento del cliente "+idcliente,ex);
       }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	   
	   try {
		   return clienteDAO.consultarClientes();
	   }
	   catch(PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar al consultar los clientes",ex);
	   }
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler {
	   try {
           return itemDAO.consultarItemsDisponibles();
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item ",ex);
       }
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {

	   try{
		   return clienteDAO.consultarMultaAlquiler(iditem, fechaDevolucion);
	   }catch(PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
	   try{
               return tipoItemDAO.load(id);
	   }catch(PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item "+id,ex);
	   }
	       
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
	   try{
		   return tipoItemDAO.consultarTiposItem();
	   }catch(PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	   try{
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, numdias);
                ItemRentado im=new ItemRentado(docu,item,date, (Date) calendar.getTime());
                clienteDAO.registrarAlquilerCliente(im);
	   }catch(PersistenceException ex) {
		throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
       try{
               clienteDAO.save(c);
	   }catch(PersistenceException ex) {
		throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
	   

   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       try{
               return itemDAO.consultarCostoAlquiler(iditem,numdias);
	   }catch(PersistenceException ex) {
		throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
	   
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
	   try{
           itemDAO.actualizarTarifaItem(id,tarifa);
	   }catch(PersistenceException ex) {
		throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
	   try {
		   itemDAO.save(i);
	   }catch(PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item "+ i.getTipo().getDescripcion(),ex);
	   }
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
	   try{
		   clienteDAO.vetarCliente(docu,estado);
	   }catch(PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar rl tipo item ",ex);
	   }
   }
}
