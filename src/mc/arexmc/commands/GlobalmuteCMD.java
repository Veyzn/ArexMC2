package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;


public class GlobalmuteCMD implements CommandExecutor {
	
	public static boolean Gmute = true;

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
		Player p = (Player) sender;
		
		if(p.hasPermission("amc.globalmute")) {
			if(Gmute == false) {
				Gmute = true;
				Bukkit.broadcastMessage(Data.Prefix + "Der §cGlobale Chat§7 wurde§a aktiviert");
				
			} else {
				Gmute = false;
				Bukkit.broadcastMessage(Data.Prefix + "Der §cGlobale Chat§7 wurde§c deaktiviert");
				
			}
			
			
		} else p.sendMessage(Data.noperms);
		
		}
		
		return false;
	}

}
