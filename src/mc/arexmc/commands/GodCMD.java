package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;



public class GodCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender; 
		
		if(p.hasPermission("RayNight.God")) {
			
			if(args.length == 0) {
				
				if(Data.goded.contains(p)) {
					
					Data.goded.remove(p);
					p.sendMessage(Data.Prefix + "Du bist nun nicht mehr im §cGodMode");
					
				} else if(!(Data.goded.contains(p))) {
					
					Data.goded.add(p);
					p.sendMessage(Data.Prefix + "Du bist nun im §cGodMode");
					
				}
				
			} else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				
				if(Data.goded.contains(target)) {
					
					Data.goded.remove(target);
					p.sendMessage(Data.Prefix + "Der Spieler §c" + target.getName() + "§7 ist nicht mehr im §cGodMode");
					
				} else if(!(Data.goded.contains(target))) {
					
					Data.goded.add(target);
					p.sendMessage(Data.Prefix + "Der Spieler §c" + target.getName() + "§7 ist im §cGodMode");
					
				}
				
			} else p.sendMessage(Data.verwendung + "/god <Spieler>");
			
		}
		
		return false;
	}
	
	

}
