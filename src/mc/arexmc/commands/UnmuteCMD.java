package mc.arexmc.commands;

import mc.arexmc.main.Data;
import mc.arexmc.manager.MuteManager;
import mc.arexmc.utils.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class UnmuteCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

        Player p = (Player)sender;


        if(p.hasPermission("NightFront.unban")) {
            if(args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if(t != null) {
                    if(MuteManager.isMuted(t.getUniqueId().toString())) {


                        MuteManager.unmute(t.getUniqueId().toString());
                        Bukkit.broadcastMessage(Data.Mute + "Der Spieler §c" + t.getName() + "§7 wurde von §c" + p.getName() + "§7 entmutet.");
                    } else p.sendMessage(Data.Mute + "§7Der Spieler ist nicht gemutet.");
                } else p.sendMessage(Data.Mute + "Der Spieler ist nicht §cOnline");
            } else p.sendMessage(Data.verwendung + "§c/unmute <Spieler>.");
        } else p.sendMessage(Data.noperms);


        return false;
    }


}
