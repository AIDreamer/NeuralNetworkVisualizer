package drawer;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class BaseDrawer extends PApplet {

    private final static float NEURON_DIAMETER = 10f;

    protected void grayBrush() {
        stroke(137, 137, 137,10);
    }

    protected void grayCicle() {
        noStroke();
        fill(137);
    }

    protected void darkFill() {
        fill(0, 0, 0, 137);
    }

    protected void drawNeuron(PVector pos) {
        ellipse(pos.x, pos.y, NEURON_DIAMETER, NEURON_DIAMETER);
    }
}
