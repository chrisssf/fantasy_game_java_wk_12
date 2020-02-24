package characters.playerCharacters.meleeCharacters.weapons;

import characters.enemies.Enemy;

import java.util.Random;

public class Sword extends Weapon {

    public Sword(){
        super("Sword-5", 5);
    }

    public int attack(Enemy enemy){
        Random random = new Random();
        int pierce = random.nextInt(4) + 1;
        if (pierce == 4){
            return (this.getAttackValue() * 2);
        } else {
            return this.getAttackValue();
        }
    }
}
