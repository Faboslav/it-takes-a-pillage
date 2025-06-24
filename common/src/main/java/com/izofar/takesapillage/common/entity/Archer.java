package com.izofar.takesapillage.common.entity;

import com.izofar.takesapillage.common.ItTakesPillage;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

/*? <=1.21 {*/
/*import net.minecraft.nbt.CompoundTag;
 *//*?}*/

//? >= 1.21.3 {
import net.minecraft.world.entity.EntitySpawnReason;
//?} else {
/*import net.minecraft.world.entity.MobSpawnType;
 *///?}

public class Archer extends AbstractIllager implements RangedAttackMob
{
	public Archer(EntityType<? extends AbstractIllager> entitytype, Level world) {
		super(entitytype, world);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.36D)
			.add(Attributes.MAX_HEALTH, 24.0D)
			.add(Attributes.ATTACK_DAMAGE, 5.0D)
			.add(Attributes.FOLLOW_RANGE, 40.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(2, new HoldGroundAttackGoal(this, 10.0F));
		this.goalSelector.addGoal(3, new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 15.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 15.0F));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
	}

	@Override
	public void tick() {
		if (!ItTakesPillage.getConfig().enableArcher) {
			this.discard();
		}

		super.tick();
	}

	@Override
	public AbstractIllager.IllagerArmPose getArmPose() {
		return this.isAggressive() ? IllagerArmPose.CROSSBOW_HOLD:IllagerArmPose.NEUTRAL;
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
	public SoundEvent getCelebrateSound() {
		return SoundEvents.PILLAGER_CELEBRATE;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource randomsource, DifficultyInstance difficulty) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
	}

	@Override
	public void performRangedAttack(LivingEntity livingEntity, float f) {
		/*
		InteractionHand interactionhand = ProjectileUtil.getWeaponHoldingHand(this, (item) -> {
			return item instanceof BowItem;
		});*/

		ItemStack itemStack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
		AbstractArrow abstractArrow = this.getArrow(itemStack, f);
		double d = livingEntity.getX() - this.getX();
		double e = livingEntity.getY(0.3333333333333333) - abstractArrow.getY();
		double g = livingEntity.getZ() - this.getZ();
		double h = Math.sqrt(d * d + g * g);
		abstractArrow.shoot(d, e + h * 0.20000000298023224, g, 1.6F, (float) (14 - this.level().getDifficulty().getId() * 4));
		this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
		this.level().addFreshEntity(abstractArrow);
	}

	protected AbstractArrow getArrow(ItemStack itemstack, float f) {
		//? if <=1.20.1 {
		/*return ProjectileUtil.getMobArrow(this, itemstack, f);
		*///?} else {
		return ProjectileUtil.getMobArrow(this, itemstack, f, null);
		//?}
	}

	@Override
	public boolean canFireProjectileWeapon(ProjectileWeaponItem item) {
		return (item == Items.BOW);
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
		return SoundEvents.PILLAGER_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.PILLAGER_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_33306_) {
		return SoundEvents.PILLAGER_HURT;
	}
}
