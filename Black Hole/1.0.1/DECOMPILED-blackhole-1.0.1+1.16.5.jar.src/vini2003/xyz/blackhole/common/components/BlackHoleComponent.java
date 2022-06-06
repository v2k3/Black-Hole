/*     */ package vini2003.xyz.blackhole.common.components;
/*     */ 
/*     */ import dev.onyxstudios.cca.api.v3.component.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1935;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2487;
/*     */ import net.minecraft.class_2680;
/*     */ import net.minecraft.class_3218;
/*     */ import net.minecraft.class_3532;
/*     */ import vini2003.xyz.blackhole.common.config.BlackHoleConfig;
/*     */ import vini2003.xyz.blackhole.common.utilities.BlackHoleUtilities;
/*     */ import vini2003.xyz.blackhole.registry.common.BlackHoleComponents;
/*     */ 
/*     */ public class BlackHoleComponent implements Component {
/*  21 */   private class_243 pos = new class_243(0.0D, 64.0D, 0.0D);
/*     */   
/*  23 */   private float size = 1.0F;
/*     */   
/*  25 */   private int countdown = 100;
/*     */   
/*     */   private int id;
/*     */   
/*     */   private class_1937 world;
/*     */   
/*     */   private class_1657 target;
/*     */   
/*  33 */   private final List<BlackHoleParticle> particles = new ArrayList<>();
/*     */   
/*     */   public BlackHoleComponent(class_1937 world) {
/*  36 */     this.world = world;
/*     */     
/*  38 */     this.id = ((BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(world)).nextId();
/*     */   }
/*     */   
/*     */   public void tickSize() {
/*  42 */     if (BlackHoleConfig.cache.grow) {
/*  43 */       this.size = Math.min(BlackHoleConfig.cache.limit, this.size * (1.0F + BlackHoleConfig.cache.growSpeed));
/*     */     }
/*     */   }
/*     */   
/*     */   public void tickDestruction() {
/*  48 */     if (BlackHoleConfig.cache.damage) {
/*  49 */       BlackHoleUtilities.destroy(this, this.world, (int)this.pos.method_10216(), (int)this.pos.method_10214(), (int)this.pos.method_10215(), (int)getSize());
/*     */     }
/*     */   }
/*     */   
/*     */   public void tickPlayerPull() {
/*  54 */     for (class_1297 entity : this.world.method_18456()) {
/*  55 */       if (!entity.method_7325() && !((class_1657)entity).method_7337()) {
/*  56 */         double distance = getPos().method_1022(entity.method_19538());
/*     */         
/*  58 */         if (BlackHoleConfig.cache.pull) {
/*  59 */           if (this.world.field_9236) {
/*  60 */             class_243 pull = getPos().method_1020(entity.method_19538()).method_1029();
/*  61 */             pull = pull.method_1021(Math.pow(BlackHoleConfig.cache.pullSpeed, distance * 1.5D / (this.size * 2.5F)));
/*     */ 
/*     */             
/*  64 */             if (distance > this.size && entity.method_18798().method_1027() < 3.0D) {
/*  65 */               entity.method_5762(class_3532.method_15350(pull.method_10216(), -1.0D, 1.0D), class_3532.method_15350(pull.method_10214(), -1.0D, 1.0D), class_3532.method_15350(pull.method_10215(), -1.0D, 1.0D));
/*  66 */               entity.field_6037 = true;
/*  67 */               entity.field_6007 = true;
/*     */             } 
/*     */             
/*  70 */             if (distance < this.size)
/*  71 */               entity.method_18799(class_243.field_1353); 
/*     */             continue;
/*     */           } 
/*  74 */           if (this.countdown <= 0 && distance < this.size) {
/*  75 */             entity.method_5768();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tickEntityPull() {
/*  84 */     if (!this.world.field_9236) {
/*  85 */       for (class_1297 entity : ((class_3218)this.world).method_27909()) {
/*  86 */         double distance = getPos().method_1022(entity.method_19538());
/*     */         
/*  88 */         if (BlackHoleConfig.cache.pull && 
/*  89 */           !(entity instanceof class_1657)) {
/*  90 */           class_243 pull = getPos().method_1020(entity.method_19538()).method_1029();
/*  91 */           pull = pull.method_1021(Math.pow(BlackHoleConfig.cache.pullSpeed, distance * 1.5D / (this.size * 2.5F)));
/*     */ 
/*     */           
/*  94 */           if (distance > this.size && entity.method_18798().method_1027() < 3.0D) {
/*  95 */             entity.method_5762(class_3532.method_15350(pull.method_10216(), -1.0D, 1.0D), class_3532.method_15350(pull.method_10214(), -1.0D, 1.0D), class_3532.method_15350(pull.method_10215(), -1.0D, 1.0D));
/*  96 */             entity.field_6037 = true;
/*  97 */             entity.field_6007 = true;
/*     */           } 
/*     */           
/* 100 */           if (this.countdown <= 0 && distance < this.size) {
/* 101 */             entity.method_5768();
/* 102 */             entity.method_18799(class_243.field_1353);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void tickTarget() {
/* 111 */     if (BlackHoleConfig.cache.follow) {
/* 112 */       if (this.target == null || !this.target.method_5805() || this.target.method_7325() || this.target.method_7337()) {
/* 113 */         this.target = this.world.method_18456().stream().filter(player -> (!player.method_7325() && !player.method_7337() && player.method_5707(getPos()) < 1048576.0D)).findFirst().orElse(null);
/*     */       } else {
/* 115 */         class_243 subtract = this.target.method_19538().method_1020(getPos());
/* 116 */         class_243 follow = subtract.method_1029().method_1021(BlackHoleConfig.cache.followSpeed);
/*     */         
/* 118 */         setPos(getPos().method_1019(follow));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void tickCountdown() {
/* 124 */     if (this.countdown > 0) {
/* 125 */       this.countdown--;
/*     */     }
/*     */   }
/*     */   
/*     */   public void tick() {
/* 130 */     if (this.countdown <= 0) {
/* 131 */       if (!this.world.field_9236) {
/* 132 */         tickSize();
/*     */       }
/*     */       
/* 135 */       tickDestruction();
/*     */       
/* 137 */       tickPlayerPull();
/*     */       
/* 139 */       if (!this.world.field_9236) {
/* 140 */         tickEntityPull();
/*     */       }
/*     */       
/* 143 */       if (!this.world.field_9236) {
/* 144 */         tickTarget();
/*     */       }
/*     */     }
/* 147 */     else if (!this.world.field_9236) {
/* 148 */       tickCountdown();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class_243 getPos() {
/* 155 */     return this.pos;
/*     */   }
/*     */   
/*     */   public void setPos(class_243 pos) {
/* 159 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   public float getSize() {
/* 163 */     return this.size;
/*     */   }
/*     */   
/*     */   public void setSize(float size) {
/* 167 */     this.size = size;
/*     */   }
/*     */   
/*     */   public int getId() {
/* 171 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/* 175 */     this.id = id;
/*     */   }
/*     */   
/*     */   public class_1937 getWorld() {
/* 179 */     return this.world;
/*     */   }
/*     */   
/*     */   public void setWorld(class_1937 world) {
/* 183 */     this.world = world;
/*     */   }
/*     */   
/*     */   public List<BlackHoleParticle> getParticles() {
/* 187 */     return this.particles;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BlackHoleParticle
/*     */   {
/*     */     private class_243 pos;
/*     */     
/*     */     private final class_2680 state;
/*     */     private final class_1799 stack;
/*     */     
/*     */     public BlackHoleParticle(class_243 pos, class_2680 state) {
/* 199 */       this.pos = pos;
/* 200 */       this.state = state;
/*     */       
/* 202 */       this.stack = new class_1799((class_1935)state.method_26204().method_8389());
/*     */     }
/*     */     
/*     */     public class_243 getPos() {
/* 206 */       return this.pos;
/*     */     }
/*     */     
/*     */     public void setPos(class_243 pos) {
/* 210 */       this.pos = pos;
/*     */     }
/*     */     
/*     */     public class_2680 getState() {
/* 214 */       return this.state;
/*     */     }
/*     */     
/*     */     public class_1799 getStack() {
/* 218 */       return this.stack;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNbt(class_2487 compoundTag) {
/* 225 */     this
/*     */ 
/*     */       
/* 228 */       .pos = new class_243(compoundTag.method_10574("X"), compoundTag.method_10574("Y"), compoundTag.method_10574("Z"));
/*     */ 
/*     */     
/* 231 */     this.size = compoundTag.method_10583("Size");
/*     */     
/* 233 */     this.countdown = compoundTag.method_10550("Countdown");
/*     */     
/* 235 */     this.id = compoundTag.method_10550("Id");
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToNbt(class_2487 compoundTag) {
/* 240 */     compoundTag.method_10549("X", this.pos.method_10216());
/* 241 */     compoundTag.method_10549("Y", this.pos.method_10214());
/* 242 */     compoundTag.method_10549("Z", this.pos.method_10215());
/*     */     
/* 244 */     compoundTag.method_10548("Size", this.size);
/*     */     
/* 246 */     compoundTag.method_10569("Countdown", this.countdown);
/*     */     
/* 248 */     compoundTag.method_10569("Id", this.id);
/*     */   }
/*     */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/blackhole-1.0.1+1.16.5.jar!/vini2003/xyz/blackhole/common/components/BlackHoleComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */