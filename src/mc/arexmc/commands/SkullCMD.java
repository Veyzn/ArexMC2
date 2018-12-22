package mc.arexmc.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import mc.arexmc.main.Data;





public class SkullCMD implements CommandExecutor {
	
    //Date date = new Date();
    //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy / HH:mm:ss");
//    ArrayList<String> lores = new ArrayList<String>();
    
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if((sender instanceof Player)) {
			Player p = (Player)sender;
			if(p.hasPermission("amc.kopf") || p.hasPermission("amc.skull")) {
				if(args.length == 1) {
			        ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
			        SkullMeta im = (SkullMeta)is.getItemMeta();
			        im.setOwner(args[0]);
			        im.setDisplayName("§7Kopf von: §c" + args[0]);
//			        lores.clear();
//			        lores.add("§f");
//			        lores.add("§bKopf erstellt: §b" + sdf.format(date));
//			        lores.add("§f");
//			        im.setLore(lores);
			        is.setItemMeta(im);
			        p.getInventory().addItem(new ItemStack[] { is });
			        p.updateInventory();
			        p.sendMessage(Data.Prefix + "Du hast den Kopf von §c" + args[0] + "§7 in dein Inventar gelegt bekommen.");
				} else {
					p.sendMessage(Data.verwendung + "/skull <Spieler>");
				}
			} else {
				p.sendMessage(Data.noperms);
			}
		} else {
			System.out.println(Data.console);
		}
		return false;
	}

}
