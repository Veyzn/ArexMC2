package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class SystemCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			 
			Player p = (Player) sender;
			p.sendMessage(Data.getHeader());
			p.sendMessage(Data.Prefix + "System Version: §a1.0");
			p.sendMessage(Data.Prefix + "System Programmiert von: §cVeyzn");
			p.sendMessage(Data.Prefix + "Lizensiert für §cArexMC.EU");
			p.sendMessage(Data.getHeader());
			
		} else System.out.println(Data.console);
		
		return false;
	}

}
