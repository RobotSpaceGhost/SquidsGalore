package com.robotspaceghost.squidsgalore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.entities.BeardEntity;
import com.robotspaceghost.squidsgalore.entities.KrakenTentacleEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;

public class BeardEntityModel <T extends BeardEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer beard;

    public BeardEntityModel() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, 0.0F);
        head.setTextureOffset(32, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        beard = new ModelRenderer(this);
        beard.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(beard);
        beard.setTextureOffset(0, 0).addBox(-6.0F, -4.0F, -4.5F, 12.0F, 12.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(0, 18).addBox(-4.0F, 6.0F, -4.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(0, 18).addBox(-4.0F, -1.0F, -4.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(18, 16).addBox(-5.0F, -3.0F, -4.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(23, 23).addBox(-6.0F, 4.0F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(36, 25).addBox(-3.0F, 7.0F, -4.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(53, 17).addBox(4.0F, -3.0F, -4.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(41, 17).addBox(5.0F, 2.0F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(1, 21).addBox(-2.0F, -2.0F, -4.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(26, 17).addBox(-4.0F, -4.0F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        beard.setTextureOffset(47, 17).addBox(3.0F, -4.0F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        setRotation(head,0,0,0);
    }


    @Override
    public void setLivingAnimations(BeardEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        if (entityIn.getBeardParent() != null){
            LivingEntity beardParent = entityIn.getBeardParent();
            this.head.rotateAngleY = beardParent.rotationYawHead * ((float)Math.PI / 180F);
            this.head.rotateAngleX = beardParent.rotationPitch * ((float)Math.PI / 180F);
        }
    }

    @Override
    public void setRotationAngles(BeardEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //this.beard.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.beard.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    protected void setRotation(ModelRenderer model, float rotX, float rotY, float rotZ)
    {
        model.rotateAngleX = (float) Math.toRadians(rotX);
        model.rotateAngleY = (float) Math.toRadians(rotY);
        model.rotateAngleZ = (float) Math.toRadians(rotZ);
    }
}
