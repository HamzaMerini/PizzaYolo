package pizzayolo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pizzayolo.entity.Base;
import pizzayolo.entity.Food;
import pizzayolo.entity.Ingredient;

public class DAOIngredient implements IDAO<Food,Integer>{

	@Override
	public Food findById(Integer id) {
		Food i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from ingredient where id=?");
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				i = new Ingredient(rs.getString("nom"), rs.getDouble("prix M"));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public Food findByNom(String nom) {      // <- pour chercher en base un ingrediant � partir de son nom 
		Food i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from ingredient where libelle like ?");
			ps.setString(1,"%"+nom+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				if(rs.getString("type").equals("Ingredient"))
				{
					i = new Ingredient(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixSupM"));
				}
				else {
					i = new Base(rs.getInt("id"),rs.getString("libelle"));
				}
			}

			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	
	
	
	public List<Food> findByRecette(Integer id){
		List<Food> listeF=new ArrayList();		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT Ingredient from lien_recette_ingredient where idRecette=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Food i = new Ingredient(rs.getString("Ingredient"));
				listeF.add(i);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listeF;
	}
	
	
	
	
	
	
	@Override
	public List<Food> findAll() {
		List<Food> ingredients = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from ingredient");
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Food i = new Ingredient(rs.getString("libelle"),rs.getDouble("prixSupM"));
				ingredients.add(i);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingredients;
	}

	@Override
	public void insert(Food i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT into ingredient (libelle,prixSupM,prixSupL,prixSupXL) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			//ps.setInt(1,i.getId());
			ps.setString(1,i.getLibelle());
			ps.setDouble(2,i.getPrixSupM());
			ps.setDouble(3,i.getPrixSupL());
			ps.setDouble(4,i.getPrixSupXL());
			
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
	public void update(Food i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);	
			PreparedStatement ps = conn.prepareStatement("UPDATE ingredient set prixSupM=?,prixSupL=?,prixSupXL=? where libelle=?");
			ps.setString(4,i.getLibelle());
			ps.setDouble(1,i.getPrixSupM());
			ps.setDouble(1,i.getPrixSupL());
			ps.setDouble(3,i.getPrixSupXL());
			//ps.setInt(4,i.getId());
			
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ingredient where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
				
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
