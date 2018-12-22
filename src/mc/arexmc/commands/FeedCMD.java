package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class FeedCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {				
			if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);		
			} else {
				
				Player p = (Player) sender;
				
				
				if(p.hasPermission("amc.Feed")) {
					if(args.length == 0) {
						p.sendMessage(Data.Prefix + "Du wurdest §aerfolgreich §7gesättigt.");
						p.setFoodLevel(20);
						
					} else if(args.length == 1) {
						if(p.hasPermission("amc.Feed.Other")) {
						Player t = Bukkit.getPlayer(args[0]);
						if(t != null) {
							t.sendMessage(Data.Prefix + "Du wurdest §aerfolgreich §7gesättigt.");
							p.sendMessage(Data.Prefix + "Der Spieler §c" + t.getName() + "§7 wurde §aerfolgreich §7gesättigt. ");
							t.setFoodLevel(20);
						
						} else p.sendMessage(Data.Prefix + "Der Spieler ist Offline");
						
						} else p.sendMessage(Data.noperms);
					 
					} else p.sendMessage(Data.verwendung + "/feed");
				} else p.sendMessage(Data.noperms);
				
				
				
			
		
		
			}
		
		
		
		return false;
	}

}
