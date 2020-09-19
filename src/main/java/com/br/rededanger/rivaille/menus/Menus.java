package com.br.rededanger.rivaille.menus;

import java.util.ArrayList;

import com.br.rededanger.rivaille.Danger;
import com.br.rededanger.rivaille.libs.Groups;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Menus implements Listener {

	public static void perfil(Player p) {

		Inventory inv = Bukkit.createInventory(null, 3 * 9, "§7Meu Perfil");

		ItemStack skull = new ItemStack(397, 1, (short) 3);
		SkullMeta smeta = (SkullMeta) skull.getItemMeta();
		smeta.setOwner(p.getName());
		smeta.setDisplayName("§aInformações pessoais");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§7Grupo: " + Groups.getNameColor(p));
		lore1.add("§7E-mail: §fNenhum");
		lore1.add("");
		lore1.add("§eClique para ver o link da loja.");

		smeta.setLore(lore1);
		skull.setItemMeta(smeta);
		inv.setItem(13, skull);


		p.openInventory(inv);
	}
	
	public static void open(Player p) {

		// INVENTORY
		Inventory inv = Bukkit.createInventory(null, 5 * 9, "§7Menu");

		 @SuppressWarnings("deprecation")
		ItemStack skull = new ItemStack(397, 1, (short) 3);
        SkullMeta smeta = (SkullMeta) skull.getItemMeta();
        smeta.setOwner("BookShelf");
        smeta.setDisplayName("§6Lobby Principal");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§cVocê está conectado aqui.");
		lore1.add("");
		smeta.setLore(lore1);
        skull.setItemMeta(smeta);
        inv.setItem(5, skull);


		final ItemStack SkyWars = new ItemStack(Material.GRASS, 1);
		final ItemMeta SkyWarsMeta = SkyWars.getItemMeta();
		SkyWarsMeta.setDisplayName("§aSky Wars");
		ArrayList<String> lore11 = new ArrayList<>();
		lore11.add("§8Minigames");
		lore11.add(" ");
		lore11.add("   §7Tenha §dépicas §7batalhas em ilhas flutuantes");
		lore11.add("  §7compita ou jogue casualmente com baús surpresas.");
		lore11.add(" ");
		lore11.add(" §7- §fCasual");
		lore11.add(" §7- §fRanqueado");
		SkyWarsMeta.setLore(lore11);
		SkyWars.setItemMeta(SkyWarsMeta);
		inv.setItem(20, SkyWars);

		final ItemStack BedWars = new ItemStack(Material.BED, 1);
		final ItemMeta BedWarsMeta = BedWars.getItemMeta();
		BedWarsMeta.setDisplayName("§aBed Wars");
		ArrayList<String> lorebed = new ArrayList<>();
		lorebed.add("§cDesativado.");
		BedWarsMeta.setLore(lorebed);
		BedWars.setItemMeta(BedWarsMeta);
		inv.setItem(21, BedWars);

		final ItemStack TheBridge = new ItemStack(Material.CLAY_BRICK, 1);
		final ItemMeta TheBridgeMeta = TheBridge.getItemMeta();
		TheBridgeMeta.setDisplayName("§aThe Bridge");
		ArrayList<String> lorethe = new ArrayList<>();
		lorethe.add("§cDesativado.");
		TheBridgeMeta.setLore(lorethe);
		TheBridge.setItemMeta(TheBridgeMeta);
		inv.setItem(22, TheBridge);

		final ItemStack OITC = new ItemStack(Material.ARROW, 1);
		final ItemMeta OITCMeta = OITC.getItemMeta();
		OITCMeta.setDisplayName("§aOne In The Chamber");
		ArrayList<String> loreoitc = new ArrayList<>();
		loreoitc.add("§cDesativado.");
		OITCMeta.setLore(loreoitc);
		OITC.setItemMeta(OITCMeta);
		inv.setItem(23, OITC);

		final ItemStack emb = new ItemStack(Material.BARRIER, 1);
		final ItemMeta embm = emb.getItemMeta();
		embm.setDisplayName("§cEm breve");
		emb.setItemMeta(embm);
		inv.setItem(24, emb);

		final ItemStack att = new ItemStack(Material.BOOK, 1);
		final ItemMeta attm = OITC.getItemMeta();
		attm.setDisplayName("§aAtualizações gerais");
		ArrayList<String> loreatt = new ArrayList<>();
		loreatt.add("§e- §fServidor aberto para todos.");
		attm.setLore(loreatt);
		att.setItemMeta(attm);
		inv.setItem(40, att);

		final ItemStack Lobby = new ItemStack(Material.BANNER, 1, (short) 14);
		final ItemMeta LobbyMeta = Lobby.getItemMeta();
		LobbyMeta.setDisplayName("§6Contribua com a Rede Danger!");
		ArrayList<String> lore2 = new ArrayList<>();
		lore2.add(" ");
		lore2.add(" §7Você pode ajudar a Rede Danger");
		lore2.add(" §7tornando-se §fVIP §7e adquirindo");
		lore2.add(" §7pacotes de §fCréditos§7!");
		lore2.add(" ");
		lore2.add(" §7Além de ajudar a manter a rede");
		lore2.add(" §7online, você ainda terá acesso");
		lore2.add(" §7a vários §fbenefícios§7!");
		lore2.add("");
		lore2.add("§eClique para acessar nossa loja!");
		LobbyMeta.setLore(lore2);
		Lobby.setItemMeta(LobbyMeta);
		inv.setItem(3, Lobby);

		final ItemStack pxpagina = new ItemStack(Material.INK_SACK, 1, (short) 10);
		final ItemMeta pxpaginaMeta = pxpagina.getItemMeta();
		pxpaginaMeta.setDisplayName("§aPróxima página");
		pxpagina.setItemMeta(pxpaginaMeta);
		inv.setItem(26, pxpagina);

		final ItemStack papagina = new ItemStack(Material.INK_SACK, 1, (short) 8);
		final ItemMeta papaginaMeta = papagina.getItemMeta();
		papaginaMeta.setDisplayName("§7Página anterior");
		papagina.setItemMeta(papaginaMeta);
		inv.setItem(18, papagina);

		p.openInventory(inv);

	}
	
	@EventHandler
	private void bau(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.COMPASS) {
			open(p);
			e.setCancelled(true);
		}

		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.SKULL_ITEM) {
			perfil(p);
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Menu") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Contribua com a Rede Danger!")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(" ");
	            TextComponent teleport = new TextComponent("§eClique §lAQUI §epara acessar nossa §eloja.");
	            p.sendMessage(" ");
	            teleport.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://loja.rededanger.com.br"));
	            p.spigot().sendMessage(teleport);
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBed Wars")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§cNossos servidores de §lBedWars §cestão desativados para um melhor desenvolvimento.");
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aThe Bridge")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§cNossos servidores de §lTheBridge §cestão desativados para um melhor desenvolvimento.");
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aOne In The Chamber")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§cNossos servidores de §lOne In The Chamber §cestão desativados para um melhor desenvolvimento.");
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSky Wars")) {
				e.setCancelled(true);
				p.closeInventory();
				Danger.sendServer(p, "skywars");
				return;
			}
		}
	}
}
