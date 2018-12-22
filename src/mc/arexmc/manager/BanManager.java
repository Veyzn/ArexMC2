package mc.arexmc.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mc.arexmc.main.MySQL;
import mc.arexmc.utils.Utils;








public class BanManager {

	public static void ban(String uuid,Player p, String playername, String reason, int seconds) {
		long end = 0;
		
		
		
		if(seconds == -1) {
			end = -1;
		} else {
			long current =	System.currentTimeMillis();
			long millis = seconds*1000;	
			end = current+millis;
		}
		MySQL.Update("INSERT INTO ArexBan (Spielername, UUID, Ende, Grund, Operator, IP) VALUES ('"+playername+"','" + uuid+ "','" + end+ "','" +reason+"','" + p.getName() + "')");
		if(Bukkit.getPlayer(playername) != null) {
			Bukkit.getPlayer(playername).kickPlayer("§c§m×§f§m---------§c§m×§c§l AREX§f§lMC §c§m×§f§m----------§c§m×\n\n"
					+ "§cDu wurdest vom Netzwerk ausgeschlossen.\n"
					+ "\n"
					+ "§3§lGrund: §c" + getReason(uuid) + "\n\n"
					+ "§3§lDauer: " + getRemainingTime(uuid) 
				    + "\n\n"
					
					+ "§3§lGebannt von: §c" + getOperator(uuid) + "\n"
					
					
					
				
					
					+ "\n\n§c§m×§f§m---------§c§m×§c§l AREX§f§lMC §c§m×§f§m----------§c§m×");
					
		}
		
	}
	
	public static void unban(String uuid) {
		MySQL.Update("DELETE FROM ArexBan WHERE UUID= '" + uuid + "'");
		
		
	}
    public static boolean isBanned(String uuid) {
		ResultSet rs = MySQL.getResult("SELECT UUID FROM ArexBan WHERE UUID= '" + uuid + "'");
		try{
			return rs.next();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return false;
		
		
	}
    
    public static boolean isIPBanned(String ip) {
		ResultSet rs = MySQL.getResult("SELECT UUID FROM ArexBan WHERE UUID= '" + ip + "'");
		try{
			return rs.next();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return false;
		
		
	}
    
    public static Long getEnd(String uuid) {
    	ResultSet rs = MySQL.getResult("SELECT * FROM ArexBan WHERE UUID= '"+uuid+"'");
    	try {
    		while(rs.next()) {
    			return rs.getLong("Ende");
    		}
			
		} catch (SQLException e) {
			
		}
    	return null;
    
    }
    
    
    public static String getReason(String uuid) {
    	ResultSet rs = MySQL.getResult("SELECT * FROM ArexBan WHERE UUID= '"+uuid+"'");
    	try {
    		while(rs.next()) {
    			return rs.getString("Grund");
    		}
			
		} catch (SQLException e) {
			
		}
    	return "";
    }

    public static List<String> getBannedPlayers() {
    	
    	List<String> list = new ArrayList<String>();
    	
    	ResultSet rs = MySQL.getResult("SELECT * FROM ArexBan");
		
    	
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
	   if(end == -1) {
		   return "§4§lPERMANENT";
	   }
	   long millis = end - current;
	   
	   int seconds= 0;
	   int minutes = 0;
	   int hours= 0;
	   int days = 0;
	   int weeks = 0;
	   
	   while(millis > 1000) {
		   millis-=1000;
		   seconds++;
		   
		   
	   }
	   while(seconds > 60) {
		   seconds-=60;
		   minutes++;
		   
		   
	   }
	   while(minutes > 60) {
		   minutes-=60;
		   hours++;
		   
		   
	   }
	   while(hours > 24) {
		   hours-=24;
		   days++;
		   
		   
	   }
	   while(days > 6) {
		   days-=7;
		   weeks++;
		   
		   
	   }
	   
	   return "§e" + weeks + " Woche(n) " + days + " Tag(e) " + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n) ";
	   
	   
    	
    }
   public static String getOperator(String uuid) {
   	ResultSet rs = MySQL.getResult("SELECT * FROM ArexBan WHERE UUID= '"+uuid+"'");
   	try {
   		while(rs.next()) {
   			return rs.getString("Operator");
   		}
			
		} catch (SQLException e) {
			
		}
   	return "";
   }
	
	
}
