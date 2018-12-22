package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.utils.PlayerCache;

public class CoinsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			final java.text.DecimalFormat german
		    = new java.text.DecimalFormat( "###,###.###");
			Player p = (Player) sender;
			
			
			if(args.length == 0) {
				PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
				p.sendMessage(Data.Prefix + "Deine Taler: §c" + german.format(pc.getCoins()));
			} else if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null) {
					PlayerCache tc = new PlayerCache(t.getUniqueId().toString());
					p.sendMessage(Data.Prefix + "Die Taler von §c" + t.getName() + "§7: §c" + german.format(tc.getCoins()));
					
				} else p.sendMessage(Data.nichton);
			} else p.sendMessage(Data.verwendung + "/taler");
			
		} else System.out.println(Data.console);
		
		
		return false;
	}

}
