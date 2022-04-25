package pizzayolo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import pizzayolo.entity.Food;
import pizzayolo.entity.Recette;

public class DAOLienR {//implements IDAO<Recette,Integer>{

	String urlBdd="jdbc:mysql://localhost:3306/pizzayolo";
	String loginBdd="root";
	String passwordBdd="";
	
	
	public void insert(Recette r,List<Food> list) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			for(Food ing:list) {
				
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT into lien_recette_ingredient (Ingredient,idIngredient,idRecette,Recette) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
					
				ps.setString(1, ing.getLibelle());
				ps.setInt(2,ing.getId());//ingredient
				ps.setInt(3,r.getId());//recette
				ps.setString(4,r.getNom());
				
				ps.executeUpdate();
				ps.close();	

				conn.close();
			}

			
			
			
//			ResultSet rs = ps.getGeneratedKeys();
//			if(rs.next()) 
//			{
//				i.setId(rs.getInt(1));
//			}
//			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Recette findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Recette> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Recette o) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}



}
