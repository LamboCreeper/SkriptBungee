package uk.lambocreeper.core;

import ch.njol.skript.Skript;
import uk.lambocreeper.core.EffBungee;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
    public static Core plugin;

    public Core() {
    }

    public void onEnable() {
        plugin = this;
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Skript.registerEffect(EffBungee.class, new String[]{"send %player% to bungee [server] %string%"});
        Skript.registerAddon(this);
    }
}
