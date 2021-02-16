package net.mcreator.hypercraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hypercraft.HypercraftModElements;

import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class HypothermiaEffectProcedure extends HypercraftModElements.ModElement {
	public HypothermiaEffectProcedure(HypercraftModElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HypothermiaEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 150, (int) 1, (false), (false)));
	}
}
