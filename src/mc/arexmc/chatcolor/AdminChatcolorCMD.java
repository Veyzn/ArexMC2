package mc.arexmc.chatcolor;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;

import mc.arexmc.utils.ItemstackAPI;



public class AdminChatcolorCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof ConsoleCommandSender) {
			 System.out.println("Dieser Commmand ist für einen Spieler");
			} else {
		Player p = (Player) sender;
		
		if(p.hasPermission("Chatcolor.admin")) {
			Inventory inv = Bukkit.createInventory(null, 4*9, "§cChatcolor §8| §7Gutscheine");
			for(int i = 0; i < inv.getSize(); i++) {
				inv.setItem(i, ItemstackAPI.CreateItemId(160, 15, 1, "§7", null));
			}
			ArrayList<String> lore = new ArrayList<>();
			lore.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §aHellgrün§7 als Gutschein");
			inv.setItem(11, ItemstackAPI.CreateItemId(351, 10, 1, "§cChatcolor §8| §a§lHellgrün", lore));


			ArrayList<String> lore1 = new ArrayList<>();
			lore1.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §5Lila§7 als Gutschein");
			inv.setItem(12, ItemstackAPI.CreateItemId(351, 5, 1, "§cChatcolor §8| §5§lLila", lore1));
			
			ArrayList<String> lore2 = new ArrayList<>();
			lore2.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §6Gold§7 als Gutschein");
			inv.setItem(13, ItemstackAPI.CreateItemId(351, 14, 1, "§cChatcolor §8| §6§lGold", lore2));
			
			ArrayList<String> lore3 = new ArrayList<>();
			lore3.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §9Blaua§7 als Gutschein");
			inv.setItem(14, ItemstackAPI.CreateItemId(351, 4, 1, "§cChatcolor §8| §9§lBlau", lore3));
			
			ArrayList<String> lore4 = new ArrayList<>();
			lore4.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §fWeiss§7 als Gutschein");
			inv.setItem(15, ItemstackAPI.CreateItemId(353, 0, 1, "§cChatcolor §8| §f§lWeiss", lore4));
			
			ArrayList<String> lore5 = new ArrayList<>();
			lore5.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §3Türkis§7 als Gutschein");
			inv.setItem(20, ItemstackAPI.CreateItemId(351, 6, 1, "§cChatcolor §8| §3§lTürkis", lore5));
			
			ArrayList<String> lore6 = new ArrayList<>();
			lore6.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §bHellblau§7 als Gutschein");
			inv.setItem(21, ItemstackAPI.CreateItemId(351, 12, 1, "§cChatcolor §8| §b§lHellblau", lore6));
			
			ArrayList<String> lore7 = new ArrayList<>();
			lore7.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §2Grün§7 als Gutschein");
			inv.setItem(22, ItemstackAPI.CreateItemId(351, 2, 1, "§cChatcolor §8| §2§lGrün", lore7));
			
			ArrayList<String> lore8 = new ArrayList<>();
			lore8.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §eGelb§7 als Gutschein");
			inv.setItem(23, ItemstackAPI.CreateItemId(351, 11, 1, "§cChatcolor §8| §e§lGelb", lore8));
			
			ArrayList<String> lore9 = new ArrayList<>();
			lore9.add("§8■ §7Mit <§eLinksklick§7> kriegst du die Farbe §dPink§7 als Gutschein");
			inv.setItem(24, ItemstackAPI.CreateItemId(351, 9, 1, "§cChatcolor §8| §d§lPink", lore9));
			
			p.openInventory(inv);
			
		}
 		
			} 
		return false;
	}

}
