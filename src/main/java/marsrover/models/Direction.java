package marsrover.models;

public enum Direction {
    NORTH(0, 'N'),
    EAST(1 ,'E'),
    SOUTH(2, 'S'),
    WEST(3,'W');

    private final int index;
    private final char shortCode;

    Direction(int index, char shortCode) {
        this.index = index;
        this.shortCode = shortCode;
    }

    public int getDirectionIndex(){
        return index;
    }

    public char getDirectionShortCode(){
        return shortCode;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getDirectionIndex() + 2) % 4];
    }
}
