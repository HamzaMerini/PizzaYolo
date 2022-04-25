package pizzayolo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pizzayolo.dao.DAOIngredient;
import pizzayolo.entity.Dessert;
import pizzayolo.entity.Food;
import pizzayolo.entity.Recette;
import pizzayolo.util.Context;

/////MODIFIER FRAIS POUR LIVRAISON
public class RecettePizza {
	
	static DAOIngredient daoIngredient = Context.getInstance().getDaoIngredient();
	
	
	
	static Dessert GlaceCookiep=new Dessert("Cookie Dough - 100ml",2.95);
	static Dessert GlaceCookieg=new Dessert("Cookie Dough - 465ml",6.95);
	static Dessert GlaceChocop=new Dessert("Chocolate Fudge Brownie - 100ml",2.95);
	static Dessert GlaceChocog=new Dessert("Chocolate Fudge Brownie - 465ml",6.95);
	static Dessert GlaceVanillep=new Dessert("Vanilla Pecan Blondie - 100ml",2.95);
	static Dessert GlaceVanilleg=new Dessert("Vanilla Pecan Blondie - 465ml",6.95);
	static Dessert GlaceCaramel=new Dessert("Caramel Brownie Party - 465ml",6.95);
	
	static Dessert Moelleux=new Dessert("Moelleux au Chocolat",2.8);
	static Dessert Beignets=new Dessert("Mini Beignets Choco-Noisette",2.8);
	static Dessert ChocoB=new Dessert("ChocoBread",2.8);
	
	
	
	
	
	
	
	
	/*
	static Boisson cocaC=new Boisson("Coca Cola - 33cl",1.5);
	static Boisson cocaB=new Boisson("Coca Cola - 1.25L",2.5);
	static Boisson cocaZC=new Boisson("Coca Cola Z�ro - 33cl",1.5);
	static Boisson cocaZB=new Boisson("Coca Cola Z�ro - 1.25L",2.5);
	static Boisson cocaCC=new Boisson("Coca Cola Cherry - 33cl",1.5);
	static Boisson cocaCB=new Boisson("Coca Cola Cherry - 1.25L",2.5);
	static Boisson fantaC=new Boisson("Fanta Orange - 33cl",1.5);
	static Boisson fantaB=new Boisson("Fanta Orange - 1.5L",2.5);
	static Boisson spriteC=new Boisson("Sprite - 33cl",1.5);
	static Boisson spriteB=new Boisson("Sprite - 1.25L",2.5);
	static Boisson oasisC=new Boisson("Oasis Tropical - 33cl",1.5);
	static Boisson oasisB=new Boisson("Oasis Tropical - 2L",2.5);
	static Boisson fuzeteaC=new Boisson("Fuzetea P�che - 33cl",1.5);
	static Boisson fuzeteaB=new Boisson("Fuzetea P�che - 1.25L",2.5);
	static Boisson badoit=new Boisson("Badoit - 50cl",1.5);
	static Boisson evian=new Boisson("Evian - 50cl",1.5);
	*/
	
	
	
//	static Food SauceTomate=new Base("Sauce Tomate");
//	static Food CremeFraiche=new Base("Cr�me fra�che");
//	static Food SauceBBQ=new Base("Sauce BBQ");
//	static Food Mozzarella=new Ingredient("Mozzarella",2);
//	static Food Ananas=new Ingredient("Ananas",1.5);
//	static Food Bacon=new Ingredient("Bacon",2);
//	static Food Boeuf=new Ingredient("Boeuf",1.8);
//	static Food Champignons=new Ingredient("Champignons",1.3);
//	static Food Chevre=new Ingredient("Ch�vre",2);
//	static Food Chorizo=new Ingredient("Chorizo",2);
//	static Food Emmental=new Ingredient("Emmental",2);
//	static Food Fourme=new Ingredient("Fourme",2);
//	static Food Jambon=new Ingredient("Jambon",1.5);
//	static Food Kebab=new Ingredient("Kebab",2);
//	static Food Lardons=new Ingredient("Lardons",1.5);
//	static Food Merguez=new Ingredient("Merguez",1.5);
//	static Food Miel=new Ingredient("Miel",1.5);
//	static Food Oignons=new Ingredient("Oignons",1);
//	static Food Olives=new Ingredient("Olives",1.8);
//	static Food Origan=new Ingredient("Origan");
//	static Food Pepperoni=new Ingredient("Pepperoni",1.8);
//	static Food Poivrons=new Ingredient("Poivrons",1.5);
//	static Food Poulet=new Ingredient("Poulet",1.8);
//	static Food Patate=new Ingredient("Patate",1.3);
//	static Food Piments=new Ingredient("Piments",1);
//	static Food Raclette=new Ingredient("Raclette",2.5);
//	static Food Reblochon=new Ingredient("Reblochon",2.3);	
//	static Food Saumon=new Ingredient("Saumon",2.9);
//	static Food Tomates=new Ingredient("Tomates",1);
//	static Food Thon=new Ingredient("Thon",2.3);

	
	static Food SauceTomate=daoIngredient.findByNom("Sauce Tomate");
	static Food CremeFraiche=daoIngredient.findByNom("Creme Fraiche");
	static Food SauceBBQ=daoIngredient.findByNom("Sauce BBQ");
	static Food Mozzarella=daoIngredient.findByNom("Mozzarella");
	static Food Ananas=daoIngredient.findByNom("Ananas");
	static Food Bacon=daoIngredient.findByNom("Bacon");
	static Food Boeuf=daoIngredient.findByNom("Boeuf");
	static Food Champignons=daoIngredient.findByNom("Champignons");
	static Food Chevre=daoIngredient.findByNom("Chevre");
	static Food Chorizo=daoIngredient.findByNom("Chorizo");
	static Food Emmental=daoIngredient.findByNom("Emmental");
	static Food Fourme=daoIngredient.findByNom("Fourme");
	static Food Jambon=daoIngredient.findByNom("Jambon");
	static Food Kebab=daoIngredient.findByNom("Kebab");
	static Food Lardons=daoIngredient.findByNom("Lardons");
	static Food Merguez=daoIngredient.findByNom("Merguez");
	static Food Miel=daoIngredient.findByNom("Miel");
	static Food Oignons=daoIngredient.findByNom("Oignons");
	static Food Olives=daoIngredient.findByNom("Olives");
	static Food Origan=daoIngredient.findByNom("Origan");
	static Food Pepperoni=daoIngredient.findByNom("Pepperoni");
	static Food Poivrons=daoIngredient.findByNom("Poivrons");
	static Food Poulet=daoIngredient.findByNom("Poulet");
	static Food Patate=daoIngredient.findByNom("Patate");
	static Food Piments=daoIngredient.findByNom("Piments");
	static Food Raclette=daoIngredient.findByNom("Raclette");
	static Food Reblochon=daoIngredient.findByNom("Reblochon");	
	static Food Saumon=daoIngredient.findByNom("Saumon");
	static Food Tomates=daoIngredient.findByNom("Tomates");
	static Food Thon=daoIngredient.findByNom("Thon");
	
	
	
	
	static List<Food> listeBase=new ArrayList();
	static List<Food> listeIngredient=new ArrayList();
	static List<Food> listeNouvelleRecette=new ArrayList();
	

	
		//Les Bons Plans
	public static Recette marga() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(1); 
		//Collections.addAll(liste, SauceTomate,Mozzarella);
		Recette pizza=new Recette("Margherita",5.99,liste);
		return pizza;
	}  

	public static Recette claJambon() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(2); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Jambon);
		Recette pizza=new Recette("Classique Jambon",5.99,liste);
		return pizza;
	}  
	
	public static Recette claMerguez() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(3); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Merguez);
		Recette pizza=new Recette("Classique Merguez",5.99,liste);
		return pizza;
	}  
	
	public static Recette claPepperoni() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(4); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Pepperoni);
		Recette pizza=new Recette("Classique Pepperoni",5.99,liste);
		return pizza;
	}  


	//Les incontournables
	public static Recette hawJambon() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(5); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Ananas,Jambon);
		Recette pizza=new Recette("Hawa�enne Jambon",8,liste);
		return pizza;
	}  
	
	public static Recette hawPoulet() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(6); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Ananas,Poulet);
		Recette pizza=new Recette("Hawa�enne Poulet",8,liste);
		return pizza;
	}  
	

	public static Recette reine() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(7); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Jambon,Champignons);
		Recette pizza=new Recette("Reine",8,liste);
		return pizza;
	}  
	
	public static Recette orientale() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(8); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Poivrons,Oignons,Merguez);
		Recette pizza=new Recette("Orientale",8,liste);
		return pizza;
	}  
	
	public static Recette steakEtChesse() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(9); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Boeuf,Tomates,Origan);
		Recette pizza=new Recette("Steak & Cheese",8,liste);
		return pizza;
	}  
	
	
	
	//Les supremes
	
	public static Recette chickenDeLight() {
		List<Food> liste=new ArrayList();
		liste=daoIngredient.findByRecette(10); 
//		Collections.addAll(liste, SauceTomate,Mozzarella,Poulet,Oignons,Champignons,Poivrons,Tomates,Origan);
		Recette pizza=new Recette("Chicken Delight",9,liste);
		return pizza;
	}  
	
	public static Recette chevreMiel() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Chevre,Miel);
		Recette pizza=new Recette("Ch�vre-Miel",9,liste);
		return pizza;
	}  
	
	public static Recette kebab() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Kebab,Merguez,Oignons);
		Recette pizza=new Recette("Urban Kebab",9,liste);
		return pizza;
	}  
	
	public static Recette deluxe() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Boeuf,Champignons,Poivrons,Oignons);
		Recette pizza=new Recette("Deluxe",9,liste);
		return pizza;
	}  

	public static Recette pecheur() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Thon,Oignons,Olives);
		Recette pizza=new Recette("P�cheur",9,liste);
		return pizza;
	}  
	
	public static Recette indienne() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Champignons,Oignons,Poulet,Emmental);
		Recette pizza=new Recette("Indienne",9,liste);
		return pizza;
	}  
	
	public static Recette bellacho() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Chorizo,Merguez,Poivrons);
		Recette pizza=new Recette("Bellacho",9,liste);
		return pizza;
	}  

	public static Recette divinefro() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Oignons,Raclette,Emmental);
		Recette pizza=new Recette("Divine 3 Fromages",9,liste);
		return pizza;
	}  

	public static Recette hypnotika() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Poulet,Merguez,Champignons);
		Recette pizza=new Recette("Hypnotika",9,liste);
		return pizza;
	}  

	public static Recette diavolaB() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Boeuf,Piments,Oignons,Poivrons);
		Recette pizza=new Recette("Diavola Boeuf",9,liste);
		return pizza;
	}  

	public static Recette diavolaP() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Pepperoni,Piments,Oignons,Poivrons);
		Recette pizza=new Recette("Diavola Pepperoni",9,liste);
		return pizza;
	}  

	public static Recette sKebab() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Kebab,Oignons,Tomates);
		Recette pizza=new Recette("Samoura� Kebab",9,liste);
		return pizza;
	}  

	public static Recette peppina() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Oignons,Poivrons,Champignons,Tomates,Olives,Origan);
		Recette pizza=new Recette("Peppina",9,liste);
		return pizza;
	}  

	public static Recette raclette() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Patate,Bacon,Oignons,Raclette);
		Recette pizza=new Recette("Authentique Raclette",9,liste);
		return pizza;
	}  

	public static Recette racletteMiel() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Oignons,Boeuf,Raclette,Miel);
		Recette pizza=new Recette("Surprenante Raclette-Miel",9,liste);
		return pizza;
	}  

	public static Recette qFro() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Chevre,Fourme,Emmental);
		Recette pizza=new Recette("4 Fromages",9,liste);
		return pizza;
	}  

	public static Recette baconGroovy() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Bacon,Poulet,Oignons);
		Recette pizza=new Recette("Bacon Groovy",9,liste);
		return pizza;
	}  

	public static Recette cannibale() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceBBQ,Mozzarella,Poulet,Merguez,Boeuf);
		Recette pizza=new Recette("Cannibale",9,liste);
		return pizza;
	}  
	

	public static Recette saumoneta() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Patate,Oignons,Saumon);
		Recette pizza=new Recette("Saumoneta",9,liste);
		return pizza;
	}  

	public static Recette extravaganzza() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Jambon,Pepperoni,Boeuf,Oignons,Champignons,Poivrons,Olives);
		Recette pizza=new Recette("Extravaganza",9,liste);
		return pizza;
	}  
	
	public static Recette savoyarde() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Patate,Lardons,Reblochon,Origan);
		Recette pizza=new Recette("Savoyarde",9,liste);
		return pizza;
	}  

	public static Recette forestiere() {
		List<Food> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Jambon,Lardons,Oignons,Champignons,Origan);
		Recette pizza=new Recette("Foresti�re",9,liste);
		return pizza;
	}  
	
	public static void afficherMenu()
	{
		System.out.println(marga()+" Prix (M,L,XL):"+marga().getPrixM()+", "+marga().getPrixL()+", "+marga().getPrixXL());
		System.out.println(claJambon()+" Prix (M,L,XL):"+claJambon().getPrixM()+", "+claJambon().getPrixL()+", "+claJambon().getPrixXL()); 
		System.out.println(claMerguez()+" Prix (M,L,XL):"+claMerguez().getPrixM()+", "+claMerguez().getPrixL()+", "+claMerguez().getPrixXL());
		System.out.println(claPepperoni()+" Prix (M,L,XL):"+claPepperoni().getPrixM()+", "+claPepperoni().getPrixL()+", "+claPepperoni().getPrixXL());
		System.out.println(hawJambon()+" Prix (M,L,XL):"+hawJambon().getPrixM()+", "+hawJambon().getPrixL()+", "+hawJambon().getPrixXL());
		System.out.println(hawPoulet()+" Prix (M,L,XL):"+hawPoulet().getPrixM()+", "+hawPoulet().getPrixL()+", "+hawPoulet().getPrixXL());
		System.out.println(reine()+" Prix (M,L,XL):"+reine().getPrixM()+", "+reine().getPrixL()+", "+reine().getPrixXL());
		System.out.println(orientale()+" Prix (M,L,XL):"+orientale().getPrixM()+", "+orientale().getPrixL()+", "+orientale().getPrixXL());
		System.out.println(steakEtChesse()+" Prix (M,L,XL):"+steakEtChesse().getPrixM()+", "+steakEtChesse().getPrixL()+", "+steakEtChesse().getPrixXL());
		System.out.println(chickenDeLight()+" Prix (M,L,XL):"+chickenDeLight().getPrixM()+", "+chickenDeLight().getPrixL()+", "+chickenDeLight().getPrixXL());
		System.out.println(chevreMiel()+" Prix (M,L,XL):"+chevreMiel().getPrixM()+", "+chevreMiel().getPrixL()+", "+chevreMiel().getPrixXL());
		System.out.println(kebab()+" Prix (M,L,XL):"+kebab().getPrixM()+", "+kebab().getPrixL()+", "+kebab().getPrixXL());
		System.out.println(deluxe()+" Prix (M,L,XL):"+deluxe().getPrixM()+", "+deluxe().getPrixL()+", "+deluxe().getPrixXL());
		System.out.println(pecheur()+" Prix (M,L,XL):"+pecheur().getPrixM()+", "+pecheur().getPrixL()+", "+pecheur().getPrixXL());
		System.out.println(indienne()+" Prix (M,L,XL):"+indienne().getPrixM()+", "+indienne().getPrixL()+", "+indienne().getPrixXL());
		System.out.println(bellacho()+" Prix (M,L,XL):"+bellacho().getPrixM()+", "+bellacho().getPrixL()+", "+bellacho().getPrixXL());
		System.out.println(divinefro()+" Prix (M,L,XL):"+divinefro().getPrixM()+", "+divinefro().getPrixL()+", "+divinefro().getPrixXL());
		System.out.println(hypnotika()+" Prix (M,L,XL):"+hypnotika().getPrixM()+", "+hypnotika().getPrixL()+", "+hypnotika().getPrixXL());
		System.out.println(diavolaB()+" Prix (M,L,XL):"+diavolaB().getPrixM()+", "+diavolaB().getPrixL()+", "+diavolaB().getPrixXL());
		System.out.println(diavolaP()+" Prix (M,L,XL):"+diavolaP().getPrixM()+", "+diavolaP().getPrixL()+", "+diavolaP().getPrixXL());
		System.out.println(sKebab()+" Prix (M,L,XL):"+sKebab().getPrixM()+", "+sKebab().getPrixL()+", "+sKebab().getPrixXL());
		System.out.println(peppina()+" Prix (M,L,XL):"+peppina().getPrixM()+", "+peppina().getPrixL()+", "+peppina().getPrixXL());
		System.out.println(raclette()+" Prix (M,L,XL):"+raclette().getPrixM()+", "+raclette().getPrixL()+", "+raclette().getPrixXL());
		System.out.println(racletteMiel()+" Prix (M,L,XL):"+racletteMiel().getPrixM()+", "+racletteMiel().getPrixL()+", "+racletteMiel().getPrixXL());
		System.out.println(qFro()+" Prix (M,L,XL):"+qFro().getPrixM()+", "+qFro().getPrixL()+", "+qFro().getPrixXL());
		System.out.println(baconGroovy()+" Prix (M,L,XL):"+baconGroovy().getPrixM()+", "+baconGroovy().getPrixL()+", "+baconGroovy().getPrixXL());
		System.out.println(cannibale()+" Prix (M,L,XL):"+cannibale().getPrixM()+", "+cannibale().getPrixL()+", "+cannibale().getPrixXL());
		System.out.println(saumoneta()+" Prix (M,L,XL):"+saumoneta().getPrixM()+", "+saumoneta().getPrixL()+", "+saumoneta().getPrixXL());
		System.out.println(extravaganzza()+" Prix (M,L,XL):"+extravaganzza().getPrixM()+", "+extravaganzza().getPrixL()+", "+extravaganzza().getPrixXL());
		System.out.println(savoyarde()+" Prix (M,L,XL):"+savoyarde().getPrixM()+", "+savoyarde().getPrixL()+", "+savoyarde().getPrixXL());
		System.out.println(forestiere()+" Prix (M,L,XL):"+forestiere().getPrixM()+", "+forestiere().getPrixL()+", "+forestiere().getPrixXL());
		
		
	}
	public static void afficherIngredient() {
	    //System.out.println(SauceTomate+" Prix (M,L,XL):"+SauceTomate.getPrixSupM()+", "+SauceTomate.getPrixSupL()+", "+SauceTomate.getPrixSupXL());
		//System.out.println(CremeFraiche+" Prix (M,L,XL):"+CremeFraiche.getPrixSupM()+", "+CremeFraiche.getPrixSupL()+", "+CremeFraiche.getPrixSupXL());
		//System.out.println(SauceBBQ+"Prix (M,L,XL):"+SauceBBQ.getPrixSupM()+", "+SauceBBQ.getPrixSupL()+", "+SauceBBQ.getPrixSupXL());
		/*System.out.println(Mozzarella+" Prix (M,L,XL):"+Mozzarella.getPrixSupM()+", "+Mozzarella.getPrixSupL()+", "+Mozzarella.getPrixSupXL());
		System.out.println(Ananas+" Prix (M,L,XL):"+Ananas.getPrixSupM()+", "+Ananas.getPrixSupL()+", "+Ananas.getPrixSupXL());
		System.out.println(Bacon+" Prix (M,L,XL):"+Bacon.getPrixSupM()+", "+Bacon.getPrixSupL()+", "+Bacon.getPrixSupXL());
		System.out.println(Boeuf+" Prix (M,L,XL):"+Boeuf.getPrixSupM()+", "+Boeuf.getPrixSupL()+", "+Boeuf.getPrixSupXL());
		System.out.println(Champignons+" Prix (M,L,XL):"+Champignons.getPrixSupM()+", "+Champignons.getPrixSupL()+", "+Champignons.getPrixSupXL());
		System.out.println(Chevre+" Prix (M,L,XL):"+Chevre.getPrixSupM()+", "+Chevre.getPrixSupL()+", "+Chevre.getPrixSupXL());
		System.out.println(Chorizo+" Prix (M,L,XL):"+Chorizo.getPrixSupM()+", "+Chorizo.getPrixSupL()+", "+Chorizo.getPrixSupXL());
		System.out.println(Emmental+" Prix (M,L,XL):"+Emmental.getPrixSupM()+", "+Emmental.getPrixSupL()+", "+Emmental.getPrixSupXL());
		System.out.println(Fourme+" Prix (M,L,XL):"+Fourme.getPrixSupM()+", "+Fourme.getPrixSupL()+", "+Fourme.getPrixSupXL());
		System.out.println(Jambon+" Prix (M,L,XL):"+Jambon.getPrixSupM()+", "+Jambon.getPrixSupL()+", "+Jambon.getPrixSupXL());
		System.out.println(Kebab+" Prix (M,L,XL):"+Kebab.getPrixSupM()+", "+Kebab.getPrixSupL()+", "+Kebab.getPrixSupXL());
		System.out.println(Lardons+" Prix (M,L,XL):"+Lardons.getPrixSupM()+", "+Lardons.getPrixSupL()+", "+Lardons.getPrixSupXL());
		System.out.println(Merguez +" Prix (M,L,XL):"+Merguez.getPrixSupM()+", "+Merguez.getPrixSupL()+", "+Merguez.getPrixSupXL());
		System.out.println(Miel+" Prix (M,L,XL):"+Miel.getPrixSupM()+", "+Miel.getPrixSupL()+", "+Miel.getPrixSupXL());
		System.out.println(Oignons" Prix (M,L,XL):"+Oignons.getPrixSupM()+", "+Oignons.getPrixSupL()+", "+Oignons.getPrixSupXL());
		System.out.println(Olives " Prix (M,L,XL):"+Olives.getPrixSupM()+", "+Olives.getPrixSupL()+", "+Olives.getPrixSupXL());
		System.out.println(Origan" Prix (M,L,XL):"+Origan.getPrixSupM()+", "+Origan.getPrixSupL()+", "+Origan.getPrixSupXL());
		System.out.println(Pepperoni" Prix (M,L,XL):"+Pepperoni.getPrixSupM()+", "+Pepperoni.getPrixSupL()+", "+Pepperoni.getPrixSupXL());
		System.out.println(Poivrons" Prix (M,L,XL):"+Poivrons.getPrixSupM()+", "+Poivrons.getPrixSupL()+", "+Poivrons.getPrixSupXL());
		System.out.println(Poulet" Prix (M,L,XL):"+Poulet.getPrixSupM()+", "+Poulet.getPrixSupL()+", "+Poulet.getPrixSupXL());
		System.out.println(Patate" Prix (M,L,XL):"+Patate.getPrixSupM()+", "+Patate".getPrixSupL()+", "+Patate".getPrixSupXL());
		System.out.println(Piments" Prix (M,L,XL):"+Piments.getPrixSupM()+", "+Piments.getPrixSupL()+", "+Piments.getPrixSupXL());
		System.out.println(Raclette" Prix (M,L,XL):"+Raclette.getPrixSupM()+", "+Raclette.getPrixSupL()+", "+Raclette.getPrixSupXL());
		System.out.println(Reblochon" Prix (M,L,XL):"+Reblochon.getPrixSupM()+", "+Reblochon.getPrixSupL()+", "+Reblochon.getPrixSupXL());
		System.out.println(Saumon" Prix (M,L,XL):"+Saumon.getPrixSupM()+", "+Saumon.getPrixSupL()+", "+Saumon.getPrixSupXL());
		System.out.println(Tomates" Prix (M,L,XL):"+Tomates.getPrixSupM()+", "+Tomates.getPrixSupL()+", "+Tomates.getPrixSupXL());
		System.out.println(Thon" Prix (M,L,XL):"+Thon.getPrixSupM()+", "+Thon.getPrixSupL()+", "+Thon.getPrixSupXL());*/
		for (Food i : daoIngredient.findAll() )
		{
			System.out.println(i.getLibelle()+", Prix(M,L,XL): "+i.getPrixSupM()+", "+i.getPrixSupL()+", "+i.getPrixSupXL());
		}
		
	}
	
	
		public static Food choisirIngredient(){
			int choix=Test.saisieInt("Choisir un ingr�dient :");
			switch(choix){
			case 1: return Mozzarella;
			case 2: return Ananas;
			case 3: return Bacon;
			case 4: return Boeuf;
			case 5: return Champignons;
			case 6: return Chevre;
			case 7: return Chorizo;
			case 8: return Emmental;
			case 9: return Fourme;
			case 10: return Jambon;
			case 11: return Kebab;
			case 12: return Lardons;
			case 13: return Merguez;
			case 14: return Miel;
			case 15: return Oignons;
			case 16: return Olives;
			case 17: return Origan;
			case 18: return Pepperoni;
			case 19: return Poivrons;
			case 20: return Poulet;
			case 21: return Patate;
			case 22: return Piments;
			case 23: return Raclette;
			case 24: return Reblochon;
			case 25: return Saumon;
			case 26: return Tomates;
			case 27: return Thon;
			default: System.out.println("Mauvaise saisie");choisirIngredient();break;
			}
			
			return Ananas;
		}
	

	
	
	
	
	
	public static void modifierRecette(Recette r){
		List<Food> listeI=r.getListeIngre();
		int cpt=1;
		System.out.println("Les ingredients de cette pizza sont : "+listeI);
		String choix=Test.saisieString("Changer la base ?(o/n)");
		if(choix.equals("o")){
			System.out.println("Choisir une nouvelle base :");
//probleme liste static 
			for(Food i:listeBase) {
				System.out.println(cpt+". "+i);cpt++;
			}

			int base=Test.saisieInt("Choix ?");
			switch(base){
			case 1: listeI.set(0, SauceTomate);break;
			case 2: listeI.set(0, CremeFraiche);break;
			case 3: listeI.set(0, SauceBBQ);break;
			default: System.out.println("Mauvaise saisie");break;
			}			
		}
		
		choix=Test.saisieString("Remplacer un ingr�dient ?(o/n)");
		while(choix.equals("o")) {
			for(int a=1;a<listeI.size();a++) {
				System.out.println(a+". "+listeI.get(a));
			}
			int i=Test.saisieInt("Quel ingr�dient ?");
			listeI.set(i, choisirIngredient());
			choix=Test.saisieString("Remplacer un autre ingr�dient ?(o/n)");
		}

		System.out.println("Votre nouvelle recette : "+listeI);
	}

	
	
	
	public static void saisieBase(){
		
		int choix=Test.saisieInt("Choix ?");
		switch(choix){
		case 1: listeNouvelleRecette.add(SauceTomate);break;
		case 2: listeNouvelleRecette.add(CremeFraiche);break;
		case 3: listeNouvelleRecette.add(SauceBBQ);break;
		default: System.out.println("Mauvaise saisie");saisieBase();break;
		}
	}

	static int cptIngredient=1;
	public static void saisieIngredient(){
		while(cptIngredient<5) {
			int choix=Test.saisieInt("Ingredient "+cptIngredient+" ?");
			switch(choix){
			case 1: listeNouvelleRecette.add(Mozzarella);cptIngredient++;break;
			case 2: listeNouvelleRecette.add(Ananas);cptIngredient++;break;
			case 3: listeNouvelleRecette.add(Bacon);cptIngredient++;break;
			case 4: listeNouvelleRecette.add(Boeuf);cptIngredient++;break;
			case 5: listeNouvelleRecette.add(Champignons);cptIngredient++;break;
			case 6: listeNouvelleRecette.add(Chevre);cptIngredient++;break;
			case 7: listeNouvelleRecette.add(Chorizo);cptIngredient++;break;
			case 8: listeNouvelleRecette.add(Emmental);cptIngredient++;break;
			case 9: listeNouvelleRecette.add(Fourme);cptIngredient++;break;
			case 10: listeNouvelleRecette.add(Jambon);cptIngredient++;break;
			case 11: listeNouvelleRecette.add(Kebab);cptIngredient++;break;
			case 12: listeNouvelleRecette.add(Lardons);cptIngredient++;break;
			case 13: listeNouvelleRecette.add(Merguez);cptIngredient++;break;
			case 14: listeNouvelleRecette.add(Miel);cptIngredient++;break;
			case 15: listeNouvelleRecette.add(Oignons);cptIngredient++;break;
			case 16: listeNouvelleRecette.add(Olives);cptIngredient++;break;
			case 17: listeNouvelleRecette.add(Origan);cptIngredient++;break;
			case 18: listeNouvelleRecette.add(Pepperoni);cptIngredient++;break;
			case 19: listeNouvelleRecette.add(Poivrons);cptIngredient++;break;
			case 20: listeNouvelleRecette.add(Poulet);cptIngredient++;break;
			case 21: listeNouvelleRecette.add(Patate);cptIngredient++;break;
			case 22: listeNouvelleRecette.add(Piments);cptIngredient++;break;
			case 23: listeNouvelleRecette.add(Raclette);cptIngredient++;break;
			case 24: listeNouvelleRecette.add(Reblochon);cptIngredient++;break;
			case 25: listeNouvelleRecette.add(Saumon);cptIngredient++;break;
			case 26: listeNouvelleRecette.add(Tomates);cptIngredient++;break;
			case 27: listeNouvelleRecette.add(Thon);cptIngredient++;break;
			default: System.out.println("Mauvaise saisie");saisieIngredient();break;
			}
		}
		cptIngredient=1;
	}

	public static Recette creerRecette(){
		int cpt=1;
		System.out.println("Creation d'une nouvelle recette...");
		System.out.println("Choisir une base :");
		
		for(Food i:listeBase) {
			System.out.println(cpt+". "+i);cpt++;
		}
		
		saisieBase();
		cpt=1;
		System.out.println("Vous pouvez choisir 4 ingredients");
		for(Food i:listeIngredient) {
			System.out.println(cpt+". "+i);cpt++;
		}
		saisieIngredient();
		
		
		/////AJOUTER SUPPLEMENT
		Recette r=new Recette(10,listeNouvelleRecette);
		return r;
	}
	
}
