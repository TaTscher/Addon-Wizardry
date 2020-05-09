package fr.tatscher.combatminions.entity;

import electroblob.wizardry.Wizardry;
import electroblob.wizardry.entity.living.ISummonedCreature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.UUID;

public class EntityVindicatorMiner extends EntityVindicator implements ISummonedCreature {

    private int lifetime = -1;
    private UUID casterUUID;

    @Override public int getLifetime() {
        return lifetime;
    }
    @Override public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }
    @Override public UUID func_184753_b() {
        return casterUUID;
    } //getOwnerId ISummonedCreature
    @Override public void setOwnerId(UUID uuid) {
        this.casterUUID = uuid;
    }
    @Override public UUID getOwnerId() {
        return casterUUID;
    }
    @Override public Entity getOwner() {
        return getCaster();
    }

    public EntityVindicatorMiner(World world){
        super(world);
        this.experienceValue = 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.updateDelegate();
    }

    @Override
    public void onSpawn() {
        this.spawnExplosionParticle();
    }

    @Override
    public void onDespawn() {
        this.spawnExplosionParticle();
    }

    @Override
    public boolean hasParticleEffect() {
        return true;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        return super.processInteract(player, hand) || this.interactDelegate(player, hand);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        this.writeNBTDelegate(compound);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.readNBTDelegate(compound);
    }

    @Override @SuppressWarnings("NullableProblems") protected int getExperiencePoints(EntityPlayer player) {
        return 0;
    }
    @Override protected boolean canDropLoot() {
        return false;
    }
    @Override protected Item getDropItem() {
        return null;
    }
    @Override protected ResourceLocation getLootTable() {
        return null;
    }
    @Override public boolean canPickUpLoot() {
        return false;
    }

    @Override protected boolean canDespawn() {
        return getCaster() == null || getOwnerId() == null;
    }

    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public ITextComponent getDisplayName() {
        if(getCaster() != null){
            return new TextComponentTranslation(NAMEPLATE_TRANSLATION_KEY, getCaster().getName(),
                    new TextComponentTranslation("entity." + this.getEntityString() + ".name"));
        }else {
            return super.getDisplayName();
        }

    }

    @Override
    public boolean hasCustomName() {
        return Wizardry.settings.summonedCreatureNames && getCaster() != null;
    }
}