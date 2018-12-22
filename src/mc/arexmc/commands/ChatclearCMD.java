package mc.arexmc.commands;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import mc.arexmc.main.Data;

public class ChatclearCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof ConsoleCommandSender) {
		 System.out.println("Dieser Commmand ist für einen Spieler");
		} else {
			
			
		
		
		Player p = (Player) sender;
		
		
		if(p.hasPermission("amc.chatclear")) {
			
			for(Player all: Bukkit.getOnlinePlayers()) {
				if(!all.hasPermission("amc.chatclear.bypass")) {
					for(int i = 0; i < 100; i++) {
					all.sendMessage("");
					}
				}
			}
			
			Bukkit.broadcastMessage(Data.Prefix + "Der Spieler §c" + p.getName() + "§7 hat den Chat geleert.");
			
			
			
		} else p.sendMessage(Data.noperms);
		}
		return false;
		}
	

}
