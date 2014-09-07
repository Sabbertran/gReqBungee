package me.sabbertran.greqbungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener
{

    private GReqBungee main;

    public Events(GReqBungee main)
    {
        this.main = main;
    }

    @EventHandler
    public void onPluginMessage(PluginMessageEvent ev)
    {
        if (ev.getTag().equals("gReq"))
        {
            ByteArrayDataInput in = ByteStreams.newDataInput(ev.getData());
            String subchannel = in.readUTF();
            if (subchannel.equals("new_ticket"))
            {
                for (ServerInfo s : main.getProxy().getServers().values())
                {
                    if (s.getPlayers().size() > 0)
                    {
                        s.sendData("gReq", ev.getData());
                    }
                }
            } else if (subchannel.equals("claim") || subchannel.equals("unclaim"))
            {
                for (ServerInfo s : main.getProxy().getServers().values())
                {
                    if (s.getPlayers().size() > 0)
                    {
                        s.sendData("gReq", ev.getData());
                    }
                }
            } else if (subchannel.equals("answer"))
            {
                String id = in.readUTF();
                String author = in.readUTF();
                for (ServerInfo s : main.getProxy().getServers().values())
                {
                    if (s.getPlayers().size() > 0)
                    {
                        s.sendData("gReq", ev.getData());
                    }
                }
            } else if (subchannel.equals("join_teleport"))
            {
                String player = in.readUTF();
                String server = in.readUTF();
                ServerInfo s = main.getProxy().getServerInfo(server);
                if (s != null)
                {
                    s.sendData("gReq", ev.getData());
                    return;
                }
            }
        }
    }
}
