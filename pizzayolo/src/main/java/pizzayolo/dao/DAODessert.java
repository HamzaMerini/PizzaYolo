package pizzayolo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pizzayolo.entity.Dessert;

public class DAODessert implements IDAO<Dessert,Integer>{

	@Override
	public Dessert findById(Integer id) {
		Dessert i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from dessert where id=?");
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Dessert(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public Dessert findByNom(String nom) {      // <- pour chercher en dessert un ingrediant � partir de son nom 
		Dessert i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from dessert where nom like ?");
			ps.setString(1,"%"+nom+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Dessert(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	
	
	@Override
	public List<Dessert> findAll() {
		List<Dessert> desserts = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from dessert");
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Dessert i = new Dessert(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
				desserts.add(i);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desserts;
	}

	@Override
	public void insert(Dessert i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT into dessert (nom,prix) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			
			//ps.setInt(1,i.getId());
			ps.setString(1,i.getNom());
			ps.setDouble(2,i.getPrix());
			
			ps.executeUpdate();
			
//			ResultSet rs = ps.getGeneratedKeys();
//			if(rs.next()) 
//			{
//				i.setId(rs.getInt(1));
//			}
//			
				
			ps.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Dessert i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);	
			PreparedStatement ps = conn.prepareStatement("UPDATE dessert set nom=? where id=?");
			ps.setString(1,i.getNom());
			ps.setInt(2,i.getId());
			
			ps.executeUpdate();
				
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM dessert where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
				
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
