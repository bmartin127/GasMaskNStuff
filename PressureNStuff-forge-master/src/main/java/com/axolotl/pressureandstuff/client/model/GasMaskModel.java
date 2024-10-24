package com.axolotl.pressureandstuff.client.model;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nonnull;

public class GasMaskModel<T extends LivingEntity> extends AgeableListModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public ModelPart mask;

	public GasMaskModel(ModelPart root) {
		this.mask = root.getChild("mask");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition part = mesh.getRoot();

		PartDefinition mask = part.addOrReplaceChild("mask", CubeListBuilder.create().texOffs(32, 32).addBox(-4.0F, -32.0F, -5.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 41).addBox(-4.0F, -26.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-4.0F, -31.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = mask.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 9).addBox(-1.0F, -0.5F, -1.0F, 2.5F, 2.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -25.0F, -5.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r2 = mask.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 9).addBox(-1.0F, -0.5F, -1.0F, 2.5F, 2.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -25.0F, -5.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r3 = mask.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 25).addBox(-4.5F, -0.5F, -1.0F, 3.5F, 3.5F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -25.0F, -6.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r4 = mask.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 41).addBox(-1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 16).addBox(-1.0F, -6.0F, 0.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -25.0F, 3.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = mask.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 48).addBox(-1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, -6.0F, 0.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -25.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}



	@Override
	@Nonnull
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.mask);
	}

	@Override
	@Nonnull
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of();
	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}


}