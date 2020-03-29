package marsrover.interfaces;

import marsrover.application.model.CommandType;
import marsrover.models.Obstacle;

public interface Command {
    void receive(CommandType... command) throws Exception;
    Coordinate getCoordinate();
    String getPosition();
    void addObstacles(Obstacle obstacle);
}
