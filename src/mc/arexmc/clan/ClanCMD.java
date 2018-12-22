package mc.arexmc.clan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;
import mc.arexmc.utils.PlayerCache;

public class ClanCMD implements CommandExecutor {
	public static ArrayList<String> confirm = new ArrayList<>();
	public static HashMap<String, String> accept = new HashMap<>();
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
			if (args.length == 0) {
				p.sendMessage(Data.getHeader());
				p.sendMessage(Data.Prefix + "/clan erstellen <Clan> §8➡ §cUm einen Clan zu erstellen ");
				p.sendMessage(Data.Prefix + "/clan löschen §8➡ §cUm einen Clan zu löschen ");
				p.sendMessage(Data.Prefix + "/clan kick <Spieler> §8➡ §cUm einen Spieler aus dem Clan zu werfen ");
				p.sendMessage(Data.Prefix + "/clan einladen <Spieler> §8➡ §cUm einen Spieler einzuladen ");
				p.sendMessage(Data.Prefix + "/clan ablehnen §8➡ §cUm eine Anfrage abzulehnen ");
				p.sendMessage(Data.Prefix + "/clan verlassen §8➡ §cUm einen Clan zu verlassen ");
				p.sendMessage(Data.Prefix + "/clan annehmen §8➡ §cUm einem Clan beizutreten");
				p.sendMessage(Data.Prefix + "/clan ranking §8➡ §cUm die Top 10 Clans zu sehen");
				p.sendMessage(Data.Prefix + "/clan stats §8➡ §cUm die Statistiken vom Clan zu sehen ");
				p.sendMessage(Data.Prefix + "/clan stats <Clantag> §8➡ §cUm andere Statistiken anzuschauen ");
				p.sendMessage(Data.Prefix + "/clan farbe §8➡ §cUm alle erreichbaren Farben zu sehen ");
				p.sendMessage(Data.getHeader());
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("ranking")) {
					RankingUtil.getRanking(p);
				} else if (args[0].equalsIgnoreCase("verlassen")) {
					
					if(pc.isClaned()) {
						ClanData clan = new ClanData(pc.getClan());
						if (!clan.getOwner().equalsIgnoreCase(p.getUniqueId().toString())) {
							clan.removePlayer(p.getUniqueId().toString());
							clan.sendClanMessage("Der Spieler §c" + p.getName() + "§7 hat den Clan verlassen");
							p.sendMessage(Data.Prefix + "Du hast den Clan verlassen");
						} else
							p.sendMessage(Data.Prefix + "Bitte benutze §c/clan löschen");
					} else
						p.sendMessage(Data.Prefix + "Du bist in keinem Clan");
				} else if(args[0].equalsIgnoreCase("stats")) {
					
					if(pc.isClaned()) {
						ClanData clan = new ClanData(pc.getClan());
						PlayerCache owner = new PlayerCache(clan.getOwner());
						
						p.sendMessage(Data.getHeader());
						
						p.sendMessage(Data.Prefix + "Clan Tag: §" + clan.getColor() + clan.getTag());
						p.sendMessage(Data.Prefix + "Clan Owner: §e" + owner.getName());
						p.sendMessage(Data.Prefix + "Kills: §a" + clan.getKills() + "§8 | §7Tode: §c" + clan.getTode());
						p.sendMessage(Data.Prefix + "Mitglieder:");
						for(int i = 0; i < clan.getMembers().size(); i++) {
							List<String> list = clan.getMembers();
							PlayerCache member = new PlayerCache(list.get(i));
							Player memb = Bukkit.getPlayer(member.getName());
							
							if(memb != null) {
								p.sendMessage(Data.Prefix + "- §a" + memb.getName());
							} else p.sendMessage(Data.Prefix + "- §7" + memb.getName());
							
						}
						p.sendMessage(Data.getHeader());
						
						
						
						
						
					} else
						p.sendMessage(Data.Prefix + "Du bist in keinem Clan");
				} else if(args[0].equalsIgnoreCase("löschen")) {
					
					
					if(pc.isClaned()) {
						ClanData clan = new ClanData(pc.getClan());
						if(clan.getOwner().equalsIgnoreCase(p.getUniqueId().toString())) {
							if(confirm.contains(p.getName())) {
								confirm.remove(p.getName());
								clan.sendClanMessage("Der Clan wurde aufgelöst!");
								clan.deleteClan(p);
								
							} else if(!confirm.contains(p.getName())) {
								p.sendMessage(Data.Prefix + "Bitte bestätige innerhalb von 10 Sekunden das Löschen mit /clan löschen");
								confirm.add(p.getName());
								
								
								Bukkit.getScheduler().runTaskLaterAsynchronously(Main.instance, new Runnable() {

									@Override
									public void run() {
										confirm.remove(p.getName());
										
									}
									
								}, 200);
								
							}
						} else p.sendMessage(Data.Prefix + "Du bist nicht der Owner dieses Clans");						
					} else p.sendMessage(Data.Prefix + "Du bist in keinem Clan");
					
					
				} else if(args[0].equalsIgnoreCase("farbe")) {
					
					p.sendMessage(Data.getHeader());
					p.sendMessage(Data.Prefix + "50 Kills = §aClan");
					p.sendMessage(Data.Prefix + "100 Kills = §2Clan");
					p.sendMessage(Data.Prefix + "250 Kills = §bClan");
					p.sendMessage(Data.Prefix + "500 Kills = §3Clan");
					p.sendMessage(Data.Prefix + "750 Kills = §8Clan");
					p.sendMessage(Data.Prefix + "1.000 Kills = §9Clan");
					p.sendMessage(Data.Prefix + "1.250 Kills = §5Clan");
					p.sendMessage(Data.Prefix + "1.500 Kills = §dClan");
					p.sendMessage(Data.Prefix + "1.750 Kills = §eClan");
					p.sendMessage(Data.Prefix + "2.000 Kills = §6Clan");
					p.sendMessage(Data.Prefix + "2.500 Kills = §fClan");
					p.sendMessage(Data.Prefix + "3.500 Kills = §cClan");
					p.sendMessage(Data.Prefix + "5.000 Kills = §4Clan");
					
					p.sendMessage(Data.getHeader());
					
				} else if(args[0].equalsIgnoreCase("annehmen"))  {

					if(accept.containsKey(p.getName())) {
						
						ClanData clan = new ClanData(accept.get(p.getName()));
						clan.addPlayer(p.getUniqueId().toString());
						clan.sendClanMessage("Der Spieler §c" + p.getName() + " §7ist dem Clan beigetreten");
						accept.remove(p.getName());
					} else p.sendMessage(Data.Prefix + "Du hast keine Einladung bekommen");
					
				} else if(args[0].equalsIgnoreCase("ablehnen")) {
					

					if(accept.containsKey(p.getName())) {
						
						ClanData clan = new ClanData(accept.get(p.getName()));
					clan.sendClanMessage("Der Spieler §c" + p.getName() + " §7hat die Anfrage abgelehnt");
					p.sendMessage(Data.Prefix + "Du hast die Anfrage abgelehnt");
						accept.remove(p.getName());
					} else p.sendMessage(Data.Prefix + "Du hast keine Einladung bekommen");
					
				} else {
					p.sendMessage(Data.getHeader());
					p.sendMessage(Data.Prefix + "/clan erstellen §8➡ §cUm einen Clan zu erstellen ");
					p.sendMessage(Data.Prefix + "/clan löschen §8➡ §cUm einen Clan zu löschen ");
					p.sendMessage(Data.Prefix + "/clan kick <Spieler> §8➡ §cUm einen Spieler aus dem Clan zu werfen ");
					p.sendMessage(Data.Prefix + "/clan einladen <Spieler> §8➡ §cUm einen Spieler einzuladen ");
					p.sendMessage(Data.Prefix + "/clan verlassen §8➡ §cUm einen Clan zu verlassen ");
					p.sendMessage(Data.Prefix + "/clan annehmen §8➡ §cUm einem Clan beizutreten");
					p.sendMessage(Data.Prefix + "/clan ranking §8➡ §cUm die Top 10 Clans zu sehen");
					p.sendMessage(Data.Prefix + "/clan stats §8➡ §cUm die Statistiken vom Clan zu sehen ");
					p.sendMessage(Data.Prefix + "/clan stats <Clantag> §8➡ §cUm andere Statistiken anzuschauen ");
					p.sendMessage(Data.Prefix + "/clan farbe §8➡ §cUm alle erreichbaren Farben zu sehen ");
					p.sendMessage(Data.getHeader());
				}

			} else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("erstellen")) {
					
					if(!pc.isClaned()) {
						String name = args[1];
						ClanData clan = new ClanData(name);
						if(!clan.clanExists()) {
							if(name.length() <= 5) {
								clan.createClan(p);
								p.sendMessage(Data.Prefix + "Der Clan §c" + name + "§7 wurde erfolgreich erstellt!");
								
								
							} else p.sendMessage(Data.Prefix + "Der Clantag ist zu lange. Maximal 5 Buchstaben");
														
						} else p.sendMessage(Data.Prefix + "Dieser Clan existiert bereits");
						
					} else p.sendMessage(Data.Prefix + "Du bist derzeit in einem Clan");
					
				} else if(args[0].equalsIgnoreCase("kick")) {
					if(pc.isClaned()) {
						ClanData clan = new ClanData(pc.getClan());
						if(clan.getOwner().equalsIgnoreCase(p.getUniqueId().toString())) {
							
							if(clan.getMembers().contains(getUUID(args[1]))) {

								clan.sendClanMessage("Der Spieler §c" + args[1] + " §7wurde aus dem Clan geworfen");
								clan.removePlayer(getUUID(args[1]));
								
								
							} else p.sendMessage(Data.Prefix + "Der Spieler ist nicht in deinem Clan");
							
							
						} else p.sendMessage(Data.Prefix + "Du bist nicht der Clan Owner");
					} else p.sendMessage(Data.Prefix + "Du bist in keinem Clan");
				} else if(args[0].equalsIgnoreCase("stats")) {
					
					String clanname = args[1];
					ClanData clan = new ClanData(clanname);
					if(clan.clanExists()) {
                     PlayerCache owner = new PlayerCache(clan.getOwner());
						
						p.sendMessage(Data.getHeader());
						
						p.sendMessage(Data.Prefix + "Clan Tag: §" + clan.getColor() + clan.getTag());
						p.sendMessage(Data.Prefix + "Clan Owner: §e" + owner.getName());
						p.sendMessage(Data.Prefix + "Kills: §a" + clan.getKills() + "§8 | §7Tode: §c" + clan.getTode());
						p.sendMessage(Data.Prefix + "Mitglieder:");
						for(int i = 0; i < clan.getMembers().size(); i++) {
							List<String> list = clan.getMembers();
							PlayerCache member = new PlayerCache(list.get(i));
							Player memb = Bukkit.getPlayer(member.getName());
							
							if(memb != null) {
								p.sendMessage(Data.Prefix + "- §a" + memb.getName());
							} else p.sendMessage(Data.Prefix + "- §7" + memb.getName());
							
						}
						p.sendMessage(Data.getHeader());
						
					} else p.sendMessage(Data.Prefix + "Dieser Clan existiert nicht");
					
					
				} else if(args[0].equalsIgnoreCase("einladen")) {
					if(pc.isClaned()) {
						ClanData clan = new ClanData(pc.getClan());
						Player target = Bukkit.getPlayer(args[1]);
						PlayerCache tc = new PlayerCache(target.getUniqueId().toString());
						if(!tc.isClaned()) {
							if(accept.get(target.getName()) == null) {
								clan.sendClanMessage("Der Spieler §c" + target.getName() + "§7 wurde eingeladen");
								accept.put(target.getName(), clan.getTag());
							
								target.sendMessage(Data.Prefix + "Der Clan §c" + clan.getTag() + "§7 hat dir eine Einladung gesendet");
								target.sendMessage(Data.Prefix + "§a/clan annehmen §8| §c/clan ablehnen");
								
								
								Bukkit.getScheduler().runTaskLaterAsynchronously(Main.instance, new Runnable() {

									@Override
									public void run() {
										accept.remove(target.getName());
										
									}
									
								}, 20*30);
							} else p.sendMessage(Data.Prefix + "Der Spieler hat bereits eine Anfrage erhalten §8(§7Eventuell von einem anderen Clan§8)");
						} else p.sendMessage(Data.Prefix + "Der Spieler ist in einem Clan");
						
						
						
						
					} else p.sendMessage(Data.Prefix + "Du bist in keinem Clan");
					
				}
			}

		} else
			System.out.println(Data.console);

		return false;
	}
	
	
	private String getUUID(String playername) {
		return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
	}

}
