package mc.arexmc.utils;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerCache {

	public static File ordner = new File("plugins/ArexMC/Playercache");
	public static File config;
	public static YamlConfiguration cfg;
	public static String UUID;

	public PlayerCache(String UUID1) {

		UUID = UUID1;
		config = new File("plugins/ArexMC/Playercache/" + UUID1);
		cfg = new YamlConfiguration().loadConfiguration(config);

	}

	public static boolean isRegistered() {
		boolean bool;
		if(config.exists()) {
			bool = true;
		} else bool = false;
	return bool;
	}

	public void create(Player p) {

		if (!ordner.exists()) {
			ordner.mkdir();
		}

		if (!config.exists()) {
			try {
				config.createNewFile();
				Date zeit = new Date();
				SimpleDateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
				cfg.set("Name", p.getName());
				cfg.set("Clan", "Keinen");
				cfg.set("Bans", 0);
				cfg.set("Coins", 0);
				cfg.set("Kills", 0);
				cfg.set("Tode", 0);
				cfg.set("Kopfgeld", 0);
				cfg.set("Killstreak", 0);
				cfg.set("Warns", 0);
				cfg.set("Mutes", 0);
				cfg.set("FirstJoinIP", Utils.getIP(p));
				cfg.set("LastJoinIP", Utils.getIP(p));
				cfg.set("FirstJoin", datum.format(zeit));
				cfg.save(config);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public int getBans() {

		return cfg.getInt("bans");
	}

	public int getMutes() {

		return cfg.getInt("Mutes");
	}

	public int getWarns() {

		return cfg.getInt("Warns");
	}

	public int getFIP() {

		return cfg.getInt("FirstJoinIP");
	}

	public int getLIP() {

		return cfg.getInt("LastJoinIP");
	}

	public int getDateFirstJoin() {

		return cfg.getInt("FirstJoin");
	}

	public String getName() {

		return cfg.getString("Name");
	}

	public String getClan() {

		if(cfg.getString("Clan").equalsIgnoreCase("Keinen")) {
			return "Keinen";
		} else
		return cfg.getString("Clan");
	}

	public int getCoins() {

		return cfg.getInt("Coins");
	}

	public int getKills() {

		return cfg.getInt("Kills");
	}

	public int getTode() {

		return cfg.getInt("Tode");
	}

	public int getKillstreak() {

		return cfg.getInt("Killstreak");
	}

	public int getKopfgeld() {

		
		return cfg.getInt("Kopfgeld");
	}

	public void addBan(int anzahl) {

		try {
			cfg.set("Bans", getBans() + anzahl);
			cfg.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void addCoins(int anzahl) {

		try {
			cfg.set("Coins", getCoins() + anzahl);
			cfg.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void addKills(int anzahl) {

		try {
			cfg.set("Kills", getKills() + anzahl);
			cfg.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void addTode(int anzahl) {

		try {
			cfg.set("Tode", getTode() + anzahl);
			cfg.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void addKillstreak(int anzahl) {

		try {
			cfg.set("Killstreak", getKillstreak() + anzahl);
			cfg.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void addKopfgeld(int anzahl) {

		try {
			cfg.set("Kopfgeld", getKopfgeld() + anzahl);
			cfg.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addMute(int anzahl) {

		try {
			cfg.set("Mutes", getMutes() + anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void addWarn(int anzahl) {

		try {
			cfg.set("Warn", getWarns() + anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void removeTode(int anzahl) {

		try {
			cfg.set("Tode", getTode() + anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void removeKills(int anzahl) {

		try {
			cfg.set("Kills", getKills() + anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void removeCoins(int anzahl) {

		try {
			cfg.set("Coins", getCoins() + anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void removeKopfgeld(int anzahl) {

		try {
			cfg.set("Kopfgeld", getKopfgeld() - anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void removeKillstreak(int anzahl) {

		try {
			cfg.set("Killstreak", getKillstreak() - anzahl);
			cfg.save(config);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public boolean exists() {

		if (config.exists()) {
			return true;
		} else
			return false;

	}

	public void setLIP(Player p) {

		try {

			cfg.set("LastJoinIP", Utils.getIP(p));
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setName(Player p) {

		try {

			cfg.set("Name", p.getName());
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setCoins(int amount) {

		try {

			cfg.set("Coins", amount);
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setKills(int amount) {

		try {

			cfg.set("Kills", amount);
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setTode(int amount) {

		try {

			cfg.set("Tode", amount);
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setKillstreak(int amount) {

		try {

			cfg.set("Killstreak", amount);
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setKopfgeld(int amount) {

		try {

			cfg.set("Kopfgeld", amount);
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setClan(String Clan) {

		try {

			cfg.set("Clan", Clan);
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean isClaned() {
		if (!getClan().equalsIgnoreCase("Keinen")) {
			return true;
		} else {
			return false;
		}

	}

}
