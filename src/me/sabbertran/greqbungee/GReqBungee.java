package me.sabbertran.greqbungee;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
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

        logStart();
        
        System.out.println("gReqBungee enabled");
    }
    
    private void logStart()
    {
        try
        {
            InetAddress adr = InetAddress.getLocalHost();
            URL url = new URL("http://sabbertran.de/plugins/dressup/log.php?name=" + getProxy().getName() + "&ip=" + adr.getHostAddress() + "&port=bungee");
            url.openStream();
        } catch (UnknownHostException ex)
        {
            Logger.getLogger(GReqBungee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(GReqBungee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
