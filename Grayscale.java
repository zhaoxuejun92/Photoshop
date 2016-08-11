import cs180.image.Pixel;

/**
 * Created by junjun on 8/6/16.
 */
public class Grayscale extends AdjustColor {
    public Grayscale(){
        super("Grayscale");

    }
    public void adjustPixel(Pixel p){
        int red;
        int blue;
        int green;

        red = p.getRed();
        blue = p.getBlue();
        green = p.getGreen();

        p.setRed(red * 0.2989 + green * 0.5870 + blue * 0.1140);
        p.setBlue(red * 0.2989 + green * 0.5870 + blue * 0.1140);
        p.setGreen(red * 0.2989 + green * 0.5870 + blue * 0.1140);
    }
}
