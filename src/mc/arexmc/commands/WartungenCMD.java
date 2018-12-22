package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.utils.Config;






public class WartungenCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			 System.out.println("Dieser Commmand ist für einen Spieler");
			} else {
		
		Player p = (Player) sender;
		
		if(p.hasPermission("amc.wartungsmodus")) {
			if(args.length == 0){
			if(Config.cfg.getBoolean("Wartungen.status")) {
				
				Config.cfg.set("Wartungen.status", false);
				Config.save();
				Bukkit.broadcastMessage(Data.Prefix + "Der §cWartungs-Modus §7wurde §cdeaktiviert§7.");
				
			} else if(!Config.cfg.getBoolean("Wartungen.status")) {
				Config.cfg.set("Wartungen.status", true);
				Config.save();
				
				Bukkit.broadcastMessage(Data.Prefix + "Der §cWartungs-Modus §7wurde §aAktiviert§7.");
				
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					
					if(!all.hasPermission("amc.wartungsmodus")) {
						all.kickPlayer(Data.getHeader()
								+ "\n\n"
								+ "§cDu wurdest gekickt.\n\n"
								+ "§7Der §c§lWartungs-Modus §7wurde Aktiviert"
								+ "\n\n"
								+ Data.getHeader());
						
					}
					
		      }
				
		   }
		} else if(args.length == 2) {
			
			if(args[0].equalsIgnoreCase("add")) {
				
				Bukkit.getServer().getOfflinePlayer(args[1]).setWhitelisted(true);;
				
				p.sendMessage(Data.Prefix + "Der Spieler §c" + args[1] + "§7 wurde erfolreich hinzugefügt.");
				
			} if(args[0].equalsIgnoreCase("remove")) {
				
				Bukkit.getServer().getOfflinePlayer(args[1]).setWhitelisted(false);
            
				
				p.sendMessage(Data.Prefix + "Der Spieler §c" + args[1] + "§7 wurde erfolreich entfernt.");
				
			} else if(!args[0].equalsIgnoreCase("add") ) {
				p.sendMessage("§8§l§m--------------[--§6§lWartungen§8§l§m--]--------------");
				p.sendMessage(Data.Prefix + "/wartungen | §cUm den Wartungsmodus zu Aktivieren / Deaktivieren");
				p.sendMessage(Data.Prefix + "/wartungen remove <Spieler> | §cUm einen Spieler zu entfernen");
				p.sendMessage(Data.Prefix + "/wartungen add <Spieler> | §cUm einen Spieler hinzuzugefügen");
				p.sendMessage("§8§l§m--------------[--§6§lWartungen§8§l§m--]--------------");
				
			}
		
			
		} else if(args.length < 3) {
			p.sendMessage("§8§l§m--------------[--§6§lWartungen§8§l§m--]--------------");
			p.sendMessage(Data.Prefix + "/wartungen | §cUm den Wartungsmodus zu Aktivieren / Deaktivieren");
			p.sendMessage(Data.Prefix + "/wartungen remove <Spieler> | §cUm einen Spieler zu entfernen");
			p.sendMessage(Data.Prefix + "/wartungen add <Spieler> | §cUm einen Spieler hinzuzugefügen");
			p.sendMessage("§8§l§m--------------[--§6§lWartungen§8§l§m--]--------------");
			
		}
	} else p.sendMessage(Data.noperms);
			}
		return false;
	}
	
	
	

}
