package characters.playerCharacters.magicCharacters;

import characters.enemies.Enemy;
import characters.playerCharacters.magicCharacters.creatures.Creature;
import characters.playerCharacters.magicCharacters.spells.Spell;

public class Wizard extends MagicPlayer{

    public Wizard(String name, Spell spell, Creature creature) {
        super(name, 1, 5, spell, creature);
    }

}
