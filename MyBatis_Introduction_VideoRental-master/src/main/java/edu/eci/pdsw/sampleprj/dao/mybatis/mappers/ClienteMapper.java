package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli")long id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli")long id, 
    		@Param("idit")int idit, 
    		@Param("fechaini")Date fechainicio,
    		@Param("fechafin")Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    public void insertarCliente(@Param("cliente") Cliente cliente);
    public ItemRentado consultarItemRentado(@Param("id")int id);
    public List<ItemRentado> consultarItemsRentados();
    public List<ItemRentado> consultarItemsRentados(@Param("id")long id);
    public long consultarMultaAlquiler(@Param("iitem")int iditem,@Param("fechaDevolucion") Date fechaDevolucion);
    public void registrarAlquilerCliente(@Param("itemRentado")ItemRentado it);
    public void vetarCliente(@Param("id") long docu,@Param("estado") boolean estado);
	
}
