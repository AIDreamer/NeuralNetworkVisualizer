/**
 * Created by Son Pham 11/12/2017
 */

import processing.core.PApplet;

public class MainApp extends PApplet {

    // Some temporary constants for point calculation.
    private static final int DISTANCE_WIDTH_X = 25;
    private static final int DISTANCE_WIDTH_Y = 0;
    private static final int DISTANCE_HEIGHT_X = 15;
    private static final int DISTANCE_HEIGHT_Y = 15;
    private static final int CIRCLE_DIAMETER = 10;

    private static final int INPUT_WIDTH = 26;
    private static final int INPUT_HEIGHT = 14;

    public static void main(String[] args) {
        PApplet.main("MainApp");
    }

    public void settings() {
        size(1200, 800);
    }

    /**
     * Setup for the canvas, mainly the size.
     */
    public void setup() {

    }

    /**
     * Draw function will repeatedly be called and draw the graphics of the network to the windows.
     */
    public void draw() {

        // Clear everything
        background(18);

        // Draw weights
        drawWeights(100, 100, 26, 14,
                293, 468, 10, 1);

        // Draw input layers
        draw2dLayer(100, 100, 26, 14);

        // Draw output layers
        draw2dLayer(293, 468, 10, 1);
    }

    private void grayBrush() {
        stroke(137, 137, 137,10);
    }

    private void grayCicle() {
        noStroke();
        fill(137);
    }

    private void darkFill() {
        fill(0, 0, 0, 137);
    }

    private void drawWeights(int x1, int y1, int numNeuronsWidth1, int numNeuronsHeight1,
                     int x2, int y2, int numNeuronsWidth2, int numNeuronsHeight2) {
        grayBrush();
        for (int i = 0; i < numNeuronsWidth1; i++) {
            for (int j = 0; j < numNeuronsHeight1; j++) {
                for (int k = 0; k < numNeuronsWidth2; k++) {
                    for (int l = 0; l < numNeuronsHeight2; l++) {
                        int point1x = x1 + i * DISTANCE_WIDTH_X + j * DISTANCE_HEIGHT_X;
                        int point1y = y1 + i * DISTANCE_WIDTH_Y + j * DISTANCE_HEIGHT_Y;
                        int point2x = x2 + k * DISTANCE_WIDTH_X + l * DISTANCE_HEIGHT_X;
                        int point2y = y2 + k * DISTANCE_WIDTH_Y + l * DISTANCE_HEIGHT_Y;
                        line(point1x, point1y, point2x, point2y);
                    }
                }
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param numNeuronsWidth
     * @param numNeuronsHeight
     */
    private void draw2dLayer(int x, int y, int numNeuronsWidth, int numNeuronsHeight) {

        // Dark fill
        darkFill();
        int x1 = x;
        int y1 = y;
        int x2 = x + (numNeuronsHeight - 1) * DISTANCE_HEIGHT_X;
        int y2 = y + (numNeuronsHeight - 1) * DISTANCE_HEIGHT_Y;
        int x3 = x + (numNeuronsWidth - 1) * DISTANCE_WIDTH_X + (numNeuronsHeight - 1) * DISTANCE_HEIGHT_X;
        int y3 = y + (numNeuronsWidth - 1) * DISTANCE_WIDTH_Y + (numNeuronsHeight - 1) * DISTANCE_HEIGHT_Y;
        int x4 = x + (numNeuronsWidth - 1) * DISTANCE_WIDTH_X;
        int y4 = y + (numNeuronsWidth - 1) * DISTANCE_WIDTH_Y;

        quad(x1, y1, x2, y2, x3, y3, x4, y4);
        // Draw coordinate lines
        grayBrush();
        for (int i = numNeuronsWidth - 1; i >= 0; i--) {
            line(x + DISTANCE_WIDTH_X * i,
                    y + DISTANCE_WIDTH_Y * i,
                    x + DISTANCE_WIDTH_X * i + DISTANCE_HEIGHT_X * (numNeuronsHeight - 1),
                    y + DISTANCE_WIDTH_Y * i + DISTANCE_HEIGHT_Y * (numNeuronsHeight - 1));
        }

        for (int j = numNeuronsHeight - 1; j >= 0; j--) {
            line(x + DISTANCE_HEIGHT_X * j,
                    y + DISTANCE_HEIGHT_Y * j,
                    x + DISTANCE_HEIGHT_X * j + DISTANCE_WIDTH_X * (numNeuronsWidth - 1),
                    y + DISTANCE_HEIGHT_Y * j + DISTANCE_WIDTH_Y * (numNeuronsWidth - 1));
        }

        // Draw all neurons
        grayCicle();
        for (int i = numNeuronsWidth - 1; i >= 0; i--) {
            for (int j = 0; j < numNeuronsHeight; j++) {
                ellipse(x + i * DISTANCE_WIDTH_X + j * DISTANCE_HEIGHT_X, y + i * DISTANCE_WIDTH_Y + j * DISTANCE_HEIGHT_Y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
            }
        }
    }
}
