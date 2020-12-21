package com.Ustensiles.app.models.abstact;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scan= new Scanner(System.in);
		Conection con = new Conection();
		con.Connect();
		
		
		AssiettetRonde assietteronde = new AssiettetRonde();
		AssietteCarree assiettecarree = new AssietteCarree();
		Cuilliere cuillere = new Cuilliere();
		
		int anne_de_fabrication =0;
		double rayon =0;
		double cote =0;
		double longueur =0;
		int id = 0;
		
		
		while (true) {
			System.out.println(" _________________________________\n "
							 + "Ajouter: 1 \n"
							 + " Afficher Cuilleres: 2 \n"
							 + " Afficher Surface Assiettes :  3 \n"
							 + " Afficher Valeur Totale : 4 \n"
							 + " Modifier Ustensile :  5");
			String method=scan.next();
			switch(method) {
			 case "1":
				 //sart case 1
				//add
				 System.out.println("Anne de fabrication : ");
				 anne_de_fabrication = scan.nextInt();
				 System.out.println(" Ajouter AssietteRonde  : 1"
				 		+ " \n Ajouter AssietteCarree : 2 "
				 		+ "\n Cuillere  : 3");
				 String method2=scan.next();
				 switch(method2) {
				  case "1":
					 //add AssietteRonde
					  System.out.println(" \n rayon de AssietteRonde : ");
					  rayon = scan.nextDouble();
					  assietteronde.create_data(rayon,anne_de_fabrication);
					  
					  break;
				  case "2":
					  //add AssietteCarree
					  System.out.println(" \n cote de AssietteCarree : ");
					  cote = scan.nextDouble();
					  assiettecarree.create_data(cote,anne_de_fabrication);
					  
					  break;
				  case "3":
					  //add AssietteCarree
					  System.out.println(" \n Longueur de Cuillere : ");
					  longueur = scan.nextDouble();
					  cuillere.create_data(longueur,anne_de_fabrication);
					  
					  break;
					  default:
				 }
				 
				 //end case 1
				 break;
			 case "2":
				 //select
				 cuillere.afficherCuilleres();
				 //cuillere.tt();
				 break;
			 case "3":
				 //select


				 System.out.println(" Surface totale AssietteRonde  : 1"
				 		+ " \n Surface totale AssietteCarree : 2 ");
				 String method3=scan.next();
				 switch(method3) {
					 case "1":
						 //1
						 assietteronde.afficherSurfaceAssiettes(1);
						 break;
					 case "2":
						 //2
						 assietteronde.afficherSurfaceAssiettes(2);
						 break;
					 default:
				 }
				 
				 //cuillere.tt();
				 break;
			 case "4":
				 //afficherValeurTotale
				 //AssietteRonde
				 System.out.println(" Cuillere      "
				 		+ " : 1 \n AssietteRonde  : 2 "
				 		+ "\n AssietteCarree : 3");
				 String method4=scan.next();
				 switch(method4) {
				 	case "1":
				 		//1
				 		cuillere.afficherValeurTotale(1);
				 		break;
				 	case "2":
				 		//2
				 		assietteronde.afficherValeurTotale(2);
				 		break;
				 	case "3":
				 		//3
				 		assiettecarree.afficherValeurTotale(3);
				 		break;
				 	default:
				 }
				 
				 break;
			 case "5":
				 //modifier
					System.out.println(" Modifier Cuilleres      : 1 "
							+ "\n Modifier AssietteRonde  : 2"
							+ " \n Modifier AssietteCarree : 3");
					String method5=scan.next();
					switch(method5) {
						case "1":
							//1
							cuillere.read_data();
							System.out.println("\n--------------------------------");
							System.out.println(" ID pour Modifier : \n");
							id = scan.nextInt();
							System.out.println(" Longeur pour Modifier : \n");
							longueur = scan.nextDouble();
							System.out.println(" Anne De Fabrication pour Modifier : \n");
							anne_de_fabrication = scan.nextInt();
							cuillere.update_data(id, longueur, anne_de_fabrication);
							
							break;
						case "2":
							//2
							assietteronde.read_data();
							System.out.println("\n--------------------------------");
							System.out.println(" ID pour Modifier : \n");
							id = scan.nextInt();
							System.out.println(" Rayon pour Modifier : \n");
							rayon = scan.nextDouble();
							System.out.println(" Anne De Fabrication pour Modifier : \n");
							anne_de_fabrication = scan.nextInt();
							assietteronde.update_data(id, rayon, anne_de_fabrication);
							break;
						case "3":
							//3
							assiettecarree.read_data();
							System.out.println("\n--------------------------------");
							System.out.println(" ID pour Modifier : \n");
							id = scan.nextInt();
							System.out.println(" Cote pour Modifier : \n");
							rayon = scan.nextDouble();
							System.out.println(" Anne De Fabrication pour Modifier : \n");
							anne_de_fabrication = scan.nextInt();
							assiettecarree.update_data(id, cote, anne_de_fabrication);
							break;
						default:
					}
				 default:
					 
			}

	}
	}}

