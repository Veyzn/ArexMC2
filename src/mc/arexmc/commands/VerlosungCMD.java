package mc.arexmc.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;



public class VerlosungCMD implements CommandExecutor {

	public static int task = 31;
	boolean aktiv = false;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender; 
		ItemStack item = p.getItemInHand();
		String defaultname = item.getType().name();
		if(p.hasPermission("amc.verlosung")) {
			
			if(args.length == 0) {
				
				
				if(aktiv == false) {
				if(!(p.getItemInHand().getType() == Material.AIR)) {
					aktiv = true;
					
					int random = new Random().nextInt(Bukkit.getServer().getOnlinePlayers().size());
					Player p1 = (Player)Bukkit.getServer().getOnlinePlayers().toArray()[random];
					p.getInventory().removeItem(p.getItemInHand());
					task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {

						int zahl = 10;
						@Override
						public void run() {

							
							if(zahl == 10) {
								if(item.getItemMeta().hasDisplayName()) {
									Bukkit.broadcastMessage("");
								Bukkit.broadcastMessage(Data.Prefix + "In §c10 Sekunden§7 wird ein zufälliger Spieler §c" + item.getAmount() + "x §7mal §c" + item.getItemMeta().getDisplayName() + "§7 erhalten.");
								Bukkit.broadcastMessage("");
								} else {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage(Data.Prefix + "In §c10 Sekunden§7 wird ein zufälliger Spieler §c" + item.getAmount() + "x §7mal §c" + defaultname + "§7 erhalten.");
									Bukkit.broadcastMessage("");
								}
								
							}
							
							if(zahl == 3) {
								Bukkit.broadcastMessage(Data.Prefix + "In §c3 Sekunden§7 wird es aufgelöst.");
							}
							if(zahl == 2) {
								Bukkit.broadcastMessage(Data.Prefix + "In §c2 Sekunden§7 wird es aufgelöst.");
							}
							if(zahl == 1) {
								Bukkit.broadcastMessage(Data.Prefix + "In §ceiner Sekunde§7 wird es aufgelöst.");
							}
							if(zahl == 0) {
								if(item.getItemMeta().hasDisplayName()) {
								Bukkit.broadcastMessage(Data.Prefix + "Der Spieler §c" + p1.getName() + "§7 hat §c" + item.getAmount() + "x §7das Item §c" + item.getItemMeta().getDisplayName() + " §7erhalten.");
								} else {
									Bukkit.broadcastMessage(Data.Prefix + "Der Spieler §c" + p1.getName() + "§7 hat §c" + item.getAmount() + "x §7das Item §c" + defaultname + " §7erhalten.");
									
								}
								aktiv = false;
								p1.getInventory().addItem(item);
								Bukkit.getScheduler().cancelTask(task);
							}
							
							zahl--;
							
							
							
						}
						
					}, 0, 20);
					
					
				} else p.sendMessage(Data.Prefix + "Du musst ein Item/Block in der Hand halten.");
				} else p.sendMessage(Data.Prefix + "Derzeit läuft eine Verlosung.");
			} else if(args.length == 1) {
				
				
				int anzahl = Integer.parseInt(args[0]);
				if(anzahl != 0 && anzahl > 0 && anzahl < 10) {

					if(item.getItemMeta().hasDisplayName()) {
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(Data.Prefix + "Jetzt werden §c" + anzahl + "x Zufällige Spieler §7ausgewählt und bekommen das Item §c" + item.getAmount() + "x" + item.getItemMeta().getDisplayName());
						Bukkit.broadcastMessage("");
						} else {
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage(Data.Prefix + "Jetzt werden §c" + anzahl + "x Zufällige Spieler §7ausgewählt und bekommen das Item §c" + item.getAmount() + "x " + defaultname);
							Bukkit.broadcastMessage("");
						}
						
					
				new BukkitRunnable() {
					
					int anzahl2 = Integer.parseInt(args[0]);
					int i = 1;
					@Override
					public void run() {
						if(anzahl2 != 0) {
							int r2 = new Random().nextInt(Bukkit.getOnlinePlayers().size());
					        final Player random2 = (Player)Bukkit.getOnlinePlayers().toArray()[r2];
						Bukkit.broadcastMessage(Data.Prefix + "#"+ i + " §c" + random2.getName());
						random2.getInventory().addItem(item);
						} else {
							this.cancel();
						}
						
						anzahl2--;
						i++;
						
					}
				}.runTaskTimer(Main.instance, 20, 20);
				
				
				} else p.sendMessage(Data.random + "Du musst höher als 1 eingeben und es darf maximal mit 10 gehen.");
			} else p.sendMessage(Data.verwendung + "/verlosung> <Anzahl>");
			
		}
		return false;
	}

}
