
package mc.arexmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import ru.tehkode.permissions.*;

public class TeamCMD implements CommandExecutor {

	private Object pex;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			String Owner = "";
			String Admin = "";
			String Dev = "";
			String Mod = "";
			String Sup = "";
			String Builder = "";
			String Guard = "";

			if (this.pex == null) {
				this.pex = PermissionsEx.getPermissionManager();
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Owner").getUsers()) {
				Owner = Owner + isOnline(user.getName()) + " " + "§8• ";
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Admin").getUsers()) {
				Admin = Admin + isOnline(user.getName()) + " " + "§8• ";
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Developer").getUsers()) {
				Dev = Dev + isOnline(user.getName()) + " " + "§8• ";
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Moderator").getUsers()) {
				Mod = Mod + isOnline(user.getName()) + " " + "§8• ";
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Builder").getUsers()) {
				Builder = Builder + isOnline(user.getName()) + " " + "§8• ";
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Guard").getUsers()) {
				Guard = Guard + isOnline(user.getName()) + " " + "§8• ";
			}
			for (PermissionUser user : ((PermissionManager) this.pex).getGroup("Supporter").getUsers()) {
				Sup = Sup + isOnline(user.getName()) + " " + "§8• ";
			}
			p.sendMessage("§8§m-----]----------§c§lTeam§8§m----------[-----");
			p.sendMessage("§4Owner§8: " + Owner);
			p.sendMessage("§cAdmin§8: " + Admin);
			p.sendMessage("§bDeveloper§8: " + Dev);
			p.sendMessage("§6Builder§8: " + Builder);
			p.sendMessage("§5Moderator§8: " + Mod);
			p.sendMessage("§9Supporter§8: " + Sup);
			p.sendMessage("§3Guard§8: " + Guard);
			p.sendMessage("§8§m-----]----------§c§lTeam§8§m----------[-----");

		}
		return false;
	}

	private String isOnline(String p) {
		if (Bukkit.getServer().getPlayer(p) != null) {
			if (!VanishCMD.vanished.contains(Bukkit.getPlayer(p))) {
				p = "§a" + p;
			} else {
				p = "§7" + p;
			}
		} else {
			p = "§7" + p;
		}
		return p;
	}
}
