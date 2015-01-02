package com.haci.EKG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by HaciOzdemir on 24/12/14.
 */
public class Baslangic extends Activity {
    Button btnveriYukle,btnbilgi;
    Spinner spinner;
    private static String[] kategoriler = new String[] { "Hastalıklı Veriler ", "Sağlıklı Veriler"    };
    int position=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baslangic);

        btnveriYukle=(Button)findViewById(R.id.btnyukle);
        btnbilgi=(Button)findViewById(R.id.bilgi);

        spinner=(Spinner)findViewById(R.id.spinner1);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner, kategoriler);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                position=arg2;
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        btnveriYukle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                Intent i = new Intent(Baslangic.this, VeriSec.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnbilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Baslangic.this, HastalikBilgi.class);
                startActivity(i);
            }
        });

    }

}
