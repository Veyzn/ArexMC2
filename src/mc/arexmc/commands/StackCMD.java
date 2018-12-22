package mc.arexmc.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import mc.arexmc.main.Data;





public class StackCMD
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(Data.Prefix + "Dieser Befehl ist nur für Spieler bestimmt.");
      return true;
    }
    Player p = (Player)sender;
    if(p.hasPermission("amc.stack")) {
    ItemStack[] contents = p.getInventory().getContents();
    int changed = 0;
    for (int i = 0; i < contents.length; i++)
    {
      ItemStack current = contents[i];
      if ((current != null) && (current.getType() != Material.AIR) && (current.getAmount() > 0)) {
        if (current.getAmount() < 64)
        {
          int needed = 64 - current.getAmount();
          for (int i2 = i + 1; i2 < contents.length; i2++)
          {
            ItemStack nextCurrent = contents[i2];
            if ((nextCurrent != null) && (nextCurrent.getType() != Material.AIR) && (nextCurrent.getAmount() > 0)) {
              if ((current.getType() == nextCurrent.getType()) && (current.getDurability() == nextCurrent.getDurability()) && (
                ((current.getItemMeta() == null) && (nextCurrent.getItemMeta() == null)) || ((current.getItemMeta() != null) && 
                (current.getItemMeta().equals(nextCurrent.getItemMeta())))))
              {
                if (nextCurrent.getAmount() > needed)
                {
                  current.setAmount(64);
                  nextCurrent.setAmount(nextCurrent.getAmount() - needed);
                  break;
                }
                contents[i2] = null;
                current.setAmount(current.getAmount() + nextCurrent.getAmount());
                needed = 64 - current.getAmount();
                
                changed++;
              }
            }
          }
        }
      }
    }
    if (changed > 0)
    {
      p.getInventory().setContents(contents);
      p.sendMessage(Data.Prefix + "Deine Items wurden erfolgreich gestackt.");
    }
    else
    {
      p.sendMessage(Data.Prefix + "Es konnten keine Items gestackt werden.");
    }
    } else p.sendMessage(Data.noperms);
    
    return true;
  }
}
