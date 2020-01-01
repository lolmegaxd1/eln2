package org.eln.sim.mna.component;

/*
NOTE: DO NOT IMPORT MINECRAFT CODE IN THIS CLASS
EXTEND IT INSTEAD IN THE org.eln.nbt DIRECTORY
 */

import org.eln.sim.mna.state.State;

public abstract class Bipole extends Component {

    public State aPin, bPin;

    public Bipole() {
    }

    public Bipole(State aPin, State bPin) {
        connectTo(aPin, bPin);
    }


    public Bipole connectTo(State aPin, State bPin) {
        breakConnection();

        this.aPin = aPin;
        this.bPin = bPin;

        if (aPin != null) aPin.add(this);
        if (bPin != null) bPin.add(this);
        return this;
    }

    public Bipole connectGhostTo(State aPin, State bPin) {
        breakConnection();

        this.aPin = aPin;
        this.bPin = bPin;
        return this;
    }

    @Override
    public void breakConnection() {
        if (aPin != null) aPin.remove(this);
        if (bPin != null) bPin.remove(this);
    }

    @Override
    public State[] getConnectedStates() {
        return new State[]{aPin, bPin};
    }

    public abstract double getCurrent();

    public double getU() {
        return (aPin == null ? 0 : aPin.state) - (bPin == null ? 0 : bPin.state);
    }

    public double getBipoleU() {
        return getU();
    }

    public String toString() {
        return "[" + aPin + " " + this.getClass().getSimpleName() + " " + bPin + "]";
    }
}
