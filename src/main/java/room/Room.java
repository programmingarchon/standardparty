package room;

import com.sun.deploy.util.ArrayUtil;
import monsters.Monster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Room {
    private List<Monster> characters;

    public Room() {
        characters = new ArrayList<Monster>();
    }

    public void addMonster(Monster monster) {
        characters.add(monster);
        monster.setRoom(this);
    }

    public Collection<Monster> getCharacters() {
        return characters;
    }

    public void addMonsters(Monster... monsters) {
        for (Monster monster : monsters) {
            addMonster(monster);
        }
    }

    public void playRound() {
        for (Monster monster : characters) {
            monster.takeAction();
        }
    }

    public List<Monster> getOtherCharactersOf(Monster monster) {
        List<Monster> copy = new ArrayList<Monster>(characters);
        copy.remove(monster);
        return copy;
    }
}
