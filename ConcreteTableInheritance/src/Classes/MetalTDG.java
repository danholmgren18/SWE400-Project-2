package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class MetalTDG {
	
	private static MetalTDG instance;
	
	private MetalTDG() {
		
	}
	
	public static MetalTDG getInstance() {
		if(instance == null) {
			instance = new MetalTDG();
		}
		return instance;
	}
	
	public ArrayList<MetalDTO> getAllMetals() {
		ArrayList<MetalDTO> data = new ArrayList<MetalDTO>();
		ResultSet rs;
		try {
			DatabaseManager db = DatabaseManager.getSingleton();
			db.setPatternNumber(2);
			Connection cn = db.getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Metal");
			while(rs.next()) {
				data.add(new MetalDTO(rs.getInt("elementOrMetalID"), rs.getInt("metalAtomicNumber"), rs.getInt("metalDissolvedBy"), rs.getDouble("metalAtomicMass"), rs.getString("metalName")));
			}
		} catch (Exception e) {
			DatabaseException.detectError(e);
		}
		return data;
	}
}