package me;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;


public class configClass  {
    private customhealthdisplay plugin;
    private File file;
    private FileConfiguration config;

    public configClass(File file) {
        this.plugin = customhealthdisplay.getPlugin();
        this.file = new File(plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(file);
        
    }


    public void createConfig() {
        if(!file.exists()) {
            try {
                file.createNewFile();
                plugin.getLogger().info("Config file created" + file.getName());
            }
            catch (Exception e) {
                plugin.getLogger().info("Config file creation failed" + file.getName());
            }
        }
    }
    public void saveConfig() {
        try {
            config.options().copyDefaults(true);
            config.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public FileConfiguration getConfig() {
        return config;
    }
}






