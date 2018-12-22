package mc.arexmc.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mc.arexmc.main.MySQL;









public class MuteManager {

	public static void mute(String uuid,Player p, String playername, String reason, int seconds) {
		long end = 0;
		
		
		
		if(seconds == -1) {
			end = -1;
		} else {
			long current =	System.currentTimeMillis();
			long millis = seconds*1000;	
			end = current+millis;
		}
		MySQL.Update("INSERT INTO ArexMute (Spielername, UUID, Ende, Grund, Operator) VALUES ('"+playername+"','" + uuid+ "','" + end+ "','" +reason+"','" + p.getName() + "')");
		
		
	}
	
	public static void unmute(String uuid) {
		MySQL.Update("DELETE FROM ArexMute WHERE UUID= '" + uuid + "'");
		
		
	}
    public static boolean isMuted(String uuid) {
		ResultSet rs = MySQL.getResult("SELECT UUID FROM ArexMute WHERE UUID= '" + uuid + "'");
		try{
			return rs.next();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return false;
		
		
	}
    public static Long getEnd(String uuid) {
    	ResultSet rs = MySQL.getResult("SELECT * FROM ArexMute WHERE UUID= '"+uuid+"'");
    	try {
    		while(rs.next()) {
    			return rs.getLong("Ende");
    		}
			
		} catch (SQLException e) {
			
		}
    	return null;
    
    }
    
    
    public static String getReason(String uuid) {
    	ResultSet rs = MySQL.getResult("SELECT * FROM ArexMute WHERE UUID= '"+uuid+"'");
    	try {
    		while(rs.next()) {
    			return rs.getString("Grund");
    		}
			
		} catch (SQLException e) {
			
		}
    	return "";
    }

    public static List<String> getMutedPlayers() {
    	
    	List<String> list = new ArrayList<String>();
    	
    	ResultSet rs = MySQL.getResult("SELECT * FROM ArexMute");
		
    	
    	try {
			while(rs.next()) {
				list.add(rs.getString("playername"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return list;
	
    }
   public static String getRemainingTime(String uuid) {
	   
	   long current = System.currentTimeMillis();
	   long end = getEnd(uuid);
	   long millis = end - current;
	   
	   int seconds= 0;
	   int minutes = 0;
	   
	   while(millis > 1000) {
		   millis-=1000;
		   seconds++;
		   
		   
	   }
	   while(seconds > 60) {
		   seconds-=60;
		   minutes++;
		   
		   
	   }
	 
	   
	   
	   return "§e" + minutes  + " Minute(n) " + seconds + " Sekunde(n)";
	   
	   
    	
    }
   public static String getOperator(String uuid) {
   	ResultSet rs = MySQL.getResult("SELECT * FROM ArexMute WHERE UUID= '"+uuid+"'");
   	try {
   		while(rs.next()) {
   			return rs.getString("Operator");
   		}
			
		} catch (SQLException e) {
			
		}
   	return "";
   }
	
	
}
