import cs180.image.Pixel;

/**
 * Created by Xuejun Zhao
 */
public class Pipeline extends AdjustColor {
    private String name;
    private AdjustColor[] steps;
    public int length;
    public Pipeline(String name){
        super(name);
        this.steps = new AdjustColor[100];
        this.length = 0;
    }

    public Pipeline(String name, AdjustColor[] steps){
        super(name);
        //this.steps = new AdjustColor[];
        this.steps = new AdjustColor[100];
        if(steps == null){
            this.length = 0;
        }else{
            for(int i = 0; i < steps.length; i++){
                this.steps[i] = steps[i];
            }
            this.length = steps.length;
        }
    }

    public void add(AdjustColor effect){
        if(effect == null){
            return;
        }else{
            this.steps[length] = effect;
            this.length = this.length + 1;
        }
    }

    public boolean remove(int index){
        if((index < 0)||(index >= this.length)){
            return false;
        }else{
            for(int i = index; i < this.length; i++){
                this.steps[i] = this.steps[i + 1];
            }
            this.length = this.length - 1;
            return true;
        }
    }

    public AdjustColor[] getSteps(){
        AdjustColor[] empty = new AdjustColor[0];
        if(this.length == 0){
            return empty;
        }else{
            AdjustColor[] steps = new AdjustColor[this.length];
            for(int i = 0; i < this.length; i++){
                steps[i] = this.steps[i];
            }
            return steps;
        }

    }

    public void adjustPixel(Pixel p){
        for(int i = 0; i < this.length; i++){
            this.steps[i].adjustPixel(p);
        }
    }
}
