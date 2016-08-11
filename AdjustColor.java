

import cs180.image.Image;
import cs180.image.Pixel;

public class AdjustColor {

    private String Effect;

    public AdjustColor(String name){
        this.Effect = name;
    }

    public void apply(Image image){
        Pixel p;
        if(image == null)
            return;
        else{
            for(int i = 0; i < image.getWidth();i++){
                for(int j = 0; j < image.getHeight();j++){
                    p = image.getPixel(i,j);
                    this.adjustPixel(p);
                    image.setPixel(i,j,p);
                }
            }
        }
    }

    public void adjustPixel(Pixel p){

    }

    public String getName(){
        return this.Effect;
    }

}
