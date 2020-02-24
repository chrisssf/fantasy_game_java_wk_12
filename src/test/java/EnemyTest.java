import characters.enemies.Enemy;
import characters.playerCharacters.magicCharacters.Wizard;
import characters.playerCharacters.magicCharacters.creatures.Creature;
import characters.playerCharacters.magicCharacters.spells.Spell;
import characters.playerCharacters.meleeCharacters.Dwarf;
import characters.playerCharacters.meleeCharacters.weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    Enemy enemy;
    Dwarf dwarf;
    Axe axe;
    Wizard wizard;
    Spell spell;
    Creature creature;

    @Before
    public void before(){
        enemy = new Enemy("Orc");
        axe = new Axe();
        dwarf = new Dwarf("Dave", axe);
        spell = new Spell("Freeze");
        creature = new Creature("Dragon");
        wizard = new Wizard("Jeff", spell, creature);
    }

    @Test
    public void canGetName(){
        assertEquals("Orc", enemy.getName());
    }

    @Test
    public void statusEffectsStartsEmpty(){
        assertEquals(0, enemy.getStatusEffects().size());
    }

    @Test
    public void canAttackPlayer(){
        enemy.attack(dwarf);
        assertEquals(20, dwarf.getHealthPoints());
    }

    @Test
    public void cantAttackWhenFrozen(){
        wizard.castSpell(enemy);
        assertEquals("Freeze", enemy.getStatusEffects().get(0));
        enemy.attack(dwarf);
        assertEquals(25, dwarf.getHealthPoints());
    }

    @Test
    public void canAttackAfterBeingFrozen(){
        wizard.castSpell(enemy);
        enemy.attack(dwarf);
        enemy.attack(dwarf);
        assertEquals(0, enemy.getStatusEffects().size());
        assertEquals(20, dwarf.getHealthPoints());
    }

//    @Test
//    public void randomHealth(){
//        assertEquals(15, enemy.getHealthPoints());
//    }
//
//    @Test
//    public void randomAttack(){
//        assertEquals(10, enemy.getAttackPoints());
//    }
}
