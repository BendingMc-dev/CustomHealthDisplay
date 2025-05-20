package me;

import me.realized.duels.api.Duels;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class CustomHealthDisplay extends JavaPlugin {
private static CustomHealthDisplay plugin;


    @Override
    public void onEnable() {
        saveResource("config.yml", false);
        Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");
        if(api.isEnabled())
            getLogger().info("Duels found, enabling custom health display");
        else
            getLogger().info("Duels not found, disabling custom health display");
            Bukkit.getPluginManager().disablePlugin(this);


    }

    @Override
    public void onDisable() {
        getLogger().info("Custom Health Display disabled");
    }
    public static CustomHealthDisplay getPlugin() {
        return plugin;
    }

}
