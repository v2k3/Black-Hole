/*    */ package vini2003.xyz.blackhole.registry.client;
/*    */ 
/*    */ import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
/*    */ import net.fabricmc.fabric.api.networking.v1.PacketSender;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_634;
/*    */ import vini2003.xyz.blackhole.BlackHole;
/*    */ import vini2003.xyz.blackhole.BlackHoleClient;
/*    */ import vini2003.xyz.blackhole.common.config.BlackHoleConfig;
/*    */ 
/*    */ public class BlackHoleNetworking {
/* 14 */   public static class_2960 KILL_PACKET = BlackHole.identifier("kill");
/* 15 */   public static class_2960 PULL_SPEED_PACKET = BlackHole.identifier("pull_speed");
/* 16 */   public static class_2960 GROW_SPEED_PACKET = BlackHole.identifier("grow_speed");
/* 17 */   public static class_2960 FOLLOW_SPEED_PACKET = BlackHole.identifier("follow_speed");
/* 18 */   public static class_2960 DAMAGE_PACKET = BlackHole.identifier("damage");
/* 19 */   public static class_2960 PAUSE_PACKET = BlackHole.identifier("pause");
/* 20 */   public static class_2960 RESUME_PACKET = BlackHole.identifier("resume");
/*    */   
/*    */   public static void initialize() {
/* 23 */     ClientPlayNetworking.registerGlobalReceiver(PULL_SPEED_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> BlackHoleConfig.cache.pullSpeed = packetByteBuf.readFloat());
/*    */ 
/*    */ 
/*    */     
/* 27 */     ClientPlayNetworking.registerGlobalReceiver(GROW_SPEED_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> BlackHoleConfig.cache.growSpeed = packetByteBuf.readFloat());
/*    */ 
/*    */ 
/*    */     
/* 31 */     ClientPlayNetworking.registerGlobalReceiver(FOLLOW_SPEED_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> BlackHoleConfig.cache.followSpeed = packetByteBuf.readFloat());
/*    */ 
/*    */ 
/*    */     
/* 35 */     ClientPlayNetworking.registerGlobalReceiver(DAMAGE_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> BlackHoleConfig.cache.damage = packetByteBuf.readBoolean());
/*    */ 
/*    */ 
/*    */     
/* 39 */     ClientPlayNetworking.registerGlobalReceiver(PAUSE_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> {
/*    */           BlackHoleConfig.cache.follow = false;
/*    */           
/*    */           BlackHoleConfig.cache.pull = false;
/*    */           BlackHoleConfig.cache.grow = false;
/*    */           BlackHoleConfig.cache.damage = false;
/*    */         });
/* 46 */     ClientPlayNetworking.registerGlobalReceiver(RESUME_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> {
/*    */           BlackHoleConfig.cache.follow = true;
/*    */           
/*    */           BlackHoleConfig.cache.pull = true;
/*    */           BlackHoleConfig.cache.grow = true;
/*    */           BlackHoleConfig.cache.damage = true;
/*    */         });
/* 53 */     ClientPlayNetworking.registerGlobalReceiver(KILL_PACKET, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> BlackHoleClient.shouldRemoveBlackHoles = true);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/blackhole-1.0.1+1.16.5.jar!/vini2003/xyz/blackhole/registry/client/BlackHoleNetworking.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */