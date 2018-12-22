package mc.arexmc.commands;

import mc.arexmc.main.Data;
import mc.arexmc.manager.BanManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnbanCMD implements CommandExecutor  {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

        Player p = (Player)sender;


        if(p.hasPermission("amc.unban")) {
            if(args.length == 1) {
                String t = args[0];
                if(BanManager.isBanned(getUUID(t))) {
                    BanManager.unban(getUUID(t));
                    Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §c" + t + "§7 wurde von §c" + p.getName() + "§7 entbannt");
                } else p.sendMessage(Data.Ban + "Der Spieler ist nicht gebannt.");
            } else p.sendMessage(Data.verwendung + "§c/unban <Spieler>.");
        } else p.sendMessage(Data.noperms);





        return false;
    }

    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }
}
