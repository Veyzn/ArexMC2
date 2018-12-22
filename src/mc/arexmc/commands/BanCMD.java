package mc.arexmc.commands;

import mc.arexmc.main.Data;
import mc.arexmc.manager.BanManager;
import mc.arexmc.utils.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class BanCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("amc.ban"))
            if(args.length == 2) {
                String t = args[0];
                 PlayerCache pc = new PlayerCache(getUUID(t));
                 if(!BanManager.isBanned(getUUID(t))) {
                     BanManager.ban(getUUID(t),p, t, args[1], -1);
                     Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §4" + t + " §7wurde §c" + p.getName() +" §7gebannt!");
                     Bukkit.broadcastMessage(Data.Ban + "§7Grund: §c" + args[1]);

                     try {
                         PlayerCache pt = new PlayerCache(getUUID(t));
                         pt.addBan(1);
                     }catch(Exception e){
                     }

                 } else p.sendMessage(Data.Ban + "Der Spieler ist bereits gebannt!");
            } else p.sendMessage(Data.verwendung + "/ban <Name> <Grund>");
       } else System.out.println(Data.console);
        return false;
    }

    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }


}
