package com.revature.services;

import java.util.List;

import com.revature.daos.SodaDAO;
import com.revature.daos.SodaDAOImpl;
import com.revature.models.Soda;

public class SodaService {

	private SodaDAO sodaDao = new SodaDAOImpl();
	
	// CREATE
	public void createNewSoda(Soda soda) {
		sodaDao.createSoda(soda);
	}
	
	// READ all
	public List<Soda> getAllSoda(){
		return sodaDao.displayAllSoda();
	}
	
	// READ by id
	public List<Soda> getSodabyId(Soda soda) {
		return sodaDao.displaySodaById(soda);
	}
	
	// UPDATE 
	public void updateSodaInfo(Soda soda) {
		sodaDao.changeSodaInfo(soda);
	}
	
	// DELETE
	public void removeSoda(Soda soda) {
		sodaDao.deleteSoda(soda);
	}
	
	
}
