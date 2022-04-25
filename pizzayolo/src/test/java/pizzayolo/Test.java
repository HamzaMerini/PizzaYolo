package pizzayolo;

import java.util.Scanner;

import pizzayolo.entity.Pizza;
import pizzayolo.entity.Recette;
import pizzayolo.entity.Taille;
import pizzayolo.entity.TypePate;

//Ajouter les conditions if(taille!= medium) impossible de creer de pizza medium
// if(taille=XL) type de pate = forcement fine

public class Test {
	

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

	
	public static void main(String[] args) {
		
		Recette maPizza=RecettePizza.indienne();
		Pizza p=new Pizza(maPizza,Taille.Medium,TypePate.MozzaCrust);
		System.out.println(p);
		
		maPizza=RecettePizza.reine();
		p=new Pizza(maPizza,Taille.Large,TypePate.Classique);
		System.out.println(p);
		
		maPizza=RecettePizza.qFro();
		p=new Pizza(maPizza,Taille.XL,TypePate.Fine);
		System.out.println(p);
		
		maPizza=RecettePizza.diavolaB();
		p=new Pizza(maPizza,Taille.Medium,TypePate.Pan);
		System.out.println(p);
		
	}
	
}
