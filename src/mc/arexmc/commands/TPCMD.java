package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;





public class TPCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)  {
		Player p = (Player)sender;
		if(p.hasPermission("amc.tp")) {
		if(args.length == 1) {
			
			Player target = Bukkit.getPlayer(args[0]);
			
			if(target !=null) {
			
			p.teleport(target);
			p.sendMessage(Data.Prefix+"Du wurdest zu dem Spieler §c" + target.getName() + " §7teleportiert.");
			
			} else p.sendMessage(Data.offline);
			
		} else p.sendMessage(Data.verwendung+"/tp <Spieler>");
		
		} else p.sendMessage(Data.noperms);
		} else System.out.println(Data.console);
		return false;
	}
 
}
