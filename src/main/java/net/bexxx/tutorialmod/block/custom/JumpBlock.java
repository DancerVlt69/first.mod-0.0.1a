package net.bexxx.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JumpBlock extends Block {
    public JumpBlock(Settings settings) {
        super(settings);
    }

    @Override
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                             Hand hand, BlockHitResult hit) {
        player.sendMessage(Text.literal("Right clicked this! "));
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100));
        }
    }
}

// TODO check using deprecated methods
