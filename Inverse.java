import cs180.image.Pixel;

/**
 * Created by Xuejun Zhao
 */
public class Inverse extends AdjustColor{
    public Inverse(){
        super("Inverse");

    }
    public void adjustPixel(Pixel p){
        int red;
        int blue;
        int green;

        red = p.getRed();
        blue = p.getBlue();
        green = p.getGreen();

        p.setRed(255 - red);
        p.setBlue(255 - blue);
        p.setGreen(255 - green);
    }
}
