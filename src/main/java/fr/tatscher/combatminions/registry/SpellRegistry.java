package fr.tatscher.combatminions.registry;

import electroblob.wizardry.spell.Spell;
import fr.tatscher.combatminions.CombatMinions;
import fr.tatscher.combatminions.spells.SummonMiner;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@ObjectHolder(CombatMinions.MODID)
@Mod.EventBusSubscriber
public class SpellRegistry {
    private SpellRegistry(){}

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    private static <T> T placeholder(){return null;}

    public static final Spell summon_miner = placeholder();

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Spell> event){
        IForgeRegistry<Spell> registry = event.getRegistry();

        registry.register(new SummonMiner());
    }

}
