package mc.arexmc.main;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Data {
	
	public static ArrayList<Player> goded = new ArrayList<>();
	public static String Prefix = "§8[§c§lAREX§f§lMC§8] §7";
	public static String console = "Dieser Command ist nur für Spieler!";
	public static String noperms = Prefix + "Du hast nicht genügend Rechte!";
	public static String nichton = Prefix + "Der Spieler ist nicht Online";
	public static String verwendung = Prefix + "Bitte benutze §c";
	public static String random = "§8[§c§lRANDOM§8] §7";
	public static String teamchat = "§8[§6§lTEAMCHAT§8] §7";
	public static String offline = Prefix + "Der Spieler ist nicht Online";
	public static String Clan = "§8[§5§lCLAN§8] §7";
	public static String broadcast = "§8[§a§lWERBUNG§8] §7";
	public static String Crate = "§8[§c§lCRATE§8] §7";
	public static String Ban = "§8§l[§c§lBAN§8§l]";
	public static String Warn = "§8§l[§a§lWARN§8§l]";
	public static String Mute = "§8§l[§6§lMUTE§8§l]";
	public static String getHeader() {
		return "§8§l§m--------------§f» §c§lAREX§f§lMC §f«§8§l§m--------------";
		
		
		
	}
}
