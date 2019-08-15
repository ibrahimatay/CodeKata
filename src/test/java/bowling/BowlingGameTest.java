package bowling;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp(){
        bowlingGame = new BowlingGame();
    }

    @Test
    public void calculate_Score_For_All_Zeros() {
        bowlingGame.roll(0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void calculate_Score_18_when_allRolls() {
        bowlingGame.roll(7);
        bowlingGame.roll(2);
        bowlingGame.roll(8);
        bowlingGame.roll(1);
        assertEquals(18, bowlingGame.score());
    }

    @Test
    public void calculate_Score_14_when_allRolls() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(2);
        assertEquals(14, bowlingGame.score());
    }
}
