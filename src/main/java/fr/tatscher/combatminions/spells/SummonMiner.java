package fr.tatscher.combatminions.spells;

import electroblob.wizardry.spell.SpellMinion;
import electroblob.wizardry.util.SpellModifiers;
import fr.tatscher.combatminions.CombatMinions;
import fr.tatscher.combatminions.entity.EntityVindicatorMiner;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class SummonMiner extends SpellMinion<EntityVindicatorMiner> {
    public SummonMiner() {
        super(CombatMinions.MODID, "summon_miner", EntityVindicatorMiner::new);
    }

    @Override
    protected void addMinionExtras(EntityVindicatorMiner minion, BlockPos pos, EntityLivingBase caster, SpellModifiers modifiers, int alreadySpawned) {
        minion.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_PICKAXE));
        minion.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.IRON_PICKAXE));
    }
}
