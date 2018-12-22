package mc.arexmc.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mc.arexmc.main.Data;








public class RenameCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
			
			
			Player p = (Player)sender;
			
			
				
			
			
			if(p.hasPermission("amc.rename")) {
				if(args.length > 0) {
				ItemStack hand = p.getItemInHand();
				if((hand == null) || (hand.getType() == Material.AIR)) {
					p.sendMessage(Data.Prefix + "Du musst ein Item in der Hand halten");
					
				}
				ItemMeta meta = hand.getItemMeta();
				
				
				
				StringBuilder sb = new StringBuilder();
				
				for (int i = 0; i < args.length; i++) {
					sb.append(args[i]).append(" ");
				}
				
				String neuerName = ChatColor.translateAlternateColorCodes('&', sb.substring(0, sb.length() - 1));
				
				meta.setDisplayName(neuerName);
				hand.setItemMeta(meta);
				
				p.sendMessage(Data.Prefix + "Der Name erfolgreich gesetzt");
				
			return true;
				}  else p.sendMessage(Data.verwendung + "/rename <Name>");
			} else p.sendMessage(Data.noperms);
			
			
		} 
		
			
			
			
		
		
		return false;
	
		
	}

}
