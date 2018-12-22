package mc.arexmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.utils.PlayerCache;
import mc.arexmc.utils.Utils;

public class StatsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
		} else System.out.println(Data.console);
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
			
			final java.text.DecimalFormat german
		    = new java.text.DecimalFormat( "###,###.##");
			double kdr =  (double)pc.getKills() / (double)pc.getTode();
			p.sendMessage(Data.getHeader() );
			p.sendMessage(Data.Prefix + "Name: §c" + p.getName() + "§8 | §7Rang: " + Utils.getRang(p));
			p.sendMessage(Data.Prefix + "§7Clan: §c" + pc.getClan() + "§8 | §7Coins: §c" + german.format(pc.getCoins())) ;
			p.sendMessage(Data.Prefix + "§7Kills: §c" + pc.getKills() + "§8 | §7Tode: §c" + pc.getTode() + "§8 | §7KD: §c" + getKD(p) );
			p.sendMessage(Data.Prefix + "§7Killstreak: §c" + pc.getKillstreak() + "§8 | §7 Kopfgeld: §c" + german.format(pc.getKopfgeld()));
			p.sendMessage(Data.getHeader() );
		}
		
		
		
		return false;
	}
	
	
	public static String getKD(Player p) {
		PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
		
		double kdr =  (double)pc.getKills() / (double)pc.getTode();
		final java.text.DecimalFormat german
	    = new java.text.DecimalFormat( "###,###.##");
		
		if(kdr == pc.getKills()) {
			return german.format(pc.getKills());
		} else if(kdr == 0) {
			return german.format(0);
		} else return german.format(kdr);
		
		
	}
	
	
	
	
	
	

}
