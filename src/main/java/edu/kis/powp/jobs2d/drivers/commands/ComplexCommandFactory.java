package edu.kis.powp.jobs2d.drivers.commands;
import edu.kis.powp.jobs2d.Job2dDriver;
public class ComplexCommandFactory {
    public static DriverCommand createSquare(int x, int y, int width, Job2dDriver driver) {
        ComplexCommand squareCommand = new ComplexCommand();
        squareCommand.addCommand(new SetPositionCommand(x, y, driver));
        squareCommand.addCommand(new OperateToCommand(x, y + width, driver));
        squareCommand.addCommand(new OperateToCommand(x + width, y + width, driver));
        squareCommand.addCommand(new OperateToCommand(x + width, y, driver));
        squareCommand.addCommand(new OperateToCommand(x, y, driver));
        return squareCommand;
    }

    public static DriverCommand createRectangle(int x, int y, int width, int height, Job2dDriver driver) {
        ComplexCommand rectangleCommand = new ComplexCommand();
        rectangleCommand.addCommand(new SetPositionCommand(x, y, driver));
        rectangleCommand.addCommand(new OperateToCommand(x, y + height, driver));
        rectangleCommand.addCommand(new OperateToCommand(x + width, y + height, driver));
        rectangleCommand.addCommand(new OperateToCommand(x + width, y, driver));
        rectangleCommand.addCommand(new OperateToCommand(x, y, driver));
        return rectangleCommand;
    }

    public static DriverCommand createTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Job2dDriver driver) {
        ComplexCommand triangleCommand = new ComplexCommand();
        triangleCommand.addCommand(new SetPositionCommand(x1, y1, driver));
        triangleCommand.addCommand(new OperateToCommand(x2, y2, driver));
        triangleCommand.addCommand(new OperateToCommand(x3, y3, driver));
        triangleCommand.addCommand(new OperateToCommand(x1, y1, driver));
        return triangleCommand;
    }

}