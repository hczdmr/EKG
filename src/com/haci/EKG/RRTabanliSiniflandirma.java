package com.haci.EKG;

import java.util.ArrayList;

/**
 * Created by HaciOzdemir on 25/12/14.
 */
public class RRTabanliSiniflandirma {
    public static int siniflandir(ArrayList<Float> rrintervalSaniye){

        ArrayList<Integer> data=RRTabanliAlgoritma.siniflandir(rrintervalSaniye);

        int sonuc=0;

        int kategory1=0;
        int kategory2=0;
        int kategory3=0;
        int kategory4=0;
        int kategory5=0;
        for (int i=0;i<data.size();i++){
            if(data.get(i)==1){
                kategory1++;
            }else if(data.get(i)==2){
                kategory2++;
            }
            else if(data.get(i)==3){
                kategory3++;
            }
            else if(data.get(i)==4){
                kategory4++;
            }else{
                kategory5++;
            }
        }

        if (kategory2>kategory3 && kategory2>kategory4  && kategory2>kategory5 ){
            sonuc=2;
        }else if (kategory3>kategory2 && kategory3>kategory4  && kategory3>kategory5 ){
            sonuc=3;
        }else if (kategory4>kategory2 && kategory4>kategory3  && kategory4>kategory5 ){
            sonuc=4;
        }else if (kategory5>kategory2 && kategory5>kategory3  && kategory5>kategory4 ){
            sonuc=5;
        }

        return sonuc;
    }
}
