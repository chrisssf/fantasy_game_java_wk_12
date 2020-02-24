package characters;

public abstract class Character {

    private String name;
    private int attackPoints;
    private int healthPoints;
    private boolean isAlive;


    public Character(String name, int attackPoints, int healthPoints){
        this.name = name;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
        if (this.healthPoints <= 0){
            this.isAlive = false;
        }
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

//    public void setAlive(boolean alive) {
//        isAlive = alive;
//    }

    //    public abstract void attack();
}
