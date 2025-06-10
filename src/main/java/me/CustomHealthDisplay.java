package me;

import me.config.ConfigClass;
import me.realized.duels.api.Duels;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public final class CustomHealthDisplay extends JavaPlugin {
private static CustomHealthDisplay plugin;


    @Override
    public void onEnable() {
        ConfigClass config = new ConfigClass(this);
        config.createConfig();
        saveResource("config.yml", false);

        getServer().getPluginManager().registerEvents(new ListenerClass(this), this);
        getLogger().info("Custom Health Display enabled");
        Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");
        if (api == null) {
            getLogger().info("Duels not found");

        }


    }



        @Override
        public void onDisable() {
            getLogger().info("Custom Health Display disabled");
        }
        public static CustomHealthDisplay getPlugin () {
            return plugin;
        }
    }

