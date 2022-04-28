package pizzayolo.util;

import java.util.ArrayList;
import java.util.List;

import pizzayolo.dao.DAOBoisson;
import pizzayolo.dao.DAODessert;
import pizzayolo.dao.DAOIngredient;
import pizzayolo.dao.DAORecette;
import pizzayolo.entity.PlanSalle;

public class Context {

	private static Context instance;
	private List<PlanSalle> tableLibre =new ArrayList();
	private List<PlanSalle> tablePrise =new ArrayList();
	
	private DAOIngredient daoIngredient = new DAOIngredient();
	private DAORecette daoRecette = new DAORecette();
	private DAOBoisson daoBoisson = new DAOBoisson();
	private DAODessert daoDessert = new DAODessert();
	
	private Context() {}



	public static Context getInstance() {
		if (instance==null) 
		{
			instance = new Context();
		}
		return instance;
	}


	public List<PlanSalle> getTableLibre() {
		return tableLibre;
	}


	public void setTableLibre(List<PlanSalle> tableLibre) {
		this.tableLibre = tableLibre;
	}


	public List<PlanSalle> getTablePrise() {
		return tablePrise;
	}


	public void setTablePrise(List<PlanSalle> tablePrise) {
		this.tablePrise = tablePrise;
	}


	public DAOIngredient getDaoIngredient() {
		return daoIngredient;
	}


	public void setDaoIngredient(DAOIngredient daoIngredient) {
		this.daoIngredient = daoIngredient;
	}


	public static void setInstance(Context instance) {
		Context.instance = instance;
	}

	
	public DAORecette getDaoRecette() {
		return daoRecette;
	}


	public void setDaoRecette(DAORecette daoRecette) {
		this.daoRecette = daoRecette;
	}





	public DAOBoisson getDaoBoisson() {
		return daoBoisson;
	}



	public void setDaoBoisson(DAOBoisson daoBoisson) {
		this.daoBoisson = daoBoisson;
	}



	public DAODessert getDaoDessert() {
		return daoDessert;
	}



	public void setDaoDessert(DAODessert daoDessert) {
		this.daoDessert = daoDessert;
	}


}
