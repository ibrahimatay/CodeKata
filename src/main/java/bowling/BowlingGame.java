package bowling;

public class BowlingGame {

    private int[] rolls = new int[21];
    private int rollCount = 0;
    private final int MAX_FRAME = 10;

    public void roll(int pin) {
        if (pin == MAX_FRAME) {
            rollCount++;
        }

        rolls[rollCount++] = pin;
    }

    public int score(){
        int totalScore = 0;

        for (int frame = 0; frame < MAX_FRAME; frame++)  {

            if (rolls[frame] == MAX_FRAME) {
                totalScore += rolls[frame] + rolls[frame + 1] + rolls[frame + 2];
            }
            else if (frame > 0 && (frame % 2) == 1) {
                int frameIndex = rolls[frame] + rolls[frame - 1];
                if (frameIndex == MAX_FRAME) {
                    totalScore += rolls[frame + 1];
                }
            }

            totalScore += rolls[frame];
        }

        return totalScore;
    }
}
