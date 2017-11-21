package layers;

public class Layer1D extends DrawableLayer {

    /**
     * Constructs a neural layer that has no spacial quality.
     * @param numNeurons number of neurons in the layer
     */
    public Layer1D(int numNeurons) {
        this.numNeurons = numNeurons;
    }
}
