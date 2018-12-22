package mc.arexmc.antiwerbung;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;



public class BlockWordCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof ConsoleCommandSender) {
			System.out.println("Dieser Command ist für Spieler");
		} else {
			Player p = (Player) sender;
			
			if(p.hasPermission("ArexMC.Antiblock")) {
				if(args.length == 2) {
					if(args[0].equalsIgnoreCase("add")) {
						String word = args[1];
						
						if(!BlockWordAPI.contains(word)) {
							BlockWordAPI.addWord(word);
							p.sendMessage(Data.Prefix + "Du hast das Wort §c" + word + "§7 erfolgreich hinzugefügt");
						} else p.sendMessage(Data.Prefix + "Das Wort exestiert bereits in der Liste.");
						
					} else if(args[0].equalsIgnoreCase("remove")) {
						String word = args[1];
						if(BlockWordAPI.contains(word)) {
							BlockWordAPI.removeWord(word);
							p.sendMessage(Data.Prefix + "Du hast das Wort §c" + word + "§7 erfolgreich entfernt");
						} else p.sendMessage(Data.Prefix + "Das Wort ist nicht  in der Liste.");
						
					
					} else if(args[0].equalsIgnoreCase("list")) {
						
						List<String> words = BlockWordAPI.getList();
						p.sendMessage(Data.getHeader());
						for(int i = 0; i < words.size(); i++) {
							p.sendMessage("§8§l» §c" + words.get(i));
						}
						p.sendMessage(Data.getHeader());
					
					} else p.sendMessage(Data.verwendung + "/blockword [Add | Remove | List]");	 				
				} else if(args.length == 1) {
                         if(args[0].equalsIgnoreCase("list")) {
						
						List<String> words = BlockWordAPI.getList();
						p.sendMessage(Data.getHeader());
						for(int i = 0; i < words.size(); i++) {
							p.sendMessage("§8§l» §c" + words.get(i));
						}
						p.sendMessage(Data.getHeader());
                         } else p.sendMessage(Data.verwendung + "/blockword [Add | Remove | List]");
				} else p.sendMessage(Data.verwendung + "/blockword [Add | Remove | List]");
			} else p.sendMessage(Data.noperms);
			
			
			
			
			
			
			
		}
		
		return false;
	}

}
