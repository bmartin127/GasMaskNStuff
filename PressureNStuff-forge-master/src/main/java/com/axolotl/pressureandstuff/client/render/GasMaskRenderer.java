package com.axolotl.pressureandstuff.client.render;

import com.axolotl.pressureandstuff.PressureAndStuff;
import com.axolotl.pressureandstuff.client.CuriosLayerDefinitions;
import com.axolotl.pressureandstuff.client.model.GasMaskModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class GasMaskRenderer<L extends LivingEntity> implements ICurioRenderer {

    private static final ResourceLocation GAS_MASK_TEXTURE = new ResourceLocation(PressureAndStuff.MODID,
            "textures/entity/gas_mask.png");
    private final GasMaskModel<L> model;

    public GasMaskRenderer() {
        this.model = new GasMaskModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CuriosLayerDefinitions.GAS_MASK));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack,
                                                                          SlotContext slotContext,
                                                                          PoseStack matrixStack,
                                                                          RenderLayerParent<T, M> renderLayerParent,
                                                                          MultiBufferSource renderTypeBuffer,
                                                                          int light, float limbSwing,
                                                                          float limbSwingAmount,
                                                                          float partialTicks,
                                                                          float ageInTicks,
                                                                          float netHeadYaw,
                                                                          float headPitch) {
        ICurioRenderer.followHeadRotations(slotContext.entity(), this.model.mask);
        VertexConsumer vertexconsumer = ItemRenderer
                .getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(GAS_MASK_TEXTURE), false,
                        stack.hasFoil());
        this.model
                .renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
                        1.0F, 1.0F);
    }
}
