package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;






public class CountdownCMD implements CommandExecutor {
	int task = 31;
	boolean on = false;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			System.out.println(Data.console);
		} else {
		Player p = (Player) sender;
		
		
		if(p.hasPermission("NightFront.countdown")) {
			if(args.length == 1 ) {
				if(on == false) { 
				int zahl = Integer.parseInt(args[0]);
				if(Main.isInt(args[0])) {
					
					Bukkit.broadcastMessage(Data.Prefix + "Der Spieler §c" + p.getName() + "§7 hat einen Countdown von §c" + zahl +  " Sekunden §7gestartet.");
					on = true;
					task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
						int noch = zahl;
						@Override
						public void run() {
							noch--;
							
							if(noch == 180) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c190 Sekunden§7.");
								
							}
							
							if(noch == 120) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c120 Sekunden§7.");
								
							}
							
							if(noch == 60) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c60 Sekunden§7.");
								
							}
							
							if(noch == 50) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c50 Sekunden§7.");
								
							}
							if(noch == 40) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c40 Sekunden§7.");
								
							}
							
							if(noch == 30) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c30 Sekunden§7.");
								
							}
							
							if(noch == 20) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c20 Sekunden§7.");
								
							}
							
							
							
							if(noch == 10) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c10 Sekunden§7.");
								
							}
							
							
							
				
							if(noch == 5) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c5 Sekunden§7.");
								
							}
							
							
							if(noch == 4) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c4 Sekunden§7.");
								
							}
							
							if(noch == 3) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c3 Sekunden§7.");
								
							}
							
							
							if(noch == 2) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §c2 Sekunden§7.");
								
							}
							
							if(noch == 1) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 5F, 5F);
									
								}
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown§7 endet in §ceiner Sekunde§7.");
								
							}
							
							if(noch == 0) {
								
								Bukkit.broadcastMessage(Data.Prefix + "Der §cCountdown §7ist nun zu §cEnde");
								Bukkit.getScheduler().cancelTask(task);
								on = false;
								
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.EXPLODE, 5F, 5F);
								}
							}
							
							
							
						}
						
					}, 0, 20);
				} else p.sendMessage(Data.Prefix + "Bitte gebe eine gültige Zahl ein.");
				} else p.sendMessage(Data.Prefix + "Es läuft derzeit ein §cCountdown.");
			} else p.sendMessage(Data.verwendung + "/countdown <Zahl>");
		} else p.sendMessage(Data.noperms);
		}
		return false;
	}

}
