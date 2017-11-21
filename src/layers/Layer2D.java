package layers;

import processing.core.PVector;

import java.util.List;

public class Layer2D extends DrawableLayer {

    // Width and height of the layers by number of neurons
    private int layerWidth;
    private int layerHeight;

    /**
     * Constructs a neuron layer that represents a 2-dimensional rectangular input like screens, image pixels, etc.
     * @param layerWidth number of neurons representing the width of the layer
     * @param layerHeight number of neurons representing the height of the layer
     */
    public Layer2D(int layerWidth, int layerHeight) {
        this.layerWidth = layerWidth;
        this.layerHeight = layerHeight;
        this.numNeurons = layerWidth * layerHeight;
    }

    /////////////////////////////////////////
    // Getters and setters for all attributes
    /////////////////////////////////////////

    public int getLayerWidth() {
        return layerWidth;
    }

    public int getLayerHeight() {
        return layerHeight;
    }
}
