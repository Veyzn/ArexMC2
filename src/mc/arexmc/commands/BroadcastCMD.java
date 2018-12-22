package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;










public class BroadcastCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
		if(sender.hasPermission("amc.broadcast")) {
			if(args.length == 0) {
				sender.sendMessage(Data.verwendung + "/broadcast <Nachricht>");
			} else {
				String msg = "§c§l";
				for(int i = 0; i < args.length; i++) {
					msg = msg + args[i];
					if(i + 1 < args.length) {
						msg = msg + " ";
					}
				}	
				String bcmsg = msg.replaceAll("&", "§");
				
				Bukkit.broadcastMessage(Data.Prefix + bcmsg);
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
				}
			}
		} else {
			sender.sendMessage(Data.noperms);
		}
		}
		return false;
	}

}
