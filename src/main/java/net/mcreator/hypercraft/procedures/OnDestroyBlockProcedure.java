package net.mcreator.hypercraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.hypercraft.HypercraftModVariables;
import net.mcreator.hypercraft.HypercraftModElements;

import java.util.Map;
import java.util.HashMap;

@HypercraftModElements.ModElement.Tag
public class OnDestroyBlockProcedure extends HypercraftModElements.ModElement {
	public OnDestroyBlockProcedure(HypercraftModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OnDestroyBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure OnDestroyBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure OnDestroyBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure OnDestroyBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure OnDestroyBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OAK_LOG.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.ACACIA_LOG.getDefaultState().getBlock()))) {
			{
				double _setval = (double) (((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new HypercraftModVariables.PlayerVariables())).NaturalPoints) - 0.1);
				entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NaturalPoints = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OAK_SAPLING.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.SPRUCE_SAPLING.getDefaultState()
							.getBlock()))
					|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.BIRCH_SAPLING.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.JUNGLE_SAPLING.getDefaultState()
									.getBlock()))
							|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.ACACIA_SAPLING.getDefaultState()
									.getBlock())
									|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DARK_OAK_SAPLING
											.getDefaultState().getBlock()))))) {
				{
					double _setval = (double) (((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new HypercraftModVariables.PlayerVariables())).NaturalPoints) - 5);
					entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NaturalPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (((((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DANDELION.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.POPPY.getDefaultState().getBlock()))
						|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.BLUE_ORCHID.getDefaultState()
								.getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.ALLIUM.getDefaultState()
										.getBlock()))
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AZURE_BLUET.getDefaultState()
										.getBlock())
										|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.RED_TULIP
												.getDefaultState().getBlock()))))
						|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.ORANGE_TULIP.getDefaultState()
								.getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WHITE_TULIP.getDefaultState()
										.getBlock()))
								|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.PINK_TULIP.getDefaultState()
										.getBlock())
										|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OXEYE_DAISY
												.getDefaultState().getBlock()))
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CORNFLOWER
												.getDefaultState().getBlock())
												|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
														.getBlock() == Blocks.LILY_OF_THE_VALLEY.getDefaultState().getBlock())))))
						|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.SUNFLOWER.getDefaultState()
								.getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.LILAC.getDefaultState()
										.getBlock()))
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.ROSE_BUSH.getDefaultState()
										.getBlock())
										|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.PEONY
												.getDefaultState().getBlock()))))) {
					{
						double _setval = (double) (((entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new HypercraftModVariables.PlayerVariables())).NaturalPoints) - 1);
						entity.getCapability(HypercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.NaturalPoints = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", (int) event.getPos().getX());
		dependencies.put("y", (int) event.getPos().getY());
		dependencies.put("z", (int) event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", event.getWorld().getWorld());
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
