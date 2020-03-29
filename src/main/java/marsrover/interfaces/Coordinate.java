package marsrover.interfaces;

import marsrover.models.Direction;
import marsrover.models.Obstacle;
import marsrover.models.Point;

public interface Coordinate {
    boolean forward();
    boolean backward();
    void directionLeft();
    void directionRight();
    Point getXCoordinate();
    Point getYCoordinate();
    Direction getDirection();
    void addObstacles(Obstacle obstacle);
}
