package me.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager extends JavaPlugin {
    public static boolean isEnabled;
    private FileConfiguration config = getConfig();





    public void load() {
        isEnabled = config.getBoolean("enabled");
    }


}
