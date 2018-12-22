package mc.arexmc.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import mc.arexmc.main.Data;



public class GodListener implements Listener {

	@EventHandler
	public void onGod(EntityDamageByEntityEvent e) {
		
		Player p = (Player) e.getEntity();
		
		if(Data.goded.contains(p)) {
			e.setCancelled(true);
		} else e.setCancelled(false);
		
	}
	
}
