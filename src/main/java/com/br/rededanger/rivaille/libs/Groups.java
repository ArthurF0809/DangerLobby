package com.br.rededanger.rivaille.libs;

import org.bukkit.entity.Player;

public class Groups {

	public static String getGroup(Player player) {
		if (player.hasPermission("grupo.master")) {
			return "§6[Master] ";

		}

		if (player.hasPermission("grupo.gerente")) {
			return "§4[Gerente] ";

		}

		if (player.hasPermission("grupo.admin")) {
			return "§c[Admin] ";

		}

		if (player.hasPermission("grupo.moderador")) {
			return "§2[Moderador] ";

		}

		if (player.hasPermission("grupo.ajudante")) {
			return "§d[Ajudante] ";

		}

		if (player.hasPermission("grupo.youtuber")) {
			return "§c[Youtuber] ";

		}

		if (player.hasPermission("grupo.mitico")) {
			return "§5[Mítico] ";

		}

		if (player.hasPermission("grupo.mestre")) {
			return "§e[Mestre] ";

		}

		if (player.hasPermission("grupo.elite")) {
			return "§1[Elite] ";

		}

		if (player.hasPermission("grupo.guerreiro")) {
			return "§a[Guerreiro] ";

		}

		return "§7";

	}

	public static String getNameColor(Player player) {
		if (player.hasPermission("grupo.master")) {
			return "§6Master";

		}

		if (player.hasPermission("grupo.gerente")) {
			return "§4Gerente";

		}

		if (player.hasPermission("grupo.admin")) {
			return "§cAdmin";

		}

		if (player.hasPermission("grupo.moderador")) {
			return "§2Moderador";

		}

		if (player.hasPermission("grupo.ajudante")) {
			return "§dAjudante";

		}

		if (player.hasPermission("grupo.youtuber")) {
			return "§cYoutuber";

		}

		if (player.hasPermission("grupo.mitico")) {
			return "§5Mítico";

		}

		if (player.hasPermission("grupo.mestre")) {
			return "§eMestre";

		}

		if (player.hasPermission("grupo.elite")) {
			return "§1Elite";

		}

		if (player.hasPermission("grupo.guerreiro")) {
			return "§aGuerreiro";

		}

		return "§7Membro";
	}

}
