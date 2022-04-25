
package pizzayolo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import pizzayolo.dao.DAOBoisson;
import pizzayolo.dao.DAODessert;
import pizzayolo.dao.DAOIngredient;
import pizzayolo.dao.DAOLienR;
import pizzayolo.dao.DAORecette;
import pizzayolo.entity.Food;
import pizzayolo.entity.PlanSalle;
import pizzayolo.entity.Taille;
import pizzayolo.entity.TypePate;
import pizzayolo.util.Context;

public class Test {
	
	static DAOIngredient daoIngredient = Context.getInstance().getDaoIngredient();
	static DAORecette daoRecette = Context.getInstance().getDaoRecette();
	static DAOBoisson daoBoisson = Context.getInstance().getDaoBoisson();
	static DAODessert daoDessert = Context.getInstance().getDaoDessert();
	static DAOLienR daoLienR = Context.getInstance().getDaoLienR();
	
	
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}


	public static void ouvrirSalle() {
		Collections.addAll(Context.getInstance().getTableLibre(),PlanSalle.Emporte,PlanSalle.TableSalle1, PlanSalle.TableSalle2, PlanSalle.TableSalle3,PlanSalle.TableSalle4,PlanSalle.TableSalle5);
		
	}
	public static void ouvrirTerasse() {
		Collections.addAll(Context.getInstance().getTablePrise(),PlanSalle.TableTerrasse1, PlanSalle.TableTerrasse2, PlanSalle.TableTerrasse3,PlanSalle.TableTerrasse4 );
	}
	
	public static void creerPizza () {
		List<Food> listeDesSupp= new ArrayList(); 
		String choixTailleString = saisieString("Quelle taille?(Medium,Large,XL)");
		Taille choixTaille=Taille.valueOf(choixTailleString);
		String choixPateString = saisieString("Quelle pate?(Classique,Fine,Pan,MozzaCrust)");
		TypePate choixPate = TypePate.valueOf(choixPateString);
		RecettePizza.afficherMenu();
		String choixRecette = saisieString("Quelle pizza?");
	    String choixSupp = saisieString("Voulez vous ajouter des suppl�ments? (o/n)");
	    while (choixSupp.equals("o"))
	    {
			for (Food i: daoIngredient.findAll())
                {
	 
 	       		System.out.println(i);
 	       		}
			String ingChoisi=saisieString("Quel ingredient voulez-vous ajouter?");
			Food i = daoIngredient.findByNom(ingChoisi);  // utiliser DAO findByNom pour r�cup�rer l'objet i en fonction de la saisie
			listeDesSupp.add(i);
			choixSupp = saisieString("Voulez vous ajouter d'autres suppl�ments? (o/n)");
		}
	}
	
	
	
	
	
	public static void main(String[] args) {

//		Collections.addAll(RecettePizza.listeBase,RecettePizza.SauceTomate,RecettePizza.CremeFraiche,RecettePizza.SauceBBQ);
//		Collections.addAll(RecettePizza.listeIngredient,RecettePizza.Mozzarella,RecettePizza.Ananas,RecettePizza.Bacon,RecettePizza.Boeuf,RecettePizza.Champignons,RecettePizza.Chevre,RecettePizza.Chorizo,RecettePizza.Emmental,RecettePizza.Fourme,RecettePizza.Jambon,RecettePizza.Kebab,RecettePizza.Lardons,RecettePizza.Merguez,RecettePizza.Miel,RecettePizza.Oignons,RecettePizza.Olives,RecettePizza.Origan,RecettePizza.Pepperoni,RecettePizza.Poivrons,RecettePizza.Poulet,RecettePizza.Patate,RecettePizza.Piments,RecettePizza.Raclette,RecettePizza.Reblochon,RecettePizza.Saumon,RecettePizza.Tomates,RecettePizza.Thon);
		
//		RecettePizza.listeBase=daoBase.findAll();
//		RecettePizza.listeIngredient=daoIngredient.findAll();
//		
//		System.out.println(RecettePizza.listeBase);
//		System.out.println(RecettePizza.listeIngredient);
//		
		/*
		daoIngredient.insert(RecettePizza.SauceTomate);
		daoIngredient.insert(RecettePizza.CremeFraiche);
		daoIngredient.insert(RecettePizza.SauceBBQ);
		daoIngredient.insert(RecettePizza.Ananas);
		daoIngredient.insert(RecettePizza.Bacon);
		daoIngredient.insert(RecettePizza.Boeuf);
		daoIngredient.insert(RecettePizza.Champignons);
		daoIngredient.insert(RecettePizza.Chevre);
		daoIngredient.insert(RecettePizza.Chorizo);
		daoIngredient.insert(RecettePizza.Emmental);
		daoIngredient.insert(RecettePizza.Fourme);
		daoIngredient.insert(RecettePizza.Jambon);
		daoIngredient.insert(RecettePizza.Kebab);
		daoIngredient.insert(RecettePizza.Lardons);
		daoIngredient.insert(RecettePizza.Merguez);
		daoIngredient.insert(RecettePizza.Miel);
		daoIngredient.insert(RecettePizza.Mozzarella);
		daoIngredient.insert(RecettePizza.Oignons);
		daoIngredient.insert(RecettePizza.Olives);
		daoIngredient.insert(RecettePizza.Origan);
		daoIngredient.insert(RecettePizza.Patate);
		daoIngredient.insert(RecettePizza.Pepperoni);
		daoIngredient.insert(RecettePizza.Piments);
		daoIngredient.insert(RecettePizza.Poivrons);
		daoIngredient.insert(RecettePizza.Poulet);
		daoIngredient.insert(RecettePizza.Raclette);
		daoIngredient.insert(RecettePizza.Reblochon);
		daoIngredient.insert(RecettePizza.Saumon);
		daoIngredient.insert(RecettePizza.Tomates);
		daoIngredient.insert(RecettePizza.Thon);
		*/
				
		
		
		
		
		/*
//LES BONS PLANS
		daoRecette.insert(RecettePizza.marga());
		daoRecette.insert(RecettePizza.claJambon());
		daoRecette.insert(RecettePizza.claPepperoni());
		daoRecette.insert(RecettePizza.claMerguez());
		
		
//LES INCONTOURNABLES
		daoRecette.insert(RecettePizza.hawJambon());
		daoRecette.insert(RecettePizza.hawPoulet());
		daoRecette.insert(RecettePizza.reine());
		daoRecette.insert(RecettePizza.orientale());
		daoRecette.insert(RecettePizza.steakEtChesse());
		
//LES SUPREMES		
		daoRecette.insert(RecettePizza.baconGroovy());
		daoRecette.insert(RecettePizza.bellacho());
		daoRecette.insert(RecettePizza.cannibale());
		daoRecette.insert(RecettePizza.chevreMiel());
		daoRecette.insert(RecettePizza.deluxe());
		daoRecette.insert(RecettePizza.diavolaB());
		daoRecette.insert(RecettePizza.diavolaP());
		daoRecette.insert(RecettePizza.divinefro());
		daoRecette.insert(RecettePizza.extravaganzza());
		daoRecette.insert(RecettePizza.forestiere());
		daoRecette.insert(RecettePizza.hypnotika());
		daoRecette.insert(RecettePizza.indienne());
		daoRecette.insert(RecettePizza.kebab());
		daoRecette.insert(RecettePizza.pecheur());
		daoRecette.insert(RecettePizza.peppina());
		daoRecette.insert(RecettePizza.qFro());
		daoRecette.insert(RecettePizza.raclette());
		daoRecette.insert(RecettePizza.racletteMiel());
		daoRecette.insert(RecettePizza.saumoneta());
		daoRecette.insert(RecettePizza.savoyarde());
		daoRecette.insert(RecettePizza.sKebab());
		*/
		
		
		
///AJOUT lien recette ingredient		
/*
		daoLienR.insert(daoRecette.findByNom("Margherita"),RecettePizza.marga().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Classique Jambon"),RecettePizza.claJambon().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Classique Merguez"),RecettePizza.claMerguez().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Classique Pepperoni"),RecettePizza.claPepperoni().getListeIngre());
			
		daoLienR.insert(daoRecette.findByNom("Hawa�enne Jambon"),RecettePizza.hawJambon().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Hawa�enne Poulet"),RecettePizza.hawPoulet().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Reine"),RecettePizza.reine().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Orientale"),RecettePizza.orientale().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Steak & Cheese"),RecettePizza.steakEtChesse().getListeIngre());
		
		daoLienR.insert(daoRecette.findByNom("Bacon Groovy"),RecettePizza.baconGroovy().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Bellacho"),RecettePizza.bellacho().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Cannibale"),RecettePizza.cannibale().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Ch�vre-Miel"),RecettePizza.chevreMiel().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Deluxe"),RecettePizza.deluxe().getListeIngre());

		daoLienR.insert(daoRecette.findByNom("Diavola Boeuf"),RecettePizza.diavolaB().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Diavola Pepperoni"),RecettePizza.diavolaP().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Divine 3 Fromages"),RecettePizza.divinefro().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Extravaganza"),RecettePizza.extravaganzza().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Foresti�re"),RecettePizza.forestiere().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Hypnotika"),RecettePizza.hypnotika().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Indienne"),RecettePizza.indienne().getListeIngre());
		
		daoLienR.insert(daoRecette.findByNom("Urban Kebab"),RecettePizza.kebab().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("P�cheur"),RecettePizza.pecheur().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Peppina"),RecettePizza.peppina().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("4 Fromages"),RecettePizza.qFro().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Authentique Raclette"),RecettePizza.raclette().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Surprenante Raclette-Miel"),RecettePizza.racletteMiel().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Saumoneta"),RecettePizza.saumoneta().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Savoyarde"),RecettePizza.savoyarde().getListeIngre());
		daoLienR.insert(daoRecette.findByNom("Samoura� Kebab"),RecettePizza.sKebab().getListeIngre());

		*/
		
		
//AJOUT DES BOISSONS 
		/*
		daoBoisson.insert(RecettePizza.cocaC);
		daoBoisson.insert(RecettePizza.cocaB);
		daoBoisson.insert(RecettePizza.cocaZC);
		daoBoisson.insert(RecettePizza.cocaZB);
		daoBoisson.insert(RecettePizza.cocaCC);
		daoBoisson.insert(RecettePizza.cocaCB);
		daoBoisson.insert(RecettePizza.fantaC);
		daoBoisson.insert(RecettePizza.fantaB);
		daoBoisson.insert(RecettePizza.spriteC);
		daoBoisson.insert(RecettePizza.spriteB);
		daoBoisson.insert(RecettePizza.oasisC);
		daoBoisson.insert(RecettePizza.oasisB);
		daoBoisson.insert(RecettePizza.fuzeteaC);
		daoBoisson.insert(RecettePizza.fuzeteaB);
		daoBoisson.insert(RecettePizza.badoit);
		daoBoisson.insert(RecettePizza.evian);
		*/
		

//AJOUT DES Desserts 
		
		daoDessert.insert(RecettePizza.GlaceCookiep);
		daoDessert.insert(RecettePizza.GlaceCookieg);
		daoDessert.insert(RecettePizza.GlaceChocop);
		daoDessert.insert(RecettePizza.GlaceChocog);
		daoDessert.insert(RecettePizza.GlaceVanillep);
		daoDessert.insert(RecettePizza.GlaceVanilleg);
		daoDessert.insert(RecettePizza.GlaceCaramel);
		daoDessert.insert(RecettePizza.Moelleux);
		daoDessert.insert(RecettePizza.Beignets);
		daoDessert.insert(RecettePizza.ChocoB);
		
		
		
		
		
		
//		Recette maPizza = RecettePizza.orientale();
//		Pizza p=new Pizza(maPizza,Taille.Medium,TypePate.MozzaCrust);
//		System.out.println(p);
//		
//		RecettePizza.modifierRecette(maPizza);
//		Recette r=RecettePizza.creerRecette();
//		System.out.println(r);
//		
//		p=new Pizza(r,Taille.Medium,TypePate.MozzaCrust);
//		System.out.println(p);
		/*
		maPizza=RecettePizza.reine();
		p=new Pizza(maPizza,Taille.Large,TypePate.Classique);
		System.out.println(p);
		
		maPizza=RecettePizza.qFro();
		p=new Pizza(maPizza,Taille.XL,TypePate.Fine);
		System.out.println(p);
		
		maPizza=RecettePizza.diavolaB();
		p=new Pizza(maPizza,Taille.Medium,TypePate.Pan);
		System.out.println(p);*/
		//creerPizza();
		









	}
	
}