package mc.arexmc.commands;

import java.util.List;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;
import mc.arexmc.manager.BanManager;
import mc.arexmc.manager.BanUnit;
import mc.arexmc.manager.WarnManager;
import mc.arexmc.utils.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class WarnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("amc.warn")) {
            if(args.length == 3) {

                String t = args[0];

                if(WarnManager.isRegistered(getUUID(t))) {

                    String grund = args[1];
                    if(Main.isInt(args[2])) {
                        int anzahl = Integer.parseInt(args[2]);
                        WarnManager.addWarns(getUUID(t), anzahl);
                        Bukkit.broadcastMessage(Data.Warn + "Der Spieler §c" + args[0] + "§7 wurde §c" + anzahl + "x §7mal von §c" + p.getName() + "§7 verwarnt!");
                        Bukkit.broadcastMessage(Data.Warn + "§7Grund: §c" + grund);


                        if(WarnManager.getWarns(getUUID(t)) == 5 || WarnManager.getWarns(getUUID(t)) > 5) {
                            List<String> unitlist = BanUnit.getUnitAsString();
                            BanUnit unit = BanUnit.getUnit("day");

                            BanManager.ban(getUUID(t),p, t, "5x Verwarnungen", 3 * unit.getToSecond());
                            Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §c" + t + " §7wurde vom §cServer §7gebannt!" );
                            Bukkit.broadcastMessage(Data.Ban + "§7Grund: §c5x Verwarnungen"  );
                            WarnManager.setWarns(getUUID(t), 0);
                            try {
                                PlayerCache pt = new PlayerCache(getUUID(t));
                                pt.addWarn(1);
                            }catch(Exception e){
                            }
                        }



                    } else p.sendMessage(Data.Prefix + "Bitte gebe eine richtige Zahl an.");




                } else p.sendMessage(Data.Prefix + "Der Spieler war noch nie auf dem Server.");
            } else p.sendMessage(Data.Prefix + "Bitte benutze §c/warn <Spieler> <WarnReason> <Anzahl>");
        } else p.sendMessage(Data.noperms);


        return false;
    }

    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }
}
