package marsrover.application.model;

public enum CommandType {
    FORWARD('F'),
    BACKWARD('B'),
    LEFT('L'),
    RIGHT('R');

    private char CommandType;

    CommandType(char commandType) {
        CommandType = commandType;
    }

    public char getCommandType(){
        return this.CommandType;
    }
}
