package nl.michaj.antiinvispotion.main.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import nl.michaj.antiinvispotion.main.Main;

public class PlayerListener implements Listener {

	private final Main main;

	public PlayerListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void playerConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if (item.getType() == Material.POTION || item.getType() == Material.LINGERING_POTION) {
			PotionMeta meta = (PotionMeta) item.getItemMeta();
			PotionType cPotion = meta.getBasePotionData().getType();
			if (cPotion == PotionType.INVISIBILITY) {
				e.setCancelled(true);
				main.msg(p, "&cYou are not allowed to use this item, " + main.getConfig().getString("ServerName")
						+ " does not allow it.");
				main.log(p.getName() + " (" + p.getCustomName() + ") tried using a Invis Potion!");
			}
		}
	}

	@EventHandler
	public void OnPotionSplash(PotionSplashEvent e) {
		Player p = (Player) e.getPotion().getShooter();

		PotionMeta meta = (PotionMeta) e.getPotion().getItem().getItemMeta();
		PotionType currentPotion = meta.getBasePotionData().getType();
		if (currentPotion == PotionType.INVISIBILITY) {
			e.setCancelled(true);
			main.msg(p, "&cYou are not allowed to use this item, " + main.getConfig().getString("ServerName")
					+ " does not allow it.");
			main.log(p.getName() + " (" + p.getCustomName() + ") tried using a Invis Potion!");
		}
	}

	@EventHandler
	public void onLingerSplash(LingeringPotionSplashEvent e) {
		Player p = (Player) e.getEntity().getShooter();

		PotionMeta meta = (PotionMeta) e.getEntity().getItem().getItemMeta();
		PotionType currentPotion = meta.getBasePotionData().getType();
		if (currentPotion == PotionType.INVISIBILITY) {
			e.setCancelled(true);
			main.msg(p, "&cYou are not allowed to use this item, " + main.getConfig().getString("ServerName")
					+ " does not allow it.");
			main.log(p.getName() + " (" + p.getCustomName() + ") tried using a Invis Potion!");
		}
	}

	public void onPotionInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if ((item.getType() == Material.LINGERING_POTION) || (item.getType() == Material.POTION)
				|| (item.getType() == Material.SPLASH_POTION)) {
			PotionMeta meta = (PotionMeta) item.getItemMeta();
			PotionType currentPotion = meta.getBasePotionData().getType();
			if (currentPotion == PotionType.INVISIBILITY) {
				e.setCancelled(true);
				main.msg(p, "&cYou are not allowed to use this item, " + main.getConfig().getString("ServerName")
						+ " does not allow it.");
				main.log(p.getName() + " (" + p.getCustomName() + ") tried using a Invis Potion!");
			}
		}
	}
}
