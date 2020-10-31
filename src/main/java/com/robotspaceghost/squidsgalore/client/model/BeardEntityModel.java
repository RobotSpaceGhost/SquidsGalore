package com.robotspaceghost.squidsgalore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.entities.BeardEntity;
import com.robotspaceghost.squidsgalore.entities.KrakenTentacleEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BeardEntityModel <T extends BeardEntity> extends EntityModel<T> {
    private final ModelRenderer beard;

    public BeardEntityModel() {
        textureWidth = 32;
        textureHeight = 32;

        beard = new ModelRenderer(this);
        beard.setRotationPoint(0.0F, 24.0F, 0.0F);
        beard.setTextureOffset(0, 0).addBox(-6.0F, -16.0F, 0.0F, 12.0F, 16.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(BeardEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        beard.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
