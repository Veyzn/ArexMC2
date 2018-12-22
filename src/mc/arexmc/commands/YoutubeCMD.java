package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class YoutubeCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			
			
			Player p = (Player) sender;
			
			p.sendMessage(Data.getHeader());
			p.sendMessage(Data.Prefix + "Vorraussetzungen für den Youtuber Rang:");
			p.sendMessage("");
			p.sendMessage(Data.Prefix + "- §7250 §cAbonnenten");
			p.sendMessage(Data.Prefix + "- §7Durschnittlich 100 §cAufrufe");
			p.sendMessage(Data.Prefix + "- §72 Videos auf §cArexMC §7mit mind. 10 §cLikes §7& 100 §cAufrufe");
			p.sendMessage("");
			p.sendMessage(Data.Prefix + "Deine Vorteile:");
			p.sendMessage("");
			p.sendMessage(Data.Prefix + "- §7Der Server unterstüzt paar §cGiveaways");
			p.sendMessage(Data.Prefix + "- §7Rechte von §5Wizard");
			p.sendMessage(Data.Prefix + "- §7Eine eigene §cCrate §8(§7Items werden mit der Leitung besprochen§8)");
			
			p.sendMessage(Data.getHeader());
			
			
			
			
		} else System.out.println(Data.console);
		
		
		
		
		return false;
	}

}
