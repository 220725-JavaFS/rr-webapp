package com.revature.daos;

import java.util.List;

import com.revature.models.Soda;
import com.ricketts.models.Table;

public interface SodaDAO {
	
	// CREATE
	public abstract void createSoda(Soda soda, Table table);
	
	
	// READ
	List <Soda> displayAllSoda(Table table);
	
	public List <Soda> displaySodaById(Soda soda, Table table);
	
	
	// UPDATE
	
	public abstract void changeSodaInfo(Soda soda, Table table);
	
	
	// DELETE

	public abstract void deleteSoda(Soda soda, Table table);
}
