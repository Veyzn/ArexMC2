package mc.arexmc.commands;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class TeamChatCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("amc.teamchat")) {
				p.sendMessage(Data.noperms);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Data.Prefix + "/teamchat <Nachricht>");
				return true;
			}
			if (args.length > 0) {
				String msg = "";
				for (int i = 0; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}
				for (Player all : Bukkit.getOnlinePlayers()) {
					if ((all.hasPermission("amc.teamchat"))) {
						all.sendMessage(Data.teamchat + "§4" + p.getName() + " §8» §c" + msg.replaceAll("&", "§"));
					}
				}
			} else
				p.sendMessage(Data.verwendung + "/teamchat <Nachricht>");
		} else
			System.out.println(Data.console);
		return true;
	}
}
