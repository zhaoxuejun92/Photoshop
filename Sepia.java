import cs180.image.Pixel;

/**
 * Created by junjun on 8/6/16.
 */
public class Sepia extends AdjustColor {
    public Sepia(){
        super("Sepia");

    }
    public void adjustPixel(Pixel p){
        int red;
        int blue;
        int green;

        red = p.getRed();
        blue = p.getBlue();
        green = p.getGreen();

        p.setRed((int)(red * 0.393 + green * 0.769 + blue * 0.189));
        p.setGreen((int)(red * 0.349 + green * 0.686 + blue * 0.168));
        p.setBlue((int)(red*.272 + green*.534 + blue*.131));
    }
}
