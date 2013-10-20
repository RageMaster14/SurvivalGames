package rageteam.survivalgames.main;

import org.bukkit.Location;
import org.bukkit.configuration.Configuration;

import rageteam.survivalgames.utilities.SerializableLocation;

public class Map
{
  private Location sp1;
  private Location sp2;
  private Location sp3;
  private Location sp4;
  private Location lobbySign;
  private Location classLobby;
  private Game game;
  private final SurvivalGames plugin;

  public Map(Game game, SurvivalGames plugin)
  {
    this.game = game;
    this.plugin = plugin;
  }

  public void load() {
    Configuration config = this.plugin.getConfig();
    if (config.isString("map." + this.game.getName() + ".sp1"))
      this.sp1 = SerializableLocation.stringToLocation(config.getString("map." + this.game.getName() + ".sp1"));
    else {
      this.sp1 = null;
    }
    if (config.isString("map." + this.game.getName() + ".sp2"))
      this.sp2 = SerializableLocation.stringToLocation(config.getString("map." + this.game.getName() + ".sp2"));
    else {
      this.sp2 = null;
    }
    if (config.isString("map." + this.game.getName() + ".sp3"))
      this.sp3 = SerializableLocation.stringToLocation(config.getString("map." + this.game.getName() + ".sp3"));
    else {
      this.sp3 = null;
    }
    if (config.isString("map." + this.game.getName() + ".sp4"))
      this.sp4 = SerializableLocation.stringToLocation(config.getString("map." + this.game.getName() + ".sp4"));
    else {
      this.sp4 = null;
    }
    if (config.isString("map." + this.game.getName() + ".lobby-sign"))
      this.lobbySign = SerializableLocation.stringToLocation(config.getString("map." + this.game.getName() + ".lobby-sign"));
    else {
      this.lobbySign = null;
    }
    if (config.isString("map." + this.game.getName() + ".class-lobby"))
      this.classLobby = SerializableLocation.stringToLocation(config.getString("map." + this.game.getName() + ".class-lobby"));
    else
      this.classLobby = null;
  }

  public void save()
  {
    Configuration config = this.plugin.getConfig();
    if (this.sp1 != null)
      config.set("map." + this.game.getName() + ".sp1", SerializableLocation.locationToString(this.sp1));
    else {
      config.set("map." + this.game.getName() + ".sp1", null);
    }
    if (this.sp2 != null)
      config.set("map." + this.game.getName() + ".sp2", SerializableLocation.locationToString(this.sp2));
    else {
      config.set("map." + this.game.getName() + ".sp2", null);
    }
    if (this.sp3 != null)
      config.set("map." + this.game.getName() + ".sp3", SerializableLocation.locationToString(this.sp3));
    else {
      config.set("map." + this.game.getName() + ".sp3", null);
    }
    if (this.sp4 != null)
      config.set("map." + this.game.getName() + ".sp4", SerializableLocation.locationToString(this.sp4));
    else {
      config.set("map." + this.game.getName() + ".sp4", null);
    }
    if (this.lobbySign != null)
      config.set("map." + this.game.getName() + ".lobby-sign", SerializableLocation.locationToString(this.lobbySign));
    else {
      config.set("map." + this.game.getName() + ".lobby-sign", null);
    }
    if (this.classLobby != null)
      config.set("map." + this.game.getName() + ".class-lobby", SerializableLocation.locationToString(this.classLobby));
    else {
      config.set("map." + this.game.getName() + ".class-lobby", null);
    }
    this.plugin.saveConfig();
  }

  public Game getGame() {
    return this.game;
  }

  public Location getSp1() {
    return this.sp1;
  }

  public void setSp1(Location sp1) {
    this.sp1 = sp1;
    save();
  }

  public Location getSp2() {
    return this.sp2;
  }

  public void setSp2(Location sp2) {
    this.sp2 = sp2;
    save();
  }

  public Location getSp3() {
    return this.sp3;
  }

  public void setSp3(Location sp3) {
    this.sp3 = sp3;
    save();
  }

  public Location getSp4() {
    return this.sp4;
  }

  public void setSp4(Location sp4) {
    this.sp4 = sp4;
    save();
  }

  public Location getLobbySign() {
    return this.lobbySign;
  }

  public void setLobbySign(Location lobbySign) {
    this.lobbySign = lobbySign;
    save();
  }

  public Location getClassLobby() {
    return this.classLobby;
  }

  public void setClassLobby(Location classLobby) {
    this.classLobby = classLobby;
    save();
  }
}
