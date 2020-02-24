import characters.enemies.Enemy;
import characters.playerCharacters.magicCharacters.WarMage;
import characters.playerCharacters.magicCharacters.creatures.Creature;
import characters.playerCharacters.magicCharacters.spells.Spell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarMageTest {

    private WarMage warMage;
    private Spell spell;
    private Spell spell2;
    private Creature creature;
    private Enemy enemy;

    @Before
    public void before(){
        spell = new Spell("Freeze");
        spell2 = new Spell("Break Weapon");
        creature = new Creature("Dragon");
        warMage = new WarMage("John", spell, creature);
        enemy = new Enemy("Orc");
    }

    @Test
    public void hasName(){
        assertEquals("John", warMage.getName());
    }

    @Test
    public void hasCreatureWith20DefendValue(){
        assertEquals(20, warMage.getCreature().getDefendValue());
    }

    @Test
    public void hasSpellCalledFreeze(){
        assertEquals("Freeze", warMage.getSpell().getName());
    }

    @Test
    public void canAttackEnemy(){
        warMage.attack(enemy);
        assertEquals(18, enemy.getHealthPoints());
    }

    @Test
    public void canAddStatusEffectToEnemy(){
        warMage.castSpell(enemy);
//        assertEquals(["Burn"], enemy.getStatusEffects());
        assertEquals("Freeze", enemy.getStatusEffects().get(0));
    }

    @Test
    public void canAddSpell(){
        warMage.addSpell(spell2);
        assertEquals("Freeze", warMage.getSpells().get(0).getName());
        assertEquals("Break Weapon", warMage.getSpells().get(1).getName());
    }

    @Test
    public void canSwapSpells(){
        warMage.setSpell(spell2);
        assertEquals("Break Weapon", warMage.getSpell().getName());
    }

    @Test
    public void canAddMultipleStatusEffectsToEnemy(){
        warMage.castSpell(enemy);
        warMage.setSpell(spell2);
        warMage.castSpell(enemy);
        assertEquals("Freeze", enemy.getStatusEffects().get(0));
        assertEquals("Break Weapon", enemy.getStatusEffects().get(1));
    }

    @Test
    public void cantAddSameStatusEffectTwice(){
        warMage.castSpell(enemy);
        warMage.setSpell(spell2);
        warMage.castSpell(enemy);
        warMage.castSpell(enemy);
        assertEquals(2, enemy.getStatusEffects().size());
    }

    @Test
    public void creatureDefendsMagicPlayer(){
        enemy.attack(warMage);
        assertEquals(15, warMage.getHealthPoints());
        assertEquals(15, warMage.getCreature().getDefendValue());
    }

    @Test
    public void magicCharacterTakesDamageWhenCreatureDead(){
        enemy.attack(warMage);
        enemy.attack(warMage);
        enemy.attack(warMage);
        enemy.attack(warMage);
        enemy.attack(warMage);
        assertEquals(10, warMage.getHealthPoints());
        assertEquals(0, warMage.getCreature().getDefendValue());
    }
}
