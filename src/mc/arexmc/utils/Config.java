package mc.arexmc.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	
	public static File ordner = new File("plugins/ArexMC");
	public static File config = new File("plugins/ArexMC/MySQL.yml");
	
	public static YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(config);
	public static File config3 = new File("plugins/ArexMC/Config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(config3);
	
	
	public static void create() {
		if(!ordner.exists()){
			ordner.mkdir();
		}
		
		
		if(!config.exists()){
			try {
				config.createNewFile();
				
				cfg2.set("HOST", "Host");
				cfg2.set("USER", "USER");
				cfg2.set("DATABASE", "DATABASE");
				cfg2.set("PASSWORT", "PASSWORT");
				
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!config3.exists()){
			try {
				config3.createNewFile();
				
				cfg.set("Wartungen.status", false);
				cfg.set("Wartungen.Motd.1", "Linie1");
				cfg.set("Wartungen.Motd.2", "Linie2");
				cfg.set("Motd.1", "Linie1");
				cfg.set("Motd.2", "Linie2");
				cfg.set("RegistrierteUser", 0);
				
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
		
	
	public static void save(){
		try {
			
			cfg2.save(config);
			cfg.save(config3);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
	}
	
	
	
	
}
