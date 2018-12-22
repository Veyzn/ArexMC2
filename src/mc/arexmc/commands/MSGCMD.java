package mc.arexmc.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class MSGCMD implements CommandExecutor {
	public static HashMap<Player, Player> msg = new HashMap<>();

	public static ArrayList<UUID> socialspy = new ArrayList();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
			Player p = (Player) sender;

			if (args.length > 1) {
				Player target = Bukkit.getPlayer(args[0]);

				String message = "";
				for (int i = 1; i < args.length; i++) {
					message = message + args[i] + " ";
				}
				if (target != null) {
					if (target != p) {
						p.sendMessage(Data.Prefix + "§cDu zu §6" + target.getName() + "§8: §c" + message);
						target.sendMessage(Data.Prefix + "§6" + p.getName() + "§c schreibt §8: §c" + message);
						msg.put(target, p);
						msg.put(p, target);
						target.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10.0F, 10.0F);
						for (UUID all : socialspy) {
							if ((Bukkit.getPlayer(all) != null)
									&& (!Bukkit.getOfflinePlayer(all).getName().equalsIgnoreCase(p.getName()))
									&& (!Bukkit.getOfflinePlayer(all).getName().equalsIgnoreCase(target.getName()))) {
								Bukkit.getPlayer(all).sendMessage("§6SocialSpy §8• §e" + p.getName() + " §8» §6"
										+ target.getName() + " §8» §c" + message);
							}
						}
					} else
						p.sendMessage(Data.Prefix + "§7Du kannst dir nicht selbst schreiben.");

				} else {
					p.sendMessage(Data.Prefix + "Der Spieler ist nicht Online");
				}

			} else
				p.sendMessage(Data.verwendung + "/msg <Spieler> <Nachricht>");
		}
		return true;
	}
}
