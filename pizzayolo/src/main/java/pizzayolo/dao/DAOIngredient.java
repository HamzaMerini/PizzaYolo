package pizzayolo.dao;

import java.util.List;

import pizzayolo.entity.Food;

public class DAOIngredient implements IDAO<Food, Integer> {

	@Override
	public Food findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Food o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Food update(Food o) {
		return o;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public Food findByNom(String ingChoisi) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Food> findByRecette(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
