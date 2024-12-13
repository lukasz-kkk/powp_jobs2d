package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class AbstractDriverAdapter extends AbstractDriver implements Job2dDriver {
    private final Job2dDriver driver;

    public AbstractDriverAdapter(Job2dDriver driver) {
        super(0, 0);
        this.driver = driver;
    }

    @Override
    public void operateTo(int x, int y) {
        this.driver.operateTo(x, y);
    }

    public void setPositionXY(int x, int y) {
        this.driver.setPosition(x, y);
    }
}