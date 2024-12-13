package edu.kis.powp.jobs2d.drivers.lines;

import edu.kis.legacy.drawer.shape.ILine;

import java.awt.*;

public class LineColorEditor implements ILine {
    private final ILine line;
    private final Color color;

    public LineColorEditor(ILine line, Color color) {
        this.line = line;
        this.color = color;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new LineColorEditor((ILine) line.clone(), this.color);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public float getThickness() {
        return this.line.getThickness();
    }

    @Override
    public boolean isDotted() {
        return this.line.isDotted();
    }

    @Override
    public int getStartCoordinateX() {
        return this.line.getStartCoordinateX();
    }

    @Override
    public int getEndCoordinateX() {
        return this.line.getEndCoordinateX();
    }

    @Override
    public int getStartCoordinateY() {
        return this.line.getStartCoordinateY();
    }

    @Override
    public int getEndCoordinateY() {
        return this.line.getEndCoordinateY();
    }

    @Override
    public void setStartCoordinates(int x, int y) {
        this.line.setStartCoordinates(x, y);
    }

    @Override
    public void setEndCoordinates(int x, int y) {
        this.line.setEndCoordinates(x, y);
    }
}