package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.arexmc.main.Data;



public class MoreCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
		Player p = (Player)sender;
		if(p.hasPermission("amc.more")) {
			if(args.length == 0) {
				
			
				ItemStack iteminhand = p.getItemInHand();
				
				if(p.getItemInHand().getType() != org.bukkit.Material.AIR) {
					
				
				iteminhand.setAmount(64);
				} else p.sendMessage(Data.Prefix + "Du musst ein Item in der Hand halten.");
			} else p.sendMessage(Data.verwendung+"/more");
		} else p.sendMessage(Data.noperms);
		
		} else System.out.println(Data.console);
		return false;
		
	}

}
