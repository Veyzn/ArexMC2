package mc.arexmc.utils;

import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;





public class CombatLog implements Listener {

	public CombatLog() {
		startTimer();
	}

	public static String prefix = "§6§lCOMBATLOG §8» ";
	public static ConcurrentHashMap<String, Long> combat = new ConcurrentHashMap<String, Long>();

	@EventHandler
	public void on(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		if (combat.containsKey(p.getName())) {
			

			
			
			
			for (ItemStack is : p.getInventory().getContents()) {
				if (is != null) {
					p.getWorld().dropItem(p.getLocation(), is);
				}
			}

			for (ItemStack is : p.getInventory().getArmorContents()) {
				if ((is != null) && (is.getType() != Material.AIR)) {
					p.getWorld().dropItem(p.getLocation(), is);
				}
			}

			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.damage(50);
			
			
			combat.remove(p);

			
		}
	}

	public static void startTimer() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (String s : combat.keySet()) {
					if (combat.get(s) <= System.currentTimeMillis()) {
						Player p = Bukkit.getPlayer(s);

						if (p != null) {
							p.sendMessage(Data.Prefix + "§aDu darfst dich nun wieder ausloggen.");
						}

						combat.remove(s);
					}
				}
			}
		}.runTaskTimer(Main.instance, 0, 20);
	}

	@EventHandler
	public void on(PlayerDeathEvent e) {
		Player p = e.getEntity();

		if (combat.containsKey(p.getName())) {
			combat.remove(p.getName());
			p.sendMessage(Data.Prefix + "§aDu darfst dich nun wieder ausloggen.");
		}

		if (p.getKiller() instanceof Player) {
			if (combat.containsKey(p.getKiller().getName())) {
				combat.remove(p.getKiller().getName());
				p.getKiller().sendMessage(Data.Prefix + "§aDu darfst dich nun wieder ausloggen.");
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void on(EntityDamageByEntityEvent e) {
		if (e.isCancelled()) {
			return;
		}

		if (!(e.getEntity() instanceof Player)) {
			return;
		}

		Player entity = (Player) e.getEntity();
		Player damager = null;
		if (e.getDamager() instanceof Projectile) {
			Projectile proj = (Projectile) e.getDamager();

			if (!(proj.getShooter() instanceof Player)) {
				return;
			}
			damager = (Player) proj.getShooter();
		} else if (e.getDamager() instanceof Player) {
			damager = (Player) e.getDamager();
		} else {
			return;
		}

		if (damager.getGameMode() == GameMode.CREATIVE) {
			return;
		}

		if (entity == damager) {
			return;
		}

		if (!combat.containsKey(entity.getName())) {
			entity.sendMessage(Data.Prefix + "§7Du befindest dich nun mit §c" + damager.getName() + " §7im Kampf!");
			entity.sendMessage(Data.Prefix + "§7Ausloggen führt zum Tod!");
		}
		if (!combat.containsKey(damager.getName())) {
			damager.sendMessage(Data.Prefix + "§7Du befindest dich nun mit §c" + entity.getName() + " §7im Kampf!");
			damager.sendMessage(Data.Prefix + "§7Ausloggen führt zum Tod!");
		}
		long time = System.currentTimeMillis() + (1000 * 10);
		combat.put(entity.getName(), time);
		combat.put(damager.getName(), time);

		entity.setFlying(false);
		entity.setAllowFlight(false);
		damager.setFlying(false);
		damager.setAllowFlight(false);
	}

	@EventHandler
  	 public void onCMD(PlayerCommandPreprocessEvent e) {
  		 Player p = e.getPlayer();
  		 
  		 String[] cmd = e.getMessage().substring(1).split(" ");
  		  
  			 if(cmd[0].equalsIgnoreCase("spawn") || cmd[0].equalsIgnoreCase("warp") || cmd[0].equalsIgnoreCase("ec") || cmd[0].equalsIgnoreCase("enderchest") || cmd[0].equalsIgnoreCase("clan")
  					 ||  cmd[0].equalsIgnoreCase("heal") || cmd[0].equalsIgnoreCase("fly") || cmd[0].equalsIgnoreCase("home")){
  				 if(combat.containsKey(p.getName())){
  					 p.sendMessage(Data.Prefix + "Du kannst diesen Command nicht im Kampf ausführen");
  					 e.setCancelled(true);
  				 }
  				 }
  			 }
}
