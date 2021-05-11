package player;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author kaimo
 */
public class PlayerTest {

    public PlayerTest() {
    }

    @Test
    public void losses_when_dice_number_is_too_low() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);
        
        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }
    
    @Test
    public void wins_when_dice_number_is_big() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(5);
        
        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }

}
