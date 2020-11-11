package com.robotspaceghost.squidsgalore.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.BeardEntityModel;
import com.robotspaceghost.squidsgalore.entities.BeardEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class BeardEntityRenderer extends MobRenderer<BeardEntity, BeardEntityModel<BeardEntity>> {

    public BeardEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BeardEntityModel<>(), 0.0f);
    }

    protected void preRenderCallback(BeardEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.beardParent != null) {
            matrixStackIn.translate(0, (entitylivingbaseIn.beardParent.getHeight() - entitylivingbaseIn.beardParent.getEyeHeight() + .23), 0);
        }
    }

    @Override
    protected void applyRotations(BeardEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        //super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        Pose pose = entityLiving.getPose();
        if (pose != Pose.SLEEPING) {
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
        }

        if (entityLiving.deathTime > 0) {
            float f = ((float)entityLiving.deathTime + partialTicks - 1.0F) / 20.0F * 1.6F;
            f = MathHelper.sqrt(f);
            if (f > 1.0F) {
                f = 1.0F;
            }

            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f * this.getDeathMaxRotation(entityLiving)));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(BeardEntity entity) {
        return new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/beard_entity.png");
    }
}
