package uk.lambocreeper.core;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.sun.istack.internal.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import uk.lambocreeper.core.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffBungee extends Effect {
    Expression<String> server;
    Expression<Player> player;

    public EffBungee() {
    }

    public boolean init(Expression<?>[] arg0, int arg1, Kleenean arg2, ParseResult arg3) {
        this.player = arg0[0];
        this.server = arg0[1];
        return true;
    }

    public String toString(@Nullable Event event, boolean args) {
        return "sends a player to a certain server!";
    }

    protected void execute(Event event) {
        Player player = (Player)this.player.getSingle(event);
        String server = (String)this.server.getSingle(event);
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException var7) {
            ;
        }

        player.sendPluginMessage(Core.plugin, "BungeeCord", b.toByteArray());
    }
}
