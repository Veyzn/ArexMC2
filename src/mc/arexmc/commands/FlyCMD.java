package mc.arexmc.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;





public class FlyCMD implements CommandExecutor{
	
	public static ArrayList<String> fly = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = (Player)sender;
		if (p.hasPermission("amc.fly"))
		{
			if (args.length == 0)
			{
				if (!fly.contains(p.getName()))
				{
					p.setAllowFlight(true);
					fly.add(p.getName());
					p.sendMessage(Data.Prefix + "Dein Flug-Modus wurde §aaktiviert§7.");
				}
				else
				{
					p.setAllowFlight(false);
					fly.remove(p.getName());
					p.sendMessage(Data.Prefix + "Dein Flug-Modus wurde §cdeaktiviert§7.");
				}
			}
			else if (args.length == 1)
			{
				if (p.hasPermission("amc.fly.other"))
				{
					Player p2 = Bukkit.getPlayer(args[0]);
					if (!fly.contains(p2.getName()))
					{
						p2.setAllowFlight(true);
						fly.add(p2.getName());
						p.sendMessage(Data.Prefix + "Der Flug-Modus von §c" + p2.getName() + " §7wurde §aaktiviert§7.");
					}
					else
					{
						p2.setAllowFlight(false);
						fly.remove(p2.getName());
						p.sendMessage(Data.Prefix + "Der Flug-Modus von§c " + p2.getName() + "§7 wurde §cdeaktiviert§7.");
					}
				}
				else
				{
					p.sendMessage(Data.noperms);
				}
				}
			}
		else
		{
			p.sendMessage(Data.noperms);
		}
		return true;
	}

}
