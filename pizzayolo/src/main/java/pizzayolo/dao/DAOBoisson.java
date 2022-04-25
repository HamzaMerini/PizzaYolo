package pizzayolo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pizzayolo.entity.Boisson;

public class DAOBoisson implements IDAO<Boisson,Integer>{

	@Override
	public Boisson findById(Integer id) {
		Boisson i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from boisson where id=?");
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Boisson(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public Boisson findByNom(String nom) {      // <- pour chercher en boisson un ingrediant � partir de son nom 
		Boisson i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from boisson where nom like ?");
			ps.setString(1,"%"+nom+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Boisson(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
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
	public List<Boisson> findAll() {
		List<Boisson> boissons = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from boisson");
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Boisson i = new Boisson(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
				boissons.add(i);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boissons;
	}

	@Override
	public void insert(Boisson i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT into boisson (nom,prix) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			
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
	public void update(Boisson i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);	
			PreparedStatement ps = conn.prepareStatement("UPDATE boisson set nom=? where id=?");
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM boisson where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
				
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
