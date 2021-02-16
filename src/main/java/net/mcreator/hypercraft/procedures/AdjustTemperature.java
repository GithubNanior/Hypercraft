package net.mcreator.extracontents.procedures;

import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.entity.Entity;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;

import net.mcreator.hypercraft.potion.HypothermiaPotion;
import net.mcreator.hypercraft.potion.HyperthermiaPotion;
import net.mcreator.hypercraft.HypercraftModVariables;
import net.mcreator.hypercraft.HypercraftModElements;

import java.util.Map;
import java.util.Collection;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.block.Block;
import java.awt.List;

@HypercraftModElements.ModElement.Tag
public class AdjustTemperature extends HypercraftModElements.ModElement {
	public AdjustTemperature(HypercraftModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AdjustTemperature!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure AdjustTemperature!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure AdjustTemperature!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure AdjustTemperature!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AdjustTemperature!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double LocalTemperature = 0;
		LocalTemperature = (double) (world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getTemperature(new BlockPos((int) x, (int) y, (int) z))
				* 75.f-10);
		if ((entity.isInWater())) {
			LocalTemperature = (double) ((LocalTemperature) - 15);
		}
		if ((world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))) {
			if (((world.getWorld().isRaining())
					&& (!(BiomeDictionary.hasType(world.getBiome(new BlockPos((int) x, (int) y, (int) z)), BiomeDictionary.Type.DRY))))) {
				LocalTemperature = (double) ((LocalTemperature) - 10);
			}
			if ((!(world.getWorld().isDaytime()))) {
				LocalTemperature = (double) ((LocalTemperature) - 10);
			}
		}
		
		for (int XCheck = (int)x -4; XCheck <= x+3; XCheck++) 
		{
			for (int YCheck = (int)y-3; YCheck <= y+3; YCheck++) 
			{
				for (int ZCheck = (int)z-3; ZCheck <= z+3; ZCheck++) 
				{
					if 
						
						((world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.CAMPFIRE.getDefaultState().getBlock()
					) {
						LocalTemperature = (double) ((LocalTemperature) + 20);
					} else if 
						((world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LAVA.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.MAGMA_BLOCK.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.FIRE.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.CAMPFIRE.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.FIRE.getDefaultState().getBlock()
					) {
						LocalTemperature = (double) ((LocalTemperature) + 5);
					} else if
						((world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.SPONGE.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.TORCH.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.WALL_TORCH.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LANTERN.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.WHITE_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.ORANGE_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.MAGENTA_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LIGHT_BLUE_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.YELLOW_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LIME_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.PINK_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.GRAY_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LIGHT_GRAY_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.CYAN_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.PURPLE_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BLUE_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BROWN_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.GREEN_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.RED_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BLACK_CARPET.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.WHITE_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.ORANGE_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.MAGENTA_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LIGHT_BLUE_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.YELLOW_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LIME_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.PINK_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.GRAY_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.LIGHT_GRAY_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.CYAN_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.PURPLE_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BLUE_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BROWN_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.GREEN_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.RED_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BLACK_WOOL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.HAY_BLOCK.getDefaultState().getBlock()
					) {
						LocalTemperature = (double) ((LocalTemperature) + 0.5);
					} else if 
						((world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.CONDUIT.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.END_PORTAL.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.SNOW.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.SNOW_BLOCK.getDefaultState().getBlock()
					) {
						LocalTemperature = (double) ((LocalTemperature) - 0.5);
					} else if  
						((world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.PACKED_ICE.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.ICE.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.FROSTED_ICE.getDefaultState().getBlock()
						||(world.getBlockState(new BlockPos((int) (XCheck), (int) (YCheck), (int) (ZCheck)))).getBlock() == Blocks.BLUE_ICE.getDefaultState().getBlock()
					) {
						LocalTemperature = (double) ((LocalTemperature) - 5);
					}
				}
			}
		}
		
		if (Math.abs((LocalTemperature) - ((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new HypercraftModVariables.PlayerVariables())).Temperature)) > 0.06) {
			if (((LocalTemperature) > ((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new HypercraftModVariables.PlayerVariables())).Temperature))) {
				{
					double _setval = (double) (((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new HypercraftModVariables.PlayerVariables())).Temperature) + 0.05);
					entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Temperature = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((LocalTemperature) < ((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new HypercraftModVariables.PlayerVariables())).Temperature))) {
				{
					double _setval = (double) (((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new HypercraftModVariables.PlayerVariables())).Temperature) - 0.05);
					entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Temperature = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				double _setval = (double) (LocalTemperature);
				entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Temperature = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		if ((!((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == HyperthermiaPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) || (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == HypothermiaPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))))) {
			if ((((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new HypercraftModVariables.PlayerVariables())).Temperature) < (-30))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(HypothermiaPotion.potion, (int) 60, (int) 1));
			} else if ((((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new HypercraftModVariables.PlayerVariables())).Temperature) > 130)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(HyperthermiaPotion.potion, (int) 60, (int) 1));
			}
		}

		if (((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.FIRE_RESISTANCE)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) && (((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new HypercraftModVariables.PlayerVariables())).Temperature) > 80))) {
			{
				double _setval = (double) 80;
				entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Temperature = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		
	}
}