import cs180.image.Pixel;

/**
 * Created by Xuejun Zhao
 */
public class Darken extends AdjustColor {
    public Darken(){
        super("Darken");

    }
    public void adjustPixel(Pixel p){
        int red;
        int blue;
        int green;

        red = p.getRed();
        blue = p.getBlue();
        green = p.getGreen();

        p.setRed(red - 25.5);
        p.setBlue(blue - 25.5);
        p.setGreen(green - 25.5);
    }
}
