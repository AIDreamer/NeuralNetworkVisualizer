package layers;

import processing.core.PVector;

import java.util.List;

public abstract class DrawableLayer {

    // Default distance between two adjacent neurons
    private static final float DEFAULT_NEURON_DISTANCE = 10f;

    // Number of neurons inside the layer
    protected int numNeurons;

    // Position of the top-most neuron of the layer
    public float x;
    public float y;
    public float z;

    // Distance between adjacent neurons
    protected float neuronDistance = DEFAULT_NEURON_DISTANCE;

    // Positions of all neurons
    private List<PVector> neuronLocs;

    // Cached screen positions of all neurons
    // This is to avoid recalculating the positions all the time
    private List<PVector> screenNeuronLocs;

    // Boolean representing whether the screen positions are updated
    private boolean positionsUpdated;

    /**
     * Set the position of the neural network
     * @param x position in the x-axis
     * @param y position in the y-axis
     * @param z position in the z-axis
     */
    public void setPosition(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Set the distance between two adjacent neurons
     * @param neuronDistance a double representing distance between two neurons
     */
    public void setNeuronDistance(float neuronDistance) {
        this.neuronDistance = neuronDistance;
    }

    /**
     * Get the distance between two adjacent neurons
     * @return distance between two adjacent neurons
     */
    public float getNeuronDistance() {
        return this.neuronDistance;
    }
}
