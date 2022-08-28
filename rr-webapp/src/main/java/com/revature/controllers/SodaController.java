package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Soda;
import com.revature.services.SodaService;

public class SodaController extends HttpServlet{
	
	SodaService sodaService = new SodaService();
	ObjectMapper objectMapper = new ObjectMapper();
	Soda soda = new Soda();
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		String URI = request.getRequestURI();
		System.out.println(URI);
		
		String[] urlSections = URI.split("/");
		
		if(urlSections.length==3) {
		
		
			List<Soda> list = sodaService.getAllSoda();
			
			String json = objectMapper.writeValueAsString(list);
			System.out.println(json);
			
			PrintWriter printWriter = response.getWriter();
			
			printWriter.print(json);
			
			response.setStatus(200);
			
			response.setContentType("application/json");
		}
		else if (urlSections.length==4) {
			try {
				soda.setSodaId(Integer.valueOf(urlSections[3]));
				
				List <Soda> list1 = sodaService.getSodabyId(soda);
				
				PrintWriter printWriter = response.getWriter();
				
				String json = objectMapper.writeValueAsString(list1);
				
				printWriter.print(json);
				response.setStatus(200);
				response.setContentType("application/json");
				
				} catch (NumberFormatException e) {
					response.setStatus(404);
					return;
			}
		}else {
			response.setStatus(404);
		}
		
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		StringBuilder sb = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		System.out.println(json);
		
		Soda soda = objectMapper.readValue(json, Soda.class);
				
		sodaService.createNewSoda(soda);
		
		response.setStatus(201);		
	}
	
	protected void doPut (HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		System.out.println(json);
		
		Soda soda = objectMapper.readValue(json, Soda.class);
				
		sodaService.updateSodaInfo(soda);
		
		response.setStatus(202);
		
	
	}
	
	
	protected void doDelete (HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		StringBuilder sb = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		System.out.println(json);
		
		Soda soda = objectMapper.readValue(json, Soda.class);
				
		sodaService.removeSoda(soda);
		
		response.setStatus(202);		
	}
	
	
	
	
}
