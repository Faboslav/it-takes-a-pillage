package com.izofar.takesapillage.fabric.mixin;

import com.izofar.takesapillage.common.event.entity.EntitySpawnEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*? >=1.21.3 {*/
import net.minecraft.world.entity.EntitySpawnReason;
/*?} else {*/
/*import net.minecraft.world.entity.MobSpawnType;
 *//*?}*/

@Mixin(StructureTemplate.class)
public class StructureTemplateEntitySpawnMixin
{
    @Inject(
		method = "method_17917",
            at = @At(
				value = "INVOKE",
				//? >=1.21.3 {
				target = "Lnet/minecraft/world/entity/Mob;finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/EntitySpawnReason;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;"
				//?} else if >=1.21.1 {
				/*target = "Lnet/minecraft/world/entity/Mob;finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;"
				*///?} else {
				/*target = "Lnet/minecraft/world/entity/Mob;finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/world/entity/SpawnGroupData;"
				*///?}
			),
            cancellable = true
	)
    private static void takesapillage$onEntitySpawn(
		Rotation rotation,
		Mirror mirror,
		Vec3 vec3,
		boolean bl,
		ServerLevelAccessor serverLevel,
		/*? <1.21.1 {*/ /*CompoundTag compoundTag,*//*?}*/
		Entity entity,
		CallbackInfo ci)
    {
        if (
			entity instanceof Mob mob
			&& EntitySpawnEvent.EVENT.invoke(
				new EntitySpawnEvent(
					mob,
					serverLevel,
					mob.isBaby(),
					/*? >=1.21.3 {*/
					EntitySpawnReason.STRUCTURE
					/*?} else {*/
					/*MobSpawnType.STRUCTURE
					*//*?}*/
				)
			)) {
            ci.cancel();
        }
    }
}
