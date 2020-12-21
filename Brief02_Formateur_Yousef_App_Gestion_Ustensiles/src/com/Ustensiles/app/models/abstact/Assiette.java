package com.Ustensiles.app.models.abstact;

import java.sql.SQLException;

public abstract class Assiette extends Ustensile {
	
	Conection con = new Conection();
	
    private double Surface = 0;
    private double valeur = 0;
	private int id;
      
	public Assiette(){
		
	}
	
	public Assiette(int Id){
		this.id = Id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//m�thode afficherSurfaceAssiettes
	
	public void afficherSurfaceAssiettes(int choix) throws SQLException {

		if(choix == 1) {
			//AssietteRonde
			//AssietteRonde : 3.14 * rayon * rayon
			//SUM(id)
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT SUM(rayon) As sum_rayon FROM assietteronde ;");
			
			while(con.rs.next()) {
				valeur = con.rs.getInt("sum_rayon");
			}
			Surface = 3.14 * (valeur * valeur);
			System.out.println(" \n 1- La valeur de la Surface de AssietteRonde : " + Surface);
			
		}else if (choix == 2) {
			//AssietteCarree
			//AssietteCarree : cote * cote
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT SUM(cote) As sum_cote FROM assiettecarree ;");
			
			while(con.rs.next()) {
				valeur = con.rs.getInt("sum_cote");
			}
			Surface = (valeur * valeur);
			System.out.println(" \n 2- La valeur de la Surface de AssietteCarree : " + Surface);
			
		}
	}
	
	abstract void afficherSurfaceAssiettes();
}
