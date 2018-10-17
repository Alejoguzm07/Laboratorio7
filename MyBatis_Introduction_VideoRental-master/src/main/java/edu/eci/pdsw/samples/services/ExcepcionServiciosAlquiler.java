package edu.eci.pdsw.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception {

	public ExcepcionServiciosAlquiler(String string, PersistenceException ex) {
		// TODO Auto-generated constructor stub
	}

    public ExcepcionServiciosAlquiler(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
