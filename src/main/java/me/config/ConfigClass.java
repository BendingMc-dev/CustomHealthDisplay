package me.config;


import me.CustomHealthDisplay;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;


public class ConfigClass {
    private CustomHealthDisplay plugin;
    private File file;
    private FileConfiguration config;

    public ConfigClass(CustomHealthDisplay plugin) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(file);

    }


    public void createConfig() {
        if(!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                plugin.getLogger().info("Config directory generated " + file.getParentFile());
            }
            catch (Exception e) {
                plugin.getLogger().info("Config directory failed " + file.getParentFile());
            }
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                plugin.getLogger().info("Config file generated " + file.getName());
            }
            catch (Exception e) {
                plugin.getLogger().info("Config file generation failed " + file.getName());
            }

        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}






