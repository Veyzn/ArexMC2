package mc.arexmc.utils;

import java.text.DecimalFormat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.arexmc.clan.ClanData;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Utils {

	public static String getIP(Player p) {
		String[] adresse = p.getAddress().toString().replaceAll("/", "").split(":", 0);

		return adresse[0];
	}

	public static void removeItemFromHand(Player p, int amount) {
		if (p.getItemInHand().getAmount() > 1) {
			p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
		} else
			p.setItemInHand(new ItemStack(Material.AIR));
	}

	public static String getCTCF(Player p) {
		PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
		if (pc.isClaned()) {
			ClanData clan = new ClanData(pc.getClan());

			return "§" + clan.getColor() + clan.getTag() + "§8*";
		} else
			return "";

	}

	public static String getZahl(int Zahl) {
		DecimalFormat df = new DecimalFormat();

		String zahl = df.format(Zahl);

		return zahl.replace(",", ".");
	}

	public static String getRang(Player p) {
		
		PermissionUser user = PermissionsEx.getUser(p);
		
		if(user.inGroup("Owner")) {
			return "§4§lOWNER";
		} else if(user.inGroup("Admin")) {
			return "§c§lADMIN";
		} else if(user.inGroup("Developer")) {
			return "§b§lDEVELOPER";
		} else if(user.inGroup("Moderator")) {
			return "§5§lMODERATOR";
		} else if(user.inGroup("Builder")) {
			return "§6§lBUILDEr";
		} else if(user.inGroup("Supporter")) {
			return "§9§lSUPPORTER";
		} else if(user.inGroup("Guard")) {
			return "§3§lGUARD";
		} else if(user.inGroup("Youtuber")) {
			return "§f§lYOUTUBER";
		} else if(user.inGroup("Master")) {
			return "§c§lMASTER";
		} else if(user.inGroup("Predator")) {
			return "§9§lPREDATOR";
		} else if(user.inGroup("Wizard")) {
			return "§5§lWIZARD";
		} else if(user.inGroup("Hunter")) {
			return "§3§lHUNTER";
		} else
		
		
		return "§7§lSPIELER";

	};

}
