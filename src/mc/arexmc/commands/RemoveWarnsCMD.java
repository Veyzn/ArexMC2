package mc.arexmc.commands;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;
import mc.arexmc.manager.WarnManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class RemoveWarnsCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        Player p = (Player) sender;


        if(p.hasPermission("amc.removewarns")) {
            if(args.length == 2) {
                String t = args[0];

                int anzahl = WarnManager.getWarns(getUUID(t));
                if(WarnManager.isRegistered(getUUID(t))) {
                    if(Main.isInt(args[1])) {
                        int zahl = Integer.parseInt(args[1]);
                        if(zahl < anzahl || zahl == anzahl) {

                            Bukkit.broadcastMessage(Data.Warn + "Der Spieler §c" + p.getName() + "§7 hat §c" + zahl +"x §7Warns von §c" + args[0] + "§7 gelöscht.");
                            WarnManager.removeWarns(getUUID(t), zahl);

                        } else p.sendMessage(Data.Warn + "Der Spieler hat nicht genug Warns.");
                    } else p.sendMessage(Data.Warn + "Bitte gib eine gültige Zahl an.");
                } else p.sendMessage(Data.Warn + "Der Spieler war noch nie auf dem Server");
            } else p.sendMessage(Data.verwendung + "Bitte benutze §c/removewarns <Spieler> <Anzahl>");
        } else p.sendMessage(Data.noperms);



        return false;
    }

    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }
}
