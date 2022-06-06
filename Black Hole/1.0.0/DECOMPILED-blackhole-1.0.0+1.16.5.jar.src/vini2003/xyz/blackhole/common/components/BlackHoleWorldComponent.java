/*    */ package vini2003.xyz.blackhole.common.components;
/*    */ 
/*    */ import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2487;
/*    */ import net.minecraft.class_2499;
/*    */ import net.minecraft.class_2520;
/*    */ import vini2003.xyz.blackhole.registry.common.BlackHoleComponents;
/*    */ 
/*    */ public class BlackHoleWorldComponent
/*    */   implements AutoSyncedComponent {
/* 15 */   private final List<BlackHoleComponent> blackHoles = new ArrayList<>();
/*    */   
/*    */   private final class_1937 world;
/*    */   
/* 19 */   private int lastId = 0;
/*    */   
/*    */   public BlackHoleWorldComponent(class_1937 world) {
/* 22 */     this.world = world;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 26 */     this.blackHoles.forEach(BlackHoleComponent::tick);
/*    */     
/* 28 */     BlackHoleComponents.BLACK_HOLES.sync(this.world);
/*    */   }
/*    */ 
/*    */   
/*    */   public void readFromNbt(class_2487 compoundTag) {
/* 33 */     class_2499 list = compoundTag.method_10554("BlackHoles", 10);
/*    */     
/* 35 */     list.forEach(blackHoleCompoundTag -> {
/*    */           int id = ((class_2487)blackHoleCompoundTag).method_10550("Id");
/*    */ 
/*    */           
/*    */           Optional<BlackHoleComponent> blackHole = this.blackHoles.stream().filter(()).findFirst();
/*    */ 
/*    */           
/*    */           if (blackHole.isPresent()) {
/*    */             ((BlackHoleComponent)blackHole.get()).readFromNbt((class_2487)blackHoleCompoundTag);
/*    */           } else {
/*    */             BlackHoleComponent blackHoleComponent = new BlackHoleComponent(this.world);
/*    */ 
/*    */             
/*    */             blackHoleComponent.readFromNbt((class_2487)blackHoleCompoundTag);
/*    */             
/*    */             this.blackHoles.add(blackHoleComponent);
/*    */           } 
/*    */         });
/*    */     
/* 54 */     this.lastId = compoundTag.method_10550("LastId");
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToNbt(class_2487 compoundTag) {
/* 59 */     class_2499 list = new class_2499();
/*    */     
/* 61 */     this.blackHoles.forEach(blackHoleComponent -> {
/*    */           class_2487 blackHoleCompoundTag = new class_2487();
/*    */           
/*    */           blackHoleComponent.writeToNbt(blackHoleCompoundTag);
/*    */           
/*    */           list.add(blackHoleCompoundTag);
/*    */         });
/*    */     
/* 69 */     compoundTag.method_10566("BlackHoles", (class_2520)list);
/*    */     
/* 71 */     compoundTag.method_10569("LastId", this.lastId);
/*    */   }
/*    */   
/*    */   public int nextId() {
/* 75 */     int id = this.lastId;
/* 76 */     this.lastId++;
/* 77 */     return id;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<BlackHoleComponent> getBlackHoles() {
/* 82 */     return this.blackHoles;
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/common/components/BlackHoleWorldComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */