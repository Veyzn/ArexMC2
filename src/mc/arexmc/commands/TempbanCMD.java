package mc.arexmc.commands;

import java.util.List;

import mc.arexmc.main.Data;
import mc.arexmc.main.Main;
import mc.arexmc.manager.BanManager;
import mc.arexmc.manager.BanUnit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TempbanCMD implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

            Player p = (Player) sender;

            //p.sendMessage("§8§m-----]----------§c§lKickreasons§8§m----------[-----");
            //p.sendMessage(Main.red+"§8§L1. §c§o§oHackclient/Unerlaubte Clientmodifikationen");
            //p.sendMessage(Main.red+"§8§L2. §c§oBugusing");
            //p.sendMessage(Main.red+"§8§L3. §c§oMakros/Autotext");
            //p.sendMessage(Main.red+"§8§L4. §c§oAutoclicker");
            //p.sendMessage(Main.red+"§8§L5. §c§oX-Ray");
            //p.sendMessage(Main.red+"§8§L6. §c§oCrash-Versuch");
            //p.sendMessage(Main.red+"§8§L7. §c§oWerbung");
            //p.sendMessage(Main.red+"§8§L8. §c§oBeleidigungen aller Art");
            //p.sendMessage(Main.red+"§8§L9. §c§oNationalsozialismus");
            //p.sendMessage(Main.red+"§8§L10. §c§oChatspam");
            //p.sendMessage(Main.red+"§8§L11. §c§oKein Grund angegeben");
            //p.sendMessage("§8§m-----]----------§c§lKickreasons§8§m----------[-----");

            if(p.hasPermission("amc.tempban")) {
                if(args.length == 4) {
                    String t = args[0];
                    String grund = args[1];
                    String format = args[3];
                    if(!BanManager.isBanned(getUUID(t))) {
                        if(Main.isInt(args[2])) {
                            int zahl = Integer.parseInt(args[2]);
                            if(format.equalsIgnoreCase("m")) {
                                List<String> unitlist = BanUnit.getUnitAsString();
                                BanUnit unit = BanUnit.getUnit("min");
                                BanManager.ban(getUUID(t),p, t, grund, zahl * unit.getToSecond());
                                Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §c" + t + " §7wurde vom §cServer §7gebannt." );
                                Bukkit.broadcastMessage(Data.Ban + "§7Grund: §c" + grund  );
                            } else if(format.equalsIgnoreCase("h")) {
                                List<String> unitlist = BanUnit.getUnitAsString();
                                BanUnit unit = BanUnit.getUnit("hour");
                                BanManager.ban(getUUID(t),p, t, grund, zahl * unit.getToSecond());
                                Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §c" + t + " §7wurde vom §cServer §7gebannt." );
                                Bukkit.broadcastMessage(Data.Ban + "§7Grund: §c" + grund  );

                            } else if(format.equalsIgnoreCase("d")) {
                                List<String> unitlist = BanUnit.getUnitAsString();
                                BanUnit unit = BanUnit.getUnit("day");
                                BanManager.ban(getUUID(t),p, t, grund, zahl * unit.getToSecond());
                                Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §c" + t + " §7wurde vom §cServer §7gebannt." );
                                Bukkit.broadcastMessage(Data.Ban + "§7Grund: §c" + grund  );

                            } else if(format.equalsIgnoreCase("w")) {
                                List<String> unitlist = BanUnit.getUnitAsString();
                                BanUnit unit = BanUnit.getUnit("week");
                                BanManager.ban(getUUID(t),p, t, grund, zahl * unit.getToSecond());
                                Bukkit.broadcastMessage(Data.Ban + "§7Der Spieler §c" + t + " §7wurde vom §cServer §7gebannt." );
                                Bukkit.broadcastMessage(Data.Ban + "§7Grund: §c" + grund  );
                            } else p.sendMessage(Data.verwendung + "/tempban <Name> <Grund> <Anzahl> <M = Minuten | H = Stunden | D = Tage | W = Wochen >");
                        } else p.sendMessage(Data.Prefix + "Bitte gebe eine gültige Zahl an");
                    } else p.sendMessage(Data.Prefix + "§7Der Spieler ist bereits gebannt.");
                } else p.sendMessage(Data.verwendung + "/tempban <Name> <Grund> <Anzahl> <M = Minuten | H = Stunden | D = Tage | W = Wochen >");
            } else p.sendMessage(Data.noperms);
            return false;
        }
        private String getUUID(String playername) {
            return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
        }


}
