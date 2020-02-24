package characters.enemies;

import characters.Character;
import characters.playerCharacters.magicCharacters.MagicPlayer;
import characters.playerCharacters.magicCharacters.Wizard;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character {

    private ArrayList<String> statusEffects;

    public Enemy(String name){
        super(name, 5, 20);
        this.statusEffects = new ArrayList<String>();
//        randomiseStats();
    }

    public ArrayList<String> getStatusEffects() {
        return statusEffects;
    }

    public void setStatusEffects(ArrayList<String> statusEffects) {
        this.statusEffects = statusEffects;
    }

    public void randomiseStats(){
        Random random = new Random();
        int attackPoints = random.nextInt(4) + 5;
        int healthPoints = random.nextInt(8) + 18;

        this.setAttackPoints(attackPoints);
        this.setHealthPoints(healthPoints);
    }

    public void attack(Character character){
        if (!this.statusEffects.contains("Freeze") && !this.statusEffects.contains("Stunned")) {
            int startingHealth = character.getHealthPoints();
            int newHealth = startingHealth - this.getAttackPoints();
            character.setHealthPoints(newHealth);
        } else if (this.statusEffects.contains("Freeze")){
            ArrayList<String> statusEffects;
            statusEffects = this.getStatusEffects();
            statusEffects.remove("Freeze");
            this.setStatusEffects(statusEffects);
        } else if (this.statusEffects.contains("Stunned")){
            ArrayList<String> statusEffects;
            statusEffects = this.getStatusEffects();
            statusEffects.remove("Stunned");
            this.setStatusEffects(statusEffects);
        }
    }

    public void attack(MagicPlayer magicPlayer){
        if (!this.statusEffects.contains("Freeze") && !this.statusEffects.contains("Stunned")) {
            if (magicPlayer.getCreature().getDefendValue() > 0) {
                int startingDefendValue = magicPlayer.getCreature().getDefendValue();
                int newDefendValue = startingDefendValue - this.getAttackPoints();
                magicPlayer.getCreature().setDefendValue(newDefendValue);
            } else {
                int startingHealth = magicPlayer.getHealthPoints();
                int newHealth = startingHealth - this.getAttackPoints();
                magicPlayer.setHealthPoints(newHealth);
            }
        } else if (this.statusEffects.contains("Freeze")){
            ArrayList<String> statusEffects;
            statusEffects = this.getStatusEffects();
            statusEffects.remove("Freeze");
            this.setStatusEffects(statusEffects);
        } else if (this.statusEffects.contains("Stunned")){
            ArrayList<String> statusEffects;
            statusEffects = this.getStatusEffects();
            statusEffects.remove("Stunned");
            this.setStatusEffects(statusEffects);
        }
    }


}
