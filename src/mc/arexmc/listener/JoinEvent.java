package mc.arexmc.listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import mc.arexmc.manager.BanManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.scheduler.BukkitRunnable;

import mc.arexmc.chatcolor.ChatcolorAPI;
import mc.arexmc.main.Data;
import mc.arexmc.main.Main;
import mc.arexmc.utils.Board;
import mc.arexmc.utils.Config;
import mc.arexmc.utils.PlayerCache;
import mc.arexmc.utils.TablistAPI;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		PlayerCache pc = new PlayerCache(p.getUniqueId().toString());		
		pc.create(p);
		pc.setName(p);
		pc.setLIP(p);
		
		ChatcolorAPI cc = new ChatcolorAPI();
		
		if(!cc.isRegistered(p.getUniqueId().toString())) {
			cc.register(p);
			Config.cfg2.set("RegistrierteUser", Config.cfg2.getInt("RegistrierteUser") + 1);
			Bukkit.broadcastMessage(Data.Prefix + "Der Spieler §c" + p.getName() + "§7 ist neu auf §c§lArex§f§lMC§7 [§8#§c" + Config.cfg2.getInt("RegistrierteUser") + "§7]");
			Config.save();
		}
		Board.createScoreboard(p);
				
		e.setJoinMessage(null);
		 
				
				TablistAPI.setTablist(p, Data.getHeader() + "\n\n" + "§7  Wir wünschen dir viel Erfolg! \n\n" , "\n§7Teamspeak: §cArexMC.EU\n§7Discord: §cdiscord.ArexMC.eu \n\n" + Data.getHeader());

		if(BanManager.isBanned(p.getUniqueId().toString())) {
			BanManager.unban(p.getUniqueId().toString());
		}
				
			
		
				
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		
		e.setQuitMessage("");
	}
	
	
	@EventHandler
	public void onPreLogin(PlayerLoginEvent e) {
		
		Player p = e.getPlayer();
		if(Config.cfg.getBoolean("Wartungen.status") == true) {
			if(!Bukkit.getWhitelistedPlayers().contains(p) ) {
				e.disallow(Result.KICK_WHITELIST, Data.getHeader()
						+ "\n\n"
						+ "§7Wir sind leider derzeit in §cWartungen."
						+ "\n§7Wir werden bald wieder für alle §aVerfügbar§7 sein."
						+ "\n§7Bitte versuche es später erneut auf den Server zu joinen."
						+ "\n\n"
						+ "§7Euer §c§lAREX§f§lMC §8- §bTeam"
						+ "\n\n"
						+ Data.getHeader());
				
				Bukkit.broadcastMessage(Data.Prefix + "Der User §c" + p.getName() + "§7 hat versucht auf den Server zu joinen.");

			
		} 
		}
		
		String[] adresse = e.getAddress().toString().replaceAll("/", "").split(":", 0);
		
		if(!ServerListEvent.adress.contains(adresse[0])) {
			
			e.disallow(Result.KICK_OTHER, "§7Bitte §aaktualisiere §7deine Serverliste.\n"
					+ "§7Oder füge den §aServer§7 zu deiner Serverliste hinzu.");
			
		}

		if(BanManager.isBanned(p.getUniqueId().toString())) {
			long current = System.currentTimeMillis();

			long end = BanManager.getEnd(p.getUniqueId().toString());

			if(current < end | end == -1) {
				e.disallow(Result.KICK_BANNED,"§c§m×§f§m---------§c§m×§c§l AREX§f§lMC §c§m×§f§m----------§c§m×\n\n"
						+ "§cDu wurdest vom Netzwerk ausgeschlossen.\n"
						+ "\n"
						+ "§3§lGrund: §c" + BanManager. getReason(p.getUniqueId().toString()) + "\n\n"
						+ "§3§lDauer: " + BanManager.getRemainingTime(p.getUniqueId().toString())
						+ "\n\n"

						+ "§3§lGebannt von: §c" + BanManager.getOperator(p.getUniqueId().toString()) + "\n"





						+ "\n\n§c§m×§f§m---------§c§m×§c§l AREX§f§lMC §c§m×§f§m----------§c§m×");
			}
		}



		
	}

}
