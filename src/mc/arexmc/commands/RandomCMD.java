package mc.arexmc.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;



public class RandomCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		
		if(p.hasPermission("amc.random")) {
			int r = new Random().nextInt(Bukkit.getOnlinePlayers().size());
	        final Player random = (Player)Bukkit.getOnlinePlayers().toArray()[r];
			if(args.length == 0) {
				
				Bukkit.broadcastMessage(Data.random + "Der Spieler §c" + random.getName() + "§7 wurde zufällig ausgewählt!");
				
			} else if(args.length == 1) {
				
				
				int anzahl = Integer.parseInt(args[0]);
				if(anzahl != 0 && anzahl > 0 && anzahl < 10) {

				new BukkitRunnable() {
					
					int anzahl2 = Integer.parseInt(args[0]);
					int i = 1;
					@Override
					public void run() {
						if(anzahl2 != 0) {
							int r2 = new Random().nextInt(Bukkit.getOnlinePlayers().size());
					        final Player random2 = (Player)Bukkit.getOnlinePlayers().toArray()[r2];
						Bukkit.broadcastMessage(Data.random + "#"+ i + " §c" + random2.getName());
						} else {
							this.cancel();
						}
						
						anzahl2--;
						i++;
						
					}
				}.runTaskTimer(Main.instance, 20, 20);
				} else p.sendMessage(Data.random + "Du musst höher als 1 eingeben und es darf maximal mit 10 gehen.");
				
				
			} else p.sendMessage(Data.verwendung + "/random <Anzahl>");
		} else p.sendMessage(Data.noperms);
		
		return false;
	}

}
