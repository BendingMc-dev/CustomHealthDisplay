package me.runnable;

import me.CustomHealthDisplay;

public class RunnableClass implements Runnable {
    private CustomHealthDisplay plugin;

    public RunnableClass(CustomHealthDisplay plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        plugin.getLogger().info("Match began.");

    }

}
