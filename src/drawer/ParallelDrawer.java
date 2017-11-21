package drawer;

import layers.Layer2D;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * A extension of PApplet class that allows users to draw neural network layers based on
 */
public abstract class ParallelDrawer extends BaseDrawer {

    // Vector describe the zero position of the objects relative to the drawing board.
    private final static PVector DEFAULT_ZERO_VECTOR = new PVector(0,0);

    // These are unit translation vector according to each x, y and z axes
    private final static PVector UNIT_X = new PVector(1, 0);
    private final static PVector UNIT_Y = new PVector((float) Math.sqrt(2) / 2, (float) Math.sqrt(2) / 2);
    private final static PVector UNIT_Z = new PVector(0, 1);

    /**
     * Draw layer 2D according to each position
     * @param layer2D a 2d layer to be drawn.
     */
    protected void drawLayer2D(Layer2D layer2D) {

        // Get width, height and neuron distance of the neuron layer
        int layerWidth = layer2D.getLayerWidth();
        int layerHeight = layer2D.getLayerHeight();
        float dist = layer2D.getNeuronDistance();

        // Calculate top left position on the screen
        // TODO: This part might be better if there is some faster dot product or matrix calculation
        PVector topLeft = new PVector();
        topLeft.add(UNIT_X.copy().mult(topLeft.x))
                .add(UNIT_Y.copy().mult(topLeft.y))
                .add(UNIT_Z.copy().mult(topLeft.z));

        // Draw a thin veil of black for the sake of emphasis
        PVector topRight = topLeft.copy().add(UNIT_X.copy().mult(layerWidth - 1));
        PVector bottomLeft = topLeft.copy().add(UNIT_Y.copy().mult(layerHeight - 1));
        PVector bottomRight = bottomLeft.copy().add(UNIT_X.copy().mult(layerWidth - 1));
        quad(topLeft.x, topLeft.y,
                topRight.x, topRight.y,
                bottomRight.x, bottomRight.y,
                bottomLeft.x, bottomLeft.y);

        // Draw vertical grid
        for (int i = 0; i < layerWidth; i++) {
            PVector pt1 = UNIT_X.copy().mult(dist).mult(i);
            PVector pt2 = pt1.copy().add(UNIT_Y.copy().mult(dist).mult(layerHeight - 1));
            grayBrush();
            line(pt1.x, pt1.y, pt2.x, pt2.y);
        }

        // Based on the position of the top-left neuron, draw all neuron on the screen.
        for (int i = 0; i < layerWidth; i++) {
            for (int j = 0; j < layerHeight; j++) {

                // Calculate neuron position on the screen
                PVector pos = new PVector();
                PVector offset = UNIT_X.copy().mult(dist);
                pos.add(topLeft).add(offset);

                // Draw the neuron out on the screen with the calculated position.
                drawNeuron(pos);
            }
        }
    }
}
