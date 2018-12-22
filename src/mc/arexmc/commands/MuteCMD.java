package mc.arexmc.commands;

import java.util.List;


import mc.arexmc.main.Data;
import mc.arexmc.main.Main;
import mc.arexmc.manager.BanUnit;
import mc.arexmc.manager.MuteManager;
import mc.arexmc.utils.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class MuteCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("amc.mute")) {
            if(args.length == 3) {
                if(Main.isInt(args[2])) {
                    int minuten = Integer.parseInt(args[2]);
                    Player t = Bukkit.getPlayer(args[0]);
                    String grund = args[1];
                    if(t != null) {
                        if(t != p) {
                            if(!MuteManager.isMuted(t.getUniqueId().toString())) {
                                List<String> unitlist = BanUnit.getUnitAsString();
                                BanUnit unit = BanUnit.getUnit("min");
                                MuteManager.mute(t.getUniqueId().toString(), p, p.getName(), grund, minuten * unit.getToSecond());
                                Bukkit.broadcastMessage(Data.Ban + "Der Spieler §c" + t.getName() + "§7 wurde von §c" + p.getName() + "§7 gemutet");
                                PlayerCache pt = new PlayerCache(t.getUniqueId().toString());
                                pt.addMute(1);

                            } else p.sendMessage(Data.Ban + "Der Spieler ist bereits gemutet.");
                        } else p.sendMessage(Data.Ban + "Du kannst dich nicht selber muten.");
                    } else p.sendMessage(Data.offline);
                } else p.sendMessage(Data.Ban + "Bitte gebe eine richtige Zahl ein.");


            } else p.sendMessage(Data.verwendung + "/mute <Name> <Grund> <Minuten>");
        } else p.sendMessage(Data.noperms);





        return false;
    }
}
