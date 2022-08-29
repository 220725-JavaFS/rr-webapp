package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.daos.SodaDAO;
import com.revature.daos.SodaDAOImpl;
import com.revature.models.Soda;
import com.ricketts.models.Table;

public class SodaServiceTests {
	SodaService sodaService = mock(SodaService.class);
    Table table = mock(Table.class);
	Soda soda = mock(Soda.class);
	
	
	@Test
	public void verifyCreateMethod() {
		
	    sodaService.createNewSoda(soda, table);
	 
	    verify(sodaService, times(1)).createNewSoda(soda, table);;
	}
	@Test
	public void addThrowsForCreate() {

		Mockito.doThrow(NullPointerException.class)
		.when(sodaService).createNewSoda(null, table);

	}
	
	@Test
	public void verifyReadByIdMethod() {
		
	    sodaService.getSodabyId(soda, table);
	 
	    verify(sodaService, times(1)).getSodabyId(soda, table);;
	}
	@Test
	public void addThrowsForReadById() {

		Mockito.doThrow(NullPointerException.class)
		.when(sodaService).getSodabyId(null, table);

	}
	
	@Test
	public void verifyUpdateMethod() {
		
	    sodaService.updateSodaInfo(soda, table);
	 
	    verify(sodaService, times(1)).updateSodaInfo(soda, table);;
	}
	@Test
	public void addThrowsForUpdate() {

		Mockito.doThrow(NullPointerException.class)
		.when(sodaService).updateSodaInfo(null, table);

	}
	
	@Test
	public void verifyDeleteMethod() {
		
	    sodaService.removeSoda(soda, table);
	 
	    verify(sodaService, times(1)).removeSoda(soda, table);;
	}
	@Test
	public void addThrowsForDelete() {

		Mockito.doThrow(NullPointerException.class)
		.when(sodaService).removeSoda(null, table);

	}
}
