package mc.arexmc.antiwerbung;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
public class BlockWordAPI {
	
	
	
	public static File config;
	public static YamlConfiguration cfg;
	
	
	
	public static void createCFG() {
		
		 config = new File("plugins/ArexMC/AntiWerbung.yml");
		 cfg = new YamlConfiguration().loadConfiguration(config);			 
		if(!config.exists()) {						
			try {				
				config.createNewFile();			
			    cfg.save(config);				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
				
		
	}
	
	public static void addWord(String word) {
		List<String> List = cfg.getStringList("BlockedWords");
		List.add(word);
		
		
		try {
			cfg.set("BlockedWords", List);
			cfg.save(config);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void removeWord(String word) {
		List<String> List = cfg.getStringList("BlockedWords");
		List.remove(word);
		
		
		try {
			cfg.set("BlockedWords", List);
			cfg.save(config);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}
	
	
	public static List<String> getList() {
		
		
		return cfg.getStringList("BlockedWords");
	}
	
	public static boolean contains(String word) {
		List<String> List = cfg.getStringList("BlockedWords");
		
		if(List.contains(word)) {
			return true;
		} else return false;
		
	}
	

	

}
