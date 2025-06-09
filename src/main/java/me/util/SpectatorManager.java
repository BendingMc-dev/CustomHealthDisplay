package me;

public class SpectatorManager() {
  private static CustomHealthDisplay plugin;
  private Spectator spectator;

  public SpectatorManager(CustomHealthDisplay plugin, Spectator spectator) {
    this.plugin = plugin;
    this.spectator = spectator;
  }
  public void setSpectators() {
    this.spectator = spectator;
  }
}
