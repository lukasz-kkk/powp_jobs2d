package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter implements Job2dDriver {
    private final DrawPanelController drawPanelController;
    private final ILine line;
    private int startX = 0;
    private int startY = 0;
    public LineDrawerAdapter(DrawPanelController drawPanelController, ILine line) {
        this.drawPanelController = drawPanelController;
        this.line = line;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        this.line.setStartCoordinates(this.startX, this.startY);
        this.line.setEndCoordinates(x, y);

        this.drawPanelController.drawLine(line);
        this.setPosition(x, y);
    }

    @Override
    public String toString() {
        return "DrawPanelController adapter";
    }
}