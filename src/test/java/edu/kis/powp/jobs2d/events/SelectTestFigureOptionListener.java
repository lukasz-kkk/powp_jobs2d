package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapters.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.commands.DriverCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private final int index;

	public SelectTestFigureOptionListener(DriverManager driverManager, int index) {
		this.driverManager = driverManager;
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(index == 1){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		if(index == 2) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
		if(index == 3) {
			AbstractDriver driver = new AbstractDriverAdapter(driverManager.getCurrentDriver());
			FiguresJane.figureScript(driver);
		}
		if (index == 4) {
			DriverCommand command = ComplexCommandFactory.createSquare(-20, -30, 100, driverManager.getCurrentDriver());
			command.execute();
		}
		if (index == 5) {
			DriverCommand command = ComplexCommandFactory.createRectangle(100, 50, 60, 110, driverManager.getCurrentDriver());
			command.execute();
		}
		if (index == 6) {
			DriverCommand command = ComplexCommandFactory.createTriangle(30, -100, -200, -50, 50, -200, driverManager.getCurrentDriver());
			command.execute();
		}
	}
}
