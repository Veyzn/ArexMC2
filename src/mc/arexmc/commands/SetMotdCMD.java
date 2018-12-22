package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.utils.Config;




public class SetMotdCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof ConsoleCommandSender) {
			 System.out.println("Dieser Commmand ist für einen Spieler");
			} else {
		Player p = (Player) sender;
		
		
		if(p.hasPermission("amc.setmotd")) {
			if(args.length > 2) {
			if(args[0].equalsIgnoreCase("normal")) {
				if(args[1].equalsIgnoreCase("oben")) {
					String motd = "";
					for(int i = 2; i < args.length; i++) {
						motd = motd + args[i];
						if(i + 1 < args.length) {
							motd = motd + " ";
						}
						
					}
					String ende = motd.replaceAll("&", "§");
					p.sendMessage(Data.Prefix + "Du hast erfolgreich die Normal Motd geändert auf " + ende);
					Config.cfg.set("Motd.1", motd);
					Config.save();
					
					
				} else if(args[1].equalsIgnoreCase("unten")) {
					
					String motd = "";
					for(int i = 2; i < args.length; i++) {
						motd = motd + args[i];
						if(i + 1 < args.length) {
							motd = motd + " ";
						}
						
					}
					String ende = motd.replaceAll("&", "§");
					p.sendMessage(Data.Prefix + "Du hast erfolgreich die Normal Motd geändert auf " + ende);
					Config.cfg.set("Motd.2", motd);
					Config.save();
					
				}
			} else if(args[0].equalsIgnoreCase("wartung")) {
				if(args[1].equalsIgnoreCase("oben")) {
					String motd = "";
					for(int i = 2; i < args.length; i++) {
						motd = motd + args[i];
						if(i + 1 < args.length) {
							motd = motd + " ";
						}
						
					}
					String ende = motd.replaceAll("&", "§");
					p.sendMessage(Data.Prefix + "Du hast erfolgreich die Wartungs Motd geändert auf " + ende);
					Config.cfg.set("Wartungen.Motd.1", motd);
					Config.save();
					
					
				} else if(args[1].equalsIgnoreCase("unten")) {
					
					String motd = "";
					for(int i = 2; i < args.length; i++) {
						motd = motd + args[i];
						if(i + 1 < args.length) {
							motd = motd + " ";
						}
						
					}
					String ende = motd.replaceAll("&", "§");
					p.sendMessage(Data.Prefix + "Du hast erfolgreich die Wartungs Motd geändert auf " + ende);
					Config.cfg.set("Wartungen.Motd.2", motd);
					Config.save();
					
				}
			}
		}
		}
			}
		
		return false;
	}

}
