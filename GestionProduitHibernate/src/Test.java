import java.util.Date;
import java.util.Iterator;

import dao.Categorie;
import dao.Produit;
import dao.Services;

public class Test {

	
	public static void main(String[] args) {
		
		//1 load service
		Services s = new Services();
		//declaration des Produits
		Produit p1 = new Produit("pc1","sony1",(double) 1000);
		Produit p2 = new Produit("pc2","sony2",(double) 2000);
		Produit p3 = new Produit("pc3","sony3",(double) 3000);
		Produit p4 = new Produit("pc4","sony4",(double) 4000);
		
		//ajout des produit
		s.addProduit(p1);
		s.addProduit(p2);
		s.addProduit(p3);
		s.addProduit(p4);
		
		Categorie c1 = new Categorie("informatique1","info1", new Date());
		Categorie c2 = new Categorie("informatique2","info2", new Date());
		Categorie c3 = new Categorie("informatique3","info3", new Date());
		Categorie c4 = new Categorie("informatique4","info4", new Date());
		
		s.addCategorie(c1);
		s.addCategorie(c2);
		s.addCategorie(c3);
		s.addCategorie(c4);	
		
		//get (affichage un produit sur la console)
		/*Categorie categorie = s.getCategorie(new Long(1));
		categorie.show();
		
		Produit produit = s.getProduit(2L);
		produit.show();
		
		//List (affichage de tout les produit sur la console)
		Iterator<Produit> produits = s.getAllProduits().iterator();
		System.out.println("la liste des produit:");
		while(produits.hasNext()) {
			Produit p = produits.next();
			p.show();
		}*/
		
		//affectation des produit au categorie
		s.addProduitToCategorie(1L, 1L); //on peut affecter plusieur produit a une categorie
		s.addProduitToCategorie(1L, 2L); //on peut affecter plusieur categorie a un produit
		s.addProduitToCategorie(1L, 3L); //c'est la relation many-to-many declarer sur le fichier de configuration
		s.addProduitToCategorie(2L, 1L);
		s.addProduitToCategorie(3L, 1L);
		s.addProduitToCategorie(3L, 2L);

		/*
		//affichage des produit qui ont categorie 1 (les jointure)
		Categorie categorie = s.getCategorie(new Long(1));
		System.out.println("info de cat: ");
		categorie.show();
		System.out.println("produit de cat : ");
		Iterator<Produit> iterator = categorie.getProduits().iterator();
		while(iterator.hasNext()) {
			Produit p = iterator.next();
			p.show();
		}*/
		
		Produit produit = s.getProduit(2L);
		System.out.println("info de prof: ");
		produit.show();
		System.out.println("cat de prod: ");
		
		Iterator<Categorie> iterator = produit.getCategories().iterator();
		while(iterator.hasNext()) {
			Categorie c = iterator.next();
			c.show();
		}

		
		
		}
}
