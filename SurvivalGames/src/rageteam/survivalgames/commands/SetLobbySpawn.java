package rageteam.survivalgames.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rageteam.survivalgames.main.GameManager;
import rageteam.survivalgames.main.Map;

public class SetLobbySpawn
  implements CommandExecutor
{
  public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings)
  {
    if (cs.hasPermission("sg.setlobbyspawn"))
    {
      if (!(cs instanceof Player)) {
        cs.sendMessage("§8[§cSG-R§8] §4 Command only usable by player");
      }
      else {
        Player player = (Player)cs;
        if ((strings.length > 1) || (strings.length < 1))
        {
          cs.sendMessage("§8[§cSG-R§8] §7 Usage: /setlobbyspawn <map name>");
        }
        else
        {
          String mapName = strings[0];
          if (GameManager.getInstance().getGame(mapName) == null)
          {
            cs.sendMessage("§8[§cSG-R§8] §4 Map doesn't exist");
            return true;
          }
          Map map = (Map) GameManager.getInstance().getGame(mapName).getMap();
          if (map == null)
          {
            cs.sendMessage("§8[§cSG-R§8] §c Map doesn't exist");
          }
          else
          {
            map.setLobbySign(player.getLocation());
            cs.sendMessage("§8[§cSG-R§8] §7 Set the lobby of " + mapName);
          }
        }
      }
    }
    else
      cs.sendMessage("§8[§cSG-R§8] §4 Not Enough Permissions");
    return true;
  }
}
