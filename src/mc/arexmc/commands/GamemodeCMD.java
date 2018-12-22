package mc.arexmc.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;


public class GamemodeCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

		
		if(sender instanceof ConsoleCommandSender) {
			 System.out.println("Dieser Commmand ist für einen Spieler");
			} else {
				
			
		Player p = (Player) sender;
		
		if(p.hasPermission("amc.gamemode")) {
		if(args.length == 1) {
			
				if(Main.isInt(args[0])) {
					int zahl = Integer.parseInt(args[0]);
						if(zahl == 0) {
							p.sendMessage(Data.Prefix + "Du bist nun im §cSurvival-Modus§7.");
							p.setGameMode(GameMode.SURVIVAL);
							
						} else	if(zahl == 1) {
							p.setFoodLevel(20);
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage(Data.Prefix + "Du bist nun im §cCreative-Modus§7.");
						} else	if(zahl == 2) {
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage(Data.Prefix + "Du bist nun im §cAdventure-Modus§7.");
						} else	if(zahl == 3) {
							p.sendMessage(Data.Prefix + "Du bist nun im §cSpectator-Modus§7.");
							p.setGameMode(GameMode.SPECTATOR);
						}  else p.sendMessage(Data.verwendung + "/gamemode [ 0 | 1 | 2 | 3 ]");
					
				} else p.sendMessage(Data.Prefix + "Bitte gebe eine gültige Zahl ein.");
			} else p.sendMessage(Data.verwendung + "/gamemode [ 0 | 1 | 2 | 3 ]");
			} else p.sendMessage(Data.noperms);
		
			}
		
		return false;
	}

}
