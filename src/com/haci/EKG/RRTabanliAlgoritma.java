package com.haci.EKG;

import java.util.ArrayList;

/**
 * Created by HaciOzdemir on 25/12/14.
 */
public class RRTabanliAlgoritma {
    public static ArrayList<Integer> siniflandir(ArrayList<Float> rrintervalSaniye) {

        int category=0;
        int pulse=0;
        double a=0.9;
        double b=0.9;
        double c=1.5;

        ArrayList<Integer> categoryTut=new ArrayList<Integer>();

        for(int i=0;i<rrintervalSaniye.size()-3;i++){
            float RR1=rrintervalSaniye.get(i);
            float RR2=rrintervalSaniye.get(i+1);
            float RR3=rrintervalSaniye.get(i+2);
            category=1;//RR2 i+1 oluyo.    ADIM2
            if (RR2<0.6 && RR3<RR2){  //ADIM3
                category=5;
                pulse=1;
                i++;

                while ((RR1<0.8) && (RR2<0.8) && (RR3<0.8)  ||  (RR1+RR2+RR3)<1.8){//ADIM3-A
                    category=5;
                    pulse=pulse+1;
                    i++;
                    RR1=rrintervalSaniye.get(i);
                    RR2=rrintervalSaniye.get(i+1);
                    RR3=rrintervalSaniye.get(i+2);

                    if (pulse>4){
                        break;
                    }

                }


                if (pulse<4){     //ADIM3-B
                    category=1;
                    i=i-pulse;
                }
            }

            if (RR2 < a*RR1  &&  RR1 <  b*RR3){     //ADIM4
                if (RR2+RR3  <  2*RR1){     //ADIM4-A
                    category=2;
                }else {                //ADIM4-B
                    category=3;
                }
            }


            if (RR2>c*RR1){        //ADIM5
                category=4;
            }

            //ADIM 6 YA GİDİYO..

            categoryTut.add(category);

        }

        return categoryTut;
    }
}
