package pizzayolo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pizzayolo.entity.Ingredient;
import pizzayolo.entity.Pizza;
import pizzayolo.entity.Recette;
import pizzayolo.entity.Taille;
import pizzayolo.entity.TypePate;


/////MODIFIER FRAIS POUR LIVRAISON
public class RecettePizza {
	static Ingredient SauceTomate=new Ingredient("Sauce Tomate");
	static Ingredient CremeFraiche=new Ingredient("Creme fraiche");
	static Ingredient SauceBBQ=new Ingredient("Sauce BBQ");
	static Ingredient Mozzarella=new Ingredient("Mozzarella",2);
	static Ingredient Ananas=new Ingredient("Ananas",1.5);
	static Ingredient Bacon=new Ingredient("Bacon",2);
	static Ingredient Boeuf=new Ingredient("Boeuf",1.8);
	static Ingredient Champignons=new Ingredient("Champignons",1.3);
	static Ingredient Chevre=new Ingredient("Chevre",2);
	static Ingredient Chorizo=new Ingredient("Chorizo",2);
	static Ingredient Emmental=new Ingredient("Emmental",2);
	static Ingredient Fourme=new Ingredient("Fourme",2);
	static Ingredient Jambon=new Ingredient("Jambon",1.5);
	static Ingredient Kebab=new Ingredient("Kebab",2);
	static Ingredient Lardons=new Ingredient("Lardons",1.5);
	static Ingredient Merguez=new Ingredient("Merguez",1.5);
	static Ingredient Miel=new Ingredient("Miel",1.5);
	static Ingredient Oignons=new Ingredient("Oignons",1);
	static Ingredient Olives=new Ingredient("Olives",1.8);
	static Ingredient Origan=new Ingredient("Origan");
	static Ingredient Pepperoni=new Ingredient("Pepperoni",1.8);
	static Ingredient Poivrons=new Ingredient("Poivrons",1.5);
	static Ingredient Poulet=new Ingredient("Poulet",1.8);
	static Ingredient Patate=new Ingredient("Patate",1.3);
	static Ingredient Piments=new Ingredient("Piments",1);
	static Ingredient Raclette=new Ingredient("Raclette",2.5);
	static Ingredient Reblochon=new Ingredient("Reblochon",2.3);	
	static Ingredient Saumon=new Ingredient("Saumon",2.9);
	static Ingredient Tomates=new Ingredient("Tomates",1);
	static Ingredient Thon=new Ingredient("Thon",2.3);
	
	
	
	static List<Ingredient> listeBase=new ArrayList();
	static List<Ingredient> listeIngredient=new ArrayList();
	static List<Ingredient> listeNouvelleRecette=new ArrayList();
	
	
		//Les Bons Plans
	public static Recette marga() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella);
		Recette pizza=new Recette("Margherita",5.99,liste);
		return pizza;
	}  

	public static Recette claJambon() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Jambon);
		Recette pizza=new Recette("Classique Jambon",5.99,liste);
		return pizza;
	}  
	
	public static Recette claMerguez() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Merguez);
		Recette pizza=new Recette("Margherita",5.99,liste);
		return pizza;
	}  
	
	public static Recette claPepperoni() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Pepperoni);
		Recette pizza=new Recette("Margherita",5.99,liste);
		return pizza;
	}  


	//Les incontournables
	public static Recette hawJambon() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Ananas,Jambon);
		Recette pizza=new Recette("Hawaienne Jambon",8,liste);
		return pizza;
	}  
	
	public static Recette hawPoulet() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Ananas,Poulet);
		Recette pizza=new Recette("Hawaienne Poulet",8,liste);
		return pizza;
	}  
	

	public static Recette reine() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Jambon,Champignons);
		Recette pizza=new Recette("Reine",8,liste);
		return pizza;
	}  
	
	public static Recette orientale() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Poivrons,Oignons,Merguez);
		Recette pizza=new Recette("Orientale",8,liste);
		return pizza;
	}  
	
	public static Recette steakEtChesse() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Boeuf,Tomates,Origan);
		Recette pizza=new Recette("Steak & Cheese",8,liste);
		return pizza;
	}  
	
	
	
	//Les supremes
	
	public static Recette chickenDeLight() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Poulet,Oignons,Champignons,Poivrons,Tomates,Origan);
		Recette pizza=new Recette("Chicken Delight",9,liste);
		return pizza;
	}  
	
	public static Recette chevreMiel() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Chevre,Miel);
		Recette pizza=new Recette("Chevre-Miel",9,liste);
		return pizza;
	}  
	
	public static Recette kebab() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Kebab,Merguez,Oignons);
		Recette pizza=new Recette("Urban Kebab",5.99,liste);
		return pizza;
	}  
	
	public static Recette deluxe() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Boeuf,Champignons,Poivrons,Oignons);
		Recette pizza=new Recette("Deluxe",9,liste);
		return pizza;
	}  

	public static Recette pecheur() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Thon,Oignons,Olives);
		Recette pizza=new Recette("Pecheur",9,liste);
		return pizza;
	}  
	
	public static Recette indienne() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Champignons,Oignons,Poulet,Emmental);
		Recette pizza=new Recette("Indienne",9,liste);
		return pizza;
	}  
	
	public static Recette bellacho() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Chorizo,Merguez,Poivrons);
		Recette pizza=new Recette("Bellacho",9,liste);
		return pizza;
	}  

	public static Recette divinefro() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Oignons,Raclette,Emmental);
		Recette pizza=new Recette("Divine 3 Fromages",9,liste);
		return pizza;
	}  

	public static Recette hypnotika() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Poulet,Merguez,Champignons);
		Recette pizza=new Recette("Hypnotika",9,liste);
		return pizza;
	}  

	public static Recette diavolaB() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Boeuf,Piments,Oignons,Poivrons);
		Recette pizza=new Recette("Diavola Boeuf",9,liste);
		return pizza;
	}  

	public static Recette diavolaP() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Pepperoni,Piments,Oignons,Poivrons);
		Recette pizza=new Recette("Diavola Pepperoni",9,liste);
		return pizza;
	}  

	public static Recette sKebab() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Kebab,Oignons,Tomates);
		Recette pizza=new Recette("Samourai Kebab",9,liste);
		return pizza;
	}  

	public static Recette peppina() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Oignons,Poivrons,Champignons,Tomates,Olives,Origan);
		Recette pizza=new Recette("Peppina",9,liste);
		return pizza;
	}  

	public static Recette raclette() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Patate,Bacon,Oignons,Raclette);
		Recette pizza=new Recette("Authentique Raclette",9,liste);
		return pizza;
	}  

	public static Recette racletteMiel() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella);
		Recette pizza=new Recette("Surprenante Raclette-Miel",9,liste);
		return pizza;
	}  

	public static Recette qFro() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Chevre,Fourme,Emmental);
		Recette pizza=new Recette("4 Fromages",9,liste);
		return pizza;
	}  

	public static Recette baconGroovy() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Bacon,Poulet,Oignons);
		Recette pizza=new Recette("Bacon Groovy",9,liste);
		return pizza;
	}  

	public static Recette cannibale() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceBBQ,Mozzarella,Poulet,Merguez,Boeuf);
		Recette pizza=new Recette("Cannibale",9,liste);
		return pizza;
	}  
	

	public static Recette saumoneta() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Patate,Oignons,Saumon);
		Recette pizza=new Recette("Saumoneta",9,liste);
		return pizza;
	}  

	public static Recette extravaganzza() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, SauceTomate,Mozzarella,Jambon,Pepperoni,Boeuf,Oignons,Champignons,Poivrons,Olives);
		Recette pizza=new Recette("Extravaganzza",9,liste);
		return pizza;
	}  
	
	public static Recette savoyarde() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Patate,Lardons,Reblochon,Origan);
		Recette pizza=new Recette("Savoyarde",9,liste);
		return pizza;
	}  

	public static Recette forestiere() {
		List<Ingredient> liste=new ArrayList();
		Collections.addAll(liste, CremeFraiche,Mozzarella,Jambon,Lardons,Oignons,Champignons,Origan);
		Recette pizza=new Recette("Forestiere",9,liste);
		return pizza;
	}  
	
	
	
	
	
	
	public static Ingredient choisirIngredient(){
			int choix=Test.saisieInt("Choisir un ingredient :");
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
		List<Ingredient> listeI=r.getListeIngre();
		int cpt=0;
		System.out.println("Les ingredients de cette pizza sont : "+listeI);
		String choix=Test.saisieString("Changer la base ?(o/n)");
		if(choix.equals("o")){
			System.out.println("Choisir une nouvelle base :");
//probleme liste static 
			for(Ingredient i:listeBase) {
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
		
		choix=Test.saisieString("Remplacer un ingredient ?(o/n)");
		while(choix.equals("o")) {
			for(int a=1;a<listeI.size();a++) {
				System.out.println(a+". "+listeI.get(a));
			}
			int i=Test.saisieInt("Quel ingredient ?");
			listeI.set(i, choisirIngredient());
			choix=Test.saisieString("Remplacer un autre ingredient ?(o/n)");
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
		
		for(Ingredient i:listeBase) {
			System.out.println(cpt+". "+i);cpt++;
		}
		
		saisieBase();
		cpt=1;
		System.out.println("Vous pouvez choisir 4 ingredients");
		for(Ingredient i:listeIngredient) {
			System.out.println(cpt+". "+i);cpt++;
		}
		saisieIngredient();
		
		
		/////AJOUTER SUPPLEMENT
		Recette r=new Recette(10,listeNouvelleRecette);
		return r;
	}
	
	
	
	public static void main(String[] args) {
//		Recette r=creerRecette();
//		System.out.println(r);
		Collections.addAll(listeBase,SauceTomate,CremeFraiche,SauceBBQ);
		Collections.addAll(listeIngredient, Mozzarella,Ananas,Bacon,Boeuf,Champignons,Chevre,Chorizo,Emmental,Fourme,Jambon,Kebab,Lardons,Merguez,Miel,Oignons,Olives,Origan,Pepperoni,Poivrons,Poulet,Patate,Piments,Raclette,Reblochon,Saumon,Tomates,Thon);
		Recette maPizza=RecettePizza.indienne();
		Pizza p=new Pizza(maPizza,Taille.Medium,TypePate.MozzaCrust);
		System.out.println(p);
		
		
		modifierRecette(maPizza);
		
	}
	
	
	
}
