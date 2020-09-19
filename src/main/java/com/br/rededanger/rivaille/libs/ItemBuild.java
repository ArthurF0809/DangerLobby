package com.br.rededanger.rivaille.libs;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuild implements Listener {

	public static final ItemStack newHead(final Player player, final String owner, final String name, final int quantity,
			final byte id) {
		final ItemStack head = new ItemStack(Material.SKULL_ITEM, quantity, (short) id);
		final SkullMeta headmeta = (SkullMeta) head.getItemMeta();

		headmeta.setOwner(owner);
		headmeta.setDisplayName(name);
		head.setItemMeta((ItemMeta) headmeta);
		return head;

	}

	public static final ItemStack newItem(final Material material, final String name, final String[] desc) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemk = item.getItemMeta();

		itemk.setDisplayName(name);
		itemk.setLore((List<String>) Arrays.asList(desc));
		item.setItemMeta(itemk);
		return item;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final ItemStack newItem(final Material material, final String name, final String[] desc, final int qt,
			final byte bt) {
		final ItemStack item = new ItemStack(material, qt, (short) bt);
		final ItemMeta itemk = item.getItemMeta();

		itemk.setDisplayName(name);
		itemk.setLore((List) Arrays.asList(desc));
		item.setItemMeta(itemk);
		return item;

	}

	public static final ItemStack newItem(final Material material, final String name, final int qt, final byte bt) {
		final ItemStack item = new ItemStack(material, qt, (short) bt);
		final ItemMeta itemk = item.getItemMeta();

		itemk.setDisplayName(name);
		item.setItemMeta(itemk);
		return item;

	}

	public static void setitem(final Player player, final Material mat, final String name, final int location,
			final Enchantment enchant, final int level, final boolean bool) {
		final ItemStack item = new ItemStack(mat);
		final ItemMeta itemmeta = item.getItemMeta();

		itemmeta.setDisplayName(name);
		itemmeta.addEnchant(enchant, level, bool);
		item.setItemMeta(itemmeta);
		player.getInventory().setItem(location, item);

	}

	public static void send(Player player) {
		player.getInventory().setItem(1, newItem(Material.COMPASS, "§eMinigames", 1, (byte) 0));
		player.getInventory().setItem(2, newHead(player, player.getName(), "§ePerfil", 1, (byte) 3));


		player.getInventory().setItem(7, newItem(Material.INK_SACK, "§fJogadores: §aVisíveis", 1, (byte) 10));

	}

	@EventHandler
	public void clicar(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		if ((player.getItemInHand().getType() != null) && (player.getItemInHand().getType() == Material.INK_SACK)) {
			if (player.getItemInHand().getItemMeta().getDisplayName().equals("§fJogadores: §aVisíveis")) {
				if (Manager.players.get(player) == "ativado") {
					Manager.players.put(player, "desativado");
					Manager.Esconder(player);
					player.getInventory().remove(newItem(Material.INK_SACK, "§fJogadores: §aVisíveis", 1, (byte) 10));
					player.getInventory().setItem(7, newItem(Material.INK_SACK, "§fJogadores: §cInvisíveis", 1, (byte) 8));
					player.updateInventory();
					player.sendMessage("§cVisibilidade dos jogadores desativada!");
					player.playSound(player.getLocation(), Sound.WOOD_CLICK, 5.0F, 5.0F);
					return;

				}

			}

			if (player.getItemInHand().getItemMeta().getDisplayName().equals("§fJogadores: §cInvisíveis")) {
				if (Manager.players.get(player) == "desativado") {
					Manager.players.put(player, "ativado");
					Manager.Aparecer(player);
					player.getInventory().remove(newItem(Material.INK_SACK, "§fJogadores: §cInvisíveis", 1, (byte) 8));
					player.getInventory().setItem(7, newItem(Material.INK_SACK, "§fJogadores: §aVisíveis", 1, (byte) 10));
					player.updateInventory();
					player.sendMessage("§aVisibilidade dos jogadores ativada!");
					player.playSound(player.getLocation(), Sound.WOOD_CLICK, 5.0F, 5.0F);
					return;

				}

			}

		}

		if (player.getItemInHand().getType() == Material.WATCH) {
			player.sendMessage("§cNo momento possuimos apenas um lobby.");
			return;

		}

		if (player.getItemInHand().getType() == Material.CHEST) {
			player.chat("/gmenu main");

		}

	}

}
