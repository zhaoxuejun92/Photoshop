import com.sun.scenario.effect.impl.sw.java.JSWBlend_LIGHTENPeer;
import cs180.image.Image;
import cs180.image.Pixel;

import java.util.ArrayList;

public class EffectsList {
    public ArrayList<AdjustColor> effectslist = new ArrayList<AdjustColor>();

    public void add(AdjustColor effect) {
        // enter your code
        if(effect == null)
            return;
        else{
            effectslist.add(effect);
        }
    }

    public String[] getEffectNames() {
        String[] effectnames = new String[effectslist.size()];
        String[] empty = new String[0];
        AdjustColor temp;
        if (this.effectslist == null){
            return empty;
        }else{
            for (int i = 0; i < effectnames.length - 1; i++){
                for(int j = 0; j < effectnames.length -1 - i; j++){
                    if(effectslist.get(j).getName().compareTo( effectslist.get(j+1).getName()) > 0){
                        temp = effectslist.get(j+1);
                        effectslist.set(j + 1, effectslist.get(j));
                        effectslist.set(j, temp);
                    }
                }
            }

            for(int i = 0; i < effectnames.length; i++){
                effectnames[i] = effectslist.get(i).getName();
            }
        }

        return effectnames;
    }

    public boolean runEffect(String effectName, Image i) {
        boolean found = false;
        if((effectName == null)||(i == null)){
            return false;
        }else{
            for(int k = 0; k < this.effectslist.size(); k++){
                if(effectName.equals(this.effectslist.get(k).getName())){
                    found = true;
                    this.effectslist.get(k).apply(i);
                }

            }
            return found;
        }

        //return found; // return this statement and enter your code
    }
}
