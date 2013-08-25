package room;

import monsters.Monster;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class RoomTest {
    Room room;

    @Before
    public void setUp() throws Exception {
        room = new Room();
    }

    @Test
    public void shouldBeAbleToAddMonster() throws Exception {
        Monster monster = new Monster();
        room.addMonster(monster);

        Collection<Monster> monstersInRoom = room.getCharacters();

        assertTrue(monstersInRoom.contains(monster));
        assertEquals(room, monster.getRoom());
    }

    @Test
    public void shouldBeAbleToAddMonsters() throws Exception {
        Monster monster1 = new Monster();
        Monster monster2 = new Monster();
        room.addMonsters(monster1, monster2);

        Collection<Monster> monstersInRoom = room.getCharacters();

        assertTrue(monstersInRoom.contains(monster1));
        assertTrue(monstersInRoom.contains(monster2));
        assertEquals(room, monster1.getRoom());
        assertEquals(room, monster2.getRoom());
    }

    @Test
    public void allCharactersShouldTakeActionDuringRound() throws Exception {
        Monster monster1 = spy(new Monster());
        Monster monster2 = spy(new Monster());
        room.addMonsters(monster1, monster2);

        room.playRound();

        verify(monster1).takeAction();
        verify(monster2).takeAction();
    }

    @Test
    public void shouldProvideOtherCharactersInRoom() throws Exception {
        Monster monster1 = new Monster().withHp(20).withStrength(5);
        Monster monster2 = new Monster().withHp(20).withStrength(5);
        room.addMonsters(monster1, monster2);

        assertEquals(monster2, room.getOtherCharactersOf(monster1).get(0));
    }
}
