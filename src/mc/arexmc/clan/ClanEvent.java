package mc.arexmc.clan;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import mc.arexmc.main.Data;
import mc.arexmc.utils.PlayerCache;

public class ClanEvent implements Listener {

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			Player p = (Player) e.getEntity();
			Player t = (Player) e.getDamager();
			PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
			PlayerCache tc = new PlayerCache(t.getUniqueId().toString());

			if (pc.isClaned() && tc.isClaned()) {
				if (pc.getClan().equalsIgnoreCase(tc.getClan())) {
					t.sendMessage(Data.Prefix + "Der Spieler ist in deinem Clan!");
					e.setCancelled(true);
				}
			}

		}
	}

	@EventHandler
	public void arrow(EntityDamageByEntityEvent e) {

		if ((e.getEntity() instanceof Player)) {
			Player t = (Player) e.getEntity();
			if ((e.getDamager() instanceof Arrow)) {
				Arrow a = (Arrow) e.getDamager();
				if ((a.getShooter() instanceof Player)) {
					Player p = (Player) a.getShooter();
					PlayerCache pc = new PlayerCache(p.getUniqueId().toString());
					PlayerCache tc = new PlayerCache(t.getUniqueId().toString());
					if (pc.isClaned() && tc.isClaned()) {
						if (pc.getClan().equalsIgnoreCase(tc.getClan())) {
							p.sendMessage(Data.Prefix + "Der Spieler ist in deinem Clan!");
							e.setCancelled(true);
						}
					}
				}
			}

		}
	}

}
