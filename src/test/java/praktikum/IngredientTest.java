package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Сырный", 100);
        float expectedPrice = 100;
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Сырный", 100);
        String expectedName = "Сырный";
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Сырный", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}