package mc.arexmc.utils;

import java.lang.reflect.Field;

import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;


public class TablistAPI {

	public static void setTablist(Player p, String head, String foot) {
		PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		IChatBaseComponent header = IChatBaseComponent.ChatSerializer.a("{'color':'', 'text':'" + head + "'}");
		IChatBaseComponent footer = IChatBaseComponent.ChatSerializer.a("{'color':'', 'text':'" + foot + "'}");
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		try {
			Field headerField = packet.getClass().getDeclaredField("a");
			headerField.setAccessible(true);
			headerField.set(packet, header);
			headerField.setAccessible(!headerField.isAccessible());

			Field footerField = packet.getClass().getDeclaredField("b");
			footerField.setAccessible(true);
			footerField.set(packet, footer);
			footerField.setAccessible(!footerField.isAccessible());
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		connection.sendPacket(packet);
	}

}