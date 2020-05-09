package fr.tatscher.combatminions;

import fr.tatscher.combatminions.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CombatMinions.MODID, name = CombatMinions.NAME, version = CombatMinions.VERSION, dependencies = "required-after:ebwizardry")
public class CombatMinions {
    public static final String MODID = "combatminions";
    public static final String NAME = "Magical Combat Minions";
    public static final String VERSION = "0.1-alpha";

    @Mod.Instance
    public static CombatMinions instance;

    @SidedProxy(clientSide = "fr.tatscher.combatminions.proxy.ClientProxy", serverSide = "fr.tatscher.combatminions.proxy.ServerProxy")
    public static IProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
