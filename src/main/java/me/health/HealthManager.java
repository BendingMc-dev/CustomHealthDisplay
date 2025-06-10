package me;

import me.config.ConfigClass;
import me.realized.duels.api.Duels;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class HealthManager {
  private static CustomHealthDisplay plugin;
  private Set<Players> = MatchRunnable.getPlayers();
  private Spectator spectator = SpectatorRunnable.getSpectators();
  private String message = players + "test" + spectators
  public HealthManager(CustomHealthDisplay plugin, Set<Players> players, Spectator spectator) {
    this.players = players;
    this.spectator = spectator;
    this.plugin = plugin;
  }
  public static void sendActionBar(Set<Players> players, Spectator spectator, String message) {
    CustomCooking actionbar = CustomCooking.playerActionBar();
    
  }
}
