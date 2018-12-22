package mc.arexmc.chatcolor;

import java.security.acl.Permission;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import mc.arexmc.main.Data;
import mc.arexmc.utils.Utils;
import mc.arexmc.utils.ItemstackAPI;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatcolorEvent implements Listener {
	
	@EventHandler
	public void onChangeColor(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().startsWith("§cChatcolor §8| §7Auswahl")) {
			e.setCancelled(true);
			if(e.getRawSlot() == 11) {		
				if(p.hasPermission("Chatcolor.hellgrün")) {
				ChatcolorAPI.setColor(p, "a");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §a§lHellgrün§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 13) {		
				if(p.hasPermission("Chatcolor.Lila")) {
				ChatcolorAPI.setColor(p, "5");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §5§lLila§7 als neue Chatcolor ausgewählt.");
				
				} else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 15) {		
				if(p.hasPermission("Chatcolor.Gold")) {
				ChatcolorAPI.setColor(p, "6");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §6§lGold§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			} 
			if(e.getRawSlot() == 19) {		
				if(p.hasPermission("Chatcolor.Blau")) {
				ChatcolorAPI.setColor(p, "9");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §9§lBlau§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 21) {		
				if(p.hasPermission("Chatcolor.Weiß")) {
				ChatcolorAPI.setColor(p, "f");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §f§lWeiss§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 23) {		
				if(p.hasPermission("Chatcolor.Türkis")) {
				ChatcolorAPI.setColor(p, "3");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §3§lTürkis§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 25) {		
				if(p.hasPermission("Chatcolor.Hellblau")) {
				ChatcolorAPI.setColor(p, "b");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §b§lHellblau§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 29) {		
				if(p.hasPermission("Chatcolor.Grün")) {
				ChatcolorAPI.setColor(p, "2");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §2§lGrün§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 31) {		
				if(p.hasPermission("Chatcolor.Gelb")) {
				ChatcolorAPI.setColor(p, "e");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §e§lGelb§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			if(e.getRawSlot() == 33) {		
				if(p.hasPermission("Chatcolor.Pink")) {
				ChatcolorAPI.setColor(p, "d");
				p.closeInventory();
				p.sendMessage(Data.Prefix + "Du hast die Farbe §d§lPink§7 als neue Chatcolor ausgewählt.");
				
				}else p.sendMessage(Data.Prefix + "Du hast diese Farbe nicht freigeschaltet!");
			}
			
			
			
			
			
			
		}
		
		
		if(e.getInventory().getName().startsWith("§cChatcolor §8| §7Gutscheine")) {
			e.setCancelled(true);
			
			if(e.getRawSlot() == 11) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §aHellgrün§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 10, 1, "§c§lFarbe §8» §a§lHellgrün", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 12) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §5Lila§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 5, 1, "§c§lFarbe §8» §5§lLila", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 13) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §6Gold§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 14, 1, "§c§lFarbe §8» §6§lGold", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 14) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §9Blau§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 4, 1, "§c§lFarbe §8» §9§lBlau", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 15) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §fWeiss§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(353, 0, 1, "§c§lFarbe §8» §f§lWeiss", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}

			if(e.getRawSlot() == 21) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §bHellblau§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 12, 1, "§c§lFarbe §8» §b§lHellblau", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 22) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §2Grün§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 2, 1, "§c§lFarbe §8» §2§lGrün", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 23) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §eGelb§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 11, 1, "§c§lFarbe §8» §e§lGelb", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			if(e.getRawSlot() == 24) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §dPink§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 9, 1, "§c§lFarbe §8» §d§lPink", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			if(e.getRawSlot() == 20) {	
				ArrayList<String> lore = new ArrayList<>();
				lore.add("");
				lore.add("§8■ §7Mit <§eRechtsklick§7> löst du die Farbe §3Türkis§7 ein.");
				lore.add("");
				p.getInventory().addItem(ItemstackAPI.CreateItemId(351, 6, 1, "§c§lFarbe §8» §3§lTürkis", lore));
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5F, 5F);
			}
			
			
			
			
		}
		
	}
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();

		try {
			
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §a§lHellgrün")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Hellgrün");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §a§lHellgrün§7 freigeschaltet.");
			} else 
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §5§lLila")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Lila");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §5§lLila§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §6§lGold")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Gold");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §6§lGold§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §9§lBlau")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Blau");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §9§lBlau§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §f§lWeiss")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Weiß");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §f§lWeiss§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §3§lTürkis")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Türkis");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §3§lTürkis§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §b§lHellblau")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Hellblau");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §b§lHellblau§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §2§lGrün")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Grün");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §2§lGrün§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §e§lGelb")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Gelb");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §e§lGelb§7 freigeschaltet.");
			} else
			
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFarbe §8» §d§lPink")) {
				PermissionUser user = PermissionsEx.getUser(p.getName());
				user.addPermission("Chatcolor.Pink");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Utils.removeItemFromHand(p, 1);
				p.sendMessage(Data.Prefix + "Du hast die Farbe §d§lPink§7 freigeschaltet.");
			}
			
		
			
			
			
		}
		} catch (NullPointerException e2) {
			
		}
			
		
		
	}

}
