package edu.kis.powp.jobs2d;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapters.DrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapters.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.lines.LineColorEditor;
import edu.kis.powp.jobs2d.enums.TestType;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigure1OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), TestType.JOE_FIGURE_SCRIPT_1);

		SelectTestFigureOptionListener selectTestFigure2OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), TestType.JOE_FIGURE_SCRIPT_2);

		SelectTestFigureOptionListener selectTestFigure3OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), TestType.JANE_FIGURE_SCRIPT_1);

		SelectTestFigureOptionListener selectTestFigure4OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), TestType.SQUARE);

		SelectTestFigureOptionListener selectTestFigure5OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), TestType.RECTANGLE);

		SelectTestFigureOptionListener selectTestFigure6OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), TestType.TRIANGLE);

		application.addTest("Figure Joe 1", selectTestFigure1OptionListener);
		application.addTest("Figure Joe 2", selectTestFigure2OptionListener);
		application.addTest("Figure Jane 1", selectTestFigure3OptionListener);
		application.addTest("Square", selectTestFigure4OptionListener);
		application.addTest("Rectangle", selectTestFigure5OptionListener);
		application.addTest("Triangle", selectTestFigure6OptionListener);
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);
		DrawPanelController drawPanelController = DrawerFeature.getDrawerController();

		Job2dDriver testDriver = new DrawerAdapter(drawPanelController);
		DriverFeature.addDriver("Draw Panel", testDriver);

		ILine basicLine = LineFactory.getSpecialLine();
		Job2dDriver basicLineDriver = new LineDrawerAdapter(drawPanelController, basicLine);
		DriverFeature.addDriver("BasicLine Driver", basicLineDriver);
		DriverFeature.updateDriverInfo();

		ILine basicBlueLine = new LineColorEditor(basicLine, Color.BLUE);
		Job2dDriver basicBlueLineDriver = new LineDrawerAdapter(drawPanelController, basicBlueLine);
		DriverFeature.addDriver("BasicBlueLine Driver", basicBlueLineDriver);

		DriverFeature.updateDriverInfo();
	}
	
	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
