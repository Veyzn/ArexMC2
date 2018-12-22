package mc.arexmc.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;





public class MsgRCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
		Player p = (Player) sender;
		if(args.length > 0) {
		if(MSGCMD.msg.get(p) != null) {
			Player t = MSGCMD.msg.get(p);
			if(t != null) {
				String message = "";
				for (int i = 0; i < args.length; i++) {
					message = message + args[i] + " ";
				}
				
				p.sendMessage(Data.Prefix + "§cDu zu §6" + t.getName() + "§8: §c" + message);
				t.sendMessage(Data.Prefix + "§6" + p.getName() + "§c schreibt §8: §c" + message);
				
				t.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10.0F, 10.0F);
				for (UUID all : MSGCMD.socialspy) {
					if ((Bukkit.getPlayer(all) != null)
							&& (!Bukkit.getOfflinePlayer(all).getName().equalsIgnoreCase(p.getName()))
							&& (!Bukkit.getOfflinePlayer(all).getName().equalsIgnoreCase(t.getName()))) {
						Bukkit.getPlayer(all).sendMessage("§6SocialSpy §8• §e" + p.getName() + " §8» §6" + t.getName() + " §8» §c" + message);
					}
				}
			} else p.sendMessage(Data.Prefix + "Der Spieler ist nicht Online");
		} else p.sendMessage(Data.Prefix + "Du hast mit keinem Geschrieben.");
		} else p.sendMessage(Data.verwendung + "/r <Nachricht>");
		}
		return false;
		
	}

}
