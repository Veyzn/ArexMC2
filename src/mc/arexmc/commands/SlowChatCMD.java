package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;



public class SlowChatCMD implements CommandExecutor {
	
	public static boolean SlowChat = false;

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
		Player p = (Player) sender;
		
		if(p.hasPermission("Skytanic.slowchat")) {
			if(SlowChat == false) {
				SlowChat = true;
				Bukkit.broadcastMessage(Data.Prefix + "Der §cSpam Schutz§7 wurde§a aktiviert");
				
			} else {
				SlowChat = false;
				Bukkit.broadcastMessage(Data.Prefix + "Der §cSpam Schutz§7 wurde§c deaktiviert");
				
			}
			
			
		} else p.sendMessage(Data.noperms);
		
		}
		
		return false;
	}

}
