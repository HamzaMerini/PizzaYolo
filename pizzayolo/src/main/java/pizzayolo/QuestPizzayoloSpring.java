package pizzayolo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import pizzayolo.entity.Boisson;
import pizzayolo.entity.Dessert;
import pizzayolo.entity.Ingredient;
import pizzayolo.entity.Recette;
import pizzayolo.services.BoissonService;
import pizzayolo.services.DessertService;
import pizzayolo.services.IngredientService;
import pizzayolo.services.RecetteService;

public class QuestPizzayoloSpring {

	@Autowired
	private BoissonService boissonService;

	@Autowired
	private DessertService dessertService;

	@Autowired
	private IngredientService ingredientService;

	@Autowired
	private RecetteService recetteService;

	public void init() {

		// AJOUT BOISSONS DANS LA BDD
		Boisson cocaC = new Boisson("Coca Cola - 33cl", 1.5);
		Boisson cocaB = new Boisson("Coca Cola - 1.25L", 2.5);
		Boisson cocaZC = new Boisson("Coca Cola Zéro - 33cl", 1.5);
		Boisson cocaZB = new Boisson("Coca Cola Zéro - 1.25L", 2.5);
		Boisson cocaCC = new Boisson("Coca Cola Cherry - 33cl", 1.5);
		Boisson cocaCB = new Boisson("Coca Cola Cherry - 1.25L", 2.5);
		Boisson fantaC = new Boisson("Fanta Orange - 33cl", 1.5);
		Boisson fantaB = new Boisson("Fanta Orange - 1.5L", 2.5);
		Boisson spriteC = new Boisson("Sprite - 33cl", 1.5);
		Boisson spriteB = new Boisson("Sprite - 1.25L", 2.5);
		Boisson oasisC = new Boisson("Oasis Tropical - 33cl", 1.5);
		Boisson oasisB = new Boisson("Oasis Tropical - 2L", 2.5);
		Boisson fuzeteaC = new Boisson("Fuzetea Pêche - 33cl", 1.5);
		Boisson fuzeteaB = new Boisson("Fuzetea Pêche - 1.25L", 2.5);
		Boisson badoit = new Boisson("Badoit - 50cl", 1.5);
		Boisson evian = new Boisson("Evian - 50cl", 1.5);

		boissonService.create(cocaC);
		boissonService.create(cocaB);
		boissonService.create(cocaZC);
		boissonService.create(cocaZB);
		boissonService.create(cocaCC);
		boissonService.create(cocaCB);
		boissonService.create(fantaC);
		boissonService.create(fantaB);
		boissonService.create(spriteC);
		boissonService.create(spriteB);
		boissonService.create(oasisC);
		boissonService.create(oasisB);
		boissonService.create(fuzeteaC);
		boissonService.create(fuzeteaB);
		boissonService.create(badoit);
		boissonService.create(evian);

		// AJOUT DESSERTS DANS LA BDD
		Dessert GlaceCookiep = new Dessert("Cookie Dough - 100ml", 2.95);
		Dessert GlaceCookieg = new Dessert("Cookie Dough - 465ml", 6.95);
		Dessert GlaceChocop = new Dessert("Chocolate Fudge Brownie - 100ml", 2.95);
		Dessert GlaceChocog = new Dessert("Chocolate Fudge Brownie - 465ml", 6.95);
		Dessert GlaceVanillep = new Dessert("Vanilla Pecan Blondie - 100ml", 2.95);
		Dessert GlaceVanilleg = new Dessert("Vanilla Pecan Blondie - 465ml", 6.95);
		Dessert GlaceCaramel = new Dessert("Caramel Brownie Party - 465ml", 6.95);
		Dessert Moelleux = new Dessert("Moelleux au Chocolat", 2.8);
		Dessert Beignets = new Dessert("Mini Beignets Choco-Noisette", 2.8);
		Dessert ChocoB = new Dessert("ChocoBread", 2.8);

		dessertService.create(GlaceCookiep);
		dessertService.create(GlaceCookieg);
		dessertService.create(GlaceChocop);
		dessertService.create(GlaceChocog);
		dessertService.create(GlaceVanillep);
		dessertService.create(GlaceVanilleg);
		dessertService.create(GlaceCaramel);
		dessertService.create(Moelleux);
		dessertService.create(Beignets);
		dessertService.create(ChocoB);

		// AJOUT INGREDIENTS DANS LA BDD
		Ingredient SauceTomate = new Ingredient("Sauce Tomate");
		Ingredient CremeFraiche = new Ingredient("Crème fraîche");
		Ingredient SauceBBQ = new Ingredient("Sauce BBQ");
		Ingredient Mozzarella = new Ingredient("Mozzarella", 2);
		Ingredient Ananas = new Ingredient("Ananas", 1.5);
		Ingredient Bacon = new Ingredient("Bacon", 2);
		Ingredient Boeuf = new Ingredient("Boeuf", 1.8);
		Ingredient Champignons = new Ingredient("Champignons", 1.3);
		Ingredient Chevre = new Ingredient("Chèvre", 2);
		Ingredient Chorizo = new Ingredient("Chorizo", 2);
		Ingredient Emmental = new Ingredient("Emmental", 2);
		Ingredient Fourme = new Ingredient("Fourme", 2);
		Ingredient Jambon = new Ingredient("Jambon", 1.5);
		Ingredient Kebab = new Ingredient("Kebab", 2);
		Ingredient Lardons = new Ingredient("Lardons", 1.5);
		Ingredient Merguez = new Ingredient("Merguez", 1.5);
		Ingredient Miel = new Ingredient("Miel", 1.5);
		Ingredient Oignons = new Ingredient("Oignons", 1);
		Ingredient Olives = new Ingredient("Olives", 1.8);
		Ingredient Origan = new Ingredient("Origan", 0);
		Ingredient Pepperoni = new Ingredient("Pepperoni", 1.8);
		Ingredient Poivrons = new Ingredient("Poivrons", 1.5);
		Ingredient Poulet = new Ingredient("Poulet", 1.8);
		Ingredient Patate = new Ingredient("Patate", 1.3);
		Ingredient Piments = new Ingredient("Piments", 1);
		Ingredient Raclette = new Ingredient("Raclette", 2.5);
		Ingredient Reblochon = new Ingredient("Reblochon", 2.3);
		Ingredient Saumon = new Ingredient("Saumon", 2.9);
		Ingredient Tomates = new Ingredient("Tomates", 1);
		Ingredient Thon = new Ingredient("Thon", 2.3);

		ingredientService.create(SauceTomate);
		ingredientService.create(CremeFraiche);
		ingredientService.create(SauceBBQ);
		ingredientService.create(Ananas);
		ingredientService.create(Bacon);
		ingredientService.create(Boeuf);
		ingredientService.create(Champignons);
		ingredientService.create(Chevre);
		ingredientService.create(Chorizo);
		ingredientService.create(Emmental);
		ingredientService.create(Fourme);
		ingredientService.create(Jambon);
		ingredientService.create(Kebab);
		ingredientService.create(Lardons);
		ingredientService.create(Merguez);		
		ingredientService.create(Miel);		
		ingredientService.create(Mozzarella);
		ingredientService.create(Oignons);
		ingredientService.create(Olives);
		ingredientService.create(Origan);
		ingredientService.create(Pepperoni);
		ingredientService.create(Poivrons);
		ingredientService.create(Poulet);
		ingredientService.create(Patate);
		ingredientService.create(Piments);
		ingredientService.create(Raclette);
		ingredientService.create(Reblochon);
		ingredientService.create(Saumon);
		ingredientService.create(Tomates);
		ingredientService.create(Thon);

		// AJOUT INGREDIENTS DANS LA BDD
		// Les Bons Plans
		Set<Ingredient> marg=new HashSet<Ingredient> ();
		Collections.addAll(marg, SauceTomate,Mozzarella);
		Recette marga = new Recette("Margherita", 5.99,marg);
		
		Set<Ingredient> claJ=new HashSet<Ingredient> ();
		Collections.addAll(claJ, SauceTomate,Mozzarella,Jambon);
		Recette claJambon = new Recette("Classique Jambon", 5.99,claJ);

		Set<Ingredient> claM=new HashSet<Ingredient> ();
		Collections.addAll(claM, SauceTomate,Mozzarella,Merguez);
		Recette claMerguez = new Recette("Classique Merguez", 5.99,claM);
		
		Set<Ingredient> claP=new HashSet<Ingredient> ();
		Collections.addAll(claP, SauceTomate,Mozzarella,Pepperoni);
		Recette claPepperoni = new Recette("Classique Pepperoni", 5.99,claP);
		
		recetteService.create(marga);
		recetteService.create(claJambon);
		recetteService.create(claMerguez);
		recetteService.create(claPepperoni);

		// Les incontournables
		Set<Ingredient> hj=new HashSet<Ingredient> ();
		Collections.addAll(hj, SauceTomate,Mozzarella,Ananas,Jambon);
		Recette hawJambon = new Recette("Hawaïenne Jambon", 8,hj);
		
		Set<Ingredient> hp=new HashSet<Ingredient> ();
		Collections.addAll(hp, SauceTomate,Mozzarella,Ananas,Poulet);
		Recette hawPoulet = new Recette("Hawaïenne Poulet", 8,hp);
		
		Set<Ingredient> queen=new HashSet<Ingredient> ();
		Collections.addAll(queen, SauceTomate,Mozzarella,Jambon,Champignons);
		Recette reine = new Recette("Reine", 8,queen);
		
		Set<Ingredient> ori=new HashSet<Ingredient> ();
		Collections.addAll(ori, SauceTomate,Mozzarella,Poivrons,Oignons,Merguez);
		Recette orientale = new Recette("Orientale", 8,ori);
		
		Set<Ingredient> sc=new HashSet<Ingredient> ();
		Collections.addAll(sc, SauceTomate,Mozzarella,Boeuf,Tomates,Origan);
		Recette steakEtChesse = new Recette("Steak & Cheese", 8,sc);
		
		recetteService.create(hawJambon);
		recetteService.create(hawPoulet);
		recetteService.create(reine);
		recetteService.create(orientale);
		recetteService.create(steakEtChesse);

		// Les supremes
		Set<Ingredient> cdl=new HashSet<Ingredient> ();
		Collections.addAll(cdl, SauceTomate,Mozzarella,Poulet,Oignons,Champignons,Poivrons,Tomates,Origan);
		Recette chickenDeLight = new Recette("Chicken Delight", 9,cdl);
		
		Set<Ingredient> cm=new HashSet<Ingredient> ();
		Collections.addAll(cm, CremeFraiche,Mozzarella,Chevre,Miel);
		Recette chevreMiel = new Recette("Chèvre-Miel", 9,cm);

		Set<Ingredient> keb=new HashSet<Ingredient> ();
		Collections.addAll(keb, SauceTomate,Mozzarella,Kebab,Merguez,Oignons);
		Recette kebab = new Recette("Urban Kebab", 9,keb);

		Set<Ingredient> del=new HashSet<Ingredient> ();
		Collections.addAll(del, SauceTomate,Mozzarella,Boeuf,Champignons,Poivrons,Oignons);
		Recette deluxe = new Recette("Deluxe", 9,del);

		Set<Ingredient> pech=new HashSet<Ingredient> ();
		Collections.addAll(pech, SauceTomate,Mozzarella,Thon,Oignons,Olives);
		Recette pecheur = new Recette("Pêcheur", 9,pech);
		
		Set<Ingredient> ind=new HashSet<Ingredient> ();
		Collections.addAll(ind, CremeFraiche,Mozzarella,Champignons,Oignons,Poulet,Emmental);
		Recette indienne = new Recette("Indienne", 9,ind);
		
		Set<Ingredient> bel=new HashSet<Ingredient> ();
		Collections.addAll(bel, SauceTomate,Mozzarella,Chorizo,Merguez,Poivrons);	
		Recette bellacho = new Recette("Bellacho", 9,bel);
		
		Set<Ingredient> divf=new HashSet<Ingredient> ();
		Collections.addAll(divf, CremeFraiche,Mozzarella,Oignons,Raclette,Emmental);
		Recette divinefro = new Recette("Divine 3 Fromages", 9,divf);
		
		Set<Ingredient> hypno=new HashSet<Ingredient> ();
		Collections.addAll(hypno, SauceTomate,Mozzarella,Poulet,Merguez,Champignons);
		Recette hypnotika = new Recette("Hypnotika", 9,hypno);
		
		Set<Ingredient> diavB=new HashSet<Ingredient> ();
		Collections.addAll(diavB, SauceTomate,Mozzarella,Boeuf,Piments,Oignons,Poivrons);
		Recette diavolaB = new Recette("Diavola Boeuf", 9,diavB);
		
		Set<Ingredient> diavP=new HashSet<Ingredient> ();
		Collections.addAll(diavP, SauceTomate,Mozzarella,Pepperoni,Piments,Oignons,Poivrons);
		Recette diavolaP = new Recette("Diavola Pepperoni", 9,diavP);
		
		Set<Ingredient> skeb=new HashSet<Ingredient> ();
		Collections.addAll(skeb, SauceTomate,Mozzarella,Kebab,Oignons,Tomates);
		Recette sKebab = new Recette("Samouraï Kebab", 9,skeb);
		
		Set<Ingredient> pepp=new HashSet<Ingredient> ();
		Collections.addAll(pepp, SauceTomate,Mozzarella,Oignons,Poivrons,Champignons,Tomates,Olives,Origan);
		Recette peppina = new Recette("Peppina", 9,pepp);

		Set<Ingredient> rac=new HashSet<Ingredient> ();
		Collections.addAll(rac, CremeFraiche,Mozzarella,Patate,Bacon,Oignons,Raclette);
		Recette raclette = new Recette("Authentique Raclette", 9,rac);

		Set<Ingredient> racM=new HashSet<Ingredient> ();
		Collections.addAll(racM, CremeFraiche,Mozzarella,Chevre,Fourme,Emmental);
		Recette racletteMiel = new Recette("Surprenante Raclette-Miel", 9,racM);

		Set<Ingredient> qf=new HashSet<Ingredient> ();
		Collections.addAll(qf, CremeFraiche,Mozzarella,Chevre,Fourme,Emmental);
		Recette qFro = new Recette("4 Fromages", 9,qf);
		
		Set<Ingredient> bg=new HashSet<Ingredient> ();
		Collections.addAll(bg, CremeFraiche,Mozzarella,Bacon,Poulet,Oignons);
		Recette baconGroovy = new Recette("Bacon Groovy", 9,bg);

		Set<Ingredient> can=new HashSet<Ingredient> ();
		Collections.addAll(can, SauceBBQ,Mozzarella,Poulet,Merguez,Boeuf);
		Recette cannibale = new Recette("Cannibale", 9,can);

		Set<Ingredient> saum=new HashSet<Ingredient> ();
		Collections.addAll(saum, CremeFraiche,Mozzarella,Patate,Oignons,Saumon);
		Recette saumoneta = new Recette("Saumoneta", 9,saum);

		Set<Ingredient> extra=new HashSet<Ingredient> ();
		Collections.addAll(extra, SauceTomate,Mozzarella,Jambon,Pepperoni,Boeuf,Oignons,Champignons,Poivrons,Olives);
		Recette extravaganzza = new Recette("Extravaganza", 9,extra);

		Set<Ingredient> sav=new HashSet<Ingredient> ();
		Collections.addAll(sav, CremeFraiche,Mozzarella,Patate,Lardons,Reblochon,Origan);
		Recette savoyarde = new Recette("Savoyarde", 9,sav);

		Set<Ingredient> fore=new HashSet<Ingredient> ();
		Collections.addAll(fore, CremeFraiche,Mozzarella,Jambon,Lardons,Oignons,Champignons,Origan);
		Recette forestiere = new Recette("Forestière", 9,fore);

		recetteService.create(chickenDeLight);
		recetteService.create(chevreMiel);
		recetteService.create(kebab);
		recetteService.create(deluxe);
		recetteService.create(pecheur);
		recetteService.create(indienne);
		recetteService.create(bellacho);
		recetteService.create(divinefro);
		recetteService.create(hypnotika);
		recetteService.create(diavolaB);
		recetteService.create(diavolaP);
		recetteService.create(sKebab);
		recetteService.create(peppina);
		recetteService.create(raclette);
		recetteService.create(racletteMiel);
		recetteService.create(qFro);
		recetteService.create(baconGroovy);
		recetteService.create(cannibale);
		recetteService.create(saumoneta);
		recetteService.create(extravaganzza);
		recetteService.create(savoyarde);
		recetteService.create(forestiere);

	}

	public void run(String... args) {
		init();
	}

}
