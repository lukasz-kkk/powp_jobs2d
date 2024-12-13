package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapters.AbstractDriverAdapter;
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
	}
}
