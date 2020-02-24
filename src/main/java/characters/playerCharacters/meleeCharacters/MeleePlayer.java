package characters.playerCharacters.meleeCharacters;

import characters.enemies.Enemy;
import characters.playerCharacters.Player;
import characters.playerCharacters.meleeCharacters.weapons.Weapon;

import java.util.ArrayList;

public abstract class MeleePlayer extends Player {

    private Weapon weapon;
    private ArrayList<Weapon> weapons;


    public MeleePlayer(String name, int attackPoints, int healthPoints, Weapon weapon){
        super(name, attackPoints, healthPoints);
        this.weapon = weapon;
        this.weapons = new ArrayList<Weapon>();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void attack(Enemy enemy){
        int startingHealth = enemy.getHealthPoints();
//        int newHealth = startingHealth - (this.weapon.getAttackValue() + this.getAttackPoints());
        int newHealth = startingHealth - (this.weapon.attack(enemy) + this.getAttackPoints());
        enemy.setHealthPoints(newHealth);
    }
}
