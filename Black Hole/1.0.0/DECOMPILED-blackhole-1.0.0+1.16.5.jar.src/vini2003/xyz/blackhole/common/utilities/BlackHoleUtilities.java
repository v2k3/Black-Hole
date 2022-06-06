/*     */ package vini2003.xyz.blackhole.common.utilities;
/*     */ 
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1923;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_2246;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2672;
/*     */ import net.minecraft.class_2680;
/*     */ import net.minecraft.class_2818;
/*     */ import net.minecraft.class_2826;
/*     */ import net.minecraft.class_2902;
/*     */ import net.minecraft.class_3215;
/*     */ import net.minecraft.class_3222;
/*     */ import vini2003.xyz.blackhole.client.utilities.BlackHoleClientUtilities;
/*     */ import vini2003.xyz.blackhole.common.components.BlackHoleComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlackHoleUtilities
/*     */ {
/*  46 */   private static final class_2680 AIR = class_2246.field_10124.method_9564();
/*     */   
/*     */   public static boolean isWithinDistance(int x1, int x2, int y1, int y2, int distance) {
/*  49 */     return ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) < distance * distance);
/*     */   }
/*     */   
/*     */   public static void destroy(BlackHoleComponent blackHole, class_1937 world, int x, int y, int z, int radius) {
/*  53 */     int clearRadius = (int)(radius * 1.5F);
/*     */     
/*  55 */     int pickupRadius = (int)(radius * 2.5F);
/*     */     
/*  57 */     int chunkRadius = Math.max(1, radius / 16) + 6;
/*     */     
/*  59 */     for (int chunkX = (x >> 4) - chunkRadius; chunkX < (x >> 4) + chunkRadius; chunkX++) {
/*  60 */       for (int chunkZ = (z >> 4) - chunkRadius; chunkZ < (z >> 4) + chunkRadius; chunkZ++) {
/*  61 */         class_2818 chunk = world.method_8497(chunkX, chunkZ);
/*     */ 
/*     */         
/*  64 */         int rX = (chunk.method_12200()).field_9229.nextInt(16);
/*  65 */         int rZ = (chunk.method_12200()).field_9229.nextInt(16);
/*     */         
/*  67 */         int rCX = (chunkX * 16 + rX - x) * (chunkX * 16 + rX - x);
/*  68 */         int rCZ = (chunkZ * 16 + rZ - z) * (chunkZ * 16 + rZ - z);
/*     */ 
/*     */         
/*  71 */         if (rCX + rCZ < pickupRadius * pickupRadius) {
/*  72 */           class_2338 topPosition = chunk.method_12200().method_8598(class_2902.class_2903.field_13202, new class_2338(chunkX * 16 + rX, 0, chunkZ * 16 + rZ)).method_10069(0, -1, 0);
/*     */           
/*  74 */           class_2680 state = chunk.method_8320(topPosition);
/*     */           
/*  76 */           if (!state.method_26215() && !(state.method_26204() instanceof net.minecraft.class_2404)) {
/*  77 */             if (world.field_9236) {
/*  78 */               class_1657 player = BlackHoleClientUtilities.getPlayer();
/*     */ 
/*     */ 
/*     */               
/*  82 */               if (world.field_9229.nextInt(5) == 0 && blackHole.getParticles().size() < 2048 && isWithinDistance(topPosition.method_10263(), (int)player.method_23317(), topPosition.method_10260(), (int)player.method_23321(), 256)) {
/*  83 */                 blackHole.getParticles().add(new BlackHoleComponent.BlackHoleParticle(new class_243(topPosition.method_10263(), topPosition.method_10264(), topPosition.method_10260()), state));
/*     */               
/*     */               }
/*     */             }
/*  87 */             else if (world.field_9229.nextInt((int)Math.sqrt(blackHole.getSize())) == 0) {
/*  88 */               world.method_8501(topPosition, class_2246.field_10124.method_9564());
/*     */             } 
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  96 */         boolean isAdjacent = ((chunkX == (x >> 4) - 1 && chunkZ == (z >> 4) - 1) || (chunkX == (x >> 4) - 1 && chunkZ == z >> 4) || (chunkX == (x >> 4) - 1 && chunkZ == (z >> 4) + 1) || (chunkX == x >> 4 && chunkZ == (z >> 4) + 1) || (chunkX == x >> 4 && chunkZ == (z >> 4) - 1) || (chunkX == x >> 4 && chunkZ == z >> 4) || (chunkX == (x >> 4) + 1 && chunkZ == (z >> 4) - 1) || (chunkX == (x >> 4) + 1 && chunkZ == z >> 4) || (chunkX == (x >> 4) + 1 && chunkZ == (z >> 4) + 1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 108 */         int cX = (chunkX * 16 - x) * (chunkX * 16 - x);
/* 109 */         int cZ = (chunkZ * 16 - z) * (chunkZ * 16 - z);
/* 110 */         int cX16 = ((chunkX + 1) * 16 - x) * ((chunkX + 1) * 16 - x);
/* 111 */         int cZ16 = ((chunkZ + 1) * 16 - z) * ((chunkZ + 1) * 16 - z);
/*     */ 
/*     */         
/* 114 */         if (isAdjacent || cX + cZ <= clearRadius * clearRadius || cX16 + cZ <= clearRadius * clearRadius || cX + cZ16 <= clearRadius * clearRadius || cX16 + cZ16 <= clearRadius * clearRadius) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 120 */           boolean shouldUpdate = false;
/*     */ 
/*     */           
/* 123 */           for (class_2826 section : chunk.method_12006()) {
/* 124 */             if (section != null) {
/* 125 */               int chunkY = section.method_12259() >> 4;
/*     */               
/* 127 */               int cY = (chunkY * 16 - y) * (chunkY * 16 - y);
/* 128 */               int cY16 = ((chunkY + 1) * 16 - y) * ((chunkY + 1) * 16 - y);
/*     */ 
/*     */ 
/*     */               
/* 132 */               if ((isAdjacent && section.method_12259() >> 4 == y >> 4) || cX + cZ + cY <= clearRadius * clearRadius || cX16 + cZ + cY <= clearRadius * clearRadius || cX + cZ16 + cY <= clearRadius * clearRadius || cX16 + cZ16 + cY <= clearRadius * clearRadius || cX + cZ + cY16 <= clearRadius * clearRadius || cX16 + cZ + cY16 <= clearRadius * clearRadius || cX + cZ16 + cY16 <= clearRadius * clearRadius || cX16 + cZ16 + cY16 <= clearRadius * clearRadius)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 142 */                 if (!section.method_12261())
/*     */                 {
/* 144 */                   for (int sectionX = 0; sectionX < 16; sectionX++) {
/* 145 */                     for (int sectionY = 0; sectionY < 16; sectionY++) {
/* 146 */                       for (int sectionZ = 0; sectionZ < 16; sectionZ++) {
/* 147 */                         int absoluteSectionX = chunkX * 16 + sectionX;
/* 148 */                         int absoluteSectionY = section.method_12259() + sectionY;
/* 149 */                         int absoluteSectionZ = chunkZ * 16 + sectionZ;
/*     */ 
/*     */                         
/* 152 */                         if (((0 < x) ? ((absoluteSectionX - x) * (absoluteSectionX - x)) : ((x - absoluteSectionX) * (x - absoluteSectionX))) + ((0 < y) ? ((absoluteSectionY - y) * (absoluteSectionY - y)) : ((y - absoluteSectionY) * (y - absoluteSectionY))) + ((0 < z) ? ((absoluteSectionZ - z) * (absoluteSectionZ - z)) : ((z - absoluteSectionZ) * (z - absoluteSectionZ))) <= clearRadius * clearRadius)
/*     */                         {
/*     */ 
/*     */                           
/* 156 */                           if (!section.method_12254(sectionX, sectionY, sectionZ).method_26215()) {
/* 157 */                             section.method_16675(sectionX, sectionY, sectionZ, AIR);
/* 158 */                             shouldUpdate = true;
/*     */                           } 
/*     */                         }
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 169 */           if (!world.field_9236 && 
/* 170 */             shouldUpdate) {
/* 171 */             chunk.method_12220();
/*     */             
/* 173 */             ((class_3215)world.method_8398()).field_17254.method_17210(new class_1923(chunkX, chunkZ), false).forEach(player -> player.field_13987.method_14364((class_2596)new class_2672(chunk, 65535)));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/common/utilities/BlackHoleUtilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */