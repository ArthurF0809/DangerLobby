package com.br.rededanger.rivaille.libs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Manager {

	public static boolean chat = true;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Player> hat = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<Player, String> tell = new HashMap();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<Player, String> score = new HashMap();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<Player, String> players = new HashMap();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<Player, Long> cooldown = new HashMap();

	public static ItemStack criarItem(Material material, String nome) {
		ItemStack stack = new ItemStack(material);
		ItemMeta stack2 = stack.getItemMeta();
		stack2.setDisplayName(nome);
		stack.setItemMeta(stack2);
		return stack;
	}
	public static ItemStack criarItem(Material material, String nome, String lore) {
		ItemStack stack = new ItemStack(material);
		ItemMeta stack2 = stack.getItemMeta();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<String> ls = new ArrayList();
		ls.add(lore);
		stack2.setLore(ls);
		stack2.setDisplayName(nome);
		stack.setItemMeta(stack2);
		return stack;
	}

	public static ItemStack criarItem(Material material, String nome, Enchantment encantamento) {
		ItemStack stack = new ItemStack(material);
		ItemMeta stack2 = stack.getItemMeta();
		stack2.addEnchant(encantamento, 1, true);
		stack2.setDisplayName(nome);
		stack.setItemMeta(stack2);
		return stack;
	}

	@SuppressWarnings("unused")
	public static void Aparecer(Player p) {
		Player[] arrayOfPlayer;
		int j;
		int i;
		j = Bukkit.getOnlinePlayers().size();
		for (i = 0; i < j; i++) {
			for (Player pl : Bukkit.getOnlinePlayers()) {
				p.showPlayer(pl);
			}
		}
	}
	@SuppressWarnings("unused")
	public static void Esconder(Player p) {
		Player[] arrayOfPlayer;
		int j;
		int i;
		j = Bukkit.getOnlinePlayers().size();
		for (i = 0; i < j; i++) {
			for (Player pl : Bukkit.getOnlinePlayers()) {
				p.hidePlayer(pl);
			}
		}
	}
}