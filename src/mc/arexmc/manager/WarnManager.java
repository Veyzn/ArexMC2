package mc.arexmc.manager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import mc.arexmc.main.MySQL;








public class WarnManager  {

	
	public static void register(Player p, String UUID){
		try{
			PreparedStatement ps = MySQL.getStatement("INSERT INTO ArexWarn (UUID, Spielername, Warns) VALUES (?, ?, ?)");
			ps.setString(2, p.getName());
			ps.setString(1, UUID);
			ps.setInt(3, 0);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	} 
	public static boolean isRegistered(String UUID){
		try{
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM ArexWarn WHERE UUID= ?");
			ps.setString(1, UUID);
			ResultSet rs = ps.executeQuery();
			boolean user = rs.next();
			rs.close();
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	

		
	public static int getWarns(String uuid) {
		try {
		PreparedStatement ps = MySQL.getStatement("SELECT Warns FROM ArexWarn WHERE UUID = ?");
		ps.setString(1, uuid.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			return rs.getInt("Warns");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return -1;
		
		
	}
	public static void setWarns(String uuid, int Warns) {
		
		if(getWarns(uuid) == -1) {
			try {
			PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO ArexWarn (UUID,Warns) VALUES (?,?)");
			ps.setString(1, uuid);
			ps.setInt(2, Warns);
			ps.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		} else  {
			
			
				PreparedStatement ps;
				try {
					ps = MySQL.con.prepareStatement("UPDATE ArexWarn SET Warns = ? WHERE UUID = ?");
					ps.setInt(1, Warns);
					ps.setString(2, uuid);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
			
			
			
			
			
		
		
		
	}
	}
	
	public static void addWarns(String uuid, int Warns) {
		setWarns(uuid, Warns + getWarns(uuid));
		
		
	}
	public static void removeWarns(String uuid, int Warns) {
		setWarns(uuid, getWarns(uuid) - Warns); 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
