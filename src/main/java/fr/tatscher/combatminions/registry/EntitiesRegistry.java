package fr.tatscher.combatminions.registry;

import fr.tatscher.combatminions.CombatMinions;
import fr.tatscher.combatminions.entity.EntityVindicatorMiner;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public final class EntitiesRegistry {
    private EntitiesRegistry(){}

    private static int id = 0;

    @SubscribeEvent
    public static void register(RegistryEvent.Register<EntityEntry> event){
        IForgeRegistry<EntityEntry> registry = event.getRegistry();

        registry.register(createEntry(EntityVindicatorMiner.class, "vindicator_miner").build());
    }


    private static <T extends Entity> EntityEntryBuilder<T> createEntry(Class<T> entityClass, String name){
        ResourceLocation registryName = new ResourceLocation(CombatMinions.MODID, name);
        return EntityEntryBuilder.<T>create().entity(entityClass).id(registryName, id++).name(registryName.toString());
    }

}
