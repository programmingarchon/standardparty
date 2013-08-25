package monsters;

import org.junit.Assert;
import org.junit.Test;
import room.Room;

import static org.junit.Assert.assertEquals;

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

        monster1.takeAction();

        assertEquals(15, monster2.getCurrentHp());
    }
}
