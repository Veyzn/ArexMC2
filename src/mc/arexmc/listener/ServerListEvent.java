package mc.arexmc.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import mc.arexmc.main.Main;
import mc.arexmc.utils.Config;



public class ServerListEvent implements Listener {
	public static ArrayList<String> adress = new ArrayList<>();
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
	
		
		
				
				
		
		String[] adresse = e.getAddress().toString().replaceAll("/", "").split(":", 0);
		adress.add(adresse[0]);
		
		
		
		
		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {

			@Override
			public void run() {
				
				
				adress.remove(adresse[0]);
				
			}
			
		},400);




		String wartungen1 = ChatColor.translateAlternateColorCodes('&', Config.cfg.getString("Wartungen.Motd.1"));
		String wartungen2 = ChatColor.translateAlternateColorCodes('&', Config.cfg.getString("Wartungen.Motd.2"));
		
		String motd1 = Config.cfg.getString("Motd.1").replaceAll("&", "§");
		String motd2 = Config.cfg.getString("Motd.2").replaceAll("&", "§");
		
		
				if(Config.cfg.getBoolean("Wartungen.status") ) {
					e.setMotd(wartungen1 + "\n" + wartungen2);
					e.setMaxPlayers(0);
				} else {
					e.setMaxPlayers(150);
					e.setMotd(motd1 + "\n" + motd2);
				}
		
	}

}
