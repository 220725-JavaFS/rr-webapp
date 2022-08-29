package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Soda;
import com.revature.utils.ConnectionUtil;
import com.ricketts.daos.ObjectDAO;
import com.ricketts.daos.ObjectDAOImpl;
import com.ricketts.daos.TableDAO;
import com.ricketts.daos.TableDAOImpl;
import com.ricketts.mappers.Mapper;
import com.ricketts.mappers.SqlMapper;
import com.ricketts.models.Table;
import com.ricketts.services.OrmServices;

public class SodaDAOImpl implements SodaDAO {
	OrmServices orm = new OrmServices();
	Mapper m = new SqlMapper();
	
	@Override
	public void createSoda(Soda soda, Table table) {
		orm.begin("sodas", table);
		orm.create(soda, table);
	}
		
	@Override
	public void changeSodaInfo(Soda soda, Table table) {
		orm.begin("sodas", table);
		orm.update(soda, table);
		
	}

	@Override
	public void deleteSoda(Soda soda, Table table) {
		orm.begin("sodas", table);
		orm.delete(soda, table);
	}
	

	@Override
	public List<Soda> displayAllSoda(Table table) {
		orm.begin("sodas", table);
		try(Connection conn = ConnectionUtil.getConnection()){
			String selectAll = m.sqlSelectAllStmt(table);
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(selectAll);
			
			List<Soda> sodaList = new LinkedList <>();
			while(result.next()) { 
				Soda soda = new Soda(
					result.getInt("soda_id"),
					result.getString("brand"),
					result.getString("flavor"),
					result.getInt("quantity"),
					result.getDouble("ounces_per_can"),
					result.getDouble("price"));
			
				sodaList.add(soda);
			}
			return sodaList;
		}//try 
		catch(SQLException e) {
			e.printStackTrace();
		}//catch
		return null;
	}

	
	 public List<Soda> displaySodaById(Soda soda, Table table) {
		 orm.begin("sodas", table);
		try(Connection conn = ConnectionUtil.getConnection()){
			String selectById = m.sqlSelectByIdStmt(soda, table);
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(selectById);
			
			List<Soda> sList = new LinkedList <>();

			while(result.next()) { 
				Soda s = new Soda(
					result.getInt("soda_id"),
					result.getString("brand"),
					result.getString("flavor"),
					result.getInt("quantity"),
					result.getDouble("ounces_per_can"),
					result.getDouble("price"));
				sList.add(s);
			}
			return sList;
		}//try 
		catch(SQLException e) {
			e.printStackTrace();
		}//catch
		return null;
	}


	
	
	
}//class
