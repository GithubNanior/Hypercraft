package net.mcreator.hypercraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.hypercraft.HypercraftModElements;

import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class HyperthermiaEffectProcedure extends HypercraftModElements.ModElement {
	public HyperthermiaEffectProcedure(HypercraftModElements instance) {
		super(instance, 48);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HyperthermiaEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.HOT_FLOOR, (float) 2);
	}
}
