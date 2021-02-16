package net.mcreator.hypercraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.hypercraft.block.CreepstoneBlock;
import net.mcreator.hypercraft.block.CreepoakwoodBlock;
import net.mcreator.hypercraft.block.CreepDirtBlock;
import net.mcreator.hypercraft.HypercraftModElements;

import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class CreeplandInfectProcedure extends HypercraftModElements.ModElement {
	public CreeplandInfectProcedure(HypercraftModElements instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CreeplandInfect!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CreeplandInfect!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CreeplandInfect!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CreeplandInfect!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double VarX = 0;
		double VarY = 0;
		double VarZ = 0;
		String facingnbt = "";
		VarX = (double) (x + (Math.round((Math.random() * 2)) - 1));
		VarY = (double) (y + (Math.round((Math.random() * 2)) - 1));
		VarZ = (double) (z + (Math.round((Math.random() * 2)) - 1));
		if ((((world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))).getBlock() == Blocks.DIRT.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), CreepDirtBlock.block.getDefaultState(), 3);
		} else {
			if (((world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))).getBlock() == Blocks.STONE.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), CreepstoneBlock.block.getDefaultState(), 3);
			} else {
				if (((world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))).getBlock() == Blocks.OAK_LOG.getDefaultState()
						.getBlock())) {
					if (((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))) == Direction.DOWN)) {
						world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), CreepoakwoodBlock.block.getDefaultState(), 3);
						try {
							BlockState _bs = world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)));
							world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)),
									_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.DOWN), 3);
						} catch (Exception e) {
						}
					} else {
						if (((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									return _bs.get(property);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))) == Direction.UP)) {
							world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), CreepoakwoodBlock.block.getDefaultState(), 3);
							try {
								BlockState _bs = world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)));
								world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)),
										_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.UP), 3);
							} catch (Exception e) {
							}
						} else {
							if (((new Object() {
								public Direction getDirection(BlockPos pos) {
									try {
										BlockState _bs = world.getBlockState(pos);
										DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
										return _bs.get(property);
									} catch (Exception e) {
										return Direction.NORTH;
									}
								}
							}.getDirection(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))) == Direction.NORTH)) {
								world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), CreepoakwoodBlock.block.getDefaultState(),
										3);
								try {
									BlockState _bs = world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)));
									world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)),
											_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.NORTH),
											3);
								} catch (Exception e) {
								}
							} else {
								if (((new Object() {
									public Direction getDirection(BlockPos pos) {
										try {
											BlockState _bs = world.getBlockState(pos);
											DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
											return _bs.get(property);
										} catch (Exception e) {
											return Direction.NORTH;
										}
									}
								}.getDirection(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))) == Direction.SOUTH)) {
									world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)),
											CreepoakwoodBlock.block.getDefaultState(), 3);
									try {
										BlockState _bs = world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)));
										world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), _bs.with(
												(DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.SOUTH), 3);
									} catch (Exception e) {
									}
								} else {
									if (((new Object() {
										public Direction getDirection(BlockPos pos) {
											try {
												BlockState _bs = world.getBlockState(pos);
												DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer()
														.getProperty("facing");
												return _bs.get(property);
											} catch (Exception e) {
												return Direction.NORTH;
											}
										}
									}.getDirection(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)))) == Direction.WEST)) {
										world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)),
												CreepoakwoodBlock.block.getDefaultState(), 3);
										try {
											BlockState _bs = world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)));
											world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), _bs.with(
													(DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
										} catch (Exception e) {
										}
									} else {
										world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)),
												CreepoakwoodBlock.block.getDefaultState(), 3);
										try {
											BlockState _bs = world.getBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)));
											world.setBlockState(new BlockPos((int) (VarX), (int) (VarY), (int) (VarZ)), _bs.with(
													(DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
										} catch (Exception e) {
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
