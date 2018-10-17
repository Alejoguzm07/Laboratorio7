package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISTipoItemDAO implements TipoItemDAO {
	@Inject
	  private TipoItemMapper tipoItemMapper;

	  @Override
	  public void save(TipoItem ti) throws PersistenceException{
	  try{
		  tipoItemMapper.addTipoItem(ti);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al registrar el TipoItem "+ti.toString(),e);
	  }        

	  }

	  @Override
	  public TipoItem load(int id) throws PersistenceException {
	  try{
	      return tipoItemMapper.getTipoItem(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el TipoItem "+id,e);
	  }

	  }

	@Override
	public List<TipoItem> consultarTiposItem() throws PersistenceException {
		try{
		      return tipoItemMapper.consultarTiposItem();
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el TipoItem ",e);
		  }
	}

}
