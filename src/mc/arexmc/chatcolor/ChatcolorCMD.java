package mc.arexmc.chatcolor;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import mc.arexmc.utils.ItemstackAPI;



public class ChatcolorCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(sender instanceof ConsoleCommandSender) {
			 System.out.println("Dieser Commmand ist für einen Spieler");
			} else {
		
		Player p = (Player) sender;
		
		Inventory inv = Bukkit.createInventory(null, 5*9, "§cChatcolor §8| §7Auswahl");
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, ItemstackAPI.CreateItemId(160, 15, 1, "§7", null));
		}
		
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§8§m---------------------------------");
		lore1.add("");
		lore1.add("§8» §7Mit <§cLinksklick§7> wählst du die §aHellgrüne§7 Farbe aus.");
		lore1.add("");
		if(p.hasPermission("Chatcolor.hellgrün")) {
			lore1.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore1.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore1.add("");
		lore1.add("§8§m---------------------------------");
		inv.setItem(11, ItemstackAPI.CreateItemId(351, 10, 1, "§a§lHellgrün", lore1));
		
		//
		ArrayList<String> lore2 = new ArrayList<>();
		lore2.add("§8§m---------------------------------");
		lore2.add("");
		lore2.add("§8» §7Mit <§cLinksklick§7> wählst du die §5Lilane§7 Farbe aus.");
		lore2.add("");
		if(p.hasPermission("Chatcolor.Lila")) {
			lore2.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore2.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore2.add("");
		lore2.add("§8§m---------------------------------");
		inv.setItem(13, ItemstackAPI.CreateItemId(351, 5, 1, "§5§lLila", lore2));
		//
		ArrayList<String> lore3 = new ArrayList<>();
		
		lore3.add("§8§m---------------------------------");
		lore3.add("");
		lore3.add("§8» §7Mit <§cLinksklick§7> wählst du die §6Goldene§7 Farbe aus.");
		
		lore3.add("");
		if(p.hasPermission("Chatcolor.Gold")) {
			lore3.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore3.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore3.add("");
		lore3.add("§8§m---------------------------------");
		inv.setItem(15, ItemstackAPI.CreateItemId(351, 14, 1, "§6§lGold", lore3));
		//
		ArrayList<String> lore4 = new ArrayList<>();
		
		lore4.add("§8§m---------------------------------");
		lore4.add("");
		lore4.add("§8» §7Mit <§cLinksklick§7> wählst du die §9Blaue§7 Farbe aus.");
		lore4.add("");
		if(p.hasPermission("Chatcolor.Blau")) {
			lore4.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore4.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore4.add("");
		lore4.add("§8§m---------------------------------");
		inv.setItem(19, ItemstackAPI.CreateItemId(351, 4, 1, "§9§lBlau", lore4));
		//
		ArrayList<String> lore5 = new ArrayList<>();
		
		lore5.add("§8§m---------------------------------");
		lore5.add("");
		lore5.add("§8» §7Mit <§cLinksklick§7> wählst du die §fWeisse§7 Farbe aus.");
		lore5.add("");
		if(p.hasPermission("Chatcolor.Weiß")) {
			lore5.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore5.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore5.add("");
		lore5.add("§8§m---------------------------------");
		inv.setItem(21, ItemstackAPI.CreateItemId(353, 0, 1, "§f§lWeiss", lore5));
		//
		ArrayList<String> lore6 = new ArrayList<>();
		lore6.add("§8§m---------------------------------");
		lore6.add("");
		lore6.add("§8» §7Mit <§cLinksklick§7> wählst du die §3Türkis§7 Farbe aus.");
		lore6.add("");
		if(p.hasPermission("Chatcolor.Türkis")) {
			lore6.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore6.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore6.add("");
		lore6.add("§8§m---------------------------------");
		inv.setItem(23, ItemstackAPI.CreateItemId(351, 6, 1, "§3§lTürkis", lore6));
		//
		ArrayList<String> lore7 = new ArrayList<>();
		lore7.add("§8§m---------------------------------");
		lore7.add("");
		lore7.add("§8» §7Mit <§cLinksklick§7> wählst du die §bHell Blaue§7 Farbe aus.");
		lore7.add("");
		if(p.hasPermission("Chatcolor.Hellblau")) {
			lore7.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore7.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore7.add("");
		lore7.add("§8§m---------------------------------");
		inv.setItem(25, ItemstackAPI.CreateItemId(351, 12, 1, "§b§lHellblau", lore7));
		//
		ArrayList<String> lore8 = new ArrayList<>();
		lore8.add("§8§m---------------------------------");
		lore8.add("");
		lore8.add("§8» §7Mit <§cLinksklick§7> wählst du die §2Grüne§7 Farbe aus.");
		lore8.add("");
		if(p.hasPermission("Chatcolor.Grün")) {
			lore8.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore8.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore8.add("");
		lore8.add("§8§m---------------------------------");
		inv.setItem(29, ItemstackAPI.CreateItemId(351, 2, 1, "§2§lGrün", lore8));
		//
		ArrayList<String> lore9 = new ArrayList<>();
		lore9.add("§8§m---------------------------------");
		lore9.add("");
		lore9.add("§8» §7Mit <§cLinksklick§7> wählst du die §cGelbe§7 Farbe aus.");
		lore9.add("");
		if(p.hasPermission("Chatcolor.Gelb")) {
			lore9.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore9.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore9.add("");
		lore9.add("§8§m---------------------------------");
		inv.setItem(31, ItemstackAPI.CreateItemId(351, 11, 1, "§c§lGelb", lore9));
		//
		ArrayList<String> lore10 = new ArrayList<>();
		lore10.add("§8§m---------------------------------");
		lore10.add("");
		lore10.add("§8» §7Mit <§cLinksklick§7> wählst du die §dPinke§7 Farbe aus.");
		lore10.add("");
		if(p.hasPermission("Chatcolor.Pink")) {
			lore10.add("§8» §7Status: §aFreigeschaltet");
		} else {
			lore10.add("§8» §7Status: §cNicht Freigeschaltet");
		}
		lore10.add("");
		lore10.add("§8§m---------------------------------");
		inv.setItem(33, ItemstackAPI.CreateItemId(351, 9, 1, "§d§lPink", lore10));
		
		
		p.openInventory(inv);
		
			}
		
		return false;
	}
	

}
