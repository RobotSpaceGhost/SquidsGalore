package com.robotspaceghost.squidsgalore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BabyKrakenModel<T extends BabyKrakenEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer neck;
    private final ModelRenderer body;
    private final ModelRenderer tentacle1;
    private final ModelRenderer tentacle2;
    private final ModelRenderer tentacle3;
    private final ModelRenderer tentacle4;
    private final ModelRenderer tentacle5;
    private final ModelRenderer tentacle6;
    private final ModelRenderer tentacle7;
    private final ModelRenderer tentacle8;

    public BabyKrakenModel() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, -1.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -6.0F, -3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 15.0F, 0.5F);
        neck.setTextureOffset(0, 16).addBox(-3.0F, 1.0F, -4.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 9.0F);
        body.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        tentacle1 = new ModelRenderer(this);
        tentacle1.setRotationPoint(-2.0F, 18.0F, 2.0F);
        tentacle1.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle2 = new ModelRenderer(this);
        tentacle2.setRotationPoint(2.0F, 18.0F, 2.0F);
        tentacle2.setTextureOffset(33, 14).addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle3 = new ModelRenderer(this);
        tentacle3.setRotationPoint(-3.0F, 18.0F, 0.0F);
        tentacle3.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle4 = new ModelRenderer(this);
        tentacle4.setRotationPoint(3.0F, 18.0F, 0.0F);
        tentacle4.setTextureOffset(33, 14).addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle5 = new ModelRenderer(this);
        tentacle5.setRotationPoint(-3.0F, 18.0F, -1.0F);
        tentacle5.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle6 = new ModelRenderer(this);
        tentacle6.setRotationPoint(3.0F, 18.0F, -1.0F);
        tentacle6.setTextureOffset(33, 14).addBox(0.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle7 = new ModelRenderer(this);
        tentacle7.setRotationPoint(-2.0F, 18.0F, -3.0F);
        tentacle7.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        tentacle8 = new ModelRenderer(this);
        tentacle8.setRotationPoint(2.0F, 18.0F, -3.0F);
        tentacle8.setTextureOffset(33, 14).addBox(0.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        float f = ((float)Math.PI / 4F);
        this.tentacle1.rotateAngleZ = (-(float)Math.PI / 4F);
        this.tentacle2.rotateAngleZ = ((float)Math.PI / 4F);
        this.tentacle3.rotateAngleZ = -0.58119464F;
        this.tentacle4.rotateAngleZ = 0.58119464F;
        this.tentacle5.rotateAngleZ = -0.58119464F;
        this.tentacle6.rotateAngleZ = 0.58119464F;
        this.tentacle7.rotateAngleZ = (-(float)Math.PI / 4F);
        this.tentacle8.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = ((float)Math.PI / 8F);
        this.tentacle1.rotateAngleY = ((float)Math.PI / 4F);
        this.tentacle2.rotateAngleY = (-(float)Math.PI / 4F);
        this.tentacle3.rotateAngleY = ((float)Math.PI / 8F);
        this.tentacle4.rotateAngleY = (-(float)Math.PI / 8F);
        this.tentacle5.rotateAngleY = (-(float)Math.PI / 8F);
        this.tentacle6.rotateAngleY = ((float)Math.PI / 8F);
        this.tentacle7.rotateAngleY = (-(float)Math.PI / 4F);
        this.tentacle8.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.tentacle1.rotateAngleY += f3;
        this.tentacle2.rotateAngleY += -f3;
        this.tentacle3.rotateAngleY += f4;
        this.tentacle4.rotateAngleY += -f4;
        this.tentacle5.rotateAngleY += f5;
        this.tentacle6.rotateAngleY += -f5;
        this.tentacle7.rotateAngleY += f6;
        this.tentacle8.rotateAngleY += -f6;
        this.tentacle1.rotateAngleZ += f7;
        this.tentacle2.rotateAngleZ += -f7;
        this.tentacle3.rotateAngleZ += f8;
        this.tentacle4.rotateAngleZ += -f8;
        this.tentacle5.rotateAngleZ += f9;
        this.tentacle6.rotateAngleZ += -f9;
        this.tentacle7.rotateAngleZ += f10;
        this.tentacle8.rotateAngleZ += -f10;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        neck.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle6.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle7.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacle8.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
/*
 @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        float f = ((float)Math.PI / 4F);
        this.tentacle1.rotateAngleZ = (-(float)Math.PI / 4F);
        this.tentacle2.rotateAngleZ = ((float)Math.PI / 4F);
        this.tentacle3.rotateAngleZ = -0.58119464F;
        this.tentacle4.rotateAngleZ = 0.58119464F;
        this.tentacle5.rotateAngleZ = -0.58119464F;
        this.tentacle6.rotateAngleZ = 0.58119464F;
        this.tentacle7.rotateAngleZ = (-(float)Math.PI / 4F);
        this.tentacle8.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = ((float)Math.PI / 8F);
        this.tentacle1.rotateAngleY = ((float)Math.PI / 4F);
        this.tentacle2.rotateAngleY = (-(float)Math.PI / 4F);
        this.tentacle3.rotateAngleY = ((float)Math.PI / 8F);
        this.tentacle4.rotateAngleY = (-(float)Math.PI / 8F);
        this.tentacle5.rotateAngleY = (-(float)Math.PI / 8F);
        this.tentacle6.rotateAngleY = ((float)Math.PI / 8F);
        this.tentacle7.rotateAngleY = (-(float)Math.PI / 4F);
        this.tentacle8.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.tentacle1.rotateAngleY += f3;
        this.tentacle2.rotateAngleY += -f3;
        this.tentacle3.rotateAngleY += f4;
        this.tentacle4.rotateAngleY += -f4;
        this.tentacle5.rotateAngleY += f5;
        this.tentacle6.rotateAngleY += -f5;
        this.tentacle7.rotateAngleY += f6;
        this.tentacle8.rotateAngleY += -f6;
        this.tentacle1.rotateAngleZ += f7;
        this.tentacle2.rotateAngleZ += -f7;
        this.tentacle3.rotateAngleZ += f8;
        this.tentacle4.rotateAngleZ += -f8;
        this.tentacle5.rotateAngleZ += f9;
        this.tentacle6.rotateAngleZ += -f9;
        this.tentacle7.rotateAngleZ += f10;
        this.tentacle8.rotateAngleZ += -f10;
    }
 */