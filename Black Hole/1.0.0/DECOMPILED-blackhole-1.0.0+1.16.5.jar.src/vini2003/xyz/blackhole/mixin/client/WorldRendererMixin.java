/*     */ package vini2003.xyz.blackhole.mixin.client;
/*     */ 
/*     */ import dev.monarkhes.myron.api.Myron;
/*     */ import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.class_1087;
/*     */ import net.minecraft.class_1159;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_4587;
/*     */ import net.minecraft.class_4588;
/*     */ import net.minecraft.class_4597;
/*     */ import net.minecraft.class_4599;
/*     */ import net.minecraft.class_4608;
/*     */ import net.minecraft.class_638;
/*     */ import net.minecraft.class_757;
/*     */ import net.minecraft.class_761;
/*     */ import net.minecraft.class_765;
/*     */ import net.minecraft.class_777;
/*     */ import net.minecraft.class_809;
/*     */ import net.minecraft.class_918;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import vini2003.xyz.blackhole.BlackHole;
/*     */ import vini2003.xyz.blackhole.BlackHoleClient;
/*     */ import vini2003.xyz.blackhole.client.utilities.BlackHoleClientUtilities;
/*     */ import vini2003.xyz.blackhole.common.components.BlackHoleComponent;
/*     */ import vini2003.xyz.blackhole.common.components.BlackHoleWorldComponent;
/*     */ import vini2003.xyz.blackhole.common.config.BlackHoleConfig;
/*     */ import vini2003.xyz.blackhole.registry.client.BlackHoleRenderLayers;
/*     */ import vini2003.xyz.blackhole.registry.common.BlackHoleComponents;
/*     */ 
/*     */ @Mixin({class_761.class})
/*     */ public class WorldRendererMixin {
/*  41 */   private long lastFrameNanoTime = -1L; @Shadow private class_638 field_4085; @Shadow
/*     */   @Final
/*  43 */   private class_4599 field_20951; private Int2ObjectArrayMap<class_1087> blackhole_models = new Int2ObjectArrayMap();
/*     */   
/*     */   @Inject(at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/render/BufferBuilderStorage;getEntityVertexConsumers()Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;")}, method = {"render"})
/*     */   void blackhole_render(class_4587 matrices, float uselessTickDelta, long limitTime, boolean renderBlockOutline, class_4184 camera, class_757 gameRenderer, class_765 lightmapTextureManager, class_1159 matrix4f, CallbackInfo ci) {
/*  47 */     if (this.lastFrameNanoTime == -1L) {
/*  48 */       this.lastFrameNanoTime = System.nanoTime();
/*     */     }
/*     */     
/*  51 */     float tickDelta = Math.min(0.375F, (float)(System.nanoTime() - this.lastFrameNanoTime) / 4.0E7F);
/*     */     
/*  53 */     this.lastFrameNanoTime = System.nanoTime();
/*     */     
/*  55 */     BlackHoleWorldComponent blackHoleWorldComponent = (BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(this.field_4085);
/*     */     
/*  57 */     class_4588 consumer = this.field_20951.method_23000().getBuffer(BlackHoleRenderLayers.BLACK_SPHERE);
/*     */     
/*  59 */     blackHoleWorldComponent.getBlackHoles().forEach(blackHole -> {
/*     */           float size = blackHole.getSize();
/*     */ 
/*     */           
/*     */           if (!this.blackhole_models.containsKey(blackHole.getId())) {
/*     */             this.blackhole_models.put(blackHole.getId(), Myron.getModel(BlackHole.identifier("models/misc/black_sphere")));
/*     */           }
/*     */ 
/*     */           
/*     */           class_1087 blackhole_model = (class_1087)this.blackhole_models.getOrDefault(blackHole.getId(), null);
/*     */ 
/*     */           
/*     */           if (blackhole_model != null) {
/*     */             matrices.method_22903();
/*     */ 
/*     */             
/*     */             matrices.method_22904(blackHole.getPos().method_10216() - camera.method_19326().method_10216(), blackHole.getPos().method_10214() - camera.method_19326().method_10214(), blackHole.getPos().method_10215() - camera.method_19326().method_10215());
/*     */ 
/*     */             
/*     */             matrices.method_22905(size, size, size);
/*     */             
/*     */             if (blackhole_model != null) {
/*     */               class_4587.class_4665 matricesEntry = matrices.method_23760();
/*     */               
/*     */               blackhole_model.method_4707(null, null, this.field_4085.method_8409()).forEach(());
/*     */             } 
/*     */             
/*     */             matrices.method_22909();
/*     */           } 
/*     */           
/*     */           if ((class_310.method_1551()).field_1724 != null && blackHole.getPos().method_1023(0.0D, 1.75D, 0.0D).method_1022((class_310.method_1551()).field_1724.method_19538()) <= size) {
/*     */             BlackHoleClient.isBlackedOut = true;
/*     */           }
/*     */           
/*     */           class_918 itemRenderer = class_310.method_1551().method_1480();
/*     */           
/*     */           class_1657 player = BlackHoleClientUtilities.getPlayer();
/*     */           
/*     */           if (BlackHoleConfig.cache.pull) {
/*     */             Iterator<BlackHoleComponent.BlackHoleParticle> particleIterator = blackHole.getParticles().iterator();
/*     */             
/*     */             while (particleIterator.hasNext()) {
/*     */               BlackHoleComponent.BlackHoleParticle particle = particleIterator.next();
/*     */               
/*     */               matrices.method_22903();
/*     */               
/*     */               double distanceToBlackHole = particle.getPos().method_1022(blackHole.getPos());
/*     */               
/*     */               double distanceToPlayer = particle.getPos().method_1022(player.method_19538());
/*     */               
/*     */               if (distanceToBlackHole < size || distanceToPlayer > 256.0D) {
/*     */                 particleIterator.remove();
/*     */                 
/*     */                 matrices.method_22909();
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/*     */               class_243 pull = particle.getPos().method_1020(blackHole.getPos()).method_1029().method_1021((tickDelta * 0.5F));
/*     */               
/*     */               particle.setPos(particle.getPos().method_1020(pull));
/*     */               
/*     */               matrices.method_22904(particle.getPos().method_10216() - camera.method_19326().method_10216(), particle.getPos().method_10214() - camera.method_19326().method_10214(), particle.getPos().method_10215() - camera.method_19326().method_10215());
/*     */               
/*     */               itemRenderer.method_23178(particle.getStack(), class_809.class_811.field_4315, 15728880, class_4608.field_21444, matrices, (class_4597)this.field_20951.method_23000());
/*     */               
/*     */               matrices.method_22909();
/*     */             } 
/*     */           } 
/*     */           
/*     */           this.field_20951.method_23000().method_22993();
/*     */         });
/*     */     
/* 132 */     if (BlackHoleClient.shouldRemoveBlackHoles) {
/* 133 */       ((BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(this.field_4085)).getBlackHoles().clear();
/*     */       
/* 135 */       BlackHoleClient.shouldRemoveBlackHoles = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/mixin/client/WorldRendererMixin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */