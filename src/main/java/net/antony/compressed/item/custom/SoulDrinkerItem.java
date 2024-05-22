package net.antony.compressed.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SoulDrinkerItem extends SwordItem {
    public SoulDrinkerItem(Tier tier) {
        super(tier,-2147483647,-2.4F,new Properties());
    }




    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity){
            LivingEntity victim = (LivingEntity) entity;
            if (victim instanceof Player && !victim.isDeadOrDying() && victim.getHealth()>0){
                if(victim.isInvulnerable()){
                    victim.setHealth(0);
                }
                else{
                    victim.kill();
                }
            }
            if(!victim.isDeadOrDying() && victim.getHealth()>0 ){
                try {
                    victim.kill();
                }
                catch(Exception e){
                    victim.setHealth(0);
                }
                return true;
            }
            if(victim.isInvulnerable() && !victim.isDeadOrDying() && victim.getHealth()>0){
                victim.setHealth(0);
            }
            return true;
        }

        return false;
    }




    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }
}
