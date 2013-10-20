package rageteam.survivalgames.stats;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerStats
{
  static FileConfiguration config = null;

  public static int getPlayerGems(String p)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getInt("gems");
  }

  public static void setPlayerGems(String p, int g, int r) throws IOException {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    config.set("gems", Integer.valueOf(((Integer)config.get("gems")).intValue() + g * r));
    config.save(pf);
    GemScoreboard.updateBalance(p);
  }

  public static int getPlayerWins(String p)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getInt("wins");
  }

  public static void setPlayerWins(String p, int w) throws IOException {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    config.set("wins", Integer.valueOf(((Integer)config.get("wins")).intValue() + w));
    config.save(pf);
  }

  public static int getPlayerRank(String p)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    if (config.getString("rank").equals("DEFAULT"))
      return 1;
    if (config.getString("rank").equals("VIP")) {
      return 2;
    }
    return 3;
  }

  public static void setPlayerRank(String p, int r) throws IOException {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    switch (r)
    {
    case 1:
      config.set("rank", "DEFAULT");
      break;
    case 2:
      config.set("rank", "VIP");
      break;
    case 3:
      config.set("rank", "VIP+");
    }

    config.save(pf);
  }

  public static int getPlayerKills(String p)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getInt("kills");
  }

  public static void setPlayerKills(String p, int k) throws IOException {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    config.set("kills", Integer.valueOf(((Integer)config.get("kills")).intValue() + k));
    config.save(pf);
  }

  public static int getPlayerDeaths(String p)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getInt("deaths");
  }

  public static void setPlayerDeaths(String p, int d) throws IOException {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    config.set("deaths", Integer.valueOf(((Integer)config.get("deaths")).intValue() + d));
    config.save(pf);
  }

  public static boolean getPlayerClass(String p, String c)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getBoolean("unlocked_characters." + c);
  }

  public static boolean getPlayerHat(String p, String c)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getBoolean("hat." + c);
  }

  public static void setPlayerHat(String p, String c, int g) {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    int cg = config.getInt("gems");
    cg -= g;
    config.set("hat." + c, Boolean.valueOf(true));
    config.set("gems", Integer.valueOf(cg));
    try {
      config.save(pf);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean getPlayerMap(String p, String m)
  {
    File pf = new File("plugins" + File.separator + "SurvivalGames" + File.separator + "users" + File.separator + p + ".yml");
    config = YamlConfiguration.loadConfiguration(pf);
    return config.getBoolean("map." + m);
  }

public static int getPlayerCoins(String playername) {
	// TODO Auto-generated method stub
	return 0;
}
}