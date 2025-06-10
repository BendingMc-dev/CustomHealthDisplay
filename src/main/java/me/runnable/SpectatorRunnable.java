package me.runnable;

import me.CustomHealthDisplay;
import me.realized.duels.api.spectate.Spectator;
import org.bukkit.scheduler.BukkitRunnable;

public class SpectatorRunnable extends BukkitRunnable {
    private static CustomHealthDisplay plugin;
    private Spectator spectator;

    public SpectatorRunnable(CustomHealthDisplay plugin, Spectator spectator) {
        this.plugin = plugin;
        this.spectator = spectator;
    }
    public void run() {
        plugin.getLogger().info("Spectator: " + spectator.toString());

    }
    public Spectator getSpectator() {
        return spectator;
    }
}
