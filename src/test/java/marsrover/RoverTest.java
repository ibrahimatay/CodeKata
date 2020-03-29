package marsrover;

import marsrover.application.RoverCommand;
import marsrover.application.model.CommandType;
import marsrover.interfaces.Command;
import marsrover.interfaces.Coordinate;
import marsrover.models.Direction;
import marsrover.models.Obstacle;
import marsrover.models.Point;
import marsrover.services.Coordinator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    private Command command;
    private final Point xCoordinate = new Point(1,9);
    private final Point yCoordinate = new Point(2,9);

    @Before
    public void before(){
        Coordinate coordinate = new Coordinator(xCoordinate, yCoordinate, Direction.NORTH, new ArrayList<>());
        command = new RoverCommand(coordinate);
    }

    @Test
    public void shouldSetRoverCoordinatesAndDirection() throws Exception {
        command.receive(CommandType.BACKWARD);
        assertEquals(command.getCoordinate().getYCoordinate().getX(),2);
    }

    @Test
    public void shouldTurnLeft() throws Exception{
        command.receive(CommandType.LEFT);
        assertEquals(command.getCoordinate().getDirection(), Direction.WEST);
    }

    @Test
    public void shouldTurnRight() throws Exception {
        command.receive(CommandType.RIGHT);
        assertEquals(command.getCoordinate().getDirection(), Direction.EAST);
    }

    @Test
    public void shouldPositionReturnXYAndDirection() throws Exception {
        command.receive(
                CommandType.LEFT,
                CommandType.FORWARD,
                CommandType.FORWARD,
                CommandType.FORWARD,
                CommandType.RIGHT,
                CommandType.FORWARD,
                CommandType.FORWARD);

        assertEquals(command.getPosition(), "{x:Point:{X:1,Y:9},y:Point:{X:2,Y:9},direction:'N'}");
    }

    @Test
    public void shouldPositionReturnNokWhenObstacleIsFound() throws Exception {
        command.addObstacles(new Obstacle(xCoordinate.getX()+1, yCoordinate.getY()));
        command.receive(CommandType.BACKWARD);

        assertEquals(command.getPosition(),"{x:Point:{X:1,Y:9},y:Point:{X:2,Y:9},direction:'N'}");
    }
}
