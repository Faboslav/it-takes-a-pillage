package com.izofar.takesapillage.common.entity;

import com.izofar.takesapillage.common.ItTakesPillage;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.function.Predicate;

/*? if <=1.20.1 {*/
/*import net.minecraft.nbt.CompoundTag;
 *//*?}*/

public final class Skirmisher extends AbstractIllager
{
	private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (difficulty -> (difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD));

	public Skirmisher(EntityType<? extends AbstractIllager> entityType, Level world) {
		super(entityType, world);
	}

	//? if <=1.20.1 {
	/*@Override
	public void applyRaidBuffs(int round, boolean b) {
	}
	*///?} else {
	public void applyRaidBuffs(ServerLevel serverLevel, int i, boolean bl) {
	}
	//?}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.36D)
			.add(Attributes.FOLLOW_RANGE, 16.0D)
			.add(Attributes.MAX_HEALTH, 24.0D)
			.add(Attributes.ATTACK_DAMAGE, 5.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new SkirmisherBreakDoorGoal(this));
		this.goalSelector.addGoal(2, new AbstractIllager.RaiderOpenDoorGoal(this));
		this.goalSelector.addGoal(3, new Raider.HoldGroundAttackGoal(this, 10.0F));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.1D, false));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
	}

	@Override
	public void tick() {
		if (!ItTakesPillage.getConfig().enableSkirmisher) {
			this.discard();
		}

		super.tick();
	}

	@Override
	public AbstractIllager.IllagerArmPose getArmPose() {
		if (this.isAggressive()) return AbstractIllager.IllagerArmPose.ATTACKING;
		return this.isCelebrating() ? AbstractIllager.IllagerArmPose.CELEBRATING:AbstractIllager.IllagerArmPose.CROSSED;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource randomsource, DifficultyInstance difficulty) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
	}

	@Override
	public SoundEvent getCelebrateSound() {
		return SoundEvents.VINDICATOR_CELEBRATE;
	}

	@Override
	protected void customServerAiStep(/*? >= 1.21.4 {*/ServerLevel level /*?}*/) {
		if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this))
			((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(((ServerLevel) this.level()).isRaided(this.blockPosition()));
		super.customServerAiStep(/*? >= 1.21.4 {*/level /*?}*/);
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
	protected SoundEvent getAmbientSound() {
		return SoundEvents.VINDICATOR_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.VINDICATOR_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_34103_) {
		return SoundEvents.VINDICATOR_HURT;
	}

	private static class SkirmisherBreakDoorGoal extends BreakDoorGoal
	{
		public SkirmisherBreakDoorGoal(Mob mob) {
			super(mob, 6, Skirmisher.DOOR_BREAKING_PREDICATE);
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean canContinueToUse() {
			return this.getMob().hasActiveRaid() && super.canContinueToUse();
		}

		@Override
		public boolean canUse() {
			return this.getMob().hasActiveRaid() && this.getMob().random.nextInt(reducedTickDelay(10)) == 0 && super.canUse();
		}

		public void start() {
			super.start();
			this.mob.setNoActionTime(0);
		}

		private Skirmisher getMob() {
			return (Skirmisher) this.mob;
		}
	}
}
