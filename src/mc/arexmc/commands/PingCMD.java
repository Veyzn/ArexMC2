package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;




public class PingCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if ((sender instanceof Player))
		{
			Player p = (Player)sender;
			if (args.length == 0)
			{
				int ping = ((CraftPlayer)p).getHandle().ping;
				p.sendMessage(Data.Prefix + "§7Dein Ping§8: §c" + ping + "ms");
			}
			if (args.length == 1)
			{
				Player p2 = Bukkit.getPlayer(args[0]);
				if (p2 != p)
				{
					if (p2 != null)
					{
						int ping = ((CraftPlayer)p2).getHandle().ping;
						
						p.sendMessage(Data.Prefix + "§7" + p2.getName() + "§7's §7Ping§8: §c" + ping + "ms");
					}
					else
					{
						p.sendMessage(Data.offline);
					}
				}
			}
		}
		return false;
	}

}
