import characters.enemies.Enemy;
import characters.playerCharacters.meleeCharacters.Knight;
import characters.playerCharacters.meleeCharacters.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight knight;
    private Sword sword;
    private Enemy enemy;

    @Before
    public void before(){
        sword = new Sword();
        knight = new Knight("Bob", sword);
        enemy = new Enemy("Orc");
    }

    @Test
    public void hasName(){
        assertEquals("Bob", knight.getName());
    }

    @Test
    public void hasWeaponWithDamage5(){
        assertEquals(5, knight.getWeapon().getAttackValue());
    }

    @Test // fails 1 in 4
    public void canAttackEnemy(){
        knight.attack(enemy);
        assertEquals(11, enemy.getHealthPoints());
    }

    @Test
    public void canKillEnemy(){
        knight.attack(enemy);
        knight.attack(enemy);
        knight.attack(enemy);
        assertEquals(false, enemy.getIsAlive());
    }
}
