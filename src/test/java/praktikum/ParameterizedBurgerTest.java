package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedBurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    private float ingredient1Price;
    private float ingredient2Price;
    private float expectedPrice;

    public ParameterizedBurgerTest(float ingredient1Price, float ingredient2Price, float expectedPrice) {
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Price = ingredient2Price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Стоимость ингредиентов. Тестовые данные: {0} {1} {2}")
    public static Object[][] priceData() {
        return new Object[][]{
                {30F, 20F, 100F},
                {50F, 10F, 110F},
                {25F, 15F, 105F}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("New Bun");
        when(bun.getPrice()).thenReturn(80F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(30F);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("dinosaur");
        when(ingredient2.getPrice()).thenReturn(50F);
    }

   @Test
   public void testAddIngredient() {
            float initialPrice = burger.getPrice();
            burger.addIngredient(ingredient1);
            float priceAfterAdding1stIngredient = burger.getPrice();
            assertEquals(initialPrice + ingredient1.getPrice(), priceAfterAdding1stIngredient, 0);
        }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float initialPrice = burger.getPrice();

        burger.removeIngredient(1);
        float priceAfterRemovingIngredient = burger.getPrice();
        assertEquals(initialPrice - ingredient2.getPrice(), priceAfterRemovingIngredient,0);
      }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float initialPrice = burger.getPrice();

        burger.moveIngredient(1, 0);
        float priceAfterMovingIngredient = burger.getPrice();
        assertEquals(initialPrice, priceAfterMovingIngredient, 0);
     }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.setBuns(new Bun("New Bun", 80));

        String expectedReceipt = "(==== New Bun ====)\r\n= sauce hot sauce =\r\n" +
                "= filling dinosaur =\r\n(==== New Bun ====)\r\n\r\nPrice: 240,000000\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
      }
    }