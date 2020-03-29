package marsrover.application;

import marsrover.application.model.CommandType;
import marsrover.interfaces.Command;
import marsrover.interfaces.Coordinate;
import marsrover.models.Obstacle;

public class RoverCommand implements Command {

    private final Coordinate coordinate;

    public RoverCommand(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void addObstacles(Obstacle obstacle) {
        coordinate.addObstacles(obstacle);
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public void receive(CommandType... commands) throws Exception {
        for(CommandType command : commands){
            switch(command) {
                case FORWARD:
                    coordinate.forward();
                    break;
                case BACKWARD:
                    coordinate.backward();
                    break;
                case LEFT:
                    coordinate.directionLeft();
                    break;
                case RIGHT:
                    coordinate.directionRight();
                    break;
                default:
                    throw new Exception("Command " + command + " is unknown.");
            }
        }
    }

    public String getPosition(){
        return coordinate.toString();
    }
}
