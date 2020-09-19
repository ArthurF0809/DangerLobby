package com.br.rededanger.rivaille.listeners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

import com.br.rededanger.rivaille.Danger;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Protection implements Listener {

	private Map<String, Long> timeout = new HashMap<>();

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();

		if (Danger.build.contains(player)) {
			event.setCancelled(false);

		}else {
			event.setCancelled(true);

		}

	}

	@EventHandler
	public void onDrop(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();

		if(Danger.build.contains(player)) {
			event.setCancelled(false);

		}else {
			event.setCancelled(true);

		}

	}

	@EventHandler
	public void onChatDelay(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();

		if ((this.timeout.containsKey(player.getName()))
				&& (((Long) this.timeout.get(player.getName())).longValue() > System.currentTimeMillis())) {

			if (player.hasPermission("lobby.staff") || player.hasPermission(Danger.permGlobal)) {
				return;

			}else {
				player.sendMessage("§cAguarde para utilizar o chat novamente.");
				event.setCancelled(true);
				return;

			}

		}

		this.timeout.put(player.getName(), Long.valueOf(System.currentTimeMillis() + 3000L));

	}

	@EventHandler
	public void onInvClickEvent(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		if (Danger.build.contains(player)) {
			event.setCancelled(false);

		}else {
			event.setCancelled(true);

		}

	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();

		if(Danger.build.contains(player)) {
			event.setCancelled(false);

		}else {
			event.setCancelled(true);

		}

	}

	@EventHandler
	public void onHunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);

	}

	@EventHandler
	public void onDamage(EntityDamageByBlockEvent event) {
		event.setCancelled(true);

	}
	
	@EventHandler
	public void onWeatherEvent(WeatherChangeEvent event) {
		if(event.toWeatherState()) {
			event.setCancelled(true);	

		}

	}

	@EventHandler
	public void onBrake(BlockBreakEvent event) {
		Player player = event.getPlayer();

		if(Danger.build.contains(player)) {
			event.setCancelled(false);

		}else {
			event.setCancelled(true);

		}

	}

	@EventHandler
	public void onDamageEnt(EntityDamageByEntityEvent event) {
		event.setCancelled(true);

	}

	@EventHandler
	public void onDamageAll(EntityDamageEvent event) {
		event.setCancelled(true);

	}
	
	@EventHandler
	public void onPlayerColor(SignChangeEvent event) {
		if (event.getLine(0).contains("&")) {
			event.setLine(0, event.getLine(0).replace("&", "�"));

		}

		if (event.getLine(1).contains("&")) {
			event.setLine(1, event.getLine(1).replace("&", "�"));

		}

		if (event.getLine(2).contains("&")) {
			event.setLine(2, event.getLine(2).replace("&", "�"));

		}

		if (event.getLine(3).contains("&")) {
			event.setLine(3, event.getLine(3).replace("&", "�"));

		}

	}

	@EventHandler
	public void onMe(final PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();

		if (event.getMessage().toLowerCase().startsWith("/me") || event.getMessage().toLowerCase().startsWith("//calc")
				|| event.getMessage().toLowerCase().startsWith("/pl")
				|| event.getMessage().toLowerCase().startsWith("/plugins")
				|| event.getMessage().toLowerCase().startsWith("/ver")
				|| event.getMessage().toLowerCase().startsWith("/bukkit")
				|| event.getMessage().toLowerCase().startsWith("/version")
				|| event.getMessage().toLowerCase().startsWith("/about")
				|| event.getMessage().toLowerCase().startsWith("/gadgetsmenu")
				|| event.getMessage().toLowerCase().startsWith("/?")) {
			event.setCancelled(true);
			player.sendMessage("Comando desconhecido.");
			return;

		}

		if (event.getMessage().toLowerCase().startsWith("/youtuber")) {
			event.setCancelled(true);

			TextComponent text = new TextComponent("§7* Clique aqui para acessar.");
			text.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://discord.gg/pGvpUXk"));
			text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("�7Voc� abrir� o convite oficial\n�7do nosso servidor no Discord.").create()));

			player.sendMessage(" §c§lYOUTUBER");
			player.sendMessage(" ");
			player.sendMessage(" §7* Para tornar-se §cYouTuber§7, deverá atender aos requisitos:");
			player.sendMessage(" §71. Possuir §c750 inscritos§7;");
			player.sendMessage(" §71. Possuir §cfeedback§7 razoável, em relação ao número de inscritos;");
			player.sendMessage(" §71. Possuir §c3 vídeos gravados§7 dentro do servidor.");
			player.sendMessage(" ");
			player.sendMessage(" §7* Para tornar-se §6Danger§7 (MiniYT), deverá atender aos requisitos:");
			player.sendMessage(" §71. Possuir §c500 inscritos§7;");
			player.sendMessage(" §71. Possuir §cfeedback§7 razoável, em relação ao número de inscritos;");
			player.sendMessage(" §71. Possuir §c3 vídeos gravados§7 dentro do servidor.");
			player.sendMessage(" ");
			player.sendMessage(" §7* Solicite sua tag entrando em nosso Discord!");
			player.spigot().sendMessage(text);
			return;

		}

		if (event.getMessage().toLowerCase().startsWith("/help") || event.getMessage().toLowerCase().startsWith("/ajuda")) {
			event.setCancelled(true);

			TextComponent staff = new TextComponent("§lAQUI");
			staff.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://bit.ly/dangerform"));
			staff.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Você será redirecionado para o formulário.").create()));

			TextComponent loja = new TextComponent("§lAQUI");
			loja.setClickEvent(new ClickEvent(Action.OPEN_URL, "loja.rededanger.com.br"));
			loja.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Você será redirecionado para a nossa loja.").create()));

			TextComponent youtuber = new TextComponent("§lAQUI");
			youtuber.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/youtuber"));
			youtuber.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Você verificará os requisitos para tornar-se §cYouTuber§7.").create()));

			player.sendMessage(" §e§lAJUDA");
			player.sendMessage(" ");
			player.sendMessage(" §e* Membros da equipe §lJAMAIS§e pedirão sua senha, não informe para nenhum jogador.");
			player.sendMessage(" §e* Clique " + staff + "§e e saiba como tornar-se um membro da equipe.");
			player.sendMessage(" §e* Saiba os valores dos nossos §lVIPs§e clicando " + loja + "§e.");
			player.sendMessage(" §e* Quer tornar-se §cYouTuber§e? Clique " + youtuber + "§e para saber os requisitos.");
			return;

		}

	}
	
	@EventHandler
	public void onMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		final Location location = player.getLocation();

		if (location.getBlockY() <= 0) {
			player.teleport(player.getWorld().getSpawnLocation());
			player.playSound(location, Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);

		}

	}

	@EventHandler
	public void onUnknown(final PlayerCommandPreprocessEvent event) {

		if (event.isCancelled()) {
			return;

		}

		final Player player = event.getPlayer();
		final String message = event.getMessage().split(" ")[0];
		final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(message);

		if (topic == null) {
			event.setCancelled(true);
			player.sendMessage("§fComando desconhecido.");

		}

	}

}
