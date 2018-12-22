package mc.arexmc.clan;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import mc.arexmc.main.Data;
import mc.arexmc.utils.PlayerCache;

public class ClanData {

	File file;
	YamlConfiguration cfg;
	String ClanName;

	public static void createCFG() {
		File ordner = new File("plugins/ArexMC/Clan");
		if (!ordner.exists()) {
			ordner.mkdir();
		}
	}

	public ClanData(String ClanName1) {

		ClanName = ClanName1;

		file = new File("plugins/ArexMC/Clan/" + ClanName.toLowerCase() + ".yml");
		cfg = new YamlConfiguration().loadConfiguration(file);

	}

	public void createClan(Player p) {
		if (!file.exists()) {
			try {
				file.createNewFile();
				cfg.set("Name", ClanName);
				cfg.set("Owner", p.getUniqueId().toString());
				cfg.set("Kills", 0);
				cfg.set("Tode", 0);
				cfg.set("Color", "7");
				PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
				pc.setClan(ClanName);

				cfg.save(file);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean clanExists() {
		if (file.exists()) {
			return true;
		} else
			return false;
	}

	public void deleteClan(Player p) {
		PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
		pc.setClan("Keinen");
		
		for(int i = 0; i < getMembers().size(); i++) {
			List<String> members = getMembers();
			PlayerCache member = new PlayerCache(members.get(i));
			member.setClan("Keinen");
		}
		
		file.delete();
	}

	public void addPlayer(String UUID) {
		try {
			PlayerCache pc = new PlayerCache(UUID);
			pc.setClan(ClanName);
			List<String> Member = cfg.getStringList("Members");
			Member.add(UUID);
			cfg.set("Members", Member);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removePlayer(String UUID) {
		try {
			PlayerCache pc = new PlayerCache(UUID);
			pc.setClan("Keinen");
			
			List<String> Member = cfg.getStringList("Members");
			Member.remove(UUID);
			cfg.set("Members", Member);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isClan(Player p) {
		PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
		if (pc.getClan().equalsIgnoreCase(ClanName)) {
			return true;
		} else
			return false;
	}

	public void checkLevelUp() {

		if (getKills() == 50) {

			setColor("a");
		} else if (getKills() == 100) {
			setColor("2");
		} else if (getKills() == 250) {
			setColor("b");
		} else if (getKills() == 500) {
			setColor("3");
		} else if (getKills() == 750) {
			setColor("8");
		} else if (getKills() == 1000) {
			setColor("9");
		} else if (getKills() == 1250) {
			setColor("5");
		} else if (getKills() == 1500) {
			setColor("d");
		} else if (getKills() == 1750) {
			setColor("e");
		} else if (getKills() == 2000) {
			setColor("6");
		} else if (getKills() == 2500) {
			setColor("f");
		} else if (getKills() == 3500) {
			setColor("c");
		} else if (getKills() == 5000) {
			setColor("4");
		}

	}

	public int getKills() {
		return cfg.getInt("Kills");
	}

	public int getTode() {
		return cfg.getInt("Tode");
	}

	public String getTag() {
		return cfg.getString("Name");
	}

	public String getColor() {
		return cfg.getString("Color");
	}

	public static List getClans() {

		File ordner = new File("plugins/ArexMC/Clan");
		List<String> clans = new ArrayList<>();

		for (File files : ordner.listFiles()) {
			clans.add(files.getName().replaceAll(".yml", ""));
		}

		return clans;

	}

	public void addKills(int amount) {
		try {

			cfg.set("Kills", getKills() + amount);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addTode(int amount) {
		try {

			cfg.set("Tode", getTode() + amount);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeTode(int amount) {
		try {

			cfg.set("Tode", getTode() - amount);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeKills(int amount) {
		try {

			cfg.set("Tode", getKills() - amount);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setColor(String color) {
		try {

			cfg.set("Color", color);
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<String> getMembers() {
		return cfg.getStringList("Members");
	}
	
	public void sendClanMessage(String Message) {
		
		PlayerCache Owner = new PlayerCache(getOwner());
		Player owner = Bukkit.getPlayer(Owner.getName());
		if(owner != null) {
		owner.sendMessage(Data.Clan + Message);
		}
		if(getMembers().size() > 0) {
		for(int i = 0; i < getMembers().size(); i++) {
			List<String> list = getMembers();
			PlayerCache member = new PlayerCache(list.get(i));
			Player p = Bukkit.getPlayer(member.getName());
			if(p != null) {
			p.sendMessage(Data.Clan + Message);
			}
		}
		
		}
	}
	
	public String getOwner() {
		return cfg.getString("Owner");
	}
	
	

}
