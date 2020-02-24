import characters.enemies.Enemy;
import characters.playerCharacters.magicCharacters.Wizard;
import characters.playerCharacters.magicCharacters.creatures.Creature;
import characters.playerCharacters.magicCharacters.spells.Spell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    private Wizard wizard;
    private Spell spell;
    private Spell spell2;
    private Creature creature;
    private Enemy enemy;

    @Before
    public void before(){
        spell = new Spell("Burn");
        spell2 = new Spell("Corrode Armour");
        creature = new Creature("Dragon");
        wizard = new Wizard("Steve", spell, creature);
        enemy = new Enemy("Orc");
    }

    @Test
    public void hasName(){
        assertEquals("Steve", wizard.getName());
    }

    @Test
    public void hasCreatureWith20DefendValue(){
        assertEquals(20, wizard.getCreature().getDefendValue());
    }

    @Test
    public void hasSpellCalledBurn(){
        assertEquals("Burn", wizard.getSpell().getName());
    }

    @Test
    public void canAttackEnemy(){
        wizard.attack(enemy);
        assertEquals(19, enemy.getHealthPoints());
    }

    @Test
    public void canAddStatusEffectToEnemy(){
        wizard.castSpell(enemy);
//        assertEquals(["Burn"], enemy.getStatusEffects());
        assertEquals("Burn", enemy.getStatusEffects().get(0));
    }

    @Test
    public void canAddSpell(){
        wizard.addSpell(spell2);
        assertEquals("Burn", wizard.getSpells().get(0).getName());
        assertEquals("Corrode Armour", wizard.getSpells().get(1).getName());
    }

    @Test
    public void canSwapSpells(){
        wizard.setSpell(spell2);
        assertEquals("Corrode Armour", wizard.getSpell().getName());
    }

    @Test
    public void canAddMultipleStatusEffectsToEnemy(){
        wizard.castSpell(enemy);
        wizard.setSpell(spell2);
        wizard.castSpell(enemy);
        assertEquals("Burn", enemy.getStatusEffects().get(0));
        assertEquals("Corrode Armour", enemy.getStatusEffects().get(1));
    }

    @Test
    public void cantAddSameStatusEffectTwice(){
        wizard.castSpell(enemy);
        wizard.setSpell(spell2);
        wizard.castSpell(enemy);
        wizard.castSpell(enemy);
        assertEquals(2, enemy.getStatusEffects().size());
    }

    @Test
    public void creatureDefendsMagicPlayer(){
        enemy.attack(wizard);
        assertEquals(5, wizard.getHealthPoints());
        assertEquals(15, wizard.getCreature().getDefendValue());
    }

    @Test
    public void magicCharacterTakesDamageWhenCreatureIsDead(){
        enemy.attack(wizard);
        enemy.attack(wizard);
        enemy.attack(wizard);
        enemy.attack(wizard);
        enemy.attack(wizard);
        assertEquals(0, wizard.getHealthPoints());
        assertEquals(0, wizard.getCreature().getDefendValue());
        assertEquals(false, wizard.getIsAlive());
    }



}
