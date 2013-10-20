package rageteam.survivalgames.main;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import rageteam.survivalgames.stats.PlayerStats;

@SuppressWarnings("unused")
public class Player
{
  private int lives;
  private int kills;
  private int deaths;
  private boolean isInLobby;
  private String lastDamagedBy;
  private String name;
  private Game currentGame;
  private SurvivalGames plugin;
  private static Player instance;

  public static Player getInstance()
  {
    return instance;
  }

  public Player(String name, SurvivalGames plugin) {
    this.name = name;
    this.plugin = plugin;
    this.lives = 5;
    this.kills = 0;
  }
  public Player getPlayer() {
    return (Player) Bukkit.getPlayer(this.name); } 
  public int getLivesLeft() { return this.lives; } 
  public int getKills() { return this.kills; } 
  public int getDeaths() { return this.deaths; } 
  public int getRank() { return PlayerStats.getPlayerRank(this.name); } 
  public boolean isInLobby() { return this.isInLobby; } 
  public Game getCurrentGame() { return this.currentGame; } 
  public String getLastDamagedBy() { return this.lastDamagedBy; } 

  public void setLivesLeft(int i)
  {
    if (i == -1)
      this.lives -= 1;
    else
      this.lives = i;
  }

  public void setKills(int i) {
    if (i == -1)
      this.kills += 1;
    else
      this.kills = i;
  }

  public void setDeaths(int i) {
    if (i == -1)
      this.deaths += 1;
    else
      this.deaths = i; 
  }

  public void setInLobby(boolean b) { this.isInLobby = b; } 
  public void setCurrentGame(Game g) { this.currentGame = g; } 
  public void setLastDamagedBy(String lastDamagedBy) { this.lastDamagedBy = lastDamagedBy; } 
}
