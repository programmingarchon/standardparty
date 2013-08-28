package monsters;

import room.Room;

public class Monster {
    private String name;
    private int currentHp;
    private int strength;
    private Room room;

    public Monster() {}

    public int getCurrentHp() {
        return currentHp;
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

    public void attemptToTakeAction() {
        if(canTakeAction()) {
            takeAction();
        }
    }

    public void takeAction() {
        Monster target = room.getOtherCharactersOf(this).get(0);
        attack(target);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public boolean canTakeAction() {
        return room != null && isAlive();
    }
}
