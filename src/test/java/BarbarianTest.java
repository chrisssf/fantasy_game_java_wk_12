import characters.enemies.Enemy;
import characters.playerCharacters.meleeCharacters.Barbarian;
import characters.playerCharacters.meleeCharacters.weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {

    private Barbarian barbarian;
    private Axe axe;
    private Enemy enemy;

    @Before
    public void before(){
        axe = new Axe();
        barbarian = new Barbarian("Dave", axe);
        enemy = new Enemy("Orc");
    }

    @Test
    public void hasName(){
        assertEquals("Dave", barbarian.getName());
    }

    @Test
    public void hasWeaponWithDamage6(){
        assertEquals(6, barbarian.getWeapon().getAttackValue());
    }

    @Test // fails 1 in 10
    public void canAttackEnemy(){
        barbarian.attack(enemy);
        assertEquals(8, enemy.getHealthPoints());
    }

    @Test // Random!! passes 1 in 10
    public void canAddWeaponRemoved1in10(){
        barbarian.attack(enemy);
        assertEquals("Removed Weapon", enemy.getStatusEffects().get(0));
    }

    @Test
    public void canKillEnemy(){
        barbarian.attack(enemy);
        barbarian.attack(enemy);
        assertEquals(false, enemy.getIsAlive());
    }
}
