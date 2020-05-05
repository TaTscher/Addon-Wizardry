package fr.tatscher.combatminions;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CombatMinions.MODID, name = CombatMinions.NAME, version = CombatMinions.VERSION)
public class CombatMinions {
    public static final String MODID = "combatminions";
    public static final String NAME = "Magical Combat Minions";
    public static final String VERSION = "0.1-alpha";

    @Mod.Instance
    public static CombatMinions instance;

    //@SidedProxy(clientSide = , serverSide = )

    private static Logger logger;
    //oui
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
    }
}
