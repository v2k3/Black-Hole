/*    */ package vini2003.xyz.blackhole;
/*    */ 
/*    */ import net.fabricmc.api.ClientModInitializer;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import vini2003.xyz.blackhole.registry.client.BlackHoleCallbacks;
/*    */ import vini2003.xyz.blackhole.registry.client.BlackHoleNetworking;
/*    */ import vini2003.xyz.blackhole.registry.client.BlackHoleRenderLayers;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class BlackHoleClient
/*    */   implements ClientModInitializer
/*    */ {
/*    */   public static boolean isBlackedOut = false;
/*    */   public static boolean shouldRemoveBlackHoles = false;
/*    */   
/*    */   public void onInitializeClient() {
/* 18 */     BlackHoleCallbacks.initialize();
/* 19 */     BlackHoleNetworking.initialize();
/* 20 */     BlackHoleRenderLayers.initialize();
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/blackhole-1.0.1+1.16.5.jar!/vini2003/xyz/blackhole/BlackHoleClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */