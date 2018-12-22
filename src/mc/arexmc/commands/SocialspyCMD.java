package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;







public class SocialspyCMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			if (!p.hasPermission("amc.socialspy")) {
				p.sendMessage(Data.noperms);
			} else if (args.length == 0) {
				boolean socialspy = MSGCMD.socialspy.contains(p.getUniqueId());
				if (socialspy) {
					MSGCMD.socialspy.remove(p.getUniqueId());
					p.sendMessage(Data.Prefix + "SocialSpy wurde §cdeaktiviert§7.");
				} else if (!socialspy) {
					MSGCMD.socialspy.add(p.getUniqueId());
					p.sendMessage(Data.Prefix + "SocialSpy wurde §aaktiviert§7.");
				} else {
					p.sendMessage(Data.verwendung + "/socialspy");
				}
			} else {
				p.sendMessage(Data.verwendung + "/socialspy");
			}
		} 
		return true;
	}
}
