package pizzayolo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pizzayolo.entity.Recette;

public class DAORecette implements IDAO<Recette,Integer>{

	@Override
	public Recette findById(Integer id) {
		Recette i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from recette where id=?");
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Recette(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public Recette findByNom(String nom) {      // <- pour chercher en recette un ingrediant � partir de son nom 
		Recette i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from recette where nom like ?");
			ps.setString(1,"%"+nom+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Recette(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
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
	public List<Recette> findAll() {
		List<Recette> recettes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from recette");
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Recette i = new Recette(rs.getInt("id"),rs.getString("nom"),rs.getDouble("prixM"));
				recettes.add(i);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recettes;
	}

	@Override
	public void insert(Recette i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT into recette (nom,prixM,prixL,prixXL) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,i.getNom());
			ps.setDouble(2,i.getPrixM());
			ps.setDouble(3,i.getPrixL());
			ps.setDouble(4,i.getPrixXL());
			
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
	public void update(Recette i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);	
			PreparedStatement ps = conn.prepareStatement("UPDATE recette set nom=? where id=?");
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM recette where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
				
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
