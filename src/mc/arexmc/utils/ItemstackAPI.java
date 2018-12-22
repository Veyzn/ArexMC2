package mc.arexmc.utils;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemstackAPI {

	public static ItemStack CreateItemId(int id, int subid, int amount, String DisplayName, ArrayList<String> lore) {
		ItemStack is = new ItemStack(id, amount, (short) subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(lore);
		is.setItemMeta(im);
		
		return is;
	}
}
