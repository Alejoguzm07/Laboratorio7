package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.Item;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("id")int id);
    
    public void insertarItem(@Param("item")Item it);
    public List<Item> consultarItemsDisponibles();
    
    public long calcularValorMulta(@Param("itemID") int id);
    public long multa(@Param("itemID")int id,@Param("devolucion")Date fechaDevolucion);
    public long consultarCostoAlquiler(@Param("itemID")int iditem, @Param("numDias")int numdias);

	public void actualizarTarifaItem(@Param("itemID")int id, @Param("tarifa")long tarifa);
        
}
