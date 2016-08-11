package cs180.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * This class represents an Image
 * 
 * 
 */
public class Image{

    BufferedImage internalBuffer; // internal buffer

    /**
     * Creates a blank 100 x 100px image
     */
    public Image() {
        internalBuffer = new BufferedImage(100,100,BufferedImage.TYPE_4BYTE_ABGR);
    }

    /**
     * Creates an image from the specified path
     */
    public Image(String filepath) {
        this();
        BufferedImage img = null;
        try {
            internalBuffer = ImageIO.read(new File(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the width of the image in pixels.
     * @return the width of the image in pixels
     */
    public int getWidth() {
        return internalBuffer.getWidth();
    }

    /**
     * Gets the height of the image in pixels.
     * @return The height of the image in pixels.
     */
    public int getHeight() {
        return internalBuffer.getHeight();
    }

    /**
     * Gets the color of the pixel at the given location.
     * @return an RGB encoded pixel.
     */
    private int getRGB(int x, int y) {
        return internalBuffer.getRGB(x, y);
    }

    /**
     * Gets the pixel at position x,y in the image
     * @param x axis position
     * @param y axis position
     * @return
     */
    public Pixel getPixel(int x, int y) {
        return new Pixel(getRGB(x,y));
    }

    /**
     * Sets the pixel at position x,y in the image
     * @param x axis position
     * @param y axis position
     * @param p pixel
     */
    public void setPixel(int x, int y, Pixel p) {
        setRGB(x,y,p.toRGB());
    }

    /**
     * Sets the color of the pixel at the given location.
     * @return an RGB encoded pixel.
     */
    private void setRGB(int x, int y, int rgb) {
        internalBuffer.setRGB(x, y, rgb);
    }

    /**
     * Get the data of the image
     * @return internal buffer
     */
    public BufferedImage getImageData() {
        return internalBuffer;
    }

    /**
     * Get a copy of an image
     * @return copy
     */
    public Image getCopy() {
        Image toReturn = new Image();
        toReturn.internalBuffer = deepCopy(internalBuffer);

        return toReturn;
    }


    /**
     * Perform a deep copy of the buffered image
     * It is done using the method in: http://stackoverflow.com/a/3514297
     * @param bi buffered image to copy
     * @return copy of the image
     */
    private static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

}

