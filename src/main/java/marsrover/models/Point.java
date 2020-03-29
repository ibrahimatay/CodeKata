package marsrover.models;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() { return x; }

    public int getForwardLocation(){
        return (x + 1) % (y + 1);
    }

    public int getBackwardLocation(){
        if (x > 0) return x - 1;

        return y;
    }

    @Override
    public String toString() {
        return "Point:{" +
                "X:" + x +","+
                "Y:" + y +"}";
    }
}
