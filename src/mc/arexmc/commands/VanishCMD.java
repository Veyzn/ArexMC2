package mc.arexmc.commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;



public class VanishCMD implements CommandExecutor {
	
	public static ArrayList<Player> vanished = new ArrayList<Player>();
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if((sender instanceof Player)) {
			Player p = (Player)sender;
			if(p.hasPermission("amc.vanish")) {
				if(args.length == 0) {
					if(vanished.contains(p)) {
						vanished.remove(p);
						p.sendMessage(Data.Prefix + "Du bist nun nicht mehr im Vanish.");
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.showPlayer(p);
							
						}
					} else {
						vanished.add(p);
						p.sendMessage(Data.Prefix + "Du bist nun im Vanish.");
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							if(!all.hasPermission("amc.vanish")) {
								all.hidePlayer(p);
								
							}
						}
					}
				} else {
					p.sendMessage(Data.verwendung
							+ "/vanish");
				}
			} else {
				p.sendMessage(Data.noperms);
			}
		} 
		return false;
	}

}
