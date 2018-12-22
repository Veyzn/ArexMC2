package mc.arexmc.listener;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import mc.arexmc.antiwerbung.BlockWordAPI;
import mc.arexmc.chatcolor.ChatcolorAPI;
import mc.arexmc.commands.GlobalmuteCMD;
import mc.arexmc.commands.SlowChatCMD;
import mc.arexmc.main.Data;
import mc.arexmc.utils.Utils;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatEvent implements Listener {
	
	HashMap<Player, Long> spam = new HashMap<Player, Long>();
	@EventHandler
	public void onText(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		String message = e.getMessage().replaceAll("%", "%%");;
		String colormessage =  e.getMessage().replaceAll("&", "§").replaceAll("%", "%%");
		String chatcolor = ChatcolorAPI.getColor(p);
		
		
		String Owner = "§8(§4§lOWNER§8) " + Utils.getCTCF(p) + "§4" + p.getName() + " §8× §4" + colormessage ;
		String Admin = "§8(§c§lADMIN§8) " + Utils.getCTCF(p) + "§c" + p.getName() + " §8× §c" + colormessage ;
		String Developer = "§8(§b§lDEVELOPER§8) " + Utils.getCTCF(p) + "§b" + p.getName() + " §8× §c" + colormessage ;
		String Moderator = "§8(§5§lMODERATOR§8) " + Utils.getCTCF(p) + "§5" + p.getName() + " §8× §c" + message ;
		String Builder = "§8(§6§lBUILDER§8) " + Utils.getCTCF(p) + "§6" + p.getName() + " §8× §c" + message ;
		String Supporter = "§8(§9§lSUPPORTER§8) " + Utils.getCTCF(p) + "§9" + p.getName() + " §8× §c" + message ;
		String Guard = "§8(§3§lGUARD§8) " + Utils.getCTCF(p) + "§3" + p.getName() + " §8× §c" + message ;
		
		String Youtuber = "§8(§f§lYOUTUBER§8) " + Utils.getCTCF(p) + "§f" + p.getName() + " §8× §" + ChatcolorAPI.getColor(p) + message ;
		String Master = "§8(§c§lMASTER§8) " + Utils.getCTCF(p) + "§c" + p.getName() + " §8× §" + ChatcolorAPI.getColor(p)  + message ;
		String Predator = "§8(§9§lPREDATOR§8) " + Utils.getCTCF(p) + "§9" + p.getName() + " §8× §" + ChatcolorAPI.getColor(p) + message ;
		String Wizard = "§8(§5§lWIZARD§8) " + Utils.getCTCF(p) + "§5" + p.getName() + " §8× §" + ChatcolorAPI.getColor(p) + message ;
		String Hunter = "§8(§3§lHUNTER§8) " + Utils.getCTCF(p) + "§3" + p.getName() + " §8× §" + ChatcolorAPI.getColor(p) + message ;
		
		String Spieler = "§8(§7§lSPIELER§8) " + Utils.getCTCF(p) + "§7" + p.getName() + " §8× §" + ChatcolorAPI.getColor(p) + message ;
		
		
		
		
		
		
		
		
	    PermissionUser pu = PermissionsEx.getUser(p);
	    
	    if(pu.inGroup("Owner")) {
	    	e.setFormat(Owner);
	    } else if(pu.inGroup("Admin")) {
	    	e.setFormat(Admin);
	    } else if(pu.inGroup("Developer")) {
	    	e.setFormat(Developer);
	    } else if(pu.inGroup("Moderator")) {
	    	e.setFormat(Moderator);
	    } else if(pu.inGroup("Builder")) {
	    	e.setFormat(Builder);
	    } else if(pu.inGroup("Supporter")) {
	    	e.setFormat(Supporter);
	    } else if(pu.inGroup("Guard")) {
	    	e.setFormat(Guard);
	    } else if(pu.inGroup("Youtuber")) {
	    	e.setFormat(Youtuber);
	    } else if(pu.inGroup("Master")) {
	    	e.setFormat(Master);
	    } else if(pu.inGroup("Predator")) {
	    	e.setFormat(Predator);
	    } else if(pu.inGroup("Wizard")) {
	    	e.setFormat(Wizard);
	    } else if(pu.inGroup("Hunter")) {
	    	e.setFormat(Hunter);
	    } else {
	    	e.setFormat(Spieler);
	    }
	    
	    List<String> blockedwords = BlockWordAPI.getList();
	    
	    if(!p.hasPermission("amc.Globalmute")) {
	    	if(GlobalmuteCMD.Gmute == false) {
	    		e.setCancelled(true);
	    		p.sendMessage(Data.Prefix + "Der §cGloable Chat§7 ist derzeit §cdeaktiviert");
	    	}
	    }
	    
	    
	    String msg = e.getMessage();
	    for(int i = 0; i < blockedwords.size(); i++) {
			   if(msg.toLowerCase().contains(blockedwords.get(i).toLowerCase())) {
				   i = blockedwords.size();
				   e.setCancelled(true);
				   p.sendMessage(Data.Prefix + "Deine Nachricht enthält unzulässige Wörter.");
			   }
		   }
	    if(SlowChatCMD.SlowChat == true) {
	    if(!p.hasPermission("amc.slowchat.bypass")) {
			if(spam.containsKey(p)) {
				if(spam.get(e.getPlayer()) > System.currentTimeMillis()) {
					e.setCancelled(true);
					p.sendMessage(Data.Prefix + "Bitte warte §c3 Sekunden §7um die nächste Nachricht zu schreiben.");
				} else {
					spam.put(p, System.currentTimeMillis() + 3 * 1000); 
				}
			} else {
				spam.put(p, System.currentTimeMillis() + 3 * 1000); 				
			}			
			}
	    }
	    
	    
	}

}
