package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.arexmc.main.Data;



public class GiveallCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
			
			Player p = (Player) sender;
			ItemStack item = p.getItemInHand();
			String defaultname = item.getType().name();
			if(p.hasPermission("amc.giveall")) {
				if(item.getType() != Material.AIR) {
				if(item.getItemMeta().hasDisplayName()) {
					Bukkit.broadcastMessage(Data.Prefix + "Alle §cSpieler §7haben das Item §c" + item.getAmount() + "x " + item.getItemMeta().getDisplayName() +  " §7bekommen");
					} else {
						Bukkit.broadcastMessage(Data.Prefix + "Alle §cSpieler §7haben das Item §c" + item.getAmount() + "x " + defaultname +  " §7bekommen");
							
					}
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.getInventory().addItem(item);
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 5F, 5F);
						}
			
				} else p.sendMessage(Data.Prefix + "Du musst ein Item in der Hand halten");
				
				
			} else p.sendMessage(Data.noperms);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		return false;
	}
	
	


}
