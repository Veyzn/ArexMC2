package mc.arexmc.broadcast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;

public class BroadcastAPI {
	
	
	public static void createCFG() {
		
		File file = new File("plugins/ArexMC/broadcaster");
			
		
				 
		if(file.exists()) {
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void startCasting() {
		
		ArrayList<String> messages = new ArrayList<>();
		messages.add("Du willst den Server unterstützen? §c/Spenden");
		messages.add("Du benötigst Hilfe? Dann joine auch unseren Teamspeak. §cArexMC.EU");
		messages.add("Du siehst einen Hacker? §c/Report <Spieler> <Grund>");
		messages.add("Du willst Gratis Items bekommen? §c/Vote§7 und erhalte tolle Belohnungen!");
		messages.add("Noch keine Island? Dann benutze §c/Island §7und erstelle dir eine!");
		messages.add("Du kennst die Regeln nicht? §c/Regeln");
		messages.add("Du interessierst dich dafür wer im Team ist? §c/Team");
		messages.add("Willst du die neusten Infos vom Server? §c/discord");
		
		new BukkitRunnable() {
			int message = messages.size();
			@Override
			public void run() {
				
				Bukkit.broadcastMessage(Data.broadcast + messages.get(message - 1));
				message--;
				if(message == 0) {
					message = messages.size();
				}
				
				
			}
		}.runTaskTimerAsynchronously(Main.instance, 20, 20 * 60 * 5);
		
	}

}
