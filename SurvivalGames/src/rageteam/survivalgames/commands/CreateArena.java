package rageteam.survivalgames.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import rageteam.survivalgames.main.GameManager;

public class CreateArena
implements CommandExecutor
{
public boolean onCommand(CommandSender cs, Command cmd, String string, String[] strings)
{
  if (cs.hasPermission("sg.createarena"))
  {
    if ((strings.length > 1) || (strings.length == 0)) {
      cs.sendMessage("§8[§cSG-R§8] §7 Usage: /createarena <map name>");
    }
    else {
      String mapName = strings[0];
      if (GameManager.getInstance().getGame(mapName) != null) {
        cs.sendMessage("§8[§cSG-R§8] §4 Map already exists");
      }
      else {
        GameManager.getInstance().createGame(mapName);
        cs.sendMessage("§8[§cSG-R§8] §7 Created map " + mapName);
      }
    }
  }
  else
    cs.sendMessage("§8[§cSG-R§8] §4 Not Enough Permissions");
  return true;
}
}
