package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import mc.arexmc.clan.ClanData;
import mc.arexmc.clan.RankingUtil;
import mc.arexmc.main.Data;

public class AbfallCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
		Player p = (Player) sender;
		
		Inventory abfall = Bukkit.createInventory(null, 4*9, "§cAbfall");
		p.openInventory(abfall);
		ClanData clan = new ClanData("Team");
			clan.addPlayer(p);
		} else System.out.println(Data.console);
		
		return false;
	}

}
