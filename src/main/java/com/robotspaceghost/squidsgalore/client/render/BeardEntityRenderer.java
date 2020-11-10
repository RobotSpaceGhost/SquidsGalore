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
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.util.ResourceLocation;

public class BeardEntityRenderer extends MobRenderer<BeardEntity, BeardEntityModel<BeardEntity>> {

    public BeardEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BeardEntityModel<>(), 0.0f);
    }

    protected void preRenderCallback(BeardEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.beardParent != null)
            matrixStackIn.translate(0,(entitylivingbaseIn.beardParent.getHeight() - entitylivingbaseIn.beardParent.getEyeHeight() + .23),0);
    }

    @Override
    public ResourceLocation getEntityTexture(BeardEntity entity) {
        return new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/beard_entity.png");
    }
}
