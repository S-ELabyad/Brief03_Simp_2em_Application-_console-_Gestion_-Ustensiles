package com.Ustensiles.app.models.abstact;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssietteCarree extends Assiette {
	
	Conection con = new Conection();
	
	private int id;
	private double cote;
	
	public AssietteCarree() {
		
	}
	
	public AssietteCarree(int Id,double Cote,int Anne_de_fabrication) {
		super (Anne_de_fabrication);
		this.id = Id;
		this.cote = Cote;
	}

	  
	  public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	public double getCote() {
		return cote;
	}

	public void setCote(double cote) {
		this.cote = cote;
	}
	
	@Override
	public String toString() {
		return  "\n \t ---------------- \n \t Cote    : " + this.cote ;
	}
	
	
	//insert
	public void create_data(double cote,int anne_de_fabrication) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query="INSERT INTO `assiettecarree`(`cote` , `anne_de_fabrication`) VALUES (?,?)";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, cote);
			ps.setDouble(2, anne_de_fabrication);
			ps.executeUpdate();
			System.out.println(" \n AssietteCarree Ajoute Avec Succes ");
		}catch (Exception e) {
			System.out.print(e);
		}
	}
	
	
	//select
		public void read_data() throws SQLException {
			//First f = new First();
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT * FROM `assiettecarree`");
			while(con.rs.next()) {
				System.out.println(" -------> ID:  " + "\t" +con.rs.getInt("id") + "\n \t Cote: " + con.rs.getDouble("cote") + " \n \t Anne De Fabrication: " + con.rs.getInt("anne_de_fabrication"));
			}
		}
		
		//update
		public void update_data(int id ,double cote ,int anne_de_fabrication) {
			//First f = new First();
			con.Connect();
			
			PreparedStatement ps = null;
			
			try {
				String query = "UPDATE `assiettecarree` SET `cote`=?,`anne_de_fabrication`=? WHERE `id`=?";
				ps=con.conn.prepareStatement(query);
				ps.setDouble(1, cote);
				ps.setInt(2, anne_de_fabrication);
				ps.setInt(3, id);
				ps.executeUpdate();
				System.out.println(" \t modification avec succes");

				
			}catch (Exception e){
				
			}
		}

		@Override
		void afficherSurfaceAssiettes() {
			// TODO Auto-generated method stub
			
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
