package com.robotspaceghost.squidsgalore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.entities.KrakenEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class KrakenModel<T extends KrakenEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer krakenEye;

    public KrakenModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 14.0F, 0.0F);
        body.setTextureOffset(28, 0).addBox(-8.0F, -8.0F, -10.0F, 16.0F, 16.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(28, 18).addBox(-8.0F, -8.0F, 8.0F, 16.0F, 16.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 36).addBox(-8.0F, -10.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
        body.setTextureOffset(0, 36).addBox(-8.0F, 8.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
        body.setTextureOffset(0, 4).addBox(-10.0F, -8.0F, -8.0F, 2.0F, 16.0F, 16.0F, 0.0F, false);
        body.setTextureOffset(0, 4).addBox(8.0F, -8.0F, -8.0F, 2.0F, 16.0F, 16.0F, 0.0F, true);

        krakenEye = new ModelRenderer(this);
        krakenEye.setRotationPoint(0.0F, 14.0F, -9.75F);
        krakenEye.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(KrakenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        krakenEye.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
