package rageteam.survivalgames.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import rageteam.survivalgames.utilities.SerializableLocation;

@SuppressWarnings("unused")
public class GameManager
{
  private static final GameManager instance = new GameManager();
  @SuppressWarnings({ "unchecked", "rawtypes" })
  private HashMap<String, Game> games = new HashMap();
  private SurvivalGames plugin;
  private Location mainLobby;
  private List<String> spawnToLobby;

  public static GameManager getInstance()
  {
    return instance;
  }

  public void setup(SurvivalGames plugin) {
    this.plugin = plugin;
    load();
  }
  public void reloadCfg() {
    for (Game game : this.games.values())
    {
      game.stopGame();
    }
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
public void load() { this.games.clear();
    List<String> names = this.plugin.getConfig().getStringList("maps");
    if (names != null) {
      for (String name : names) {
        addGame(new Game(this.plugin, name, this.plugin.getConfig().getBoolean("map." + name + ".disabled")));
      }
    }
    if (this.plugin.getConfig().isString("main-lobby")) {
      this.mainLobby = SerializableLocation.stringToLocation(this.plugin.getConfig().getString("main-lobby"));
    }
    if (this.plugin.getConfig().isList("respawning"))
      this.spawnToLobby = this.plugin.getConfig().getStringList("respawning");
    else
      this.spawnToLobby = new ArrayList();
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
public Game createGame(String name)
  {
    if (getGame(name) == null) {
      Game game = (Game)this.games.put(name, new Game(this.plugin, name, false));
      List names = this.plugin.getConfig().getStringList("maps");
      names.add(name);
      this.plugin.getConfig().set("maps", names);
      this.plugin.saveConfig();
      return game;
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
public boolean deleteGame(String name)
  {
    if (getGame(name) != null)
    {
      getGame(name).stopGame();
      this.games.remove(name);
      List names = this.plugin.getConfig().getStringList("maps");
      names.remove(name);
      Location loc = SerializableLocation.stringToLocation(this.plugin.getConfig().getString("map." + name + ".lobby-sign"));
      loc.getBlock().setType(Material.AIR);
      this.plugin.getConfig().set("maps", names);
      this.plugin.getConfig().set("maps." + name, null);
      this.plugin.saveConfig();
      return true;
    }
    return false;
  }

public Game getGame(String game) {
    if (this.games.containsKey(game)) {
      return (Game)this.games.get(game);
    }
    return null;
  }

  public void addGame(Game game) {
    if (game == null) {
      return;
    }
    if (!this.games.containsKey(game.getName()))
      this.games.put(game.getName(), game);
  }

  public void removeGame(Game game)
  {
    if (game == null) {
      return;
    }
    removeGame(game.getName());
  }

  public void removeGame(String game) {
    if (game == null) {
      return;
    }
    if (this.games.containsKey(game))
      this.games.remove(game);
  }

  public Collection<Game> getAllGames()
  {
    return this.games.values();
  }

  public Location getMainLobby() {
    return this.mainLobby;
  }

  public void setMainLobby(Location mainLobby) {
    this.plugin.getConfig().set("main-lobby", SerializableLocation.locationToString(mainLobby));
    this.plugin.saveConfig();
    this.mainLobby = mainLobby;
  }

  public boolean isSpawningToLobby(String player) {
    return this.spawnToLobby.contains(player);
  }

  public void addSpawningToLobby(String player) {
    this.spawnToLobby.add(player);
    this.plugin.getConfig().set("respawning", this.spawnToLobby);
    this.plugin.saveConfig();
  }

  public void removeSpawningToLobby(String player) {
    this.spawnToLobby.remove(player);
    this.plugin.getConfig().set("respawning", this.spawnToLobby);
    this.plugin.saveConfig();
  }
}
