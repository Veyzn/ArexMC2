package mc.arexmc.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import mc.arexmc.main.Data;



public class UnknownCommandListener implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL)
	
	public void onUnknown(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage().split(" ")[0];
		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if(topic == null) {
			p.sendMessage(Data.Prefix + "Der Befehl §8(§c" + msg + "§8) §7Existiert nicht.");
			e.setCancelled(true);
		}
	}

}

