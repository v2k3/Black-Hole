/*    */ package vini2003.xyz.blackhole.mixin.client;
/*    */ 
/*    */ import net.minecraft.class_1041;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_329;
/*    */ import net.minecraft.class_332;
/*    */ import net.minecraft.class_4587;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import vini2003.xyz.blackhole.BlackHoleClient;
/*    */ 
/*    */ @Mixin({class_329.class})
/*    */ public class InGameHudMixin {
/*    */   @Inject(at = {@At("HEAD")}, method = {"render"})
/*    */   void blackhole_onRender(class_4587 matrices, float tickDelta, CallbackInfo ci) {
/* 18 */     if (BlackHoleClient.isBlackedOut) {
/* 19 */       class_1041 window = class_310.method_1551().method_22683();
/* 20 */       class_332.method_25294(matrices, 0, 0, window.method_4486(), window.method_4502(), -16777216);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/blackhole-1.0.1+1.16.5.jar!/vini2003/xyz/blackhole/mixin/client/InGameHudMixin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */