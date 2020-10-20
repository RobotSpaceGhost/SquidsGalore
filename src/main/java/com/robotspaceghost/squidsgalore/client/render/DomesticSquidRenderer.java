package com.robotspaceghost.squidsgalore.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.DomesticSquidModel;
import com.robotspaceghost.squidsgalore.entities.DomesticSquidEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class DomesticSquidRenderer extends MobRenderer<DomesticSquidEntity, DomesticSquidModel<DomesticSquidEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/domestic_squid.png");


    public DomesticSquidRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DomesticSquidModel<>(), 0.7f);
    }
    //-----------------------------
    //dont include in flying squid lol
    //---------------------------------
    protected void applyRotations(DomesticSquidEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, entityLiving.prevSquidPitch, entityLiving.squidPitch);
        float f1 = MathHelper.lerp(partialTicks, entityLiving.prevSquidYaw, entityLiving.squidYaw);
        matrixStackIn.translate(0.0D, 0.5D, 0.0D);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - rotationYaw));
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f));
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f1));
        matrixStackIn.translate(0.0D, -1.2F, 0.0D);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(DomesticSquidEntity livingBase, float partialTicks) {
        return MathHelper.lerp(partialTicks, livingBase.lastTentacleAngle, livingBase.tentacleAngle);
    }
    //--------------------------------
    // end squid stuff
    //-------------------------------
    @Override
    public ResourceLocation getEntityTexture(DomesticSquidEntity entity) {
        return TEXTURE;
    }
}
