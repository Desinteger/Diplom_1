package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Test Bun", 300F);
        String expectedName = "Test Bun";
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Test Bun", 300F);
        float expectedPrice = 300F;
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}