package com.Ustensiles.app.models.abstact;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cuilliere extends Ustensile {
	
	Conection con = new Conection();
	
	private int id;
	private double longueur;
	
	
    public Cuilliere(){
    	
    }
	public Cuilliere(int Id,double Longueur,int Anne_de_fabrication){
		super (Id,Anne_de_fabrication);
		this.id = Id;
		this.longueur = Longueur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
	//afficheCuillere
	@Override
	public String toString() {
		return  "\n \t ---------------- \n \t longueur    : " + this.longueur ;
	}
	
	public void create_data(double longueur,int anne_de_fabrication) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query="INSERT INTO `cuillere`(`longeur` , `anne_de_fabrication`) VALUES (?,?)";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, longueur);
			ps.setDouble(2, anne_de_fabrication);
			ps.executeUpdate();
			System.out.println(" \n cuillere Ajoute Avec Succes ");
		}catch (Exception e) {
			System.out.print(e);
		}
	}
	
	//méthode afficherCuilleres
	public void afficherCuilleres() throws SQLException {
		//First f = new First();
		con.Connect();
		con.stat = con.conn.createStatement();
		con.rs = con.stat.executeQuery("SELECT COUNT(*) As total FROM cuillere ;");
		
		while(con.rs.next()) {
			System.out.println(" -------> total:  " + "\t" +con.rs.getInt("total") );
		}
		con.rs = con.stat.executeQuery("SELECT * FROM `cuillere`");
		while(con.rs.next()) {
			System.out.println(" -------> ID:  " + "\t" +con.rs.getInt("id") + "\n \t longeur: " + con.rs.getDouble("longeur") + " \n \t anne_de_fabrication:  " + con.rs.getInt("anne_de_fabrication"));
		}
		
	}
	
	public void tt() throws SQLException {
		con.Connect();
		con.stat = con.conn.createStatement();
		con.rs = con.stat.executeQuery("SELECT * FROM `cuillere`");
		while(con.rs.next()) {
			System.out.println(" -------> ID:  " + "\t" +con.rs.getInt("id") + "\n \t longeur: " + con.rs.getDouble("longeur") + " \n \t anne_de_fabrication:  " + con.rs.getInt("anne_de_fabrication"));
		}
	}
	
	
	//select
	public void read_data() throws SQLException {
		//First f = new First();
		con.Connect();
		con.stat = con.conn.createStatement();
		con.rs = con.stat.executeQuery("SELECT * FROM `cuillere`");
		while(con.rs.next()) {
			System.out.println(" -------> ID:  " + "\t" +con.rs.getInt("id") + "\n \t Longeur: " + con.rs.getDouble("longeur") + " \n \t Anne De Fabrication: " + con.rs.getInt("anne_de_fabrication"));
		}
	}
	

	//update
	public void update_data(int id ,double longeur ,int anne_de_fabrication) {
		//First f = new First();
		con.Connect();
		
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE `cuillere` SET `longeur`=?,`anne_de_fabrication`=? WHERE `id`=?";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, longeur);
			ps.setInt(2, anne_de_fabrication);
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");

			
		}catch (Exception e){
			
		}
	}
	@Override
	void afficherValeurTotale() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void update_global_data() {
		// TODO Auto-generated method stub
		
	}
}
