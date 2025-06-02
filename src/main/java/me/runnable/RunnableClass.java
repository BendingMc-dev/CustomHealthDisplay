package me.runnable;

import me.CustomHealthDisplay;

public class RunnableClass implements Runnable {
    private CustomHealthDisplay plugin;
    private Set<player> players;

    public RunnableClass(CustomHealthDisplay plugin, Set<player> players) {
        this.plugin = plugin;
        this.players = players;
    }
    @Override
    public void run() {
        plugin.getLogger().info("Match began.");

    }

}
