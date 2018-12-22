package mc.arexmc.chatcolor;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ChatcolorAPI {
	
	public static File file = new File("plugins/ArexMC/Chatcolor.yml");
	public static YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(file);
	
	public static void createCFG() {
				
		if(!file.exists()) {
			try {
				file.createNewFile();												
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}		
	}
	
	
	
	public static boolean isRegistered(String uuid) {		
		if(cfg.getString(uuid) != null) {	
		
			return true;
		} else return false;				
	}
	
	
	public static void register(Player p) {
		try {
		cfg.set(p.getUniqueId().toString() + ".Name", p.getName());
		cfg.set(p.getUniqueId().toString() + ".Chatcolor", "7");		
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	
	public static void setColor(Player p, String color) {
		try {
			cfg.set(p.getUniqueId().toString() + ".Chatcolor", color);		
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}
	
	public static String getColor(Player p) {		
		if(cfg.getString(p.getUniqueId().toString() + ".Chatcolor") != null) {
			return cfg.getString(p.getUniqueId().toString() + ".Chatcolor");
		} else return "7";				
	}
	
 
}
