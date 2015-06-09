package me.sabbertran.greqbungee;

import java.util.logging.Logger;
import net.md_5.bungee.api.plugin.Plugin;

public class GReqBungee extends Plugin
{

    public Logger log = getLogger();

    @Override
    public void onDisable()
    {
        log.info("gReqBungee disabled");
    }

    @Override
    public void onEnable()
    {
        this.getProxy().registerChannel("gReq");
        this.getProxy().getPluginManager().registerListener(this, new Events(this));
        
        System.out.println("gReqBungee enabled");
    }
}
