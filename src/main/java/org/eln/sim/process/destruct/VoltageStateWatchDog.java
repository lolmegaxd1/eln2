package org.eln.sim.process.destruct;

/*
NOTE: DO NOT IMPORT MINECRAFT CODE IN THIS CLASS
EXTEND IT INSTEAD IN THE org.eln.nbt DIRECTORY
 */

import org.eln.sim.mna.state.VoltageState;

public class VoltageStateWatchDog extends ValueWatchdog {

    VoltageState state;

    @Override
    double getValue() {
        return state.getU();
    }

    public VoltageStateWatchDog set(VoltageState state) {
        this.state = state;
        return this;
    }

    public VoltageStateWatchDog setUNominal(double uNominal) {
        this.max = uNominal * 1.3;
        this.min = -uNominal * 1.3;
        this.timeoutReset = uNominal * 0.05 * 5;
        return this;
    }

    public VoltageStateWatchDog setUNominalMirror(double uNominal) {
        this.max = uNominal * 1.3;
        this.min = -max;
        this.timeoutReset = uNominal * 0.05 * 5;
        return this;
    }

    public VoltageStateWatchDog setUMaxMin(double uNominal) {
        this.max = uNominal * 1.3;
        this.min = -uNominal * 1.3;
        this.timeoutReset = uNominal * 0.05 * 5;
        return this;
    }
}
