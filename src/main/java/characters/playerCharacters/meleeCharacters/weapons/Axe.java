package characters.playerCharacters.meleeCharacters.weapons;

import characters.enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class Axe extends Weapon {

    public Axe(){
        super("Axe-6", 6);
    }

    public int attack(Enemy enemy){
        Random random = new Random();
        int effect = random.nextInt(10) + 1;
        if (effect == 10){
            return 1000;
        } else if (effect == 9){
            removeWeapon(enemy);
            return this.getAttackValue();
        } else {
            return this.getAttackValue();
        }
    }

    private void removeWeapon(Enemy enemy){
        ArrayList<String> statusEffects;
        statusEffects = enemy.getStatusEffects();
        if (!statusEffects.contains("Removed Weapon")) {
            statusEffects.add("Removed Weapon");
            enemy.setStatusEffects(statusEffects);
        }
    }

}
