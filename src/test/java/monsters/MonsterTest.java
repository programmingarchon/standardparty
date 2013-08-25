package monsters;

import org.junit.Assert;
import org.junit.Test;

public class MonsterTest {
    @Test
    public void shouldHaveStartingHP() throws Exception {
        Monster monster = new Monster().withHp(20);

        Assert.assertEquals(20, monster.getCurrentHp());
    }

    @Test
    public void shouldHaveStrength() throws Exception {
        Monster monster = new Monster().withStrength(5);

        Assert.assertEquals(5, monster.getStrength());
    }

    @Test
    public void shouldHaveName() throws Exception {
        Monster monster = new Monster().withHp(20).withStrength(5).withName("Fluffy");

        Assert.assertEquals("Fluffy", monster.getName());
    }

    @Test
    public void shouldBeAbleToAttack() throws Exception {
        Monster monster1 = new Monster().withHp(20).withStrength(5).withName("Fluffy");
        Monster monster2 = new Monster().withHp(20).withStrength(3).withName("Fluffier");

        monster1.attack(monster2);

        Assert.assertEquals(15, monster2.getCurrentHp());
    }
}
