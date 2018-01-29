package nl.michaj.antiinvispotion.main;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import nl.michaj.antiinvispotion.main.events.PlayerListener;

public class Main extends JavaPlugin {

	public void onEnable() {
		log("Enabling AntiInvis");
		getEvents();
		addDefaultsToConfig();
	}

	public void getEvents() {
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}

	public void log(String msg) {
		getLogger().info(msg);
	}

	public void msg(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	public void addDefaultsToConfig() {
		log("Adding defaults to configuration!");
		getConfig().addDefault("ServerName", "Your Server Name Here!");
		getConfig().options().copyDefaults(true);
		log("Saving Config");
		saveConfig();
	}
}
