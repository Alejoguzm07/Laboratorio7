/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     * @throws ParseException 
     */
    public static void main(String args[]) throws SQLException, ParseException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        /*String string = "2018-02-15";
        String string2 = "2018-02-16";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(string);
        Date date2 = format.parse(string2);
        
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        
        
        System.out.println("PARTE 2 LABORATORIO MYBATIS");
        System.out.println();
        
        System.out.println("*-----------------------------------------------------*");
        System.out.println("Punto 1: consulta de clientes");
        System.out.println(cm.consultarClientes());
        System.out.println();
        
        
        System.out.println("*-----------------------------------------------------*");
        System.out.println("Punto 2:consulta de un cliente ");
        System.out.println(cm.consultarCliente(100));
        System.out.println();
        
        ItemMapper im=sqlss.getMapper(ItemMapper.class);
        TipoItem tipo= new TipoItem(3,"Juego");       
        Item it=new Item(tipo,2138459,"itemSinTipo","no tengo tipo :C", date, 154555255, "holi soy un formato", "no definido");
        
        
        System.out.println("*-----------------------------------------------------*");
        System.out.println("Punto 3: agregarItemRentado");
      //cm.agregarItemRentadoACliente(2, 45, date, date2);
        //cm.agregarItemRentadoACliente(100, 2138459, date, date2);
        System.out.println(im.consultarItem(2138459));
        
        System.out.println("*-----------------------------------------------------*");
        System.out.println("Punto 4:consultarItem");
        System.out.println(im.consultarItem(2138459));
        System.out.println();
      //im.insertarItem(it);
        System.out.println("*-----------------------------------------------------*");
        System.out.println("Punto 5 :modificacion de mapper");
        for(Item i: im.consultarItems()) {
        	System.out.println(i);
        	}
        System.out.println();
        System.out.println(im.consultarItem(2138459))
        System.out.println();
        String string = "5818-04-20";
         String string2 = "5818-04-28";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(string);
        Date date2 = format.parse(string2);
      
        ItemMapper im=sqlss.getMapper(ItemMapper.class);
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        TipoItemMapper tim=sqlss.getMapper(TipoItemMapper.class);  
        System.out.println(cm.consultarCliente(12345));
        System.out.println(".........................................................................................................");
        System.out.println(cm.consultarItemsRentados(12345));
        System.out.println(".........................................................................................................");
        System.out.println(cm.consultarClientes());
        System.out.println(".........................................................................................................");
        System.out.println(im.consultarItem(15));
        System.out.println(".........................................................................................................");
        System.out.println(im.consultarItemsDisponibles());
        System.out.println(".........................................................................................................");
        System.out.println(cm.consultarMultaAlquiler(1,date));
        System.out.println(".........................................................................................................");
        System.out.println(tim.getTipoItem(1));
        System.out.println(".........................................................................................................");
        System.out.println(tim.consultarTiposItem());
        System.out.println(".........................................................................................................");
        //cm.agregarItemRentadoACliente(12345, 2132219, date, date2);
        Cliente cliente= new Cliente("yowis", 2138459, "3188478818", "P Sherman Calle Wallaby 42 Sidney", "yowis@mail.com"); 
        //cm.insertarCliente(cliente);
        System.out.println(".........................................................................................................");
        System.out.println(im.consultarCostoAlquiler(1, 8));
        System.out.println(".........................................................................................................");
        TipoItem tipo= new TipoItem(3,"Juego");       
        Item it=new Item(tipo,2138458,"itemSinTipo","no tengo tipo :C", date, 154555255, "holi soy un formato", "no definido");
        //im.insertarItem(it);
        cm.vetarCliente(2138459, true);
        
        im.actualizarTarifaItem(15, 15000);*/
        String string = "5818-04-20";
        String string2 = "5818-04-28";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(string);
        Date date2 = format.parse(string2);
        TipoItem tipo= new TipoItem(3,"Juego");       
        Item it=new Item(tipo,2138458,"itemSinTipo","no tengo tipo :C", date, 154555255, "holi soy un formato", "no definido");
        Cliente cliente= new Cliente("yowis", 2138459, "3188478818", "P Sherman Calle Wallaby 42 Sidney", "yowis@mail.com");
        
        ServiciosAlquilerFactory alquiler = ServiciosAlquilerFactory.getInstance();
        ServiciosAlquiler servicio = alquiler.getServiciosAlquiler();
        System.out.println(".........................................................................................................");
        System.out.println("valorMultaRetrasoxDia");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.valorMultaRetrasoxDia(15));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarCliente");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarCliente(2138459));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarItemsCliente");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarItemsCliente(2132219));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarClientes");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarClientes());
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarItem");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarItem(15));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarItemsDisponibles");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarItemsDisponibles());
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarMultaAlquiler");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarMultaAlquiler(1, (java.sql.Date) date));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarTipoItem");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarTipoItem(1));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarTiposItem");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarTiposItem());
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("registrarAlquilerCliente");
        System.out.println(".........................................................................................................");
        try {
            servicio.actualizarTarifaItem(15, 0);
            //servicio.registrarAlquilerCliente((java.sql.Date) date,2132219,it,8);
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("registrarCliente");
        System.out.println(".........................................................................................................");
        try {
            servicio.actualizarTarifaItem(15, 0);
            //servicio.registrarCliente(cliente);
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("consultarCostoAlquiler");
        System.out.println(".........................................................................................................");
        try {
            System.out.println(servicio.consultarCostoAlquiler(1, 8));
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("actualizarTarifaItem");
        System.out.println(".........................................................................................................");
        try {
            servicio.actualizarTarifaItem(15, 15000);
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("registrarItem");
        System.out.println(".........................................................................................................");
        try {
            //servicio.registrarItem(it);
            servicio.actualizarTarifaItem(15, 15000);
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        System.out.println("vetarCliente");
        System.out.println(".........................................................................................................");
        try {
            //servicio.registrarItem(it);
            servicio.vetarCliente(2138459, true);
        } catch (ExcepcionServiciosAlquiler ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(".........................................................................................................");
        sqlss.commit();   
        sqlss.close();

        
        
    }


}
