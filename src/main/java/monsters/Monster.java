package monsters;

public class Monster {
    private String name;
    private int currentHp;
    private int strength;

    public Monster() {}

    public Monster(int currentHp, int strength, String name) {
        this.currentHp = currentHp;
        this.strength = strength;
        this.name = name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public Monster withHp(int hp) {
        this.currentHp = hp;
        return this;
    }

    public Monster withStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public Monster withName(String name) {
        this.name = name;
        return this;
    }

    public void attack(Monster otherMonster) {
        otherMonster.loseHP(strength);
    }

    public void loseHP(int damage){
        currentHp -= damage;
    }
}
