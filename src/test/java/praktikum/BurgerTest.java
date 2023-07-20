package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


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
            burger.setBuns(bun);
            when(bun.getPrice()).thenReturn(50F);
            when(ingredient1.getPrice()).thenReturn(30F);
            when(ingredient2.getPrice()).thenReturn(20F);
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
            float expectedPrice = 150F;
            assertEquals(expectedPrice, totalPrice, 0);
        }
    }
