package marsrover.services;

import marsrover.interfaces.Coordinate;
import marsrover.models.Direction;
import marsrover.models.Obstacle;
import marsrover.models.Point;

import java.util.List;

public class Coordinator implements Coordinate {

    private final Point x;
    private final Point y;
    private final List<Obstacle> obstacles;

    private Direction direction;

    public Coordinator(Point x, Point y, Direction direction, List<Obstacle> obstacles) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.obstacles = obstacles;
    }

    public Point getXCoordinate() {
        return x;
    }

    public Point getYCoordinate() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void addObstacles(Obstacle obstacle){ obstacles.add(obstacle); }

    private boolean move(Direction direction){
        int xLocation = x.getX();
        int yLocation = y.getX();
        switch (direction){
            case NORTH:
                yLocation = y.getForwardLocation();
                break;
            case EAST:
                xLocation = x.getForwardLocation();
                break;
            case WEST:
                xLocation = x.getBackwardLocation();
                break;
            case SOUTH:
                yLocation = y.getBackwardLocation();
                break;
        }

        if(!hasObstacle(xLocation, yLocation)){
            return true;
        }

        return false;
    }

    private boolean hasObstacle(int x, int y){
        return obstacles.stream().filter(obstacle->
                obstacle.getXCoordinate() == x && obstacle.getYCoordinate() == y
        ).count() > 0;
    }

    private void changeDirection(Direction directionValue, int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + directionValue.getDirectionIndex() + directionStep) % directions;

        direction = Direction.values()[index];
    }

    @Override
    public boolean forward() {
        return move(direction);
    }

    @Override
    public boolean backward() {
        return move(direction.getBackwardDirection());
    }

    @Override
    public void directionLeft() {
        changeDirection(direction, -1);
    }

    @Override
    public void directionRight() {
        changeDirection(direction, 1);
    }

    @Override
    public String toString() {
        return "{" +
                "x:" + x +","+
                "y:" + y +","+
                "direction:'" + direction.getDirectionShortCode() +"'}";
    }
}
