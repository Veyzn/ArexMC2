package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class InformationCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			p.sendMessage(Data.getHeader());
			p.sendMessage(Data.Prefix + "Skype: §cLoqxdeveloper");
			p.sendMessage(Data.Prefix + "Teamspeak: §cArexMC.EU");
			p.sendMessage(Data.Prefix + "Discord: §cdiscord.gg/fUp4wrk");
			p.sendMessage(Data.getHeader());
			
		} else System.out.println(Data.console);
		
		
		return false;
	}

}
