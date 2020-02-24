package characters.playerCharacters.meleeCharacters.weapons;

import characters.enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class Club extends Weapon {

    public Club(){
        super("Club-5", 5);
    }

    public int attack(Enemy enemy){
        Random random = new Random();
        int stun = random.nextInt(4) + 1;
        if (stun == 4){
            stunEnemy(enemy);
            return this.getAttackValue();
        } else {
            return this.getAttackValue();
        }
    }

    private void stunEnemy(Enemy enemy){
        ArrayList<String> statusEffects;
        statusEffects = enemy.getStatusEffects();
        if (!statusEffects.contains("Stunned")) {
            statusEffects.add("Stunned");
            enemy.setStatusEffects(statusEffects);
        }
    }
}
