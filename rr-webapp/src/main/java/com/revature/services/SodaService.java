package com.revature.services;

import java.util.List;

import com.revature.daos.SodaDAO;
import com.revature.daos.SodaDAOImpl;
import com.revature.models.Soda;
import com.ricketts.models.Table;

public class SodaService {
	
	private SodaDAO sodaDao = new SodaDAOImpl();
	
	// CREATE
	public void createNewSoda(Soda soda, Table table) {
		sodaDao.createSoda(soda, table);
	}
	
	// READ all
	public List<Soda> getAllSoda(Table table){
		return sodaDao.displayAllSoda(table);
	}
	
	// READ by id
	public List<Soda> getSodabyId(Soda soda, Table table) {
		return sodaDao.displaySodaById(soda, table);
	}
	
	// UPDATE 
	public void updateSodaInfo(Soda soda, Table table) {
		sodaDao.changeSodaInfo(soda, table);
	}
	
	// DELETE
	public void removeSoda(Soda soda, Table table) {
		sodaDao.deleteSoda(soda, table);
	}
	
	
}
