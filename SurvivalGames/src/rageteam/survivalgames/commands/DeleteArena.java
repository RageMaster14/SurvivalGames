package rageteam.survivalgames.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import rageteam.survivalgames.main.GameManager;

public class DeleteArena
  implements CommandExecutor
{
  public boolean onCommand(CommandSender cs, Command cmd, String string, String[] strings)
  {
    if (cs.hasPermission("sg.deletearena"))
    {
      if ((strings.length > 1) || (strings.length < 1))
      {
        cs.sendMessage("§8[§cSG-R§8] §7 Usage: /deletearena <map name>");
      }
      else
      {
        String mapName = strings[0];
        if (GameManager.getInstance().getGame(mapName) == null)
        {
          cs.sendMessage("§8[§cSG-R§8] §4 Map doesn't exist");
        }
        else
        {
          GameManager.getInstance().deleteGame(mapName);
          cs.sendMessage("§8[§cSG-R§8] §7 Deleted map " + mapName);
        }
      }
    }
    else
    {
      cs.sendMessage("§8[§cSG-R§8] §4 Not Enough Permissions");
    }
    return true;
  }
}
