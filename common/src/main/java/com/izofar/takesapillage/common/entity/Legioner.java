package com.izofar.takesapillage.common.entity;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.entity.ai.ShieldGoal;
import com.izofar.takesapillage.common.init.ItTakesPillageSoundEvents;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;


import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

/*? >= 1.21 {*/
import net.minecraft.server.level.ServerLevel;
import com.izofar.takesapillage.common.ItTakesPillage;
/*?} else {*/
/*import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
*//*?}*/


//? >= 1.21.3 {
import net.minecraft.world.entity.EntitySpawnReason;
//?} else {
/*import net.minecraft.world.entity.MobSpawnType;
*///?}

public final class Legioner extends AbstractIllager implements ShieldedMob
{
	private static final EntityDataAccessor<Boolean> DATA_IS_SHIELDED = SynchedEntityData.defineId(Legioner.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_SHIELD_HAND = SynchedEntityData.defineId(Legioner.class, EntityDataSerializers.BOOLEAN); // True for Main Hand, False for Offhand
	private static final EntityDataAccessor<Integer> DATA_SHIELD_COOLDOWN = SynchedEntityData.defineId(Legioner.class, EntityDataSerializers.INT);

	/*? >= 1.21 {*/
	private static final AttributeModifier SPEED_MODIFIER_BLOCKING = new AttributeModifier(ItTakesPillage.makeId("speed_modifier_attacking"), -0.10D, AttributeModifier.Operation.ADD_VALUE);
	/*?} else {*/
	/*private static final UUID SPEED_MODIFIER_ATTACKING_UUID = UUID.fromString("3520BCE0-D755-458F-944B-A528DB8EF9DC");
	private static final AttributeModifier SPEED_MODIFIER_BLOCKING = new AttributeModifier(SPEED_MODIFIER_ATTACKING_UUID, "Shielded speed penalty", -0.10D, AttributeModifier.Operation.ADDITION);
	*//*?}*/

	public Legioner(EntityType<? extends AbstractIllager> entitytype, Level world) {
		super(entitytype, world);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.275D)
			.add(Attributes.FOLLOW_RANGE, 24.0D)
			.add(Attributes.MAX_HEALTH, 40.0D)
			.add(Attributes.ATTACK_DAMAGE, 6.5D)
			.add(Attributes.ARMOR, 6.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new ShieldGoal<>(this, Player.class));
		this.goalSelector.addGoal(2, new AbstractIllager.RaiderOpenDoorGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.25D, true));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
	}

	/*? >= 1.21 {*/
	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_IS_SHIELDED, false);
		builder.define(DATA_SHIELD_HAND, false);
		builder.define(DATA_SHIELD_COOLDOWN, 0);
	}
	/*?} else {*/
	/*@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_IS_SHIELDED, false);
		this.entityData.define(DATA_SHIELD_HAND, false);
		this.entityData.define(DATA_SHIELD_COOLDOWN, 0);
	}
	*//*?}*/

	@Override
	public void tick() {
		if (!ItTakesPillage.getConfig().enableLegioner) {
			this.discard();
		}

		super.tick();

		if (!this.level().isClientSide()) {
			this.decrementShieldCooldown();
		}
	}

	@Override
	public SpawnGroupData finalizeSpawn(
		ServerLevelAccessor world,
		DifficultyInstance difficulty,
		//? >= 1.21.3 {
		EntitySpawnReason spawnReason,
		 //?} else {
		/*MobSpawnType spawnReason,
		*///?}
		@Nullable SpawnGroupData entityData
		//? <1.21.1 {
		/*,CompoundTag compoundTag
		*///?}
	) {
		SpawnGroupData spawngroupdata = super.finalizeSpawn(world, difficulty, spawnReason, entityData /*? <1.21.1 {*//*, compoundTag*//*?}*/);
		((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(true);
		RandomSource randomSource = world.getRandom();
		this.populateDefaultEquipmentSlots(randomSource, difficulty);
		this.populateDefaultEquipmentEnchantments(/*? >= 1.21.1 {*/world, /*?}*/ randomSource, difficulty);

		return spawngroupdata;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource randomsource, DifficultyInstance difficulty) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
	}

	@Override
	public AbstractIllager.IllagerArmPose getArmPose() {
		if (this.isAggressive()) return AbstractIllager.IllagerArmPose.ATTACKING;
		return this.isCelebrating() ? AbstractIllager.IllagerArmPose.CELEBRATING:null;
	}

	//? if <=1.20.1 {
	/*@Override
	public void applyRaidBuffs(int round, boolean b) {
	}
	*///?} else {
	public void applyRaidBuffs(ServerLevel serverLevel, int i, boolean bl) {
	}
	//?}

	@Override
	public void knockback(double x, double y, double z) {
		if (!this.isUsingShield()) {
			super.knockback(x, y, z);
		} else {
			//? if >=1.21.5 {
			var soundEvent = SoundEvents.SHIELD_BLOCK.value();
			//?} else {
			/*var soundEvent = SoundEvents.SHIELD_BLOCK;
			*///?}
			this.playSound(soundEvent, 1.0F, 0.8F + this.level().random.nextFloat() * 0.4F);
		}
	}

	@Override
	//? if >=1.21.5 {
	protected void blockUsingItem(ServerLevel level, LivingEntity attacker)
	//?} else {
	/*protected void blockUsingShield(LivingEntity attacker)
	*///?}
	{
		//? if >=1.21.5 {
		super.blockedByItem(this);
		//?} else {
		/*super.blockUsingShield(attacker);
		*///?}

		if (attacker.getMainHandItem().getItem() instanceof AxeItem) {
			this.disableShield();
		}
	}

	private void disableShield() {
		this.setShieldCooldown(60);
		this.stopUsingShield();
		this.level().broadcastEntityEvent(this, (byte) 30);
		//? if >=1.21.5 {
		var soundEvent = SoundEvents.SHIELD_BREAK.value();
		//?} else {
		/*var soundEvent = SoundEvents.SHIELD_BREAK;
		 *///?}
		this.playSound(soundEvent, 0.8F, 0.8F + this.level().random.nextFloat() * 0.4F);
	}

	@Override
	public boolean isShieldDisabled() {
		return this.getShieldCooldown() > 0;
	}

	@Override
	public void startUsingShield() {
		if (this.isUsingShield() || this.isShieldDisabled()) return;
		for (InteractionHand interactionhand : InteractionHand.values()) {
			if (this.getItemInHand(interactionhand).is(Items.SHIELD)) {
				this.startUsingItem(interactionhand);
				this.setUsingShield(true);
				this.setShieldMainhand(interactionhand == InteractionHand.MAIN_HAND);
				AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
				/*? >= 1.21 {*/
				if (attributeinstance != null && !attributeinstance.hasModifier(SPEED_MODIFIER_BLOCKING.id())) {
					/*?} else {*/
					/*if (attributeinstance != null && !attributeinstance.hasModifier(SPEED_MODIFIER_BLOCKING)) {
					 *//*?}*/
					attributeinstance.addTransientModifier(SPEED_MODIFIER_BLOCKING);
				}
			}
		}
	}

	@Override
	public void stopUsingShield() {
		if (!this.isUsingShield()) return;
		for (InteractionHand interactionhand : InteractionHand.values()) {
			if (this.getItemInHand(interactionhand).is(Items.SHIELD)) {
				this.stopUsingItem();
				this.setUsingShield(false);
				AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
				if (attributeinstance != null)
					attributeinstance.removeModifier(SPEED_MODIFIER_BLOCKING);
			}
		}
	}

	public boolean isUsingShield() {
		return this.entityData.get(DATA_IS_SHIELDED);
	}

	public void setUsingShield(boolean isShielded) {
		this.entityData.set(DATA_IS_SHIELDED, isShielded);
	}

	private boolean isShieldMainhand() {
		return this.entityData.get(DATA_SHIELD_HAND);
	}

	private void setShieldMainhand(boolean isShieldedMainHand) {
		this.entityData.set(DATA_SHIELD_HAND, isShieldedMainHand);
	}

	private int getShieldCooldown() {
		return this.entityData.get(DATA_SHIELD_COOLDOWN);
	}

	private void setShieldCooldown(int newShieldCooldown) {
		this.entityData.set(DATA_SHIELD_COOLDOWN, newShieldCooldown);
	}

	private void decrementShieldCooldown() {
		this.setShieldCooldown(Math.max(this.getShieldCooldown() - 1, 0));
	}

	public InteractionHand getShieldHand() {
		return this.isUsingShield() ? (this.isShieldMainhand() ? InteractionHand.MAIN_HAND:InteractionHand.OFF_HAND):null;
	}

	@Override
	public SoundEvent getCelebrateSound() {
		return ItTakesPillageSoundEvents.LEGIONER_CELEBRATE.get();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ItTakesPillageSoundEvents.LEGIONER_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ItTakesPillageSoundEvents.LEGIONER_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_33306_) {
		return ItTakesPillageSoundEvents.LEGIONER_HURT.get();
	}

}
