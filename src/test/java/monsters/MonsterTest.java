package monsters;

import org.junit.Assert;
import org.junit.Test;
import room.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MonsterTest {
    @Test
    public void shouldHaveStartingHP() throws Exception {
        Monster monster = new Monster().withHp(20);

        assertEquals(20, monster.getCurrentHp());
    }

    @Test
    public void shouldHaveStrength() throws Exception {
        Monster monster = new Monster().withStrength(5);

        assertEquals(5, monster.getStrength());
    }

    @Test
    public void shouldHaveName() throws Exception {
        Monster monster = new Monster().withHp(20).withStrength(5).withName("Fluffy");

        assertEquals("Fluffy", monster.getName());
    }

    @Test
    public void shouldBeAbleToAttack() throws Exception {
        Monster monster1 = new Monster().withHp(20).withStrength(5).withName("Fluffy");
        Monster monster2 = new Monster().withHp(20).withStrength(3).withName("Fluffier");

        monster1.attack(monster2);

        assertEquals(15, monster2.getCurrentHp());
    }

    @Test
    public void shouldAttackOthersWhenTakingAction() throws Exception {
        Room room = new Room();
        Monster monster1 = new Monster().withHp(20).withStrength(5);
        Monster monster2 = new Monster().withHp(20).withStrength(5);
        room.addMonsters(monster1, monster2);

        monster1.attemptToTakeAction();

        assertEquals(15, monster2.getCurrentHp());
    }

    @Test
    public void shouldBeDeadIfOutOfHP() throws Exception {
        Monster monster = new Monster().withHp(-1);

        assertTrue(monster.isDead());
    }

    @Test
    public void shouldBeAliveWhenHasHP() throws Exception {
        Monster monster = new Monster().withHp(20);

        assertTrue(monster.isAlive());
    }

    @Test
    public void shouldNotTakeActionIfDead() throws Exception {
        Monster deadMonster = spy(new Monster().withHp(-1));
        Monster aliveMonster = new Monster().withHp(10);
        Room chamber = new Room();
        chamber.addMonsters(deadMonster, aliveMonster);

        deadMonster.attemptToTakeAction();

        verify(deadMonster, never()).attack(any(Monster.class));
    }

    @Test
    public void shouldNotBeAbleToTakeActionIfNotInRoom() throws Exception {
        Monster monster = new Monster().withHp(1);

        assertFalse(monster.canTakeAction());
    }


    @Test
    public void shouldNotBeAbleToTakeActionIfDead() throws Exception {
        Monster monster = new Monster().withHp(-1);
        Room palace = new Room();
        palace.addMonster(monster);

        assertFalse(monster.canTakeAction());
    }
}
