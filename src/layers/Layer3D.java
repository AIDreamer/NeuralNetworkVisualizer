package layers;

public class Layer3D extends DrawableLayer {

    // Width and height of the layers by number of neurons
    private int layerWidth;
    private int layerHeight;
    private int layerDepth;

    public Layer3D(int layerWidth, int layerHeight, int layerDepth) {
        this.layerWidth = layerWidth;
        this.layerHeight = layerHeight;
        this.layerDepth = layerDepth;
        this.numNeurons = layerWidth * layerHeight * layerDepth;
    }
}
