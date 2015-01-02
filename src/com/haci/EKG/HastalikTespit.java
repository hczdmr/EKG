package com.haci.EKG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hilal on 14.04.2014.
 */
public class HastalikTespit {
    public static ArrayList<String> hastalikBul(Float kalpHizi) {

        ArrayList<String> diseases = new ArrayList<String>();


        if(kalpHizi<60 && kalpHizi!=0){
            diseases.add("Sinus Bradikardisi");
            diseases.add("Junctional Escape Ritim");
        }
        else if(kalpHizi>100){
            diseases.add("Sinüs Taşikardisi");
        }
        else if (kalpHizi<=190 && kalpHizi>=160){
            diseases.add("Paroxysmal Supraventricular Taşikardi");
        }
        else if(kalpHizi>=60 && kalpHizi<=100){
            diseases.add("Normal Sinüs Ritmi");
        }
        else if(kalpHizi==0){
            diseases.add("Ventriküler Fibrilasyon");
            diseases.add("Ritim Asistoli");
        }


        // If no diseases were detected, report that
        if(diseases.size()==0){
            diseases.add("Tespit edilen kalp rahatsızlığınız yoktur.");
        }



        return diseases;
    }

}

