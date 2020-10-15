package com.robotspaceghost.squidsgalore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BabyKrakenModel<T extends BabyKrakenEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer neck;
    private final ModelRenderer indexTentacleRight;
    private final ModelRenderer indexTentacleLeft;
    private final ModelRenderer middleTentacleRight;
    private final ModelRenderer middleTentacleLeft;
    private final ModelRenderer ringTentacleRight;
    private final ModelRenderer ringTentacleLeft;
    private final ModelRenderer pinkieTentacleRight;
    private final ModelRenderer pinkieTentacleLeft;

    public BabyKrakenModel() {

        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, -1.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -6.0F, -3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(2.0F, -8.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 7).addBox(1.0F, -3.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 7).addBox(1.0F, -5.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(43, 7).addBox(2.0F, -6.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(43, 7).addBox(3.0F, -7.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 6).addBox(4.0F, -7.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 6).addBox(5.0F, -6.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(43, 7).addBox(-2.0F, -3.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 7).addBox(-2.0F, -5.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 6).addBox(-3.0F, -6.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 8).addBox(-4.0F, -7.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 6).addBox(-5.0F, -7.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(42, 6).addBox(-6.0F, -6.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(32, 8).addBox(-2.0F, -1.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(36, 8).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(32, 7).addBox(0.0F, -1.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(32, 4).addBox(1.0F, -1.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 15.0F, 0.5F);
        neck.setTextureOffset(0, 16).addBox(-3.0F, 1.0F, -4.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);

        indexTentacleRight = new ModelRenderer(this);
        indexTentacleRight.setRotationPoint(-2.0F, 18.0F, -3.0F);
        indexTentacleRight.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        indexTentacleLeft = new ModelRenderer(this);
        indexTentacleLeft.setRotationPoint(2.0F, 18.0F, -3.0F);
        indexTentacleLeft.setTextureOffset(33, 14).addBox(0.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        middleTentacleRight = new ModelRenderer(this);
        middleTentacleRight.setRotationPoint(-3.0F, 18.0F, -1.0F);
        middleTentacleRight.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        middleTentacleLeft = new ModelRenderer(this);
        middleTentacleLeft.setRotationPoint(3.0F, 18.0F, -1.0F);
        middleTentacleLeft.setTextureOffset(33, 14).addBox(0.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        ringTentacleRight = new ModelRenderer(this);
        ringTentacleRight.setRotationPoint(-3.0F, 18.0F, 0.0F);
        ringTentacleRight.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        ringTentacleLeft = new ModelRenderer(this);
        ringTentacleLeft.setRotationPoint(3.0F, 18.0F, 0.0F);
        ringTentacleLeft.setTextureOffset(33, 14).addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        pinkieTentacleRight = new ModelRenderer(this);
        pinkieTentacleRight.setRotationPoint(-2.0F, 18.0F, 2.0F);
        pinkieTentacleRight.setTextureOffset(33, 14).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

        pinkieTentacleLeft = new ModelRenderer(this);
        pinkieTentacleLeft.setRotationPoint(2.0F, 18.0F, 2.0F);
        pinkieTentacleLeft.setTextureOffset(33, 14).addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setLivingAnimations(BabyKrakenEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        int sitHeightOffset = 3;
        if(entityIn.isAlive() && entityIn.isSitting()) {
            head.setRotationPoint(head.rotationPointX, 16 + sitHeightOffset, head.rotationPointZ);
            neck.setRotationPoint(neck.rotationPointX, 15 + sitHeightOffset, neck.rotationPointZ);
            indexTentacleRight.setRotationPoint(indexTentacleRight.rotationPointX, 18 + sitHeightOffset, indexTentacleRight.rotationPointZ);
            indexTentacleLeft.setRotationPoint(indexTentacleLeft.rotationPointX, 18+ sitHeightOffset, indexTentacleLeft.rotationPointZ);
            middleTentacleRight.setRotationPoint(middleTentacleRight.rotationPointX, 18 + sitHeightOffset, middleTentacleRight.rotationPointZ);
            middleTentacleLeft.setRotationPoint(middleTentacleLeft.rotationPointX, 18 + sitHeightOffset, middleTentacleLeft.rotationPointZ);
            ringTentacleRight.setRotationPoint(ringTentacleRight.rotationPointX, 18 + sitHeightOffset, ringTentacleRight.rotationPointZ);
            ringTentacleLeft.setRotationPoint(ringTentacleLeft.rotationPointX, 18 + sitHeightOffset, ringTentacleLeft.rotationPointZ);
            pinkieTentacleRight.setRotationPoint(pinkieTentacleRight.rotationPointX, 18 + sitHeightOffset, pinkieTentacleRight.rotationPointZ);
            pinkieTentacleLeft.setRotationPoint(pinkieTentacleLeft.rotationPointX, 18 + sitHeightOffset, pinkieTentacleLeft.rotationPointZ);
            float splayLegs = 6;
            this.indexTentacleRight.rotateAngleY =  (-(float) Math.PI / (splayLegs - 2));
            this.indexTentacleRight.rotateAngleZ = 0;
            this.indexTentacleLeft.rotateAngleY = ((float) Math.PI / (splayLegs - 2));
            this.indexTentacleLeft.rotateAngleZ = 0;
            this.middleTentacleRight.rotateAngleY = (-(float) Math.PI / splayLegs);
            this.middleTentacleRight.rotateAngleZ = 0;
            this.middleTentacleLeft.rotateAngleY = ((float) Math.PI / splayLegs);
            this.middleTentacleLeft.rotateAngleZ = 0;
            this.ringTentacleRight.rotateAngleY = ((float) Math.PI / splayLegs);
            this.ringTentacleRight.rotateAngleZ = 0;
            this.ringTentacleLeft.rotateAngleY = (-(float) Math.PI / splayLegs);
            this.ringTentacleLeft.rotateAngleZ = 0;
            this.pinkieTentacleRight.rotateAngleY = ((float) Math.PI / (splayLegs - 2));
            this.pinkieTentacleRight.rotateAngleZ = 0;
            this.pinkieTentacleLeft.rotateAngleY = (-(float) Math.PI / (splayLegs - 2));
            this.pinkieTentacleLeft.rotateAngleZ = 0;

        } else {
            head.setRotationPoint(head.rotationPointX, 16, head.rotationPointZ);
            neck.setRotationPoint(neck.rotationPointX, 15, neck.rotationPointZ);
            indexTentacleRight.setRotationPoint(indexTentacleRight.rotationPointX, 18 , indexTentacleRight.rotationPointZ);
            indexTentacleLeft.setRotationPoint(indexTentacleLeft.rotationPointX, 18 , indexTentacleLeft.rotationPointZ);
            middleTentacleRight.setRotationPoint(middleTentacleRight.rotationPointX, 18 , middleTentacleRight.rotationPointZ);
            middleTentacleLeft.setRotationPoint(middleTentacleLeft.rotationPointX, 18, middleTentacleLeft.rotationPointZ);
            ringTentacleRight.setRotationPoint(ringTentacleRight.rotationPointX, 18, ringTentacleRight.rotationPointZ);
            ringTentacleLeft.setRotationPoint(ringTentacleLeft.rotationPointX, 18 , ringTentacleLeft.rotationPointZ);
            pinkieTentacleRight.setRotationPoint(pinkieTentacleRight.rotationPointX, 18, pinkieTentacleRight.rotationPointZ);
            pinkieTentacleLeft.setRotationPoint(pinkieTentacleLeft.rotationPointX, 18 , pinkieTentacleLeft.rotationPointZ);
            setRotationAngles(entityIn,limbSwing,limbSwingAmount,entityIn.ticksExisted, entityIn.getYaw(partialTick), entityIn.getPitch(partialTick));
        }
    }

    @Override
    public void setRotationAngles(BabyKrakenEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        if (!entityIn.isSitting()) {
            this.indexTentacleRight.rotateAngleY = (-(float) Math.PI / 4F);
            this.indexTentacleRight.rotateAngleZ = (-(float) Math.PI / 4F);
            this.indexTentacleLeft.rotateAngleY = ((float) Math.PI / 4F);
            this.indexTentacleLeft.rotateAngleZ = ((float) Math.PI / 4F);
            this.middleTentacleRight.rotateAngleY = (-(float) Math.PI / 8F);
            this.middleTentacleRight.rotateAngleZ = -0.58119464F;
            this.middleTentacleLeft.rotateAngleY = ((float) Math.PI / 8F);
            this.middleTentacleLeft.rotateAngleZ = 0.58119464F;
            this.ringTentacleRight.rotateAngleY = ((float) Math.PI / 8F);
            this.ringTentacleRight.rotateAngleZ = -0.58119464F;
            this.ringTentacleLeft.rotateAngleY = (-(float) Math.PI / 8F);
            this.ringTentacleLeft.rotateAngleZ = 0.58119464F;
            this.pinkieTentacleRight.rotateAngleY = ((float) Math.PI / 4F);
            this.pinkieTentacleRight.rotateAngleZ = (-(float) Math.PI / 4F);
            this.pinkieTentacleLeft.rotateAngleY = (-(float) Math.PI / 4F);
            this.pinkieTentacleLeft.rotateAngleZ = ((float) Math.PI / 4F);
            float indexTentacleSwingY = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
            float indexTentacleSwingZ = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
            float middleTentacleSwingY = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
            float middleTentacleSwingZ = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
            float ringTentacleSwingY = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
            float ringTentacleSwingZ = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
            float pinkieTentacleSwingY = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
            float pinkieTentacleSwingZ = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
            if (entityIn.isInWater()) {
                float swimShift = entityIn.ticksExisted % 90;
                this.indexTentacleRight.rotateAngleZ = - (float) Math.toRadians(swimShift);
                this.indexTentacleLeft.rotateAngleZ = (float) Math.toRadians(swimShift);
                this.middleTentacleRight.rotateAngleZ = -(float) Math.toRadians(swimShift);
                this.middleTentacleLeft.rotateAngleZ = (float) Math.toRadians(swimShift);
                this.ringTentacleRight.rotateAngleZ = -(float) Math.toRadians(swimShift);
                this.ringTentacleLeft.rotateAngleZ = (float) Math.toRadians(swimShift);
                this.pinkieTentacleRight.rotateAngleZ = -(float) Math.toRadians(swimShift);
                this.pinkieTentacleLeft.rotateAngleZ = (float) Math.toRadians(swimShift);
            }else{
                this.indexTentacleRight.rotateAngleZ += indexTentacleSwingZ;
                this.indexTentacleLeft.rotateAngleY += -indexTentacleSwingY;
                this.indexTentacleLeft.rotateAngleZ += -indexTentacleSwingZ;
                this.middleTentacleRight.rotateAngleY += middleTentacleSwingY;
                this.middleTentacleRight.rotateAngleZ += middleTentacleSwingZ;
                this.middleTentacleLeft.rotateAngleY += -middleTentacleSwingY;
                this.middleTentacleLeft.rotateAngleZ += -middleTentacleSwingZ;
                this.ringTentacleRight.rotateAngleY += ringTentacleSwingY;
                this.ringTentacleRight.rotateAngleZ += ringTentacleSwingZ;
                this.ringTentacleLeft.rotateAngleY += -ringTentacleSwingY;
                this.ringTentacleLeft.rotateAngleZ += -ringTentacleSwingZ;
                this.pinkieTentacleRight.rotateAngleY += pinkieTentacleSwingY;
                this.pinkieTentacleRight.rotateAngleZ += pinkieTentacleSwingZ;
                this.pinkieTentacleLeft.rotateAngleY += -pinkieTentacleSwingY;
                this.pinkieTentacleLeft.rotateAngleZ += -pinkieTentacleSwingZ;
            }
        }


    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        neck.render(matrixStack, buffer, packedLight, packedOverlay);
        pinkieTentacleRight.render(matrixStack, buffer, packedLight, packedOverlay);
        pinkieTentacleLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        ringTentacleRight.render(matrixStack, buffer, packedLight, packedOverlay);
        ringTentacleLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        middleTentacleRight.render(matrixStack, buffer, packedLight, packedOverlay);
        middleTentacleLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        indexTentacleRight.render(matrixStack, buffer, packedLight, packedOverlay);
        indexTentacleLeft.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}