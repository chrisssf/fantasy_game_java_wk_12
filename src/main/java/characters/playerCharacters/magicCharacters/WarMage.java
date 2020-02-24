package characters.playerCharacters.magicCharacters;

import characters.playerCharacters.magicCharacters.creatures.Creature;
import characters.playerCharacters.magicCharacters.spells.Spell;

public class WarMage extends MagicPlayer {

    public WarMage(String name, Spell spell, Creature creature) {
        super(name, 2, 15, spell, creature);
    }
}
