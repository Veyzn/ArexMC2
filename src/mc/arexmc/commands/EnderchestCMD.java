package mc.arexmc.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;







public class EnderchestCMD implements CommandExecutor{
	
	public static ArrayList<UUID> ec = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		Player p = (Player)sender;
		if (!p.hasPermission("SkyTanic.enderchest")) {
			p.sendMessage(Data.noperms);
			return true;
		}
		if (args.length == 0)
		{
			p.sendMessage(Data.Prefix + "Du hast deine §5Enderchest §7geöffnet.");
			p.openInventory(p.getEnderChest());
		}
		else if (args.length == 1)
		{
			if (!p.hasPermission("SkyTanic.enderchest.other"))
			{
				p.sendMessage(Data.noperms);
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null)
			{
				p.sendMessage(Data.Prefix + "Der Spieler ist nicht Online");
			}
			p.openInventory(target.getEnderChest());
			p.sendMessage(Data.Prefix + "Du hast die §5Enderchest §7von §c" + target.getName() + "§7 geöffnet.");
			ec.contains(p.getUniqueId());
		}
		else
		{
			p.sendMessage(Data.verwendung + "/enderchest");
		}
		return true;
	}

}
