package characters.playerCharacters.magicCharacters;

import characters.enemies.Enemy;
import characters.playerCharacters.Player;
import characters.playerCharacters.magicCharacters.creatures.Creature;
import characters.playerCharacters.magicCharacters.spells.Spell;

import java.util.ArrayList;

public abstract class MagicPlayer extends Player {

    private Spell spell;
    private Creature creature;
    private ArrayList<Spell> spells;

    public MagicPlayer(String name, int attackPoints, int healthPoints, Spell spell, Creature creature){
        super(name, attackPoints, healthPoints);
        this.spell = spell;
        this.creature = creature;
        this.spells = new ArrayList<Spell>();
        this.spells.add(spell);
    }

    public Spell getSpell() {
        return spell;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public Creature getCreature() {
        return creature;
    }

    public void addSpell(Spell spell){
        this.spells.add(spell);
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public void attack(Enemy enemy){
        int startingHealth = enemy.getHealthPoints();
        int newHealth = startingHealth - this.getAttackPoints();
        enemy.setHealthPoints(newHealth);
    }

    public void castSpell(Enemy enemy){
        ArrayList<String> statusEffects;
//        ArrayList<String> updatedStatusEffect;
//        updatedStatusEffect = enemy.getStatusEffects().add(spell.getName());
        statusEffects = enemy.getStatusEffects();
        if (!statusEffects.contains(spell.getName())) {
            statusEffects.add(spell.getName());
            enemy.setStatusEffects(statusEffects);
        }
    }
}
