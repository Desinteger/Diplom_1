package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(80F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(30F);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("dinosaur");
        when(ingredient2.getPrice()).thenReturn(50F);
    }

    @Test
    public void testSetBuns(){
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float totalPrice = burger.getPrice();
        float expectedPrice = 240F;
        assertEquals(expectedPrice, totalPrice, 0);
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