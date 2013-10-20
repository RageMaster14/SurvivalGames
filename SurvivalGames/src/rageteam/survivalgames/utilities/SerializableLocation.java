package rageteam.survivalgames.utilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class SerializableLocation
{
  public static String locationToString(Location l)
  {
    String w = l.getWorld().getName();
    double x = l.getX();
    double y = l.getY();
    double z = l.getZ();
    float p = l.getPitch();
    float ya = l.getYaw();
    return w + "~" + x + "~" + y + "~" + z + "~" + p + "~" + ya;
  }

  public static Location stringToLocation(String s) {
    String[] str = s.split("\\~");
    World w = Bukkit.getServer().getWorld(str[0]);
    double x = Double.parseDouble(str[1]);
    double y = Double.parseDouble(str[2]);
    double z = Double.parseDouble(str[3]);
    float p = Float.parseFloat(str[4]);
    float ya = Float.parseFloat(str[5]);
    return new Location(w, x, y, z, ya, p);
  }

  public static boolean compareLocations(Location one, Location two) {
    String w = one.getWorld().getName();
    int x = one.getBlockX();
    int y = one.getBlockZ();
    int z = one.getBlockZ();

    String checkw = two.getWorld().getName();
    int checkx = two.getBlockX();
    int checky = two.getBlockZ();
    int checkz = two.getBlockZ();

    return (w.equalsIgnoreCase(checkw)) && (x == checkx) && (y == checky) && (z == checkz);
  }
}
