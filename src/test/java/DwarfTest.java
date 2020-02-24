import characters.enemies.Enemy;
import characters.playerCharacters.meleeCharacters.Dwarf;
import characters.playerCharacters.meleeCharacters.weapons.Club;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    private Dwarf dwarf;
    private Club club;
    private Enemy enemy;

    @Before
    public void before(){
        club = new Club();
        dwarf = new Dwarf("Jeff", club);
        enemy = new Enemy("Orc");
    }

    @Test
    public void hasName(){
        assertEquals("Jeff", dwarf.getName());
    }

    @Test
    public void hasWeaponWithDamage5(){
        assertEquals(5, dwarf.getWeapon().getAttackValue());
    }

    @Test
    public void canAttackEnemy(){
        dwarf.attack(enemy);
        assertEquals(13, enemy.getHealthPoints());
    }

    @Test // Random!!
    public void canStunEnemy1in4(){
        dwarf.attack(enemy);
        assertEquals("Stunned", enemy.getStatusEffects().get(0));
    }

    @Test
    public void canKillEnemy(){
        dwarf.attack(enemy);
        dwarf.attack(enemy);
        dwarf.attack(enemy);
        assertEquals(false, enemy.getIsAlive());
    }
}
