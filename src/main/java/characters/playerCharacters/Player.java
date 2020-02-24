package characters.playerCharacters;

import characters.Character;

import java.util.ArrayList;

public abstract class Player extends Character {

    private ArrayList<Treasure> treasureBag;

    public Player(String name, int attackPoints, int healthPoints){
        super(name, attackPoints, healthPoints);
        this.treasureBag = new ArrayList<Treasure>();
    }


}
