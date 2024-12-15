package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.enums.TestType;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapters.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.commands.DriverCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final TestType testType;

	public SelectTestFigureOptionListener(DriverManager driverManager, TestType testType) {
		this.driverManager = driverManager;
		this.testType = testType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (testType)
		{
			case JOE_FIGURE_SCRIPT_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case JOE_FIGURE_SCRIPT_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case JANE_FIGURE_SCRIPT_1:
				AbstractDriver driver = new AbstractDriverAdapter(driverManager.getCurrentDriver());
				FiguresJane.figureScript(driver);
				break;
			case SQUARE:
				DriverCommand squareCommand = ComplexCommandFactory.createSquare(-20, -30, 100, driverManager.getCurrentDriver());
				squareCommand.execute();
				break;
			case RECTANGLE:
				DriverCommand rectangleCommand = ComplexCommandFactory.createRectangle(100, 50, 60, 110, driverManager.getCurrentDriver());
				rectangleCommand.execute();
				break;
			case TRIANGLE:
				DriverCommand triangleCommand = ComplexCommandFactory.createTriangle(30, -100, -200, -50, 50, -200, driverManager.getCurrentDriver());
				triangleCommand.execute();
				break;

		}

	}
}
