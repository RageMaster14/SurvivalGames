package rageteam.survivalgames.stats;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class GemScoreboard
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
private static HashMap<String, Scoreboard> playerboards = new HashMap();

  public static void addPlayer(Player player)
  {
    String sp = player.getName();
    Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
    int rank = PlayerStats.getPlayerRank(player.getName());
    String srank = null;
    switch (rank)
    {
    case 1:
      srank = "DEFAULT";
      break;
    case 2:
      srank = "VIP";
      break;
    case 3:
      srank = "VIP+";
    }

    int gems = PlayerStats.getPlayerCoins(player.getName());
    Objective objective = board.registerNewObjective("gems", "dummy");
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    objective.setDisplayName(sp + " (" + srank + ") ");
    Score score = objective.getScore(Bukkit.getOfflinePlayer("Coins:"));
    score.setScore(gems);
    playerboards.put(sp, board);
    player.setScoreboard(board);
  }

  public static void updateBalance(String playername)
  {
    if (playerboards.containsKey(playername))
    {
      int gems = PlayerStats.getPlayerCoins(playername);
      Scoreboard board = (Scoreboard)playerboards.get(playername);
      Objective objective = board.getObjective(DisplaySlot.SIDEBAR);
      Score score = objective.getScore(Bukkit.getOfflinePlayer("Coins:"));
      score.setScore(gems);
      playerboards.remove(playername);
      playerboards.put(playername, board);
      Bukkit.getPlayer(playername).setScoreboard(board);
    }
    else {
      addPlayer(Bukkit.getPlayer(playername));
    }
  }

  public static void removePlayer(Player player) {
    if (playerboards.containsKey(player.getName()))
    {
      playerboards.remove(player.getName());
      player.setScoreboard(Bukkit.getServer().getScoreboardManager().getNewScoreboard());
    }
  }
}